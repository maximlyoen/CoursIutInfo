
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
  Sprite balle
    **/
  PImage spriteBall;
/*  PImage spriteBalle;*/
/*  int test*/

  /**
   * Constructeur sans paramètre : tous les attributs prennent des valeurs par défaut.
   */
  Ball() {
    x = width/2;
    y = height/2;
    mvt_x = BALL_SPEED;
    mvt_y = BALL_SPEED;
    spriteBall=loadImage("data/ball.png");
  }
}

/**
 * Affichage de la balle
 */
void showBall(Ball b){
  //fill(BALL_COLOR);
  //ellipse(b.x, b.y, BALL_WIDTH, BALL_WIDTH);
  copy(b.spriteBall,0, 0, BALL_WIDTH, BALL_WIDTH, b.x, b.y, BALL_WIDTH, BALL_WIDTH);
}

/**
 * Déplacement de la balle
 */
/**
 * Déplacement de la balle
 */
void 
moveBall(Ball b, Racket r1, Racket r2)
{
  // Mouvement Horizontal
  b.x += b.mvt_x;
  if (collisionHorizontale(b, r1, r2)==true)
  {
    b.x -= b.mvt_x; // mouvement annulé
    b.mvt_x *= -1; // changement de direction
  }

  // Mouvement Vertical
  b.y += b.mvt_y;
  if (collisionVerticale(b, r1, r2)==true){
    b.y -= b.mvt_y; // mouvement annulé
    b.mvt_y *= -1; // changement de direction
  }
}

/**
 * Retourne vrai si la balle touche les bords gauche ou droit ou une des 2 raquettes
 */
boolean 
collisionHorizontale(Ball b, Racket r1, Racket r2)
{
  // rectangle englobant de la balle
  int rect_bx = b.x - BALL_WIDTH/2;
  int rect_by = b.y - BALL_WIDTH/2;

  return (b.x+BALL_WIDTH/2 > width) || (b.x-BALL_WIDTH/2 < 0)
    || collision(rect_bx, rect_by, BALL_WIDTH, BALL_WIDTH, r1.x, r1.y, RACKET_WIDTH, RACKET_HEIGHT)
    || collision(rect_bx, rect_by, BALL_WIDTH, BALL_WIDTH, r2.x, r2.y, RACKET_WIDTH, RACKET_HEIGHT);
}

/**
 * Retourne vrai si la balle touche les bords haut ou bas ou une des 2 raquettes
 */
boolean 
collisionVerticale(Ball b, Racket r1, Racket r2)
{
  // rectangle englobant de la balle
  int rect_bx = b.x - BALL_WIDTH/2;
  int rect_by = b.y - BALL_WIDTH/2;

  return (b.y+BALL_WIDTH/2 > height) || (b.y-BALL_WIDTH/2 < 0)
    || collision(rect_bx, rect_by, BALL_WIDTH, BALL_WIDTH, r1.x, r1.y, RACKET_WIDTH, RACKET_HEIGHT)
    || collision(rect_bx, rect_by, BALL_WIDTH, BALL_WIDTH, r2.x, r2.y, RACKET_WIDTH, RACKET_HEIGHT);
}


boolean 
point(Ball b,Racket r1,Racket r2)
{
  if(b.x-BALL_WIDTH<0)
    {
      r2.score++;
      b.x = width/2;
      b.y = height/2;
      return true;
    }
  if(b.x+BALL_WIDTH> width)
    {
      r1.score++;
      b.x = width/2;
      b.y = height/2;
      return true;
    }
    return false;
}