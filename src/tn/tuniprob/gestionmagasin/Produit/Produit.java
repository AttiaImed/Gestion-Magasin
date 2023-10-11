package tn.tuniprob.gestionmagasin.Produit;

import java.util.Date;
public class Produit {
    private int id;
    private String libelle;
    private String marque;
    private double prix;
    private Date date_expiration;

    public Produit() {
        id = 0;
        libelle = "";
        marque = "";
        prix = 0;
        date_expiration = new Date();
    }

    public Produit(int id, String libelle, String marque, double prix) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
        this.prix = prix;
        this.date_expiration = new Date();
    }

    public String toString() {
        return "L'identifiant de produit est " + this.id + "\n"
                + " Libellé est : " + this.libelle + "\n"
                + " La marque est  : " + this.marque + "\n"
                + " Le prix est : " + this.prix + "\n"
                + " La date " + this.date_expiration + "\n";
    }

    public void afficher() {
        System.out.println("Libellé: " + libelle);
        System.out.println("Prix: " + prix);
    }
    public boolean comparer(Produit p) {
        return this.id == p.id &&
                this.libelle.equals(p.libelle) &&
                this.prix == p.prix;
    }
    public static boolean comparer(Produit p1, Produit p2) {
        return p1.id == p2.id &&
                p1.libelle.equals(p2.libelle) &&
                p1.prix == p2.prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double nprix) {
        if (nprix > 0) {
            this.prix = nprix;
        }
    }
}
