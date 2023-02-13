import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_Pong extends PApplet {

// Constantes - Couleurs
final int NOIR = color(0);
final int BLANC = color(255);
final int ROUGE = color(255, 0, 0);
final int VERT = color(0, 255, 0);
final int BLEU = color(0, 0, 255);
// Variables
int ScoreJoueur1 = 0;
int ScoreJoueur2 = 0;
int Page = 1;
int couleurfond = 3;
int couleurtexte = 6;
int vitesse = 3;
boolean Pause = true;
// Polices
PFont font;
// Images
PImage fondmenu;
PImage bouton;
PImage parametre;
PImage fondbleu;
PImage fondindigo;
PImage fondjaune;
PImage fondorange;
PImage fondpourpre;
PImage fondrouge;
PImage fondvert;
PImage fondviolet;
PImage fondnoir;
PImage fondblanc;
PImage racket1;
PImage racket2;
PImage ball1;
/**
 *Cette fonction permet de mettre en pause quand on appuis sur la bar espace.
 *
 *@param val Pause
 *@return Pause
 *@author Maxim Lyoen
 */
public void keyPressed()
{
  switch(key)
  {
  case ' ' :
    if (Pause == true)
    {
      loop();
      Pause = false;
    } else
    {
      noLoop();
      Pause = true;
    }
    break;
  }
}
/** La balle */
Ball ball;
Racket rVert, rBleu;
/**
 * Fonction d'initialisation Processing.
 */
public void setup()
{
  

  // on initialise nos objets
  ball = initBall();
  rVert = initRacket(20, height/2-RACKET_HEIGHT/2);
  rBleu = initRacket(610, height/2-RACKET_HEIGHT/2);
  font = loadFont("DejaVuSansMono-Oblique-48.vlw");
  fondmenu = loadImage("fondmenu.png");
  bouton = loadImage("button.png");
  parametre = loadImage("parametre.png");
  fondbleu = loadImage("fondbleu.png");
  fondindigo = loadImage("fondindigo.png");
  fondjaune = loadImage("fondjaune.png");
  fondorange = loadImage("fondorange.png");
  fondpourpre = loadImage("fondpourpre.png");
  fondrouge = loadImage("fondrouge.png");
  fondvert = loadImage("fondvert.png");
  fondviolet = loadImage("fondviolet.png");
  fondnoir = loadImage("fondnoir.png");
  fondblanc = loadImage("fondblanc.png");
  racket1 = loadImage("player01.png");
  racket2 = loadImage("player02.png");
  ball1 = loadImage("ball.png");
}
/**
 * Fonction de rafraichissement Processing.
 */
public void draw()
{
  if (Page == 0)
  {
    fondjeux();
    showBall(ball); 
    moveBall(ball);
    showRacket(rVert);
    showRacket(rBleu);
    moveRacketUp(rVert);
    moveRacketDown(rVert);
    moveRacketUp(rBleu);
    moveRacketDown(rBleu);
    gestionDuScore();
    Interface();
    gestionClavierDepuisDraw();
  } else
  {
    if (Page == 1)
    {
      background(fondmenu);
      copy (bouton, 0, 100, 150, 60, 240, 103, 150, 60);
      copy (bouton, 0, 0, 150, 60, 240, 236, 150, 60);
      image (parametre, 560, 10);
      boutonJaune();
    } else
    {
      background(fondmenu);
      InterfaceParametre();
      textFont(font, 30);
      fill(255, 255, 255);
      text("RETOUR", 10, 30);
    }
  }
}
/**
 * si la balle touche le cêté droit du mur on donne un point à joueur gauche et sur la balle touche le mur gauche on donne un point au joueur droit.
 *
 *@param val  Ball.x,Ball.y,ScoreJoueur1 et ScoreJoueur2
 *@return ScoreJoueur1 et ScoreJoueur2
 *@author Maxim Lyoen
 */
public void gestionDuScore()
{
  if (ball.x > 635)
  {
    ScoreJoueur1 = ScoreJoueur1 + 1;
    ball.x = 320;
    ball.y = 200;
  }
  if (ball.x < 3)
  {
    ScoreJoueur2 = ScoreJoueur2 + 1;
    ball.x = 320;
    ball.y = 200;
  }
}
/** largeur (ou diamètre) de la balle */
final int BALL_WIDTH = 6;
/** vitesse de déplacement de la balle */
int BALL_SPEED = 3;
/** couleur de la balle */
final int BALL_COLOR = BLANC; 
/**
 *il crée les differente class pour ball.
 *
 *@author Maxim Lyoen
 */
class Ball {

  /** abscisse du centre de la balle */
  int x;

  /** ordonnée du centre de la balle */
  int y;

  /** mouvement sur l'axe des abscisses */
  int mvt_x;

  /** mouvement sur l'axe des ordonnées */
  int mvt_y;
}
/**
 * il initialise les parametres des racket.
 *
 *@author Maxim Lyoen
 */
public Ball initBall() {
  Ball ball = new Ball();
  ball.x = width/2;
  ball.y = height/2;
  ball.mvt_x = BALL_SPEED;
  ball.mvt_y = BALL_SPEED;
  return ball;
}
/**
 * il affiche la balle.
 *
 *@author Maxim Lyoen
 */
public void showBall(Ball b) 
{
  image (ball1, b.x, b.y);
}
/**
 * il gere le rebon de la balle contre les mur et la rackette.
 *
 *@author Maxim Lyoen
 */
public void moveBall(Ball b)
{
  // Mouvement Horizontal
  b.x += b.mvt_x;
  if (collisionHorizontale(b))
  {
    b.x -= b.mvt_x; // mouvement annulé
    b.mvt_x *= -1; // changement de direction
  }

  // Mouvement Vertical
  b.y += b.mvt_y;
  if (collisionVerticale(b))
  {
    b.y -= b.mvt_y; // mouvement annulé
    b.mvt_y *= -1; // changement de direction
  }
}
/**
 * il indique a quel moment il appele la fonction pour faire rebondire la balle.
 *
 *@param val Ball b
 *@return il retourne une position.
 *@author Maxim Lyoen
 */
public boolean collisionHorizontale(Ball b)
{
  return (b.x > width) || (b.x < 0) || collision(rVert.x, rVert.y, RACKET_WIDTH, RACKET_HEIGHT, ball.x, ball.y, BALL_WIDTH, BALL_WIDTH) || collision(rBleu.x, rBleu.y, RACKET_WIDTH, RACKET_HEIGHT, ball.x - BALL_WIDTH/2, ball.y - BALL_WIDTH/2, BALL_WIDTH, BALL_WIDTH);
}
/**
 * il indique a quel moment il appele la fonction pour faire rebondire la balle.
 *
 *@param val Ball b
 *@return il retourne une position.
 *@author Maxim Lyoen
 */
public boolean collisionVerticale(Ball b)
{
  return (b.y > height - BALL_WIDTH) || (b.y < 0) || collision(rVert.x, rVert.y, RACKET_WIDTH, RACKET_HEIGHT, ball.x, ball.y, BALL_WIDTH, BALL_WIDTH) || collision(rBleu.x, rBleu.y, RACKET_WIDTH, RACKET_HEIGHT, ball.x - BALL_WIDTH/2, ball.y - BALL_WIDTH/2, BALL_WIDTH, BALL_WIDTH);
}

/**
 *Interface affiche les textes principaux sur lecran de jeux.
 *
 *@author Maxim Lyoen
 */
public void Interface()
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
public void InterfaceParametre()
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
public void fondjeux ()
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
public void fondtexte ()
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
public void mousePressed()
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
public void boutonJaune()
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
/**
 * Quand on appelle cette fonction on vérifie si b == 1 et s'il y est égal à 1 ou la donne la valeur 0 puis on loop.
 *
 *@param val b
 *@return b
 *@author Maxim Lyoen
 */
public int Pause1(int b)
{
  if (b == 1)
  {
    b = 0;
    loop();
    println("Pas pause");
  }
  return b;
}
/**
 * Quand on appelle cette fonction on vérifie si b == 0 et s'il y est égal à 0 ou la donne la valeur 1 puis on noLoop.
 *
 *@param val
 *@return
 *@author Maxim Lyoen
 */
public int Pause2(int b)
{
  if (b == 0)
  {
    b = 1;
    noLoop();
    println("pause");
  }
  return b;
}
/** largeur d'une raquette */
final int RACKET_WIDTH  = 6;
/** hauteur d'une raquette */
final int RACKET_HEIGHT = 40;
/** vitesse de déplacement vertical d'une raquette */
final int RACKET_SPEED  = 5;
/** distance du bord de la fenêtre pour la raquette */
final int BORDER_SPACE  = 20;
/**
 *
 *
 *@param val
 *@return
 *@author Maxim Lyoen
 */
class Racket 
{
  int x;
  int y;
  int largeur;
  int hauteur;
  int col;
}
/**
 *
 *
 *@param val
 *@return
 *@author Maxim Lyoen
 */
public Racket initRacket(int lx, int ly) 
{
  Racket rect = new Racket();
  rect.x = lx;
  rect.y = ly;
  rect.largeur = RACKET_WIDTH;
  rect.hauteur = RACKET_HEIGHT;
  return rect;
}
/**
 * il affiche une racket.
 *
 *@author Maxim Lyoen
 */
public void showRacket(Racket A) 
{

  image (racket1, A.x, A.y);
}
/**
 * il crée le mouvement de la rackette vers le haut.
 *
 *@author Maxim Lyoen
 */
public void moveRacketUp(Racket r) 
{
  r.y -= RACKET_SPEED;
}
/**
 * il crée le mouvement de la rackette vers le bas.
 *
 *@author Maxim Lyoen
 */
public void moveRacketDown(Racket r) 
{
  r.y += RACKET_SPEED;
}
/**
 * il gere les touche du clavier pour la montée et descente des deux rackettent.
 *
 *@author Maxim Lyoen
 */
public void gestionClavierDepuisDraw()
{
  if (keyPressed)
  {
    if ( Page == 0)
    {
      switch (key)
      {
      case 'z' :
        moveRacketUp(rVert);
        if ( rVert.y < 0)
        {
          rVert.y = 0;
        }
        break;
      case 's' :
        moveRacketDown(rVert);
        if ( rVert.y > 400 - RACKET_HEIGHT-1)
        {
          rVert.y = 400 - RACKET_HEIGHT-1;
        }
        break;
      case 'o' :
        moveRacketUp(rBleu);
        if ( rBleu.y < 0)
        {
          rBleu.y = 0;
        }
        break;
      case 'l' :
        moveRacketDown(rBleu);
        if ( rBleu.y > 400 - RACKET_HEIGHT-1)
        {
          rBleu.y = 400 - RACKET_HEIGHT-1;
        }
        break;
      }
    }
  }
}
/**
 * Détection de collision entre 2 rectangles a et b
 *
 * @param ax rectangle 1 : abscisse du coin haut/gauche
 * @param ay rectangle 1 : ordonnée du coin haut/gauche
 * @param aw rectangle 1 : largeur
 * @param ah rectangle 1 : hauteur
 * @param bx rectangle 2 : abscisse du coin haut/gauche
 * @param by rectangle 2 : ordonnée du coin haut/gauche
 * @param bw rectangle 2 : largeur
 * @param bh rectangle 2 : hauteur
 * @return true si il y a collision entre les deux rectangles, false sinon
 */
public boolean collision( int ax, int ay, int aw, int ah,
                   int bx, int by, int bw, int bh)
{
  // il y a collision si les abscisses se chevauchent, ainsi que les ordonnées
  return chevauchementIntervalles(ax, ax+aw, bx, bx+bw)
      && chevauchementIntervalles(ay, ay+ah, by, by+bh);
}
/**
 * Détermine si deux intervalles se chevauchent (s'intersectent).
 *
 * @param a_min borne inférieure du premier intervalle
 * @param a_max borne supérieure du premier intervalle
 * @param b_min borne inférieure du deuxième intervalle
 * @param b_max borne supérieure du deuxième intervalle
 */
public boolean chevauchementIntervalles(int a_min, int a_max, int b_min, int b_max)
{
    int plus_grand_min = max(a_min, b_min);
    int plus_petit_max = min(a_max, b_max);
    return plus_grand_min <= plus_petit_max;
}
  public void settings() {  size(640, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_Pong" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
