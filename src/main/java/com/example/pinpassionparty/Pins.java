package com.example.pinpassionparty;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Pins {
    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Image img;

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    private double prix;
    private String description;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private String nom;
    public Pins(String Nom, double prix, String description){
        this.nom=nom;
        this.prix= prix;
        this.description= description;
    }
}
