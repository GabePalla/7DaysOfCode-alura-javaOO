import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

class FluxoJsonParteII {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        
        String response = new ImdbApiClient("https://imdb-api.com/en/API/Top250Movies/k_x8813nda").getBody();
        new HTMLGenerator(new FileWriter("index.html")).generate(new ImdbMovieJsonParser(response).parse());
    }
}