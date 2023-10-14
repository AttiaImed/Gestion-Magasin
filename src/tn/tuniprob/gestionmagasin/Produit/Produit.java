package tn.tuniprob.gestionmagasin.Produit;

import tn.tuniprob.gestionmagasin.Exceptions.PrixNegatifException;

import java.util.Date;

public class Produit {
    private int id;
    private String libelle;
    private String marque;
    private double prix;
    private Date date_expiration;

    public Produit() {
        super();
    }

    public Produit(int id, String libelle, String marque, double prix) throws PrixNegatifException {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
        if (prix > 0) {
            this.prix = prix;
        } else {
            throw new PrixNegatifException("Le prix est négatif");
        }
        this.date_expiration = new Date();
    }

    public String toString() {
        return "L'identifiant du produit est " + this.id + "\n"
                + "Libellé : " + this.libelle + "\n"
                + "Marque : " + this.marque + "\n"
                + "Prix : " + this.prix + "\n"
                + "Date d'expiration : " + this.date_expiration + "\n";
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

    public void setPrix(double nprix) throws PrixNegatifException {
        if (nprix > 0) {
            this.prix = nprix;
        } else {
            throw new PrixNegatifException("Prix négatif");
        }
    }
}
