import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FluxoJsaon {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://imdb-api.com/en/API/Top250Movies/k_x8813nda")).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String listaFilmesString = response.body().substring(11, response.body().length() - 21);
        String[] listaFilmesJson = listaFilmesString.split("\\},\\{");

        List<String> listaFilmes = new ArrayList<>(Arrays.asList(listaFilmesJson));

        List<String> listaTitulos = new ArrayList<>();
        List<String> listaImagens = new ArrayList<>();
        List<String> listaAnos = new ArrayList<>();
        List<String> listaNotas = new ArrayList<>();


        for(String itemString: listaFilmes) {
            List<String> itemElemento = Arrays.asList(itemString.split(","));
            listaTitulos.add(itemElemento.get(2));
            listaImagens.add(itemElemento.get(5));
            listaAnos.add(itemElemento.get(4));
            listaNotas.add(itemElemento.get(12));
        }

        for(int i = 0; i <250; i++ ) {
            System.out.println(listaTitulos.get(i) + "--" + listaImagens.get(i) + "--" + listaAnos.get(i) + "--" + listaNotas.get(i) + "\n");
        }
        
        
        
       
    }
}