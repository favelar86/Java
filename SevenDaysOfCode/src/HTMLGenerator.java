import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class HTMLGenerator {

	private final Writer writer;

	public HTMLGenerator(Writer writer) {
		this.writer = writer;
	}

	public void generate(ArrayList<Filmes> filmes) throws IOException {
		this.writer.write(
				"""

						<!doctype html>
						<html>
						<head>
						    <meta charset="utf-8">
						    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
						    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
						        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
						    <title>Top 250 Movies</title>
						</head>
						<body>
						<ul style="list-style:none">

						""");

		final String divTemplate =
				"""
						<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
						    <h4 class="card-header">%s</h4>
						    <div class="card-body">
						        <img class="card-img" src="%s">
						        <p class="card-text mt-2">Nota: %s - Ano: %s </p>
						    </div>
						</div>
						""";
		
		for (Filmes filme : filmes) {
            final String listItemHtml = "<li>" +
                    String.format(divTemplate,
                            filme.getTitulo(),
                            filme.getUrl(),
                            filme.getNota(),
                            filme.getAno())
                    + "</li>";
            this.writer.write(listItemHtml);
        }
	}
}
