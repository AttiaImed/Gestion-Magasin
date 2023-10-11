package tn.tuniprob.gestionmagasin.Magasin;
import tn.tuniprob.gestionmagasin.GestionEmp.Caissier;
import tn.tuniprob.gestionmagasin.GestionEmp.Employe;
import tn.tuniprob.gestionmagasin.GestionEmp.Responsable;
import tn.tuniprob.gestionmagasin.Produit.Produit;

import java.util.Arrays;

public class Magasin {
    private int id;
    private String nom;
    private String address;
    private Produit[] listProduit = new Produit[50];
    private Employe[] listPersonne = new Employe[20];
    private int nbrProduits = 0;
    private int nbrPersonne;
    private static int totalProduit;
    private static int totalPersonne;

    public Magasin(){
        super();
    }
    public Magasin(int id, String nom,String address) {
        this.id = id;
        this.address = address;
        this.nom = nom;
    }

    public void ajouterProduit(Produit p) {
        if (!chercherProduit(p)) {
            if(nbrProduits < listProduit.length){
                listProduit[nbrProduits] = p;
                nbrProduits++;
                totalProduit++;
            }

            else{

                System.out.println("Magasin plein");
            }}
        else {

            System.out.println("le produit existe");
        }
    }



    public boolean chercherProduit(Produit p) {
        if(this.listProduit != null){
            for (Produit produit : this.listProduit) {
                if (produit != null && produit.comparer(p)) {
                    return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }

    public void supprimerProduit(int idProduitASupprimer) {
        int indexASupprimer = -1;
        for (int i = 0; i < nbrProduits; i++) {
            if (listProduit[i] != null && listProduit[i].getId() == idProduitASupprimer) {
                indexASupprimer = i;
                break;
            }
        }
        if (indexASupprimer != -1) {
            listProduit[indexASupprimer] = listProduit[nbrProduits - 1];
            listProduit[nbrProduits - 1] = null;
            nbrProduits--;
            totalProduit--;
        }
    }

    public static Magasin magasinAvecPlusDeProduits(Magasin magasin1, Magasin magasin2) {
        if (magasin1.getNbrProduits() > magasin2.getNbrProduits()) {
            return magasin1;
        } else if (magasin2.getNbrProduits() > magasin1.getNbrProduits()) {
            return magasin2;
        } else {
            return null;
        }
    }

    public String afficher() {
        StringBuilder str = new StringBuilder("listProduit= \n");

        for (int i = 0; i < nbrProduits; i++) {
                str.append(listProduit[i].toString()).append("\n");
        }
        str.append("listPersonne= \n");
        for (int i = 0; i < nbrPersonne; i++) {
            if (listPersonne[i] != null) {
                 str.append(listPersonne[i].toString()).append("\n");
            }
        }
        return str.toString();
    }
    public void ajouterPersonne(Employe p) {
        if (nbrPersonne < listPersonne.length) {
            listPersonne[nbrPersonne] = p;
            nbrPersonne++;
            totalPersonne++;
        }
    }

    public void supprimerPersonne(int idPersonne) {
        int indexASupprimer = -1;
        for (int i = 0; i < nbrPersonne; i++) {
            if (listPersonne[i] != null && listPersonne[i].getIdentifiant() == idPersonne) {
                indexASupprimer = i;
                break;
            }
        }
        if (indexASupprimer != -1) {
            listPersonne[indexASupprimer] = listPersonne[nbrPersonne - 1];
            listPersonne[nbrPersonne - 1] = null;
            nbrPersonne--;
            totalPersonne--;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbrPersonne() {
        return nbrPersonne;
    }

    public void setNbrPersonne(int nbrPersonne) {
        this.nbrPersonne = nbrPersonne;
    }

    public static int getTotalPersonne() {
        return totalPersonne;
    }

    public static void setTotalPersonne(int totalPersonne) {
        Magasin.totalPersonne = totalPersonne;
    }

    public Produit[] getListProduit() {
        return listProduit;
    }

    public void setListProduit(Produit[] listProduit) {
        this.listProduit = listProduit;
    }

    public int getNbrProduits() {
        return nbrProduits;
    }

    public void setNbrProduits(int nbrProduits) {
        this.nbrProduits = nbrProduits;
    }

    public static int getTotalProduit() {
        return totalProduit;
    }

    public static void setTotalProduit(int totalProduit) {
        Magasin.totalProduit = totalProduit;
    }

    public Employe[] getListPersonne() {
        return listPersonne;
    }

    public void setListPersonne(Employe[] listPersonne) {
        this.listPersonne = listPersonne;
    }

    @Override
    public String toString() {
        return "Magasin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", address='" + address + '\n' +
                this.afficher() +
                ", nbrProduits=" + nbrProduits +
                ", nbrPersonne=" + nbrPersonne +
                '}';
    }

    public void afficherSalaire(){
        for (int i = 0; i < nbrPersonne; i++) {
            if (listPersonne[i] != null) {
                System.out.println(listPersonne[i].calculeSalaire());
            }
        }
    }

    public void affichePrimeResponsable (){
        for (int i = 0; i < nbrPersonne; i++) {
            if (listPersonne[i] instanceof Responsable) {
                System.out.println(((Responsable) listPersonne[i]).getPrime());
            }
        }
    }

    public void afficheNombreEmployesParType() {
        int nombreCaissier = 0;
        int nombreResponsables = 0;
        int nombreVendeur = 0;

        for (Employe employe : listPersonne) {
            if (employe instanceof Responsable) {
                nombreResponsables++;
            } else if (employe instanceof Caissier) {
                nombreCaissier++;
            }else{
                nombreVendeur++;
            }
        }
        System.out.println("Nombre d'employés caissier : " + nombreCaissier);
        System.out.println("Nombre de responsables : " + nombreResponsables);
        System.out.println("Nombre d'employés vendeur : " + nombreVendeur);
    }
}
