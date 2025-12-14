/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Repertoire;

/**
 *
 * @author liber
 */
public class Navigateur {
     private static Navigateur instance;
    private Repertoire repertoireCourant;
   
    //Bloc static
    static {
        instance= new Navigateur();
    }
    private Navigateur(){
        
    }
    
    public static Navigateur getInstance(){
        return instance;
    }
    public Repertoire getRepertoireCourant(){
        return this.repertoireCourant;
    }
    public void setRepertoieCourant(Repertoire repertoireCourant){
        this.repertoireCourant=repertoireCourant;
    }

   /* public void setRepertoireCourant(Repertoire root) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
*/
    public void setRepertoireCourant(Repertoire rep) {
    this.repertoireCourant = rep;
}

}
