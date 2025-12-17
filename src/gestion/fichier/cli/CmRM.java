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
        if(nom == null){
            System.out.println("Parametres manquants");
            return;
        }
        Fichier fichier = Navigateur.getInstance().getRepertoireCourant().getFichierParNom(nom);
        if(fichier == null){
            System.out.println("Fichier inexistant");
            return;
        }
        Navigateur.getInstance().getRepertoireCourant().supprimerFichier(nom);
    }

    @Override
    public void setParametres(String[] parametres) {
        if(parametres != null && parametres.length >= 1){
            this.nom = parametres[0];
        }
        
    }
    
    
    
}
