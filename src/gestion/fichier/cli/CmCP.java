/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;
import java.nio.file.FileAlreadyExistsException;

/**
 *
 * @author liber
 */
public class CmCP extends Commande {
   private String source;
    private String destination;

    @Override
    public void executer() {
        try {
           
            if (source == null || source.equals("")) {
                throw new IllegalArgumentException("Le fichier source est obligatoire.");
            }

            // Prendre le dossier courant
            Repertoire rep = Navigateur.getInstance().getRepertoireCourant();

            //  Trouver le fichier source
            Fichier fichierSource = rep.getFichierParNom(source);
            if (fichierSource == null) {
                throw new FileNotFoundExistsException("Le fichier source n'existe pas.");
            }

            //  Destination : dossier courant si vide
            Repertoire dossierDestination = rep;
            String nomFinal = fichierSource.getNom();

            if (destination != null && !destination.equals("")) {
                // Si on trouve un répertoire du nom destination
                Fichier destCible = rep.getFichierParNom(destination);
                if (destCible != null && destCible.estRepertoire()) {
                    dossierDestination = (Repertoire) destCible;
                } else if (destCible == null) {
                    // destination est le nouveau nom
                    nomFinal = destination;
                } else {
                    throw new FileNotFoundExistsException("Destination invalide.");
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
        } catch (FileNotFoundExistsException  e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    @Override
    public void setPararmetres(String[] parametres) {
      if(parametres != null && parametres. length >= 2){
            this.source = parametres[0];
            this.destination = parametres[1];
        }
}
}