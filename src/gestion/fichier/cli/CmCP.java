/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.FichierSimple;
import gestion.fichier.metier.Repertoire;

/**
 *
 * @author liber
 */
public class CmCP extends Commande{
    private String nomSource;
    private String nomDestination;
    @Override
    public void executer() {
        if(nomSource == null || nomDestination == null){
            System.out.println("Parametres manquants");
            return;
        }
        Fichier fichierSource = Navigateur.getInstance().getRepertoireCourant().getFichierParNom(nomSource);
        if(fichierSource == null){
            System.out.println("Fichier source inexistant");
            return;
        }
        if(Navigateur.getInstance().getRepertoireCourant().getFichierParNom(nomDestination) != null){
            System.out.println("Fichier destination existant");
            return;
        }
        if(fichierSource.estRepertoire()){
            Navigateur.getInstance().getRepertoireCourant().ajouterRepertoire(nomDestination);
        }else{
            Navigateur.getInstance().getRepertoireCourant().ajouterFichierSimple(nomDestination);
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        if(parametres != null && parametres.length >= 2){
            this.nomSource = parametres[0];
            this.nomDestination = parametres[1];
        }
        
    }
    
    
    
}
