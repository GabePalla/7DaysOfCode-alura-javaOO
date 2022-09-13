public class Movie implements Content{

    private String titulo;
    private String UrlImage;
    private String nota;
    private String ano;

    Movie(String titulo, String UrlImage, String nota, String ano) {
        this.titulo = titulo;
        this.UrlImage = UrlImage;
        this.nota = nota;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return this.titulo;
    }

    @Override
    public String Titulo() {
        return this.titulo;
    }

    @Override
    public String UrlImage() {
        return this.UrlImage;
    }

    @Override
    public String Nota() {
        return this.nota;
    }

    @Override
    public String Ano() {
        return this.ano;
    }

    @Override
    public int compareTo(Content o) {
        return this.ano.compareTo(o.Ano());
    }

    

}
