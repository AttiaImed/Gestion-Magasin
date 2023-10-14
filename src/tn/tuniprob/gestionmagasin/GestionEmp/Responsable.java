package tn.tuniprob.gestionmagasin.GestionEmp;

public class Responsable extends Employe {
    private int prime;

    public Responsable(int id, String nom, String addresse, double nbr_heure, int prime) {
        super(id, nom, addresse, nbr_heure);
        this.prime = prime;
    }

    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }

    @Override
    public String toString() {
        return super.toString() + "Type Employee est : Responsable\n" +
                "prime=" + prime + ", Salaire est : " + this.calculeSalaire() + "\n";
    }

    public double calculeSalaire() {
        double salaire = 0;
        if (this.nbr_heures < 160) {
            salaire = (this.nbr_heures * 10) + this.prime;
        } else {
            salaire = 1600 + prime + ((this.nbr_heures - 160) * 0.2);
        }
        return salaire;
    }
}
