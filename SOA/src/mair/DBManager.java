package mair;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;

/**
 * Created by Wolf on 19.04.2015.
 */
public class DBManager {

    private MysqlDataSource ds;
    private Connection con;
    private Statement st;
    private ResultSet rs = null;

    DBManager(String user, String pass, String host, String db, int port){

        System.out.print("Connection starting\n");
        ds = new MysqlDataSource();
        ds.setServerName(host);
        ds.setUser(user);
        ds.setPassword(pass);
        ds.setDatabaseName(db);
        ds.setPort(port);
    }


    public void connect(){
        try {
            con = ds.getConnection();
            st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getData(String text){
        System.out.println("Starting to search Articles ...");
        String erg = "";
        long count = 0;

        try{
            rs = st.executeQuery("select * from Article where title like '%"+text+"%';");

            if(rs != null){
                //Deklarieren von Attributen
                int colCount;

                String[] colName;
                String[] row;

                //ResultSetMetaData Objekt erstellen um deren Methoden zu benutzen
                ResultSetMetaData md = rs.getMetaData();
                //Spalten anzahl
                colCount = md.getColumnCount();

                erg += "\n";

                //Den Inhalt der Tabellenmodel speichern
                while (rs.next()) {
                    count++;
                    row = new String[colCount];
                    for (int i = 1; i <= colCount; i++) {
                        erg += md.getColumnName(i)+": ";
                        erg += rs.getString(i)+"| ";
                    }
                    erg += "\n\n";
                }
            }

            rs.close();
            st.close();
            con.close();
            System.out.println("Finished Searching ... "+count+" Articles are matching the search string ...");
            return erg;
        }
        catch(SQLException sqle){
            System.out.print("Error: "+sqle.getMessage());
            return "Wait what did you say?";
        }
    }


    public void fillDB(String text){

        System.out.println("Filling Database with entries.");
        String query = "";
        long startTime = System.currentTimeMillis();
        System.out.println("Preparing the Data ...");
        for(int z = 0; z < 1000; z++) {
            query = "";
            for (int i = 0; i < 1000; i++) {
                query += "('" + text + "" + (1000*z+i) + "','The important number is " + (1000*z+i) + "!')";
                System.out.println(1000*z+i);
                if (i + 1 < 1000)
                    query += ",";
            }
            System.out.println("Finished preparing Data ...");
            try {
                System.out.println("Starting to insert ...");
                st.executeUpdate("INSERT INTO Article (title,body) VALUES" + query + ";");
                System.out.println("Finished inserting ...");
            } catch (SQLException sqle) {
                System.out.print("Error: " + sqle.getMessage());
            }
        }
        System.out.println("The procedure took: "+(System.currentTimeMillis()-startTime)/1000+" seconds\n");
        }

    }
