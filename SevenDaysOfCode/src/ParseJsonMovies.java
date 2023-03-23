import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseJsonMovies {
	
	String json;

	public ParseJsonMovies(String json) {
		super();
		this.json = json;
	}
	
	public String[] Parse() {
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
}
