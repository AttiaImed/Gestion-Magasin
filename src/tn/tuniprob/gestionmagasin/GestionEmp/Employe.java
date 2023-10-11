package tn.tuniprob.gestionmagasin.GestionEmp;

abstract public class Employe {
    protected int identifiant;
    protected String nom;
    protected String adresse;
    protected double nbr_heures;



    public Employe(int identifiant, String nom, String adresse, double nbr_heures) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.nbr_heures = nbr_heures;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getNbr_heures() {
        return nbr_heures;
    }

    public void setNbr_heures(double nbr_heures) {
        this.nbr_heures = nbr_heures;
    }


    public String toString() {
        return "Employe{" +
                "identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", nbr_heures=" + nbr_heures + "\n";
    }
    abstract public double calculeSalaire();

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return identifiant == employe.identifiant && nom.equals(employe.nom);
    }
}
