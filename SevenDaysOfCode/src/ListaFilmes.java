import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListaFilmes {

	public static void main(String[] args) throws Exception {
		
		String apiKey = "Key";
		URI apiIMDB = URI.create("https://imdb-api.com/en/API/Top250TVs/" + apiKey);
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String json = response.body();
		
		String[] moviesArray = parseJsonMovies(json);
	
		List<String> titles = parseTitles(moviesArray);
		List<String> urlImages = parseUrlImages(moviesArray);
		List<String> rating = parseRating(moviesArray);
		List<String> year = parseYear(moviesArray);
		
		ArrayList<Filmes> filmes = MontaObjeto(titles, urlImages, rating, year);
		
		try {
            Writer writer = new PrintWriter("filmes.html");
            HTMLGenerator htmlGenerator = new HTMLGenerator(writer);
            htmlGenerator.generate(filmes);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

	}
	
	private static String[] parseJsonMovies(String json) {
		Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("no match in " + json);
		}

		String[] moviesArray = matcher.group(1).split("\\},\\{");
		moviesArray[0] = moviesArray[0].substring(1);
		int last = moviesArray.length - 1;
		String lastString = moviesArray[last];
		moviesArray[last] = lastString.substring(0, lastString.length() - 1);
		return moviesArray;
	}
	
	private static List<String> parseAttribute(String[] moviesArray, int pos) {
		return Stream.of(moviesArray)
			.map(e -> e.split("\",\"")[pos]) 
			.map(e -> e.split(":\"")[1]) 
			.map(e -> e.replaceAll("\"", ""))
			.collect(Collectors.toList());
	}
	
	private static List<String> parseTitles(String[] moviesArray) {
		return parseAttribute(moviesArray, 3);
	}
	
	private static List<String> parseUrlImages(String[] moviesArray) {
		return parseAttribute(moviesArray, 5);
	}
	
	private static List<String> parseRating(String[] moviesArray) {
		return parseAttribute(moviesArray, 7);
	}
	
	private static List<String> parseYear(String[] moviesArray) {
		return parseAttribute(moviesArray, 4);
	}
	
	private static ArrayList<Filmes> MontaObjeto(
			List<String> titles,
			List<String> urlImages,
			List<String> rating,
			List<String> year){
		
		ArrayList<Filmes> filmes = new ArrayList<Filmes>();
		
		for (int i = 0; i < titles.size(); i++) {
			Filmes filme = new Filmes();
			
			filme.setTitulo(titles.get(i));
			filme.setUrl(urlImages.get(i));
			filme.setNota(Double.parseDouble(rating.get(i)));
			filme.setAno(Integer.parseInt(year.get(i)));
			
			filmes.add(filme);
		}

		return filmes;	
	}
}
