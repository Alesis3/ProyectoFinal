package org.example.Util;

import org.example.Modelo.Tablets;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TabletsDad implements InterfaceDad {
    public TabletsDad() {

    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO tablets(marca, nombre, pulgadas, color, URL) VALUES(?, ?, ?, ?, ?); ";
        int rowCount = 0 ;
        PreparedStatement pstm = ConexionSql.getInstance("Tablets.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Tablets) obj).getMarca());
        pstm.setString(2, ((Tablets) obj).getNombre());
        pstm.setDouble(3, ((Tablets) obj).getPulgadas());
        pstm.setString(4, ((Tablets) obj).getColor());
        pstm.setString(5, ((Tablets) obj).getUrl());
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE tablets SET marca =?, nombre=?, pulgadas=?, color=?, Url=? WHERE id=?;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSql.getInstance("Tablets.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Tablets) obj).getMarca());
        pstm.setString(2, ((Tablets) obj).getNombre());
        pstm.setDouble(3, ((Tablets) obj).getPulgadas());
        pstm.setString(4, ((Tablets) obj).getColor());
        pstm.setString(5, ((Tablets) obj).getUrl());
        pstm.setInt(6, ((Tablets) obj).getId());

        rowCount = pstm.executeUpdate();

        return rowCount > 0;

    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM tablets WHERE id = ?;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSql.getInstance("Tablets.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {

        String sql = "SELECT * FROM tablets";
        ArrayList<Tablets> resultado = new ArrayList<>();
        Statement stm = ConexionSql.getInstance("Tablets.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            resultado.add(new Tablets(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5), rst.getString(6)));
        }
        return resultado;

    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM tablets WHERE id = ?;";
        Tablets tablets = null;

        PreparedStatement pstm = ConexionSql.getInstance("Tablets.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            tablets = new Tablets(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5), rst.getString(6));
            return tablets;
        }
        return null;
    }
}