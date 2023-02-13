/** largeur (ou diamètre) de la balle */
final int BALL_WIDTH = 6;
/** vitesse de déplacement de la balle */
int BALL_SPEED = 3;
/** couleur de la balle */
final color BALL_COLOR = BLANC; 
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
Ball initBall() {
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
void showBall(Ball b) 
{
  image (ball1, b.x, b.y);
}
/**
 * il gere le rebon de la balle contre les mur et la rackette.
 *
 *@author Maxim Lyoen
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
 * il indique a quel moment il appele la fonction pour faire rebondire la balle.
 *
 *@param val Ball b
 *@return il retourne une position.
 *@author Maxim Lyoen
 */
boolean collisionHorizontale(Ball b)
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
boolean collisionVerticale(Ball b)
{
  return (b.y > height - BALL_WIDTH) || (b.y < 0) || collision(rVert.x, rVert.y, RACKET_WIDTH, RACKET_HEIGHT, ball.x, ball.y, BALL_WIDTH, BALL_WIDTH) || collision(rBleu.x, rBleu.y, RACKET_WIDTH, RACKET_HEIGHT, ball.x - BALL_WIDTH/2, ball.y - BALL_WIDTH/2, BALL_WIDTH, BALL_WIDTH);
}
