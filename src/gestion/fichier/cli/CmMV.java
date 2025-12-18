/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Fichier;

/**
 *
 * @author liber
 */
public class CmMV extends Commande {
    private String ancienNom;
    private String nouveauNom;
     @Override
    public void executer() {
          // on a bien les deux parametres ? 
        if(ancienNom == null || nouveauNom == null){
            System.out.println("Parametres manquants");
            return;
        }
        
        //  le fichier a deplacer existe ?
         Fichier fichier = Navigateur. getInstance().getRepertoireCourant().getFichierParNom(ancienNom);
        if(fichier == null){
            System.out.println("Fichier inexistant");
            return;
        }
        
        // verifier si  le nouveau nom n'est pas deja pris 
        if(Navigateur. getInstance().getRepertoireCourant().getFichierParNom(nouveauNom) != null){
            System. out.println("Fichier destination existant");
            return;
        }
        
        // On cree la copie selon le type
        if(fichier.estRepertoire()){
            Navigateur.getInstance().getRepertoireCourant().ajouterRepertoire(nouveauNom);
        }else{
            Navigateur.getInstance().getRepertoireCourant().ajouterFichierSimple(nouveauNom);
        }
        
        // on supprime l'original 
        Navigateur.getInstance().getRepertoireCourant().supprimerFichier(ancienNom);
        
        System.out.println("Deplacement effectue");
    }
    @Override
    public void setPararmetres(String[] parametres) {
        if(parametres != null && parametres. length >= 2){
            this.ancienNom = parametres[0];
            this.nouveauNom = parametres[1];
        }
        
    }
    
    
}
