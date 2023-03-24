public class Filmes implements Comparable<Filmes> {
	
	private String titulo;
	private String url;
	private String nota;
	private String ano;
	
	public Filmes() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Filme = [titulo=" + titulo + ", url=" + url + ", nota=" + nota + ", ano=" + ano + "] \n";
	}

	public int compareTo(Filmes filme) {

		return this.titulo.compareTo(filme.getTitulo());
	}	
}
