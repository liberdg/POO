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
public class CmRM extends Commande{
    private String nom;
     @Override
    public void executer() {
        //  on a bien le parametre ?
        if(nom == null){
            System.out.println("Parametres manquants");
            return;
        }
        
        //  le fichier existe ?
         Fichier fichier = Navigateur. getInstance().getRepertoireCourant().getFichierParNom(nom);
        if(fichier == null){
            System.out. println("Fichier inexistant");
            return;
        }
        
        // On supprime le fichier
        Navigateur.getInstance().getRepertoireCourant().supprimerFichier(nom);
        
        System.out.println("Suppression effectuee");
    
    }

    @Override
    public void setPararmetres(String[] parametres) {
        if(parametres != null && parametres.length >= 1){
            this.nom = parametres[0];
        }
        
    }
    
    
}
