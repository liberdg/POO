/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

/**
 *
 * @author liber
 */
public class CmCP extends Commande {
   private String nomComplet;
    private String nomCompletDestination;

    @Override
    public void executer() {
        try {
           
            if (nomComplet == null || nomComplet.equals("")) {
                throw new IllegalArgumentException("Le fichier source est obligatoire.");
            }

            // Prendre le dossier courant
            Repertoire rep = Navigateur.getInstance().getRepertoireCourant();

            //  Trouver le fichier source
            Fichier fichierSource = rep.getFichierParNom(nomComplet);
            if (fichierSource == null) {
                throw new FileNotFoundException("Le fichier source n'existe pas.");
            }

            //  Destination : dossier courant si vide
            Repertoire dossierDestination = rep;
            String nomFinal = fichierSource.getNom();

            if (nomCompletDestination != null && !nomCompletDestination.equals("")) {
                // Si on trouve un répertoire du nom destination
                Fichier destCible = rep.getFichierParNom(nomCompletDestination);
                if (destCible != null && destCible.estRepertoire()) {
                    dossierDestination = (Repertoire) destCible;
                } else if (destCible == null) {
                    // destination est le nouveau nom
                    nomFinal = nomCompletDestination;
                } else {
                    throw new FileNotFoundException("Destination invalide.");
                }
            }

            //  Existence d'un fichier du même nom à destination ?
            if (dossierDestination.getFichierParNom(nomFinal) != null) {
                throw new FileAlreadyExistsException("Un fichier du même nom existe déjà dans le répertoire de destination !");
            }

            //  Créer la copie 
            if (fichierSource.estRepertoire()) {
                dossierDestination.ajouterRepertoire(nomFinal);
            } else {
                dossierDestination.ajouterFichierSimple(nomFinal);
            }

            System.out.println("Copie effectuée !");
        } catch (FileNotFoundException  e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    @Override
    public void setPararmetres(String[] parametres) {
      if(parametres != null && parametres. length >= 2){
            this.nomComplet = parametres[0];
            this.nomCompletDestination = parametres[1];
        }
}
}