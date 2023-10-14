package tn.tuniprob.gestionmagasin.GestionEmp;

public class Caissier extends Employe {
    private int numeroDeCaisse;

    public Caissier(int id, String nom, String add, double nbr_heure, int numeroDeCaisse) {
        super(id, nom, add, nbr_heure);
        this.numeroDeCaisse = numeroDeCaisse;
    }

    @Override
    public String toString() {
        return super.toString() + "Type Employee: Caissier\n" +
                "Numero de Caisse: " + numeroDeCaisse + "\n" +
                "Salaire: " + this.calculeSalaire() + '\n';
    }

    @Override
    public double calculeSalaire() {
        double salaire = 0;
        if (this.nbr_heures <= 180) {
            salaire = this.nbr_heures * 5;
        } else {
            salaire = 1800 + ((this.nbr_heures - 180) * 1.5);
        }
        return salaire;
    }
}
