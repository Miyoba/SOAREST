package mair;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Wolf on 16.04.2015.
 */
@WebService(endpointInterface = "mair.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

    @Override
    public String getHelloWorldAsString(String name) {


        return "Hello World JAX-WS " + name;
    }
}
