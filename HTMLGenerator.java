import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class HTMLGenerator {

    Writer writer;

    HTMLGenerator(FileWriter writer){
        this.writer = writer;
    }

    public Writer getWriter() {
        return writer;
    }

    
    public void generate(List<Movie> movie) throws IOException {
        String abreHtmlString = """
                <html>
                    <head>
                        <meta charset="utf-8">
                        <link rel="stylesheet" href="style.css">
                    </head>

                    <body>
                """;
        writer.write(abreHtmlString);

        for (Movie movieItem : movie) {
            String body = """
                            <article id="movies">
                                <h1 id="titulo">%s</h1>
                                <img src="%s" id="image">
                                <p id="texto">Nota: %s - Ano: %s</p>
                            </article>

                    """.formatted(movieItem.getTitulo(), movieItem.getUrlImage(), movieItem.getNota(), movieItem.getAno());

            writer.write(body);
        }

        String fechaHtmlString = """
                    </body>
                </html>
                """;
        writer.write(fechaHtmlString);

        writer.close();

        
    }
}
