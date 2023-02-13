const monImage = document.querySelector('img');
// construction d'un obet requete
// Ici on passe simplement le nom de l'image que l'on veut récupérer sur le serveur
//on verra plus tard qu'il est possible de passer des paramètres
let maRequete = new Request('univ.png');

//la requête part au serveur
fetch(maRequete)
//.then est exécuté quand la requète est revenue. Cette requète est aynschrone.
//donc pendant le temps d'attente le site reste utilisable (l'appel n'est pas bloquant)
.then(function (reponse) {
  //on vérifie que le serveur à retourné un code 200 
  if (!reponse.ok) {
    throw new Error(`erreur HTTP! statut: ${reponse.status}`);
  }
  //fetch retourne ce qu'on appelle une promesse
  //c'est un objet qui indique que tout c'est bien passé (ou pas). 
  //ici la promesse contient la réponse (ici un blob c'est à dire un fichier binaire : l'image)        
  return reponse.blob();
})
//grace à cette promesse retournée on est certain que l'image est bien téléchargée, 
//avec le then on peut ensuite chainer la suite des traitements.
//Sans cet appel asynchrone, 
//on pourrait en venir à la situation ou l'image serait ajoutée via le code JS alors
// qu'elle n'est pas encore physiquement sur votre ordinateur
.then(function (reponse) {
  //insertion de l'image
  let URLobjet = URL.createObjectURL(reponse);
  monImage.src = URLobjet;
});