package tn.tuniprob.gestionmagasin.GestionEmp;

public class Vendeur extends Employe {
    private double tauxDeVente;
    private final double CNST_VALUE = 450.0;

    public Vendeur(int id, String nom, String add , double nbr_heure, int tauxDeVente){
        super(id,nom,add,nbr_heure);
        this.tauxDeVente = tauxDeVente;
    }

    public double getTauxDeVente() {
        return tauxDeVente;
    }

    public void setTauxDeVente(int tauxDeVente) {
        this.tauxDeVente = tauxDeVente;
    }

    @Override
    public String toString() {
        return super.toString()+"Type Employee est : Vendeur /" +
                "tauxDeVente=" + tauxDeVente + ",  Salaire est : " + this.calculeSalaire()+
                '}';
    }

    public double calculeSalaire(){
       return CNST_VALUE * (this.tauxDeVente/100);
    }
}
