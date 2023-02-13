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
    w = int(random( MIN_WIDTH_OBSTACLE, MAX_WIDTH_OBSTACLE));
    h = int(random( MIN_HEIGHT_OBSTACLE, MAX_HEIGHT_OBSTACLE));
    x = int(random( RACKET_WIDTH + MIN_GAP_WALL_OBSTACLE, width - RACKET_WIDTH - MIN_GAP_WALL_OBSTACLE - w));
    y = int(random( 0, height - w));
  }
}

/**
 * action qui affiche un obstacle
 *
 * @param o un obstacle
 * 
 * @author Maxim Lyoen
 */
void showObstacle(Obstacle o){
  fill (NOIR);
  rect (o.x,o.y,o.w,o.h);
}
