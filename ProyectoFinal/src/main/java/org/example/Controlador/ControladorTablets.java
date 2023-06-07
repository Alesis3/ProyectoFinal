package org.example.Controlador;

import org.example.Modelo.ModeloTabla;
import org.example.Modelo.Tablets;
import org.example.Vista.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorTablets extends MouseAdapter {
    private Ventana view;

    private ModeloTabla modelo;



    public ControladorTablets(Ventana view) {
        modelo = new ModeloTabla();
        this.view = view;
        this.view.getTabla().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBoton().addMouseListener(this);
        this.view.getTabla().addMouseListener(this);
        this.view.getBtnDelete().addMouseListener(this);
        this.view.getBtnModificar().addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== this.view.getBtnCargar()){
            modelo.cargarDatos();
            this.view.getTabla().setModel(modelo);
            this.view.getTabla().updateUI();
        }
        //--------Agregar--------
        if(e.getSource() == this.view.getBoton()){
            Tablets tablets;
            tablets = new Tablets();

            tablets.setMarca(this.view.getTxtMarca().getText());
            tablets.setNombre(this.view.getTxtNombre().getText());
            tablets.setPulgadas(Double.parseDouble(this.view.getTxtPulgadas().getText()));
            tablets.setColor(this.view.getTxtColor().getText());
            tablets.setUrl(this.view.getTxtUrl().getText());
            if(modelo.agregarTablet(tablets)){
                System.out.println("Se agrego correctamente");
                this.view.getTabla().updateUI();
            }else{
                System.out.println("No se pudo agregar correctamente");
            }
        this.view.limpiar();

        }
        //------MostrarImg------
        if(e.getSource()== view.getTabla()){
            System.out.println("Se hizo click en la tabla");
            int index = this.view.getTabla().getSelectedRow();
            Tablets tmp = modelo.getTablets(index);
            try {
                this.view.getImagen().setIcon(tmp.getImagen());
                this.view.getImagen().setText(" ");
            }catch (MalformedURLException mle){
                mle.printStackTrace();
            }
        }
        //-------------Eliminar----------
        if(e.getSource() == this.view.getBtnDelete()){ //Comprueba si el origen del evento es el boton de eliminacion de la vista actual
            ModeloTabla tmp = new ModeloTabla(); //Crea una nueva Instancia de la clase ModeloTabla y la asigna a la variable tmp
            int index = this.view.getTabla().getSelectedRow()
            Tablets temp = modelo.getTablets(index);
            if(tmp.eliminarTablet(Integer.toString(temp.getId()))){
                System.out.println("Se elimino correctamente");
                modelo.cargarDatos();
                this.view.getTabla().updateUI();
                this.view.limpiar();
            }else{
                System.out.println("No se pudo eliminar correctamente");
            }
        }
        //------Modificar--------
     if(e.getSource()==this.view.getBtnModificar()){
         int index = this.view.getTabla().getSelectedRow();
         Tablets tmp = modelo.getTablets(index);
         Tablets tablets = new Tablets();

         tablets.setMarca(this.view.getTxtMarca().getText());
         tablets.setNombre(this.view.getTxtNombre().getText());
         tablets.setPulgadas(Double.parseDouble(this.view.getTxtPulgadas().getText()));
         tablets.setColor(this.view.getTxtColor().getText());
         tablets.setUrl(this.view.getTxtUrl().getText());
         tablets.setId(tmp.getId());

         if(modelo.Modifcar(tablets)){
             modelo.cargarDatos();
             this.view.getTabla().setModel(modelo);
             this.view.getTabla().updateUI();
         }else{
             System.out.println("No se pudo modificar correctamente");
         }
         this.view.getTabla().updateUI();
         this.view.limpiar();
     }
    }

}
