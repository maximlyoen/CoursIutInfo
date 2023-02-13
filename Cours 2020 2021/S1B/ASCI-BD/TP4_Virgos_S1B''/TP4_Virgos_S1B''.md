# TP4 : Opérations ensemblistes et jointures externes 

## ACSI-BD 
## Virgos Antoine S1B'' 

# Première partie - Compléments sur les jointures 

- Nombre d’éditeurs par pays, en affichant 0 si aucun éditeur du pays n’est connu (67 lignes, 16 éditeurs allemands, aucun éditeur bolivien)

```sql
select count(Editeur.Code_Editeur) as nbEditeurs, Pays.Nom_Pays
from Editeur 
right outer join Pays on Pays.Code_Pays = Editeur.Code_Pays
group by Pays.Nom_Pays
order by Pays.Nom_Pays asc
```

- Nombre d'interprètes par pays, en affichant 0 si aucun interprète du pays n’est connu (67 lignes, 124 interprètes français, aucun interprète laotien)

```sql
select count(distinct Musicien.Code_Musicien) as nbMusiciens, Pays.Nom_Pays
from Interpréter
inner join Musicien on Musicien.Code_Musicien = Interpréter.Code_Musicien
right outer join Pays on Pays.Code_Pays = Musicien.Code_Pays
group by Pays.Nom_Pays
order by Pays.Nom_Pays asc
```

- Nombre de musiciens par instrument, en affichant 0 si aucun musicien n’est connu (98 lignes, 99 musiciens pour 'Baryton') [en cours]

```sql
select count(distinct Musicien.Code_Musicien) as nbMusiciens, Instrument.Nom_Instrument
from Musicien
right outer join Instrument on Instrument.Code_Instrument = Interpréter.Code_Instrument
group by Instrument.Nom_Instrument
order by Instrument.Nom_Instrument asc
```

- Nombre d'instruments différents par enregistrement, en affichant 0 si aucun instrument n’est spécifié (15 077 lignes, maximum 6 instruments)

```sql
select count(distinct Instrument.Code_Instrument) as nbInstruments, Enregistrement.Code_Enregistrement
from Instrument
inner join Interpréter on Interpréter.Code_Instrument = Instrument.Code_Instrument
right outer join Enregistrement on Enregistrement.Code_Enregistrement = Interpréter.Code_Enregistrement
group by Enregistrement.Code_Enregistrement
order by nbInstruments desc
```

- Liste des symphonies et des chefs qui les ont dirigées (jointure normale) (205 lignes) 

```sql
select distinct Composition.Titre_Composition, Musicien.Nom_Musicien, Musicien.Prénom_Musicien
from Direction
inner join Musicien on Direction.Code_Musicien = Musicien.Code_Musicien
inner join Enregistrement on Direction.Code_Enregistrement = Enregistrement.Code_Enregistrement
inner join Composition on Enregistrement.Code_Composition=Composition.Code_Composition
where Composition.Titre_Composition like '%Symphonie%'
```

- Liste des symphonies et des chefs qui les ont dirigées, même si le chef est inconnu (220 lignes)

```sql
select distinct Composition.Titre_Composition, Musicien.Nom_Musicien, Musicien.Prénom_Musicien
from Direction
left join Musicien on Direction.Code_Musicien = Musicien.Code_Musicien
right join Enregistrement on Direction.Code_Enregistrement = Enregistrement.Code_Enregistrement
left outer join Composition on Enregistrement.Code_Composition=Composition.Code_Composition
where Composition.Titre_Composition like '%Symphonie%'
```

- Mise en forme de la requête précédente : afficher "nom inconnu", "prénom_inconnu" si le chef est inconnu (220 lignes)

```sql
select distinct Composition.Titre_Composition, Coalesce(Musicien.Nom_Musicien, 'Inconnu') as Nom_Musicien, Coalesce(Musicien.Prénom_Musicien, 'Inconnu') as Prénom_Musicien
from Direction
left join Musicien on Direction.Code_Musicien = Musicien.Code_Musicien
right join Enregistrement on Direction.Code_Enregistrement = Enregistrement.Code_Enregistrement
left outer join Composition on Enregistrement.Code_Composition=Composition.Code_Composition
where Composition.Titre_Composition like '%Symphonie%' and Musicien.Nom_Musicien in ('Beethoven', 'Inconnu')
```

- Liste des symphonies de Beethoven et des chefs qui les ont dirigées, même si l’information est inconnue (12 lignes, une seule dont le chef est inconnu)

```sql
select distinct Composition.Titre_Composition, Coalesce(Musicien.Nom_Musicien, 'Inconnu') as Nom_Musicien, Coalesce(Musicien.Prénom_Musicien, 'Inconnu') as Prénom_Musicien
from Direction
left join Musicien on Direction.Code_Musicien = Musicien.Code_Musicien
right join Enregistrement on Direction.Code_Enregistrement = Enregistrement.Code_Enregistrement
left outer join Composition on Enregistrement.Code_Composition=Composition.Code_Composition
where Composition.Titre_Composition like '%Symphonie%'
```

# Seconde partie - compléments divers

- Liste des prénoms qui sont portés à la fois par un chef d'orchestre et par un interprète (81 lignes)

```sql
select Musicien.Prénom_Musicien
from Musicien
inner join Direction on Direction.Code_Musicien = Musicien.Code_Musicien
intersect
select Musicien.Prénom_Musicien
from Musicien
inner join Interpréter on Interpréter.Code_Musicien = Musicien.Code_Musicien
```

- Liste des prénoms qui sont portés par un chef d'orchestre ou un interprète (550 lignes)

```sql
select Musicien.Prénom_Musicien
from Musicien
inner join Direction on Direction.Code_Musicien = Musicien.Code_Musicien
union
select Musicien.Prénom_Musicien
from Musicien
inner join Interpréter on Interpréter.Code_Musicien = Musicien.Code_Musicien
```

- Compositeurs qui sont aussi des chefs d’orchestre (8 lignes)

```sql
select Musicien.Prénom_Musicien, Musicien.Nom_Musicien
from Musicien
inner join Composer on Composer.Code_Musicien = Musicien.Code_Musicien
intersect
select Musicien.Prénom_Musicien, Musicien.Nom_Musicien
from Musicien
inner join Direction on Direction.Code_Musicien = Musicien.Code_Musicien
```

- Liste des noms des compositeurs qui ne sont pas des noms d'interprètes (349 lignes)

```sql
select Musicien.Nom_Musicien
from Musicien
inner join Composer on Composer.Code_Musicien = Musicien.Code_Musicien
except
select Musicien.Nom_Musicien
from Musicien
inner join Interpréter on Interpréter.Code_Musicien = Musicien.Code_Musicien
```

- Calculer pour chaque musicien, le nombre de musiciens qui le précédent dans l’ordre alphabétique (1 962 lignes, 6 musiciens précèdent John Adams)

```sql
select count(Musicien.Code_Musicien), Musicien.Prénom_Musicien, Musicien.Nom_Musicien
from Musicien
group by Musicien.Nom_Musicien, Musicien.Prénom_Musicien
order by Musicien.Nom_Musicien, Musicien.Prénom_Musicien asc
```

- Liste des compositeurs n’ayant pas composé de sonate (323 lignes) 

```sql
select Musicien.Prénom_Musicien, Musicien.Nom_Musicien
from Musicien
inner join Composer on Composer.Code_Musicien = Musicien.Code_Musicien
except
select Musicien.Prénom_Musicien, Musicien.Nom_Musicien
from Musicien
inner join Composer on Composer.Code_Musicien = Musicien.Code_Musicien
inner join Oeuvre on Oeuvre.Code_Oeuvre = Composer.Code_Oeuvre
inner join Composition_Oeuvre on Composition_Oeuvre.Code_Oeuvre = Oeuvre.Code_Oeuvre
inner join Composition on Composition.Code_Composition = Composition_Oeuvre.Code_Composition
where Composition.Titre_Composition like '%Sonate%'
```

- Liste des musiciens n’étant ni compositeur ni chef d’orchestre (1 333 lignes)

```sql
select Musicien.Nom_Musicien
from Musicien
except
select Musicien.Nom_Musicien
from Musicien
inner join Composer on Composer.Code_Musicien = Musicien.Code_Musicien 
left outer join Direction on Direction.Code_Musicien = Musicien.Code_Musicien
```

- Nom des éditeurs et noms des musiciens (sur une seule colonne, nommée Nom) (1 953 lignes)

```sql
select Editeur.Nom_Editeur as 'Nom'
from Musicien
inner join Pays on Pays.Code_Pays = Musicien.Code_Pays
right outer join Editeur on Editeur.Code_Pays = Pays.Code_Pays
union
select Musicien.Nom_Musicien
from Musicien
```

- Liste des pays ayant des musiciens mais pas d'éditeur (36 lignes)

```sql
select Pays.Nom_Pays
from Pays
inner join Musicien on Musicien.Code_Pays = Pays.Code_Pays
except
select Pays.Nom_Pays
from Pays
inner join Editeur on Editeur.Code_Pays = Pays.Code_Pays
```

- Liste des interprètes n'ayant interprété aucun enregistrement au piano (446 lignes)

```sql
select Musicien.Prénom_Musicien, Musicien.Nom_Musicien
from Musicien
inner join Interpréter on Interpréter.Code_Musicien = Musicien.Code_Musicien
except
select Musicien.Prénom_Musicien, Musicien.Nom_Musicien
from Musicien
inner join Interpréter on Interpréter.Code_Musicien = Musicien.Code_Musicien
inner join Enregistrement on Enregistrement.Code_Enregistrement = Interpréter.Code_Enregistrement
inner join Instrument on Instrument.Code_Instrument = Interpréter.Code_Instrument 
where Instrument.Nom_Instrument not like '%Piano%' and Enregistrement.Titre not like '%Piano%'
```