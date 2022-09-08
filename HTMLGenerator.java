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

    public void generate(Movie movie) throws IOException {

        String html = """
                <html>
                    <head>
                        <meta charset="utf-8">
                    </head>
                    <body>
                        <h1>%s</h1>
                        <img src=>
                        <img
                    </body>
                </html>
                """.formatted(movie.getTitulo());

        writer.append(html);
        
    }
}
