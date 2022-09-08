public class Movie {

    String titulo;
    String UrlImage;
    String nota;
    String ano;

    Movie(String titulo, String UrlImage, String nota, String ano) {
        this.titulo = titulo;
        this.UrlImage = UrlImage;
        this.nota = nota;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlImage() {
        return UrlImage;
    }

    public String getNota() {
        return nota;
    }

    public String getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return this.titulo.substring(9, this.titulo.length() - 1);
    }

}
