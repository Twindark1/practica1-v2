/**
 * Created by cesarjose on 5/24/17.
 */

import org.jsoup.Connection;
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

        System.out.println("Escriba la url de la pagina: ");

        Scanner scanner = new Scanner(System.in);
        String url = scanner.next();

        Connection.Response responseParagraph = Jsoup.connect(url).execute();
        Document doc = Jsoup.connect(url).get();

        // Parte A

        System.out.println("La cantidad de lineas es: "+ responseParagraph.body().split("\n").length);

        // Parte B

        Elements parrafo = doc.getElementsByTag("p");
        System.out.println("La cantidad etiquetas P es: "+ parrafo.size());

        // Parte C

        int i=1;
        for (Element sentence : doc.getElementsByTag("p"))
        {
            System.out.print("La cantidad de Imagenes dentro de P " + i + " es igual a: ");
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

        System.out.println("La cantidad de formularios con metodo GET es = " +  contadorGet);
        System.out.println("La cantidad de formularios con metodo POST es = " +  contadorPost);

        // Parte E

        i=1;
        for (FormElement forms :formularios.forms())
        {
            Elements inputs = forms.getElementsByTag("input");
            for (Element x : inputs)
            {
                System.out.println("El input "+ i +  " = " + x.attr("type"));
                i++;
            }
        }

        // Parte F

        i = 1;
        Document newDocument;

        for (Element form: formularios.forms())
        {
            System.out.println("Formulario " + i + ":");
            Elements posts = form.getElementsByAttributeValueContaining("method","post");

            for (Element post: posts)
            {
                String absURL = post.absUrl("action");
                newDocument = Jsoup.connect(absURL).data("asignatura","practica1").post();
                System.out.println(newDocument.body().toString());
            }
            i++;
            System.out.println("\n");
        }
    }
}