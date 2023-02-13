# Un titre de niveau 1 : h1 <h1> 

Les paragraphes sont séparés par une ligne vide. �

2ème paragraphe. accentué, gras et monospace .

les Listes :

* celui-là

* celui-là

* L'autre

# Un titre de niveau 2 : h2 <h2> 

Voici une liste numérotée:

1. premier article 
2. deuxième article  
3. troisième élément

et un exemple de code:

    # Itération ...
    pour i variant de 1 .. 10 {faire quelque chose}

Au fait, au lieu d'indenter le bloc, vous pouvez utiliser des blocs délimités, si vous aimez:

    définir foobar () {
    print "Bienvenue dans le pays des fous!";
    }

Vous pouvez éventuellement marquer le
bloc délimité avec le language pour la syntaxe ( ici Python )

    import time
    # Quick, count to ten!
    for i in range(10):
    # (but not *too* quick)
    time.sleep(0.5)
    print(i)

# Une en-tête h3 <h3>

Maintenant une liste imbriquée:

1. D'abord, procurez-vous ces ingrédients:
  * carottes
  * céleri
  * Lentilles
2. Faites bouillir de l'eau.

3. Vider tout dans le pot et suivre cet algorithme:

Voici un lien vers <un site Web>(http://foo.bar/) et vers une entête de section dans le document

Les tableaux peuvent ressembler à ceci avec l'alignement des colonnes à droite, centré et à gauche :


Nom          | Taille       | Matiere   | Couleur |
------------ | -------------|-----------|---------|
All business | 9            | en cuir   | marron  |
Cendrillon   | 11           | verre     | transparent |
Roundabout   | 10           | toile de chanvre | naturel |


Une ligne horizontale suit ...

- [ ] Case non cochée
- [x] Case cochée

Les images peuvent être spécifiées comme suit:

![/images/logo.png](https://moodle1.u-bordeaux.fr/pluginfile.php/531713/mod_label/intro/s_Hcm.jpg)

Pour la partie mathématique, un plugin supplémentaire sera peut être nécessaire et une recherche
internet pour la syntaxe.

Équation mathématique en ligne: : $\omega = d \phi / dt$

Les maths peuvent se centrer directement sur la ligne :

: $I = \int_0^2 \rho R ^ {2} dV$

Et notez que vous pouvez utiliser une barre oblique inversée pour échapper tous les caractères de
ponctuation que vous souhaitez afficher littéralement, par exemple: 'foo `, *bar *, etc

Le rendu sera différent suivant le convertisseur (Ils ont chacun points forts et points faibles) que vous
utilisez et toutes les fonctionnalités ne seront peut être pas prise en compte. Vous pouvez également
convertir vos fichiers md en ligne