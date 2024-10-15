markdown
# Application de Gestion des Produits et État Civil

Ce projet est une application Java utilisant Hibernate pour la gestion de produits, de stocks, de projets, et de l'état civil des citoyens. Il est structuré en plusieurs couches : persistance, services et tests.

## Table des matières

1. [Prérequis](#prérequis)
2. [Installation](#installation)
3. [Structure du projet](#structure-du-projet)
4. [Utilisation](#utilisation)
5. [Fonctionnalités](#fonctionnalités)
6. [Contributeurs](#contributeurs)

## Prérequis

- JDK 8 ou supérieur
- MySQL
- NetBeans IDE
- Dépendances Hibernate et JPA


ma.projet
├── config
│   └── hibernate.cfg.xml
├── dao
│   ├── IDao.java
├── entity
│   ├── Produit.java
│   ├── Categorie.java
│   ├── Commande.java
│   ├── Employe.java
│   ├── Tache.java
│   └── Mariage.java
├── service
│   ├── ProduitService.java
│   ├── CategorieService.java
│   ├── CommandeService.java
│   ├── LigneCommandeService.java
│   ├── EmployeService.java
│   ├── TacheService.java
│   └── MariageService.java
└── util
    └── HibernateUtil.java
Utilisation
Gestion des Produits et Commandes
Créer, afficher, modifier et supprimer des produits.
Afficher les produits selon des critères (prix, dates de commande, par catégorie).
Gérer les commandes et les lignes de commande associées.
Gestion de l'État Civil
Gérer les informations des citoyens : hommes, femmes et mariages.
Afficher les épouses d'un homme, le nombre d'enfants d'une femme entre deux dates, et les mariages d'un homme.
Gestion de Projets
Gérer des projets et des tâches associées.
Afficher les tâches réalisées par un employé, les tâches planifiées pour un projet, et les tâches réalisées entre deux dates.
Fonctionnalités
Gestion des Produits

CRUD pour les produits.
Filtrage par prix et dates de commande.
Gestion des Commandes

Gestion des commandes et lignes de commande.
Gestion de l'État Civil

Informations sur les hommes et les femmes.
Requêtes sur les mariages et les enfants.
Gestion de Projets

Informations sur les projets et les tâches.
Affichage des tâches par projet et employé.
Contributeurs
Votre Nom
Autres contributeurs
