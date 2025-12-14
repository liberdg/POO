/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;



/**
 *
 * @author liber
 */
public class CmLS extends Commande{
   // private String nom;
    @Override
    public void executer() {
        Navigateur.getInstance().getRepertoireCourant().afficherContenu();
    }

    @Override
    public void setParametres(String[] parametres) {
        //this.nom= parametres[0];
        
    }
    
    
    
}
