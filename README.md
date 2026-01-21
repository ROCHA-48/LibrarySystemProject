 # Système de Gestion de Bibliothèque - Java (Console)

## Description
Ce projet est un système de gestion de bibliothèque développé en Java.  
Il permet de gérer une collection de livres avec différentes fonctionnalités : ajout, suppression, mise à jour, tri, recherche, historique d'emprunts et activités récentes.

## Fonctionnalités
- Ajouter, supprimer et mettre à jour des livres
- Rechercher des livres par titre, auteur ou ISBN
- Tri des livres par titre (bulles), auteur (sélection) ou année (rapide)
- Stockage des livres dans un tableau
- Liste chaînée pour l'historique des emprunts
- Pile pour les activités récentes
- Menu console interactif pour l'utilisateur

## Structure du projet

## Compilation et exécution
1. Compiler tous les fichiers Java :
```bash
javac -d out $(find src/main/java -name "*.java")
# LibrarySystemProject

Projet Java – Système de gestion de bibliothèque (console)

## 📌 Dépôt GitHub
https://github.com/ROCHA-48/LibrarySystemProject

## ⚙️ Compilation
javac -d out $(find src/main/java -name "*.java")

## ▶️ Exécution
java -cp out App.Main
