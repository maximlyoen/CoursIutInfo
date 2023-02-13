/** largeur (ou diamètre) de la balle */
final int BALL_WIDTH = 10;
/** vitesse de déplacement de la balle */
final int BALL_SPEED = 3;
/** couleur de la balle */
final color BALL_COLOR = BLANC; 

// Etat du jeu

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
  
  PImage img;


  /**
   * Initialisation d'une balle : tous les attributs prennent des valeurs par défaut.
   */
  Ball(int mx, int my,PImage imgB) {
    x = width/2;
    y = height/2;
    mvt_x = BALL_SPEED*mx;
    mvt_y = BALL_SPEED*my;
    img = imgB;
  }
}


/**
 * action qui affiche une balle
 *
 * @param b une balle
 * 
 * @author Maxim Lyoen
 */
void showBall(Ball b)
{
  //fill(BALL_COLOR);
  //llipse(b.x, b.y, BALL_WIDTH, BALL_WIDTH);
  image(b.img,b.x, b.y,BALL_WIDTH, BALL_WIDTH);
}


/**
 * action qui fait bouger la ball par rapport au collision
 *
 * @param b une balle
 * 
 * @author Maxim Lyoen
 */
void moveBall(Ball b)
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
boolean collisionHorizontale(Ball b)
{
  return (b.x + BALL_WIDTH/2 > width)
    || (b.x - BALL_WIDTH/2 < 0)
    || (b.x - BALL_WIDTH/2 < rGreen.x + RACKET_WIDTH ) && (b.x + BALL_WIDTH/2 > rGreen.x) && (b.y + BALL_WIDTH/2 > rGreen.y) && (b.y - BALL_WIDTH/2 < rGreen.y + RACKET_HEIGHT) 
    || (b.x - BALL_WIDTH/2 < rBlue.x + RACKET_WIDTH ) && (b.x + BALL_WIDTH/2 > rBlue.x) && (b.y + BALL_WIDTH/2 > rBlue.y) && (b.y - BALL_WIDTH/2 < rBlue.y + RACKET_HEIGHT)
    || (b.x - BALL_WIDTH/2 < obs1.x + obs1.w - BALL_WIDTH/2) && (b.x + BALL_WIDTH/2 > obs1.x) && (b.y + BALL_WIDTH/2 > obs1.y) && (b.y - BALL_WIDTH/2 < obs1.y + obs1.h - BALL_WIDTH/2) 
    || (b.x - BALL_WIDTH/2 < obs2.x + obs2.w - BALL_WIDTH/2) && (b.x + BALL_WIDTH/2 > obs2.x) && (b.y + BALL_WIDTH/2 > obs2.y) && (b.y - BALL_WIDTH/2 < obs2.y + obs2.h - BALL_WIDTH/2);
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
boolean collisionVerticale(Ball b)
{
  return (b.y + BALL_WIDTH/2 > height)
    || (b.y - BALL_WIDTH/2 < 0)
    || (b.x - BALL_WIDTH/2 < rGreen.x + RACKET_WIDTH ) && (b.x + BALL_WIDTH/2 > rGreen.x) && (b.y + BALL_WIDTH/2 > rGreen.y) && (b.y - BALL_WIDTH/2 < rGreen.y + RACKET_HEIGHT)
    || (b.x - BALL_WIDTH/2 < rBlue.x + RACKET_WIDTH ) && (b.x + BALL_WIDTH/2 > rBlue.x) && (b.y + BALL_WIDTH/2 > rBlue.y) && (b.y - BALL_WIDTH/2 < rBlue.y + RACKET_HEIGHT)
    || (b.x - BALL_WIDTH/2 < obs1.x + obs1.w - BALL_WIDTH/2) && (b.x + BALL_WIDTH/2 > obs1.x) && (b.y + BALL_WIDTH/2 > obs1.y) && (b.y - BALL_WIDTH/2 < obs1.y + obs1.h - BALL_WIDTH/2) 
    || (b.x - BALL_WIDTH/2 < obs2.x + obs2.w - BALL_WIDTH/2) && (b.x + BALL_WIDTH/2 > obs2.x) && (b.y + BALL_WIDTH/2 > obs2.y) && (b.y - BALL_WIDTH/2 < obs2.y + obs2.h - BALL_WIDTH/2);
}


/**
 * action pour afficher le choix entre 1 ou 4 balles
 * 
 * @author Maxim Lyoen
 */
void drawNbBalles() {
  fill(255, 255, 255);
  textFont(font, 20);
  text("Nombre de Balle", 450, 370);
  text("1 Balle", 450, 390);
  text("4 Balle", 540, 390);
  if (bouton1Ball()) {
    fill(ROUGE);
    text("1 Balle", 450, 390);
  }
  if (bouton4Ball()) {
    fill(ROUGE);
    text("4 Balle", 540, 390);
  }
}


/**
 * action initialize les balles par rapport au nombre de balles choisie
 * 
 * @author Maxim Lyoen
 */
void initNbBall() {
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
