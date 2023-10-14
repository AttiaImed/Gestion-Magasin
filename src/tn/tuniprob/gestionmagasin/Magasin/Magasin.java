package tn.tuniprob.gestionmagasin.Magasin;

import tn.tuniprob.gestionmagasin.Exceptions.MagasinPleinException;
import tn.tuniprob.gestionmagasin.GestionEmp.Caissier;
import tn.tuniprob.gestionmagasin.GestionEmp.Employe;
import tn.tuniprob.gestionmagasin.GestionEmp.Responsable;
import tn.tuniprob.gestionmagasin.Produit.Produit;

public class Magasin {
    private int id;
    private String nom;
    private String address;
    private static final int CAPACITY_PR = 2;
    private Produit[] listProduit = new Produit[CAPACITY_PR];
    private Employe[] listPersonnel = new Employe[20];
    private int nbrProduits = 0;
    private int norPersonnel;
    private static int totalProduit;
    private static int totalPersonnel;

    public Magasin() {
        super();
    }

    public Magasin(int id, String nom, String address) {
        this.id = id;
        this.address = address;
        this.nom = nom;
    }

    public void ajouterProduit(Produit p) throws MagasinPleinException {
        if (!chercherProduit(p)) {
            if (nbrProduits < CAPACITY_PR) {
                listProduit[nbrProduits] = p;
                nbrProduits++;
                totalProduit++;
            } else {
                throw new MagasinPleinException("Magasin est plein");
            }
        } else {
            System.out.println("le produit existe");
        }
    }

    public boolean chercherProduit(Produit p) {
        if (this.listProduit != null) {
            for (Produit produit : this.listProduit) {
                if (produit != null && produit.comparer(p)) {
                    return true;
                }
            }
            return false;
        } else {
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
        for (int i = 0; i < norPersonnel; i++) {
            if (listPersonnel[i] != null) {
                str.append(listPersonnel[i].toString()).append("\n");
            }
        }
        return str.toString();
    }

    public void ajouterPersonne(Employe p) {
        if (norPersonnel < listPersonnel.length) {
            listPersonnel[norPersonnel] = p;
            norPersonnel++;
            totalPersonnel++;
        }
    }

    public void supprimerPersonne(int idPersonne) {
        int indexASupprimer = -1;
        for (int i = 0; i < norPersonnel; i++) {
            if (listPersonnel[i] != null && listPersonnel[i].getIdentifiant() == idPersonne) {
                indexASupprimer = i;
                break;
            }
        }
        if (indexASupprimer != -1) {
            listPersonnel[indexASupprimer] = listPersonnel[norPersonnel - 1];
            listPersonnel[norPersonnel - 1] = null;
            norPersonnel--;
            totalPersonnel--;
        }
    }
    
    @Override
    public String toString() {
        return "Magasin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", address='" + address + '\n' +
                this.afficher() +
                ", nbrProduits=" + nbrProduits +
                ", nbrPersonne=" + norPersonnel +
                '}';
    }

    public void afficherSalaire() {
        for (int i = 0; i < norPersonnel; i++) {
            if (listPersonnel[i] != null) {
                System.out.println(listPersonnel[i].calculeSalaire());
            }
        }
    }

    public void affichePrimeResponsable() {
        for (int i = 0; i < norPersonnel; i++) {
            if (listPersonnel[i] instanceof Responsable) {
                System.out.println(((Responsable) listPersonnel[i]).getPrime());
            }
        }
    }

    public void afficheNombreEmployesParType() {
        int nombreCaissier = 0;
        int nombreResponsables = 0;
        int nombreVendeur = 0;

        for (Employe employe : listPersonnel) {
            if (employe instanceof Responsable) {
                nombreResponsables++;
            } else if (employe instanceof Caissier) {
                nombreCaissier++;
            } else {
                nombreVendeur++;
            }
        }
        System.out.println("Nombre d'employés caissier : " + nombreCaissier);
        System.out.println("Nombre de responsables : " + nombreResponsables);
        System.out.println("Nombre d'employés vendeur : " + nombreVendeur);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Produit[] getListProduit() {
        return listProduit;
    }

    public void setListProduit(Produit[] listProduit) {
        this.listProduit = listProduit;
    }

    public Employe[] getListPersonnel() {
        return listPersonnel;
    }

    public void setListPersonnel(Employe[] listPersonnel) {
        this.listPersonnel = listPersonnel;
    }

    public int getNbrProduits() {
        return nbrProduits;
    }

    public void setNbrProduits(int nbrProduits) {
        this.nbrProduits = nbrProduits;
    }

    public int getNorPersonnel() {
        return norPersonnel;
    }

    public void setNorPersonnel(int norPersonnel) {
        this.norPersonnel = norPersonnel;
    }

    public static int getTotalProduit() {
        return totalProduit;
    }

    public static void setTotalProduit(int totalProduit) {
        Magasin.totalProduit = totalProduit;
    }

    public static int getTotalPersonnel() {
        return totalPersonnel;
    }

    public static void setTotalPersonnel(int totalPersonnel) {
        Magasin.totalPersonnel = totalPersonnel;
    }
}
