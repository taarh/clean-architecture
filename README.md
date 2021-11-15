# clean-architecture

Clean architecture est un style d'architecture qui permet une séparation fine des différentes couches de l'applications. la couche entité , et userCase qui représentent le coeur de l'application
et les couche BD, Rest api , les jobs qui sont au dessus de la couche core .

# Avantage

1- Indépendance à la base de donnée et Framework :  l'application n'est pas dépendant d'un ORM ou Base de données. on peut la changer facielement.  
2- Indépendade à l'interface utilisateur :  l'interface utilisateur peut changer facilement , sans changer le reste de l'application et la logique métier.  
3- Testable : maintenant l'application est testable . on peut tester nos logiques métier sans besoin sans considérer les services externes (UI,DB, Mocking services).  
4- Indépendance aux services externes:  en réalité, la logique métier ne connaist rien sur ce qui se passe à l'exterieur.  

# Technologies

Java 8, Kubernetes, Docker, Kafka
