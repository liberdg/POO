/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichier.cli;

import gestion.fichier.metier.Fichier;
import gestion.fichier.metier.Repertoire;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;


public class CmMV extends Commande {
    private String source;
    private String dest;

    @Override
    public void executer() {
        try {
            if (source == null || source.equals("")) {
                throw new IllegalArgumentException("La source est obligatoire ");
            }

            // Récupérer le dossier courant
            Repertoire repCourant = Navigateur.getInstance().getRepertoireCourant();

            // Chercher le fichier à déplacer par son chemin 
            Fichier fichierSource = repCourant.getFichierParNom(source);
            if (fichierSource == null) {
                throw new FileNotFoundException("Le fichier ou dossier source n'existe pas ");
            }

            // trouver le rep destination 
            Repertoire destination;
            if (dest == null || dest.equals("")) {
                destination = repCourant;
            } else {
                Fichier cible = repCourant.getFichierParNom(dest);
                if (cible == null || !cible.estRepertoire()) {
                    throw new FileNotFoundException("La destination doit exister et être un répertoire ");
                }
                destination = (Repertoire) cible;
            }

            // Vérifier qu'un même nom n'existe pas dans la destination
            if (destination.getFichierParNom(fichierSource.getNom()) != null) {
                throw new FileAlreadyExistsException("Un fichier ou dossier du même nom existe déjà dans la destination ");
            }

            // Supprimer du répertoire courant et ajouter à la destination
            repCourant.supprimerFichier(source);
            destination.getFichiers().add(fichierSource);

            System.out.println("Déplacement effectué !");
        } catch (FileNotFoundException  e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }
    }

    @Override
   public void setPararmetres(String[] parametres) {
        if(parametres != null && parametres. length >= 2){
            this.source = parametres[0];
            this.dest = parametres[1];
        }
}}