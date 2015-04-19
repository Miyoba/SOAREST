package mair;
import javax.xml.ws.Endpoint;

//Endpoint publisher
public class SOAPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello", new SOAImpl());
        System.out.println("published");

    }

}