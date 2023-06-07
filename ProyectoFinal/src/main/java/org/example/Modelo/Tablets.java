package org.example.Modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Tablets {
    private int id;
    private String marca;
    private String nombre;
    private double pulgadas;
    private String Color;
    private String url;

    public Tablets() {
    }

    public Tablets(int id, String marca, String nombre, double pulgadas, String color, String url) {
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.pulgadas = pulgadas;
        Color = color;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Tablets{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pulgadas=" + pulgadas +
                ", Color='" + Color + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImagen = new URL(this.url);
        return new ImageIcon(urlImagen);
    }
}
