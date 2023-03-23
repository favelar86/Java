import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient {
	
	String apiKey;
	String url;
	
	public ImdbApiClient(String apiKey, String url) {
		super();
		this.apiKey = apiKey;
		this.url = url;
	}

	public String httpGet() throws IOException, InterruptedException {
		
		URI apiIMDB = URI.create(url + apiKey);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		return response.body();
	}

}
