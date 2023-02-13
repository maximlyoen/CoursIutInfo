
/**
 *Interface affiche les textes principaux sur lecran de jeux.
 *
 *@author Maxim Lyoen
 */
void Interface()
{
  fondtexte();
  textFont(font, 20);
  text("Score", 295, 20);
  text(ScoreJoueur1, 20, 20);
  text(ScoreJoueur2, 610, 20);
  textFont(font, 25);
  text("MENU", 5, 395);
  text("RECOMENCER", 483, 395);
}
/**
 *InterfaceParametre elle affiche les textes principeux sur la page parametre.
 *
 *@author Maxim Lyoen
 */
void InterfaceParametre()
{
  fondtexte();
  textFont(font, 35);
  text("PARAMETRE", 230, 30);
  //
  textFont(font, 20);
  text("Background-color:", 10, 75);
  textFont(font, 12);
  fill(0, 255, 255);
  text("Bleu!", 215, 72);
  fill(121, 28, 248);
  text("Indigo!", 253, 72);
  fill(255, 255, 0);
  text("Jaune!", 305, 72);
  fill(0, 0, 0);
  text("Noir!", 350, 72);
  fill(255, 165, 0);
  text("Orange!", 389, 72);
  fill(158, 14, 64);
  text("Pourpre!", 440, 72);
  fill(255, 0, 0);
  text("Rouge!", 499, 72);
  fill(0, 128, 0);
  text("Vert!", 542, 72);
  fill(128, 0, 128);
  text("Violet!", 579, 72);
  //
  textFont(font, 18);
  fondtexte ();
  text("Couleur-Affichage:", 10, 150);
  textFont(font, 12);
  fill(0, 255, 255);
  text("Bleu!", 215, 147);
  fill(121, 28, 248);
  text("Indigo!", 253, 147);
  fill(255, 255, 0);
  text("Jaune!", 305, 147);
  fill(0, 0, 0);
  text("Noir!", 350, 147);
  fill(255, 165, 0);
  text("Orange!", 389, 147);
  fill(158, 14, 64);
  text("Pourpre!", 440, 147);
  fill(255, 0, 0);
  text("Rouge!", 499, 147);
  fill(0, 128, 0);
  text("Vert!", 542, 147);
  fill(128, 0, 128);
  text("Violet!", 579, 147);
  //
  textFont(font, 24);
  fondtexte ();
  text("Vitesse-Balle:", 10, 225);
  fill(0, 128, 0);
  text("Facile!", 230, 222);
  fill(255, 165, 0);
  text("Moyen!", 370, 222);
  fill(255, 0, 0);
  text("Difficile!", 495, 222);
  fill(128, 0, 128);
}
/**
 * fondjeux permet de changer la couleur de fonds grâce à une variable couleurfond qui pour chaque entier designe un fond écran différant.
 *
 *@author Maxim Lyoen
 */
void fondjeux ()
{
  if (couleurfond == 0)
  {
    background(fondbleu);
  }
  if (couleurfond == 1)
  {
    background(fondindigo);
  }
  if (couleurfond == 2)
  {
    background(fondjaune);
  }
  if (couleurfond == 3)
  {
    background(fondnoir);
  }
  if (couleurfond == 4)
  {
    background(fondorange);
  }
  if (couleurfond == 5)
  {
    background(fondpourpre);
  }
  if (couleurfond == 6)
  {
    background(fondrouge);
  }
  if (couleurfond == 7)
  {
    background(fondvert);
  }
  if (couleurfond == 8)
  {
    background(fondviolet);
  }
}
/**
 * fondtexte permet de changer la couleur de fonds du texte grâce à une variable couleurtexte qui pour chaque entier designe une couleur differant.
 *
 *@author Maxim Lyoen
 */
void fondtexte ()
{
  if (couleurtexte == 0)
  {
    fill(0, 255, 255);
  }
  if (couleurtexte == 1)
  {
    fill(121, 28, 248);
  }
  if (couleurtexte == 2)
  {
    fill(255, 255, 0);
  }
  if (couleurtexte == 3)
  {
    fill(0, 0, 0);
  }
  if (couleurtexte == 4)
  {
    fill(255, 165, 0);
  }
  if (couleurtexte == 5)
  {
    fill(158, 14, 64);
  }
  if (couleurtexte == 6)
  {
    fill(255, 0, 0);
  }
  if (couleurtexte == 7)
  {
    fill(0, 128, 0);
  }
  if (couleurtexte == 8)
  {
    fill(128, 0, 128);
  }
}
/**
 * mousePressed indique pour les 3 pages si on clique à un endroit d'écran different qul fonction l'on doit exécuter.
 *
 *@author Maxim Lyoen
 */
void mousePressed()
{
  if (Page == 0)
  {
    if (mouseX>0 && mouseX<70 && mouseY>367 && mouseY<400)
    {
      Page = 1;
    }
    if (mouseX>483 && mouseX<640 && mouseY>367 && mouseY<400)
    {
      Page = 0;
      ball = initBall();
      rVert = initRacket(20, height/2-RACKET_HEIGHT/2);
      rBleu = initRacket(610, height/2-RACKET_HEIGHT/2);
      ScoreJoueur1 = 0;
      ScoreJoueur2 = 0;
    }
  }
  if (Page == 1)
  {
    if (mouseX>240 && mouseX<390 && mouseY>103 && mouseY<165)
    {
      Page = 0;
      ball = initBall();
      rVert = initRacket(20, height/2-RACKET_HEIGHT/2);
      rBleu = initRacket(610, height/2-RACKET_HEIGHT/2);
      ScoreJoueur1 = 0;
      ScoreJoueur2 = 0;
    }
    if (mouseX>240 && mouseX<390 && mouseY>236 && mouseY<298)
    {
      exit();
    }
    if (mouseX>560 && mouseX<640 && mouseY>0 && mouseY<80)
    {
      Page = 2;
    }
  }
  if (Page == 2)
  {
    if (mouseX>215 && mouseX<253 && mouseY>55 && mouseY<80)
    {
      println ("CouleurdeFond:Bleu");
      couleurfond = 0;
    }
    if (mouseX>253 && mouseX<305 && mouseY>55 && mouseY<80)
    {
      println ("CouleurdeFond:Indigo");
      couleurfond = 1;
    }
    if (mouseX>305 && mouseX<350 && mouseY>55 && mouseY<80)
    {
      println ("CouleurdeFond:Jaune");
      couleurfond = 2;
    }
    if (mouseX>350 && mouseX<389 && mouseY>55 && mouseY<80)
    {
      println ("CouleurdeFond:Noir");
      couleurfond = 3;
    }
    if (mouseX>389 && mouseX<440 && mouseY>55 && mouseY<80)
    {
      println ("CouleurdeFond:Orange");
      couleurfond = 4;
    }
    if (mouseX>440 && mouseX<499 && mouseY>55 && mouseY<80)
    {
      println ("CouleurdeFond:Pourpre");
      couleurfond = 5;
    }
    if (mouseX>499 && mouseX<542 && mouseY>55 && mouseY<80)
    {
      println ("CouleurdeFond:Rouge");
      couleurfond = 6;
    }
    if (mouseX>542 && mouseX<579 && mouseY>55 && mouseY<80)
    {
      println ("CouleurdeFond:Vert");
      couleurfond = 7;
    }
    if (mouseX>579 && mouseX<630 && mouseY>55 && mouseY<80)
    {
      println ("CouleurdeFond:Violet");
      couleurfond = 8;
    }
    //
    if (mouseX>215 && mouseX<253 && mouseY>130 && mouseY<155)
    {
      println ("CouleurduTexte:Bleu");
      couleurtexte = 0;
    }
    if (mouseX>253 && mouseX<305 && mouseY>130 && mouseY<155)
    {
      println ("CouleurduTexte:Indigo");
      couleurtexte = 1;
    }
    if (mouseX>305 && mouseX<350 && mouseY>130 && mouseY<155)
    {
      println ("CouleurduTexte:Jaune");
      couleurtexte = 2;
    }
    if (mouseX>350 && mouseX<389 && mouseY>130 && mouseY<155)
    {
      println ("CouleurduTexte:Noir");
      couleurtexte = 3;
    }
    if (mouseX>389 && mouseX<440 && mouseY>130 && mouseY<155)
    {
      println ("CouleurduTexte:Orange");
      couleurtexte = 4;
    }
    if (mouseX>440 && mouseX<499 && mouseY>130 && mouseY<155)
    {
      println ("CouleurduTexte:Pourpre");
      couleurtexte = 5;
    }
    if (mouseX>499 && mouseX<542 && mouseY>130 && mouseY<155)
    {
      println ("CouleurduTexte:Rouge");
      couleurtexte = 6;
    }
    if (mouseX>542 && mouseX<579 && mouseY>130 && mouseY<155)
    {
      println ("CouleurduTexte:Vert");
      couleurtexte = 7;
    }
    if (mouseX>579 && mouseX<630 && mouseY>130 && mouseY<155)
    {
      println ("CouleurduTexte:Violet");
      couleurtexte = 8;
    }
    //
    if (mouseX>230 && mouseX<330 && mouseY>195 && mouseY<235)
    {
      println ("Niveau:Facile!");
      BALL_SPEED = 2;
    }
    if (mouseX>370 && mouseX<455 && mouseY>195 && mouseY<235)
    {
      println ("Niveau:Moyen!");
      BALL_SPEED = 3;
    }
    if (mouseX>495 && mouseX<640 && mouseY>195 && mouseY<235)
    {
      println ("niveau:Difficile");
      BALL_SPEED = 4;
    }
    if (mouseX>0 && mouseX<130 && mouseY>0 && mouseY<40)
    {
      Page = 1;
    }
  }
}
/**
 * il change image sur le menu principal si la souris et sur le bouton play ou quit.
 *
 *@author Maxim Lyoen
 */
void boutonJaune()
{
  if (mouseX>240 && mouseX<390 && mouseY>103 && mouseY<165)
  {
    copy (bouton, 200, 100, 150, 60, 240, 103, 150, 60);
  }
  if (mouseX>240 && mouseX<390 && mouseY>236 && mouseY<298)
  {
    copy (bouton, 200, 0, 150, 60, 240, 236, 150, 60);
  }
}
