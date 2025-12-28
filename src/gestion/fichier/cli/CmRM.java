/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;

/**
 *
 * @author liber
 */
public class CmRM extends Commande {
    private String nom;

    @Override
    public void executer() {
        if(nom == null) {
            System.out.println("ERREUR: Veiller entrer le nom du Fichier a supprimer");
            return;
        }

        Repertoire r = Navigateur.getInstance().getRepertoireCourant();

        if(r.getFichierParNom(nom) == null) {
            System.out.println("Le Fichier n'existe pas");
            return;
        }

        try {
            r.supprimerFichier(nom);
            System.out.println("Suppression effectuee");
        } catch(Exception e) {
            // En cas d'erreur
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }

    @Override
    public void setPararmetres(String[] parametres) {
        if(parametres != null && parametres.length > 0)
            nom = parametres[0];
    }
}