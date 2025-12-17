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
public class CmMV extends Commande{
    private String ancienNom;
    private String nouveauNom;
    @Override
    public void executer() {
        Fichier fichier = Navigateur.getInstance().getRepertoireCourant().getFichierParNom(ancienNom);
        if(fichier == null){
            System.out.println("Fichier inexistant");
            return;
        }
        if(Navigateur.getInstance().getRepertoireCourant().getFichierParNom(nouveauNom) != null){
            System.out.println("Fichier destination existant");
            return;
        }
        if(fichier.estRepertoire()){
            Navigateur.getInstance().getRepertoireCourant().ajouterRepertoire(nouveauNom);
        }else{
            Navigateur.getInstance().getRepertoireCourant().ajouterFichierSimple(nouveauNom);
        }
        Navigateur.getInstance().getRepertoireCourant().supprimerFichier(ancienNom);
    }

    @Override
    public void setParametres(String[] parametres) {
        this.ancienNom = parametres[0];
        this.nouveauNom = parametres[1];
        
    }
    
    
    
}
