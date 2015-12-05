# Projet-QCM

Welcome to QCM MIX Project

1. C'est quoi QUIX MIX ?

est un software qui permet de créer des versions différentes d'un sujet d'examen structuré sur la forme des Questions à choix multiples(QCM). Cela garantie la probabilité que deux candidats voisins en salle d'examen n'aient pas le même sujet d'examen avec la même organisation.

2. Systèmes d'exploitation acceptés et java

- Windows
- Linux
- Java Version 8 de préférence
 
 3. Installation 
 
 Pour la version portable
il suffit juste delancer QCM-mix.exe en tant que administrateur et la fenetre d'accueil de s'application s'ouvrira en loins d'une minute sans aucune autre sollicitation de l’utilisateur. 

Pour la version installable
Il suffit de double cliquer sur le fichier QCM-mix.exe et de suivre les instructions.

4. Models, format et structure du file input acceptés 

 -Tout fichier different  du xls doit au préalable etre converti en xls. 
 -Dans le fichier source  chaque question doit etre précedée par un nombre et  chaque proposition de réponse précédée par une lettre (a,b,c,d...)
 - Il n'y a pas un nombre limite de question, ni de propositions de réponse.
 -Toute proposition de réponse à une question doit tenir sur sa ligne d'énumeration (a,b,c,d,e,f....)
 
Model 1

 ce model de structure du format xls est formé sur 6 collonnes et autant que possible de lignes. les colonne A et D contienent les numeros des questions. B et  E les caracteres d'énumeration des propositions de réponses, tandis que les C et F contiennent les propositions de réponses.


Model 2

Ce model est formé de de colonnes 2 colonnes. L'énummération des questions(1,2,3,4,...) et des réponses(a,b,c,d.. tiennent sur la meme colonne A, tandis que les propositions de réponses sont dans la colonne B.
  NB: le nom du fichier source doit absolument commencer par ! pour etre accepté par le système.



