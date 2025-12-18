/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import java.io.FileNotFoundException;

/**
 *s
 * @author liber
 */
public class CmLS extends Commande {
    //private String nom;
    private String chemin;

    @Override
    public void executer() {
      if(chemin == null){
            Navigateur.getInstance().getRepertoireCourant().afficherContenu();
        }else{
            // Si on a un parametre, on verifie si le repertoire existe
            if(Navigateur. getInstance().getRepertoireCourant().existeRepertoire(chemin)){
                try {
                    // Le repertoire existe, on affiche son contenu
                    Navigateur.getInstance().getRepertoireCourant().getRepertoire(chemin).afficherContenu();
                } catch (FileNotFoundException ex) {
                    System.getLogger(CmLS.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }else{
                // Le repertoire n'existe pas
                System.out. println("Repertoire inexistant");
            }
        }
    }

    @Override
    public void setPararmetres(String[] parametres) {
    // Le chemin est optionnel
        if(parametres != null && parametres. length > 0){
            this.chemin = parametres[0];
       }
     }
    
     
}
