import tn.tuniprob.gestionmagasin.GestionEmp.Caissier;
import tn.tuniprob.gestionmagasin.GestionEmp.Responsable;
import tn.tuniprob.gestionmagasin.GestionEmp.Vendeur;
import tn.tuniprob.gestionmagasin.Magasin.Magasin;
import tn.tuniprob.gestionmagasin.Produit.Produit;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Produit lait = new Produit();
        Produit yaourt = new Produit();
        Produit tomate = new Produit(3250,"Tomate","Sicam",1.200);

        lait.setId(1021);
        lait.setLibelle("Lait");
        lait.setMarque("Delice");
        lait.setPrix(1200);

        yaourt.setId(2510);
        yaourt.setLibelle("Yaourt");
        yaourt.setMarque("Vitalait");
        yaourt.setPrix(1500);

        lait.afficher();
        yaourt.afficher();
        tomate.afficher();

        lait.setPrix(0.700);
        System.out.println(lait.getPrix());

        yaourt.setPrix(1.100);
        System.out.println("Prix Modifer ");
        System.out.println(yaourt.toString());

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1);
        calendar.set(Calendar.MONTH, 10 - 1);
        lait.setDate_expiration(calendar.getTime());
        yaourt.setDate_expiration(calendar.getTime());
        tomate.setDate_expiration(calendar.getTime());

        System.out.println(lait.toString());
        System.out.println(yaourt.toString());
        System.out.println(tomate.toString());



        System.out.println("/////Gestion Employee//////");
        Magasin m3 = new Magasin(6,"Carrefour","Centre-Ville");
        Magasin m4 = new Magasin(6,"Monoprix","Menzah6");

        //Employees pour la premier magasin
        Caissier c1 = new Caissier(1,"Mariem","Sousse",170,3);
        Caissier c2 = new Caissier(2,"Wassef","Hal9 wed",250,2);
        Vendeur v1 = new Vendeur(1,"Med Salah","Centre-Ville",180,89);
        Responsable r1 = new Responsable(1,"wassef","Mnihla",180,100);

        //Employees pour la deuxieme magasin
        Caissier c3 = new Caissier(1,"imed","Sousse",170,3);
        Vendeur v2 = new Vendeur(1,"Ali","Centre-Ville",180,10);
        Vendeur v3 = new Vendeur(1,"Med","Centre-Ville",180,10);
        Vendeur v4 = new Vendeur(1,"Amin","Centre-Ville",180,10);
        Responsable r2 = new Responsable(1,"Attia","Mnihla",180,100);

        //Remplissage des magasin
        System.out.println("/////Magasin 1//////");
        m3.ajouterProduit(lait);
        m3.ajouterProduit(tomate);
        m3.ajouterPersonne(c1);
        m3.ajouterPersonne(c2);
        m3.ajouterPersonne(v1);
        m3.ajouterPersonne(r1);
        System.out.println(m3.toString());
        System.out.println("/////Magasin 2//////");
        m4.ajouterProduit(yaourt);
        m4.ajouterProduit(lait);
        m4.ajouterProduit(tomate);
        m4.ajouterPersonne(v2);
        m4.ajouterPersonne(v3);
        m4.ajouterPersonne(v4);
        m4.ajouterPersonne(r2);
        m4.ajouterPersonne(c3);
        System.out.println(m4.toString());

        //Gestion des Salaire
        System.out.println("///// Gestion Salaire //////");
        System.out.println(r1.toString());
        System.out.println("La salaire de l'employee est : "+ r1.calculeSalaire());
        System.out.println(c1.toString());
        System.out.println("La salaire de l'employee est : "+ c1.calculeSalaire());
        System.out.println(v1.toString());
        System.out.println("La salaire de l'employee est : "+ v1.calculeSalaire());


        System.out.println("//////////////Affichage du salaire");
        m4.afficherSalaire();
        m3.afficherSalaire();

        System.out.println("////// Prime Reponsable///////");
        m4.affichePrimeResponsable();
        m3.affichePrimeResponsable();






    }
}
