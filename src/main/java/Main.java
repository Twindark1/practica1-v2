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

        Document documento = Jsoup.parse(doc.html());
        Elements formulario = documento.getElementsByTag("form");

        for (FormElement forms :formulario.forms())
        {
            if(forms.attr("method").equalsIgnoreCase("post"))
            {
                Connection.Response response;
                response = Jsoup.connect(url)
                        .data("asignatura","practica1")
                        .execute();

                System.out.println("La respuesta del servidor es: "+ response.body());
            }
        }
    }
}