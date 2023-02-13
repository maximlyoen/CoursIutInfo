<?php
srand((double)microtime() * 1000000);
$val=$_GET["pensee"];
$array = [
0=>"Moi, Adam et Eve, j'y crois plus tu vois, parce que je suis pas un idiot : la pomme ?a peut pas etre mauvais, c'est plein de pectine...",
1=>"Vandamme is back,physically and mentally. Y'a rien qui peut me stopper, except...myself and God",
2=>"Un biscuit, ca n'a pas de spirit, c'est juste un biscuit. Mais avant c'etait du lait, des oeufs.Et dans les oeufs, il y a la vie potentielle.",
3=>"Une noisette j'la casse entre mes fesses tu vois ?!",
4=>"Si tu parles à ton eau de Javel pendant que tu fais la vaisselle, elle est moins concentrée.",
5=>"Je suis fascine par l'air. Si on enlevait l'air du ciel, tous les oiseaux tomberaient par terre....Et les avions aussi.... En même temps l'air tu peux pas le toucher...ça existe et ça n'existe pas..."
];
if ($val<6){
	echo json_encode($array[$val]);	
}
else{
 	header('HTTP/1.1 500 Internal Server Error');
	 echo "Error JCVD";
}
?>