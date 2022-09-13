import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImdbMovieJsonParser implements JsonParser{
        String response;
        List<Content> list;

    ImdbMovieJsonParser(String response) {
        this.response = response;
        this.list = new ArrayList<>();
    }
    
    @Override
    public List<Content> parse() {
        String[] listaFilmesJson = response.substring(11, response.length() - 21).split("\\},\\{");
        List<String> listaFilmes = new ArrayList<>(Arrays.asList(listaFilmesJson));

        for(String itemString: listaFilmes) {
            List<String> itemElemento = Arrays.asList(itemString.split("\",\""));
            list.add(new Movie(itemElemento.get(2).substring(8), 
                itemElemento.get(5).substring(8), 
                itemElemento.get(7).substring(13), 
                itemElemento.get(4).substring(7)));
        }
        Collections.sort(list);
        return list;
    }
}
