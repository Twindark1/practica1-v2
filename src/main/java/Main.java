/**
 * Created by cesarjose on 5/24/17.
 */

import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.Jsoup;
import java.util.Scanner;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) throws IOException {

        // Parte Inicial

        Scanner scanner = new Scanner(System.in);
        String url = "https://en.wikipedia.org/wiki/John_Wick:_Chapter_2";

        Document doc = Jsoup.connect(url).get();

        // Parte A

        String page = doc.html();
        String[] lines = page.split("\n");
        System.out.println("La cantidad de lineas es: "+ lines.length);

        // Parte B

        Elements parrafo = doc.getElementsByTag("p");
        System.out.println("La cantidad etiquetas P es: "+ parrafo.size());

        // Parte C

        for (Element sentence : doc.getElementsByTag("p"))
        {
            // sentence.getElementById("")
        }
    }
}
