package mair;

/**
 * Created by Wolf on 16.04.2015.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SOAClient {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ws/hello?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://mair/", "SOAImplService");

        Service service = Service.create(url, qname);

        SOA hello = service.getPort(SOA.class);



        System.out.println(hello.searcher(search()));

    }

    public static String search(){
        // read line
        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        String line="";

        System.out.println("Type in a word... \n  ");

        //
        while(line.equalsIgnoreCase("")) {
            try {
                line = buffer.readLine();
            } catch (IOException e) {
            }
            if(!line.equalsIgnoreCase("")) {
                return line;
            }
        }

        return null;
    }

}