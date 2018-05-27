# Projet_Charlet_Courtois_ElGharib_Plantet


## Lancer le projet

Back-end : aller dans le dossier simple-service pour faire : mvn clean install exec:java

Front-end : aller dans le dossier Projet/myapp puis faire npm start

## Technologies utilisées

Back-end : Jersey + JAX-RS

Front-end : React + typescript

## Fonctionnalités implémentées

### Back-end

 - Génération de JSON contenant tous les fichiers du Google Drive de l'utilisateur qui s'est connecté (via /myapp/db/auth puis via /myapp/db/validateAuth/access_token={token})
 - Suppression de fichier
 - Upload de fichier


### Front-end

 - Lecture d'un fichier JSON, et traitement pour affichage normalisé de la liste des fichiers représentée dans ce JSON (avec détails)
