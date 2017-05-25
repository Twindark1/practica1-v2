/**
 * Created by cesarjose on 5/24/17.
 */

import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.Jsoup;
import java.util.Scanner;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) throws IOException {

        // Parte Inicial

        Scanner scanner = new Scanner(System.in);
        String url = "https://webapp-st.pucmm.edu.do/WebSISE/Estudiante/Login.aspx?ReturnUrl=/WebSISE/Estudiante/";

        Document doc = Jsoup.connect(url).get();

        // Parte A

        String page = doc.html();
        String[] lines = page.split("\n");
        System.out.println("La cantidad de lineas es: "+ lines.length);

        // Parte B

        Elements parrafo = doc.getElementsByTag("p");
        System.out.println("La cantidad etiquetas P es: "+ parrafo.size());

        // Parte C

        int i=1;
        //  Elements newsHeadlines = doc.select("#mp-itn img");
        for (Element sentence : doc.getElementsByTag("p"))
        {
            System.out.print("La cantidad de elementos en P " + i + " es igual a: ");
            System.out.println(sentence.getElementsByTag("img").size());
            i++;
        }

        // Parte D

        int contadorGet=0;
        int contadorPost=0;

        Elements formularios = doc.getElementsByTag("form");
        for (FormElement forms :formularios.forms())
        {
            if(forms.attr("method").equalsIgnoreCase("get"))
                contadorGet++;

            else if (forms.attr("method").equalsIgnoreCase("post"))
                contadorPost++;
        }


    }
}
