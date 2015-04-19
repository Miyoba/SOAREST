package mair;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.jws.WebService;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


/**
 * Created by Wolf on 16.04.2015.
 */
@WebService(endpointInterface = "mair.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

    private DBManager man = new DBManager("god", "triangle", "localhost", "iknow", 3306);

    @Override
    public String getHelloWorldAsString(String name) {
        man.connect();
        man.fillDB("News");
        return man.getData(name);

    }
}
