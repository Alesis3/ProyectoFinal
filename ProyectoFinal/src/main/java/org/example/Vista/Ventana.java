package org.example.Vista;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.sql.SQLException;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JLabel lblId;
    private JLabel lblMarca;
    private JLabel lblNombre;
    private JLabel lblPulgadas;
    private JLabel lblColor;
    private JLabel lblUrl;
    private JTextField txtId;
    private JTextField txtMarca;
    private JTextField txtNombre;
    private JTextField txtPulgadas;
    private JTextField txtColor;
    private JTextField txtUrl;
    private JButton boton;
    private JPanel panel2;
    private JScrollPane scrollPane;
    private JButton btnCargar;
    private JTable tabla;
    private JPanel panel3;
    private  JLabel imagen;
    private JPanel panel4;


    private JLabel lblDelete;

    private JTextField txtDelete;

    private JButton btnDelete;
    private JButton btnModificar;
    private GridLayout layout;




    public Ventana(String title) throws HeadlessException {
        this.setSize(800, 800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel1
        panel1 = new JPanel();
        panel1.setBackground(new Color(0x9A63FF));
        this.getContentPane().add(panel1);

        lblMarca = new JLabel("Marca");
        txtMarca = new JTextField(15);
        panel1.add(lblMarca);
        panel1.add(txtMarca);

        lblNombre  = new JLabel("Nombre");
        txtNombre = new JTextField(15);
        panel1.add(lblNombre);
        panel1.add(txtNombre);

        lblPulgadas  = new JLabel("Pulgadas");
        txtPulgadas = new JTextField(15);
        panel1.add(lblPulgadas);
        panel1.add(txtPulgadas);

        lblColor  = new JLabel("Color");
        txtColor = new JTextField(15);
        panel1.add(lblColor);
        panel1.add(txtColor);

        lblUrl  = new JLabel("Url");
        txtUrl = new JTextField(30);
        panel1.add(lblUrl);
        panel1.add(txtUrl);

        boton = new JButton("Agregar");
        panel1.add(boton);


        this.getContentPane().add(panel1);

        //panel2
        panel2 = new JPanel();
        panel2.setBackground(new Color(0xF553FDE3, true));
        btnCargar = new JButton("Cargar");
        tabla  = new JTable();
        scrollPane = new JScrollPane(tabla);
        panel2.add(scrollPane);
        panel2.add(btnCargar);



        this.getContentPane().add(panel2);

        //panel3
        panel3 = new JPanel();
        panel3.setBackground(new Color(0x68EF5E));
        imagen = new JLabel("...");
        panel3.add(imagen);




        this.getContentPane().add(panel3);

        //panel4
        panel4 = new JPanel();
        panel4.setBackground(new Color(0xF1DA69));
        btnDelete = new JButton("Delete");
        panel4.add(btnDelete);
        btnModificar = new JButton("Modificar");
        panel4.add(btnModificar);

        JLabel accion = new JLabel("¿Que desea realizar?");
        accion.setFont(new Font("Arial", Font.BOLD,15));
        panel4.add(accion);



        this.getContentPane().add(panel4);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
//---------------------------------------------getter and setters----------------------------------------------


    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblMarca() {
        return lblMarca;
    }

    public void setLblMarca(JLabel lblMarca) {
        this.lblMarca = lblMarca;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblPulgadas() {
        return lblPulgadas;
    }

    public void setLblPulgadas(JLabel lblPulgadas) {
        this.lblPulgadas = lblPulgadas;
    }

    public JLabel getLblColor() {
        return lblColor;
    }

    public void setLblColor(JLabel lblColor) {
        this.lblColor = lblColor;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public void setTxtMarca(JTextField txtMarca) {
        this.txtMarca = txtMarca;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtPulgadas() {
        return txtPulgadas;
    }

    public void setTxtPulgadas(JTextField txtPulgadas) {
        this.txtPulgadas = txtPulgadas;
    }

    public JTextField getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(JTextField txtColor) {
        this.txtColor = txtColor;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JLabel getImagen() {
        return imagen;
    }

    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getLblDelete() {
        return lblDelete;
    }

    public void setLblDelete(JLabel lblDelete) {
        this.lblDelete = lblDelete;
    }

    public JTextField getTxtDelete() {
        return txtDelete;
    }

    public void setTxtDelete(JTextField txtDelete) {
        this.txtDelete = txtDelete;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public void limpiar(){
        txtMarca.setText(" ");
        txtNombre.setText(" ");
        txtPulgadas.setText(" ");
        txtColor.setText(" ");
        txtUrl.setText(" ");
    }
}
