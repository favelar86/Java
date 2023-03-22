public class Filmes {
	
	private String titulo;
	private String url;
	private Double nota;
	private int ano;
	
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

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Filme = [titulo=" + titulo + ", url=" + url + ", nota=" + nota + ", ano=" + ano + "] \n";
	}	
}
