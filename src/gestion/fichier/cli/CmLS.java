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
    private String chemin;
    @Override
    public void executer() {
        if(chemin == null){
            Navigateur.getInstance().getRepertoireCourant().afficherContenu();
        }else{
            if(Navigateur.getInstance().getRepertoireCourant().existeRepertoire(chemin)){
                Navigateur.getInstance().getRepertoireCourant().getRepertoire(chemin).afficherContenu();
            }else{
                System.out.println("Repertoire inexistant");
            }
        }
    }

    @Override
    public void setParametres(String[] parametres) {
        if(parametres != null && parametres.length > 0){
            this.chemin = parametres[0];
        }
        
    }
    
    
    
}
