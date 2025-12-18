/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

/**
 *
 * @author tkossi
 */
public class CmAide extends Commande {

    @Override
    public void executer() {
       System. out.println("=== AIDE - Liste des commandes ===");
        System.out.println("exit   :  Quitter le programme");
        System.out.println("help   : Afficher cette aide");
        System.out. println("mkdir  :  Creer un repertoire (mkdir nomDossier)");
        System.out.println("touch  : Creer un fichier (touch nomFichier)");
        System.out.println("ls     : Lister le contenu (ls ou ls nomDossier)");
        System.out.println("cp     : Copier un fichier (cp source destination)");
        System.out.println("mv     :  Deplacer/renommer (mv ancien nouveau)");
        System.out.println("rm     :  Supprimer un fichier (rm nomFichier)");
    }

    @Override
    public void setPararmetres(String[] parametres) {
        
    }
    
}