import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FluxoJsonParteII {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://imdb-api.com/en/API/Top250Movies/k_x8813nda")).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String listaFilmesString = response.body().substring(11, response.body().length() - 21);
        String[] listaFilmesJson = listaFilmesString.split("\\},\\{");

        List<String> listaFilmes = new ArrayList<>(Arrays.asList(listaFilmesJson));

        List<Movie> listaFilmesObjeto = new ArrayList<>();
        
        for(String itemString: listaFilmes) {
            List<String> itemElemento = Arrays.asList(itemString.split(","));
            listaFilmesObjeto.add(new Movie(itemElemento.get(2), itemElemento.get(5), itemElemento.get(12), itemElemento.get(4)));
        }
        
        HTMLGenerator htmlGenerator = new HTMLGenerator(new FileWriter("index.html"));
        for (Movie movie : listaFilmesObjeto) {
            htmlGenerator.generate(movie);

        }
        htmlGenerator.getWriter().close();
        


        // listaFilmesObjeto.forEach((item) -> {System.out.println(item + "\n");});
        
       
    }
}