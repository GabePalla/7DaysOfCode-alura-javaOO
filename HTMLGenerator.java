import java.io.FileWriter;
import java.io.IOException;
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

    
    public void generate(List<Content> movie) throws IOException {
        String abreHtmlString = """
                <html>
                    <head>
                        <meta charset="utf-8">
                        <link rel="stylesheet" href="style.css">
                        <link rel="preconnect" href="https://fonts.googleapis.com">
                        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap">
                    </head>

                    <body>
                """;
        writer.write(abreHtmlString);

        for (Content movieItem : movie) {
            String body = """
                            <article id="movies">
                                <h1 id="titulo">%s</h1>
                                <img src="%s" id="image">
                                <p id="texto">Nota: %s - Ano: %s</p>
                            </article>

                    """.formatted(movieItem.Titulo(), movieItem.UrlImage(), movieItem.Nota(), movieItem.Ano());

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
