package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.simple.*;
import org.json.simple.parser.*;


public class ConnectionDB {

    PreparedStatement sta;

    public static Connection getConnection()
    {
        Connection conn = null;
        JSONParser parser = new JSONParser();

       /* String dbURL="jdbc:mysql://localhost:3306/libreriagui";
        String username="root";
        String password="Fercho7772735";*/

        try
        {
            String credentials_path = System.getProperty("user.dir")+"/src/utils/db_credentials.json";
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(credentials_path));

            String host     = (String)jsonObject.get("db_ip");
            String port     = (String)jsonObject.get("db_port");
            String username = (String)jsonObject.get("db_user");
            String password = (String)jsonObject.get("db_password");
            String dbURL    = "jdbc:mysql://"+host+":"+port+"/libreriagui";

            conn= DriverManager.getConnection(dbURL,username, password);

            /*if(conn != null)
            {
                System.out.println("Conectado!! -"+conn);
            }*/
        }

        catch(SQLException | FileNotFoundException ex)
        {
            ex.printStackTrace();
        }

        catch (IOException | ParseException ex)
        {
            ex.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args)
    {
        getConnection();
    }


}
