/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.metier;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liber
 */
public class Repertoire extends Fichier{
    private List<Fichier> fichiers=new ArrayList<>();
    
    public Repertoire(){
        
    }
     public Repertoire(String nom, Repertoire repertoireParent){
         super(nom, repertoireParent);
        
    }
    public void ajouterRepertoire(String nom ){
       new Repertoire(nom,this);
    }
     public void ajouterFichierSimple(String nom ){
        new FichierSimple(nom,this);
    }
     public void afficherContenu(){
         for(Fichier fichier: fichiers){
             System.out.print(fichier.getNom()+ "\t");
         }
     }
     /*public  boolean existeFichierSimple(String nom){
         for(Fichier fichier:fichiers){
             if(fichier instanceof FichierSimple && fichier.getNom().equals(nom)){
                 return true;
             }
           
         }
             return false;
     }*/
     public boolean existeFichierSimple(String nom){
         if(nom== null){
             return false;
         }
         for(Fichier f: fichiers){
             if(f.estRepertoire()&& f.getNom().equals(nom)){
                 return true;
             }
         }
         return false;
     }
     public boolean existeRepertoire(String nom){
         if(nom== null){
             return false;
         }
         for(Fichier f: fichiers){
             if(f.estRepertoire()&& f.getNom().equals(nom)){
                 return true;
             }
         }
         return false;
     }
     public Repertoire getRepertoire(String nom){
         if(nom== null){
             return null;
         }
         for(Fichier f: fichiers){
             if(f.estRepertoire()&& f.getNom().equals(nom)){
                 return (Repertoire) f;
             }
         }
         return null;
     }
    /* public  boolean existeRepertoire(String nom){
         for(Fichier fichier:fichiers){
             if(fichier instanceof Repertoire && fichier.getNom().equals(nom)){
                 return true;
             }
           
         }
             return false;
     }*/
     public boolean estRepertoire(){
         return true;
     }
    @Override
    public int getTaille(){
        int taille = 0;
        for(Fichier fichier:fichiers){
            taille += fichier.getTaille();
        }
        return taille;
    }
    
    public List<Fichier> getFichier(){
        return this.fichiers;
    }
    
    public void supprimerFichier(String nom){
        if(nom == null){
            return;
        }
        for(int i = 0; i < fichiers.size(); i++){
            if(fichiers.get(i).getNom().equals(nom)){
                fichiers.remove(i);
                return;
            }
        }
    }
    
    public Fichier getFichierParNom(String nom){
        if(nom == null){
            return null;
        }
        for(Fichier f: fichiers){
            if(f.getNom().equals(nom)){
                return f;
            }
        }
        return null;
    }

    
    
}
