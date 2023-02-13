/** largeur d'une raquette */
final int RACKET_WIDTH  = 10;
/** hauteur d'une raquette */
final int RACKET_HEIGHT = 40;
/** vitesse de déplacement vertical d'une raquette */
final int RACKET_SPEED  = 7;
/** vitesse de déplacement vertical d'une raquette */
final int RACKET_SPEED_TEST = 20;
/** distance du bord de la fenêtre pour la raquette */
final int BORDER_SPACE  = 20;

/**
 * Une raquette.
 */
class Racket {
  
  /** abscisse haut-gauche de la raquette */
  int x;
  
  /** ordonnée haut-gauche */
  int y;
  
  /** couleur de la raquette */
  color rColor;
  
  /** Score associé à la raquette**/
  int score;
  
  /**
  Sprite raquette
  **/
  PImage spriteRaquette;
  
  /**
   * Constructeur.
   * L'ordonnée n'est pas précisée : la raquette est centrée verticalement par défaut.
   *
   * @param unX abscisse initiale
   * @param uneCouleur couleur initiale
   * @param id Raquette
   */
  Racket(int unX, color uneCouleur, int idRaquette) {
    x = unX;
    y = height/2 - RACKET_HEIGHT/2;
    rColor = uneCouleur;
    score=0;
    if (idRaquette==1)
       spriteRaquette=loadImage("data/player01.png");
    else
       spriteRaquette=loadImage("data/player01.png");
  }
}

/**
 * Affichage d'une raquette
 */
void showRacket(Racket r)
{
  //fill(r.rColor);
  //rect(r.x, r.y, RACKET_WIDTH, RACKET_HEIGHT);
  copy(r.spriteRaquette,0, 0, RACKET_WIDTH, RACKET_HEIGHT, r.x, r.y, RACKET_WIDTH, RACKET_HEIGHT);
  
}

/**
 * Déplacement d'une raquette vers le haut
 * @param r la raquette à déplacer
 */
void moveRacketUp(Racket r)
{
  r.y -= RACKET_SPEED;
  if (r.y < 0) {
    r.y = 0;
  }
}

/**
 * Déplacement d'une raquette vers le bas
 * @param r la raquette à déplacer
 */
void moveRacketDown(Racket r)
{
  r.y += RACKET_SPEED;
  if (r.y+RACKET_HEIGHT > height) {
    r.y = height - RACKET_HEIGHT;
  }
}