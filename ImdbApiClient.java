import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient {

    HttpRequest request;
    HttpClient client;

    ImdbApiClient(String request)throws URISyntaxException {
        this.request = HttpRequest.newBuilder().uri(new URI(request)).GET().build();
        this.client = HttpClient.newHttpClient();
    }

    public String getBody()throws IOException, InterruptedException {
        return client.send(this.request, HttpResponse.BodyHandlers.ofString()).body();
    }


}
