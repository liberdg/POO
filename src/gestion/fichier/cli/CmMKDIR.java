/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import java.nio.file.FileAlreadyExistsException;

/**
 *
 * @author liber
 */
public class CmMKDIR extends Commande {
    private String nom;

    @Override
    public void executer() {
        
        try{
            
        
        if(! Navigateur.getInstance().getRepertoireCourant().existeRepertoire(nom)){
            
        Navigateur.getInstance().getRepertoireCourant().ajouterRepertoire(nom);
        }else{
            throw new FileAlreadyExistsException("Un fichier ou répertoire de ce nom existe déjà !");
            }
        } catch (FileAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } 
    }

    @Override
    public void setPararmetres(String[] parametres) {
        this.nom = parametres[0];
    }
     
}
