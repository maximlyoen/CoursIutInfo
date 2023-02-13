<?php
    srand((float)microtime() * 1000000);
    $nom = $_GET["nom"];

    $data = array();
    if ($nom != null) {
    if (strcmp("lacanau", $_GET["nom"]) === 0 or strcmp("toutes", $_GET["nom"]) === 0) {    
    $data[]=["ville" => "lacanau", "vente" => rand(100, 1000)];
    }
    if (strcmp("biarritz", $_GET["nom"]) === 0 or strcmp("toutes", $_GET["nom"]) === 0) {
    $data[]=["ville" => "biarritz", "vente" => rand(180, 800)];
    }
    if (strcmp("nice", $_GET["nom"]) === 0 or strcmp("toutes", $_GET["nom"]) === 0) { 
    $data[]=["ville" => "nice", "vente" => rand(120, 1200)];
    }  
    echo json_encode($data);
    } else {
    echo json_encode("Planche inconnue");
    }
?>