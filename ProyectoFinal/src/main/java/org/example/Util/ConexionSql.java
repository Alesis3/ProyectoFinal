package org.example.Util;

import java.sql.*;

public class ConexionSql {
    private String baseDatos;
    public static ConexionSql _instance;
    public Connection connection;

    private ConexionSql ( String database){
        this.baseDatos = database;
      try{
          Class.forName("org.sqlite.JDBC");
          connection = DriverManager.getConnection("jdbc:sqlite: " + this.baseDatos);

      }catch (SQLException sqle) {
          System.out.println("Si");
      }catch (Exception e){
          System.out.println("no");
      }
    }

    public static ConexionSql getInstance(String baseDatos){
        if(_instance == null){
            _instance = new ConexionSql(baseDatos);
        }else{
            System.out.println("Ya se creó");
        }
        return _instance;
    }
    public Connection getConnection() {
        return connection;
    }

}
