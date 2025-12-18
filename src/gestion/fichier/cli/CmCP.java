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
public class CmCP extends Commande{
    private String nomSource;
    private String nomDestination;
     @Override
    public void executer() {
        //  on a bien les deux parametres ? 
        if(nomSource == null || nomDestination == null){
            System.out.println("Parametres manquants");
            return;
        }
        
        //  le fichier source existe ?
         Fichier fichierSource = Navigateur.getInstance().getRepertoireCourant().getFichierParNom(nomSource);
        if(fichierSource == null){
            System.out.println("Fichier source inexistant");
            return;
        }
        
        //  la destination n'existe pas deja ? 
        if(Navigateur. getInstance().getRepertoireCourant().getFichierParNom(nomDestination) != null){
            System.out.println("Fichier destination existant");
            return;
        }
        
        // On cree la copie selon le type du fichier source
        if(fichierSource.estRepertoire()){
            // C'est un repertoire, on cree un repertoire
            Navigateur.getInstance().getRepertoireCourant().ajouterRepertoire(nomDestination);
        }else{
            // C'est un fichier simple, on cree un fichier simple
            Navigateur.getInstance().getRepertoireCourant().ajouterFichierSimple(nomDestination);
        }
        
        System.out.println("Copie effectuee");
    
    }

    @Override
    public void setPararmetres(String[] parametres) {
        if(parametres != null && parametres.length >= 2){
            this.nomSource = parametres[0];
            this.nomDestination = parametres[1];
        }
        
    }
    
    
}
