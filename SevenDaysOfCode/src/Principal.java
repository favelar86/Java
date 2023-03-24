import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		ImdbApiClient apiClient = new ImdbApiClient("Key", "https://imdb-api.com/en/API/Top250TVs/");
		String json = apiClient.httpGet();
		
		ParseJsonMovies parseJsonMovies = new ParseJsonMovies(json);
		String[] moviesArray = parseJsonMovies.Parse();
		
		ListaFilme listaFilme = new ListaFilme(moviesArray);
		ArrayList<Filmes> filmes = listaFilme.MontaObjeto();
		
		Collections.sort(filmes);
		
		try {
            Writer writer = new PrintWriter("filmes.html");
            HTMLGenerator htmlGenerator = new HTMLGenerator(writer);
            htmlGenerator.generate(filmes);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

	}
}
