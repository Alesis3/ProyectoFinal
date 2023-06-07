package org.example.Modelo;

import org.example.Util.TabletsDad;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.PseudoColumnUsage;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTabla implements TableModel {
    public static final int COLUMNAS = 6;
    private ArrayList<Tablets> info;
    private TabletsDad tlD;

    public ModeloTabla() {
        tlD = new TabletsDad();
        info = new ArrayList<Tablets>();
    }

    public ModeloTabla(ArrayList<Tablets> info) {
        this.info = info;
        tlD = new TabletsDad();
    }

    @Override
    public int getRowCount() {
        return info.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return "Id";
            case 1:
                return "Marca";
            case 2:
                return "Nombre";
            case 3:
                return "Pulgadas";
            case 4:
                return "Color";
            case 5:
                return "Url";

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            case 4:
                return String.class;
            case 5:
                return String.class;

        }
        return null;
    }


    @Override
    public boolean isCellEditable(int i, int i1) {

        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tablets tmp = info.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getMarca();
            case 2:
                return tmp.getNombre();
            case 3:
                return tmp.getPulgadas();
            case 4:
                return tmp.getColor();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int colIndex) {
        switch (colIndex) {
            case 0:
                //info.get(rowIndex).getId((String) o);
                break;
            case 1:
                info.get(rowIndex).setMarca((String) o);
                break;
            case 2:
                info.get(rowIndex).setNombre((String) o);
                break;
            case 3:
                info.get(rowIndex).setPulgadas((Double) o);
                break;
            case 4:
                info.get(rowIndex).setColor((String) o);
                break;
            case 5:
                info.get(rowIndex).setUrl((String) o);
                break;

        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
    public void cargarDatos(){
        try {
            info = tlD.obtenerTodo();

        }catch (SQLException sql){
            sql.printStackTrace();
        }
    }

    public boolean agregarTablet(Tablets tablets){
        boolean resultado = false;
        try {
            if (tlD.insertar(tablets)){
                info.add(tablets);
                resultado= true;
            }else{
                resultado = false;
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }
        return resultado;
    }
    public boolean eliminarTablet(String id){
        boolean resultado = false;
        try{
            if (tlD.delete(id)) {
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sql){
            sql.printStackTrace();
        }
        return resultado;
    }
    public boolean Modifcar(Tablets tablets){

        boolean resultado = false;
        try {
            if (tlD.update(tablets)) {
                info.add(tablets);
                resultado = true;
            } else {
                resultado = false;
            }
        }catch(SQLException sql){
         sql.printStackTrace();
        }
        return resultado;
    }
    public Tablets getTablets(int inx){
        return info.get(inx);

    }
}