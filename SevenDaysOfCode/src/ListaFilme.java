import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListaFilme {
	
	String[] moviesArray;

	public ListaFilme(String[] moviesArray) {
		super();
		this.moviesArray = moviesArray;
	}
	
	public ArrayList<Filmes> MontaObjeto(){
		
		List<String> titles = parseTitles(this.moviesArray);
		List<String> urlImages = parseUrlImages(this.moviesArray);
		List<String> rating = parseRating(this.moviesArray);
		List<String> year = parseYear(this.moviesArray);
		
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

}
