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
void showRacket (Racket r) {
  //rect(r.x, r.y, r.w, r.h);
  image(r.img, r.x, r.y);
}


/**
 * action qui permet le mouvement a la racket
 *
 * @param r une racket
 * 
 * @author Maxim Lyoen
 */
void moveRacket(Racket r) {
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
void racketLimite (Racket r) {
  if (r.y < 0 - RACKET_HEIGHT)
  {
    r.y =height;
  }
  if (r.y > height)
  {
    r.y = 0 - RACKET_HEIGHT;
  }
}
