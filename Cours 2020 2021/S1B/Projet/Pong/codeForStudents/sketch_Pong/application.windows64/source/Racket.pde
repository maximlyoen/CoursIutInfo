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
  color col;
}
/**
 *
 *
 *@param val
 *@return
 *@author Maxim Lyoen
 */
Racket initRacket(int lx, int ly) 
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
void showRacket(Racket A) 
{

  image (racket1, A.x, A.y);
}
/**
 * il crée le mouvement de la rackette vers le haut.
 *
 *@author Maxim Lyoen
 */
void moveRacketUp(Racket r) 
{
  r.y -= RACKET_SPEED;
}
/**
 * il crée le mouvement de la rackette vers le bas.
 *
 *@author Maxim Lyoen
 */
void moveRacketDown(Racket r) 
{
  r.y += RACKET_SPEED;
}
/**
 * il gere les touche du clavier pour la montée et descente des deux rackettent.
 *
 *@author Maxim Lyoen
 */
void gestionClavierDepuisDraw()
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
