package mair;

import javax.jws.WebService;


/**
 * Created by Wolf on 16.04.2015.
 */
@WebService(endpointInterface = "mair.SOA")
public class SOAImpl implements SOA {

    private DBManager man = new DBManager("god", "triangle", "localhost", "iknow", 3306);

    @Override
    public String searcher(String name) {
        man.connect();
        man.fillDB("News");
        return man.getData(name);

    }
}
