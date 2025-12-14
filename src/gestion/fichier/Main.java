/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion.fichier;

import gestion.fichier.cli.Commande;
import gestion.fichier.cli.Navigateur;
import gestion.fichier.metier.Repertoire;
import gestion.fichier.cli.ParseurCommande;
import gestion.fichier.metier.Fichier;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author liber
 */
public class Main {

        private static Scanner clavier = new Scanner(System.in);
        private static ParseurCommande parseur = new ParseurCommande();
        //private static Navigateur naviguer=new Navigateur();
        private static Navigateur naviguer = Navigateur.getInstance();
        private static Repertoire root = new Repertoire("/", null);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
      
      System.out.println("Bonjour!!!\n Entrer votre comande");
      try{
          Fichier.restaurer();
      }catch(Exception e){
          e.printStackTrace();
      }
      
      
      Navigateur.getInstance().setRepertoireCourant(Fichier.getRoot());
      while(true){
      String chemin= "liber@hp:"
              + Navigateur.getInstance().getRepertoireCourant().
                      getNomComplet()
              + "$";
          
      System.out.print(chemin);
      String strCmde = clavier.nextLine();
      
      Commande commande=parseur.parser(strCmde);
      commande.executer();
        
      }  
    }
      

       
}
