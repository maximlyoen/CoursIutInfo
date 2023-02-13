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

// Etat du jeu

/** Gestion de la pause */
boolean enPause = false;

/** La balle */
Ball ball, ball1, ball2, ball3;

/** Les obstacles */
Obstacle obs1, obs2;

/** Les rackets */
Racket rGreen, rBlue;

/** Gestion des points */
int scJ1;
int scJ2;

/**Creation police*/
PFont font;

/** Creation des images*/
PImage imgFondGalax;
PImage racketP1;
PImage racketP2;
PImage fondM;
PImage boutonM;

/** Gestion des pages du jeu*/
int pageC = 0;

/**
 * Fonction d'initialisation Processing.
 */
public void setup()
{
  

  /** Initialisation du score des deux joueurs*/
  scJ1 = 0;
  scJ2 = 0;

  /**Gere la police des texts*/
  font = loadFont("LMMonoPropLt10-Oblique-48.vlw");

  /**Gere les images*/
  imgFondGalax = loadImage("space.jpg");
  racketP1 = loadImage("player01.png");
  racketP2 = loadImage("player02.png");
  fondM = loadImage("fond.png");
  boutonM = loadImage("BoutonM.png");


  // on initialise nos objets
  ball = new Ball(1, 1);
  ball1 = new Ball(-1, 1);
  ball2 = new Ball(1, -1);
  ball3 = new Ball(-1, -1);
  obs1 = new Obstacle();
  obs2 = new Obstacle();
  rGreen = new Racket(10, height/2-RACKET_HEIGHT/2, RACKET_WIDTH, RACKET_HEIGHT, 0, racketP1);
  rBlue = new Racket(620, height/2-RACKET_HEIGHT/2, RACKET_WIDTH, RACKET_HEIGHT, 0, racketP2);
}

/**
 * Fonction de rafraichissement Processing.
 */
public void draw()
{
  switch (pageC)
  {
  case 0:
    background(fondM);
    imageMenu();
    drawNbBalles();
    break;
  case 1 :
    background(imgFondGalax);
    showObstacle(obs1);
    showObstacle(obs2);
    imageRetourJeux();
    initNbBall();
    showRacket(rGreen);
    showRacket(rBlue);
    moveRacket(rGreen);
    moveRacket(rBlue);
    checkPoint(ball);
    checkPoint(ball1);
    checkPoint(ball2);
    checkPoint(ball3);
    drawPoint(scJ1, scJ2);
    racketLimite(rBlue);
    racketLimite(rGreen);
    break;
  }
}


public void keyPressed() {
  switch (key)
  {
  case 'z' :
    rGreen.mvtY = -RACKET_SPEED;
    break;
  case 's' :
    rGreen.mvtY = RACKET_SPEED;
    break;
  case 'o' :
    rBlue.mvtY = -RACKET_SPEED;
    break;
  case 'l' :
    rBlue.mvtY = RACKET_SPEED;
    break;
  case ' ' :
    if (enPause == false) {
      noLoop();
      enPause = true;
    } else {
      loop();
      enPause = false;
    }
  default :
    println("erreur");
    break;
  }
}


public void keyReleased() {
  switch (key)
  {
  case 'z' :
    rGreen.mvtY = 0;
    break;
  case 's' :
    rGreen.mvtY = 0;
    break;
  case 'o' :
    rBlue.mvtY = 0;
    break;
  case 'l' :
    rBlue.mvtY = 0;
    break;
  }
}


public void mousePressed() {
  if (pageC==0) {
    if (mouseX>100 && mouseX<250 && mouseY > 200 && mouseY < 260) {
      pageC=1;
    }
    if (mouseX>375 && mouseX<525 && mouseY > 200 && mouseY < 260) {
      exit();
    }
  }
  if (pageC==1) {
    if (mouseX>285 && mouseX<360 && mouseY > 370 && mouseY < 415) {
      pageC=0;
    }
  }
  if (mouseX>450 && mouseX< 520&& mouseY > 375 && mouseY < 395) {
    nbBalles = 1;
  }
  if (mouseX>550 && mouseX< 600&& mouseY > 375 && mouseY < 395) {
    nbBalles = 4;
  }
}

/**
 * action qui permet de dire si la balle sort du terrein sur la droite ou la auche et ajoute un point au joueur adverse.
 *
 * @param b la balle
 * 
 * @author Maxim Lyoen
 */
public void checkPoint(Ball b) {
  if (b.x + BALL_WIDTH/2 > width-1) {
    scJ1++;
    b.x = width/2;
    b.y = height/2;
  }
  if (b.x - BALL_WIDTH/2 < 0+1) {
    scJ2++;
    b.x = width/2;
    b.y = height/2;
  }
}


/**
 * action qui ecrit le score qui est donné en parametre sur ecran
 *
 * @param a et b
 * 
 * @author Maxim Lyoen
 */
public void drawPoint(int a, int b) {
  fill(BLEU);
  textFont(font, 20);
  text("Score", width/2-25, 20);
  text(a, width/2-40, 40);
  text(b, width/2+25, 40);
}


/**
 * Action qui affiche les images pour quiter ou demarer le jeux
 * 
 * @author Maxim Lyoen
 */
public void imageMenu() {
  if (pageC==0) {
    copy(boutonM, 0, 100, 200, 60, width/8, 200, 200, 60);
    if (mouseX>80 && mouseX<230 && mouseY > 200 && mouseY < 260) {
      copy(boutonM, 200, 100, 200, 60, width/8, 200, 200, 60);
    }

    copy(boutonM, 0, 0, 200, 60, width-width/8 - 150, 200, 200, 60);
    if (mouseX>410 && mouseX<560 && mouseY > 200 && mouseY < 260) {
      copy(boutonM, 200, 0, 200, 60, width-width/8 - 150, 200, 200, 60);
    }
  }
}


/**
 * action qui affiche le bouton si on veux retourner au menu du jeu
 * 
 * @author Maxim Lyoen
 */
public void imageRetourJeux() {
  if (pageC==1) {
    copy(boutonM, 0, 0, 200, 60, 285, 370, 100, 30);
    if (mouseX>285 && mouseX<360 && mouseY > 370 && mouseY < 415) {
      copy(boutonM, 200, 0, 200, 60, 285, 370, 100, 30);
    }
  }
}

/** largeur (ou diamètre) de la balle */
final int BALL_WIDTH = 10;
/** vitesse de déplacement de la balle */
final int BALL_SPEED = 3;
/** couleur de la balle */
final int BALL_COLOR = BLANC; 
/** nombres de balles */
int nbBalles = 1;


/**
 * Une balle.
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


  /**
   * Initialisation d'une balle : tous les attributs prennent des valeurs par défaut.
   */
  Ball(int mx, int my) {
    x = width/2;
    y = height/2;
    mvt_x = BALL_SPEED*mx;
    mvt_y = BALL_SPEED*my;
  }
}


/**
 * action qui affiche une balle
 *
 * @param b une balle
 * 
 * @author Maxim Lyoen
 */
public void showBall(Ball b)
{
  fill(BALL_COLOR);
  ellipse(b.x, b.y, BALL_WIDTH, BALL_WIDTH);
}


/**
 * action qui fait bouger la ball par rapport au collision
 *
 * @param b une balle
 * 
 * @author Maxim Lyoen
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
 * fontion Retourne vrai si la balle touche le mur du bas ou le mure de gauche
 *
 * @param b la balle
 *
 * @return un boulean
 * 
 * @author Maxim Lyoen
 */
public boolean collisionHorizontale(Ball b)
{
  return (b.x + BALL_WIDTH/2 > width)
    || (b.x - BALL_WIDTH/2 < 0)
    || (b.x - BALL_WIDTH/2 < rGreen.x + RACKET_WIDTH ) && (b.x + BALL_WIDTH/2 > rGreen.x) && (b.y + BALL_WIDTH/2 > rGreen.y) && (b.y - BALL_WIDTH/2 < rGreen.y + RACKET_HEIGHT) 
    || (b.x - BALL_WIDTH/2 < rBlue.x + RACKET_WIDTH ) && (b.x + BALL_WIDTH/2 > rBlue.x) && (b.y + BALL_WIDTH/2 > rBlue.y) && (b.y - BALL_WIDTH/2 < rBlue.y + RACKET_HEIGHT)
    || (b.x - BALL_WIDTH/2 < obs1.x + obs1.w ) && (b.x + BALL_WIDTH/2 > obs1.x) && (b.y + BALL_WIDTH/2 > obs1.y) && (b.y - BALL_WIDTH/2 < obs1.y + obs1.h) 
    || (b.x - BALL_WIDTH/2 < obs2.x + obs2.w ) && (b.x + BALL_WIDTH/2 > obs2.x) && (b.y + BALL_WIDTH/2 > obs2.y) && (b.y - BALL_WIDTH/2 < obs2.y + obs2.h);
}


/**
 * fontion Retourne vrai si la balle touche le mur du haut ou le mur de droite
 *
 * @param b la balle
 *
 * @return un boulean
 * 
 * @author Maxim Lyoen
 */
public boolean collisionVerticale(Ball b)
{
  return (b.y + BALL_WIDTH/2 > height)
    || (b.y - BALL_WIDTH/2 < 0)
    || (b.x - BALL_WIDTH/2 < rGreen.x + RACKET_WIDTH ) && (b.x + BALL_WIDTH/2 > rGreen.x) && (b.y + BALL_WIDTH/2 > rGreen.y) && (b.y - BALL_WIDTH/2 < rGreen.y + RACKET_HEIGHT)
    || (b.x - BALL_WIDTH/2 < rBlue.x + RACKET_WIDTH ) && (b.x + BALL_WIDTH/2 > rBlue.x) && (b.y + BALL_WIDTH/2 > rBlue.y) && (b.y - BALL_WIDTH/2 < rBlue.y + RACKET_HEIGHT)
    || (b.x - BALL_WIDTH/2 < obs1.x + obs1.w ) && (b.x + BALL_WIDTH/2 > obs1.x) && (b.y + BALL_WIDTH/2 > obs1.y) && (b.y - BALL_WIDTH/2 < obs1.y + obs1.h) 
    || (b.x - BALL_WIDTH/2 < obs2.x + obs2.w ) && (b.x + BALL_WIDTH/2 > obs2.x) && (b.y + BALL_WIDTH/2 > obs2.y) && (b.y - BALL_WIDTH/2 < obs2.y + obs2.h);
}


/**
 * action pour afficher le choix entre 1 ou 4 balles
 * 
 * @author Maxim Lyoen
 */
public void drawNbBalles() {
  fill(255, 255, 255);
  textFont(font, 20);
  text("Nombre de Balle", 450, 370);
  text("1 Balle", 450, 390);
  text("4 Balle", 540, 390);
  if (mouseX>450 && mouseX< 515&& mouseY > 375 && mouseY < 395) {
    fill(ROUGE);
    text("1 Balle", 450, 390);
  }
  if (mouseX>540 && mouseX< 605&& mouseY > 375 && mouseY < 395) {
    fill(ROUGE);
    text("4 Balle", 540, 390);
  }
}


/**
 * action initialize les balles par rapport au nombre de balles choisie
 * 
 * @author Maxim Lyoen
 */
public void initNbBall() {
  if (nbBalles == 1) {
    showBall(ball); 
    moveBall(ball);
  } else {
    showBall(ball); 
    moveBall(ball);
    showBall(ball1); 
    moveBall(ball1);
    showBall(ball2); 
    moveBall(ball2);
    showBall(ball3); 
    moveBall(ball3);
  }
}
/** hauteur maximum d'un obstacle */
final int MAX_HEIGHT_OBSTACLE = 80;
/** hauteur minimum d'un obstacle */
final int MIN_HEIGHT_OBSTACLE = 50;
/** largeur maximum d'un obstacle */
final int MAX_WIDTH_OBSTACLE = 80;
/** largeur minimum d'un obstacle */
final int MIN_WIDTH_OBSTACLE = 50;
/** Ecart minimum entre le bord et les obstacle*/
final int MIN_GAP_WALL_OBSTACLE = 100;


/**
 * Un obstacle.
 */
class Obstacle {
  /** abscisse du coin en haut a gauche du rectangle */
  int x;
  /** ordonnée du coin en haut a gauche du rectangle */
  int y;
  /** largeur du rectangle */
  int w;
  /** hauteur du rectangle */
  int h;
  
  
  /**
   * Initialisation d'un Obstacle : tous les attributs prennent des valeurs par défaut.
   */
  Obstacle() {
    w = PApplet.parseInt(random( MIN_WIDTH_OBSTACLE, MAX_WIDTH_OBSTACLE));
    h = PApplet.parseInt(random( MIN_HEIGHT_OBSTACLE, MAX_HEIGHT_OBSTACLE));
    x = PApplet.parseInt(random( RACKET_WIDTH + MIN_GAP_WALL_OBSTACLE, width - RACKET_WIDTH - MIN_GAP_WALL_OBSTACLE - w));
    y = PApplet.parseInt(random( 0, height - w));
  }
}

/**
 * action qui affiche un obstacle
 *
 * @param o un obstacle
 * 
 * @author Maxim Lyoen
 */
public void showObstacle(Obstacle o){
  fill (NOIR);
  rect (o.x,o.y,o.w,o.h);
}
/** largeur d'une raquette */
final int RACKET_WIDTH  = 10;
/** hauteur d'une raquette */
final int RACKET_HEIGHT = 40;
/** vitesse de déplacement vertical d'une raquette */
final int RACKET_SPEED  = 7;
/** distance du bord de la fenêtre pour la raquette */
final int BORDER_SPACE  = 20;


/**
 * Une raquette.
 */
class Racket {
  /** abscisse du coin en haut a gauche de la racket */
  int x;
  /** ordonnée du coin en haut a gauche du rectangle */
  int y;
  /** largeur de la racket */
  int w;
  /** largeur de la racket */
  int h;
  /** mouvement sur axe y */
  int mvtY;
  /** image de fond de la racket */
  PImage img;


  /**
   * Initialisation d'une racket : tous les attributs prennent des valeurs par défaut.
   */
  Racket (int xR, int yR, int wR, int hR, int mvtYR, PImage imgR  ) {
    x = xR;
    y = yR;
    w = wR;
    h = hR;
    mvtY = mvtYR;
    img = imgR;
  }
}


/**
 * action qui affiche la racket
 *
 * @param r une racket
 * 
 * @author Maxim Lyoen
 */
public void showRacket (Racket r) {
  rect(r.x, r.y, r.w, r.h);
  image(r.img, r.x, r.y);
}


/**
 * action qui permet le mouvement a la racket
 *
 * @param r une racket
 * 
 * @author Maxim Lyoen
 */
public void moveRacket(Racket r) {
  if (r.mvtY != 0) {
    r.y = r.y + r.mvtY;
  }
}


/**
 * action qui fait en sorte que la racket ne puisse pas sortir de ecran
 *
 * @param r une racket
 * 
 * @author Maxim Lyoen
 */
public void racketLimite (Racket r) {
  if (r.y < 0 - RACKET_HEIGHT)
  {
    r.y =height;
  }
  if (r.y > height)
  {
    r.y = 0 - RACKET_HEIGHT;
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
