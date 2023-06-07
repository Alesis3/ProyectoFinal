package org.example;
import org.example.Controlador.ControladorTablets;
import org.example.Vista.Ventana;


public class Main {
    public static void main(String[] args) {
        Ventana vn = new Ventana("Ventana");
        ControladorTablets crl = new ControladorTablets(vn);



    }
}