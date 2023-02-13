// Constantes - Couleurs
final color NOIR = color(0);
final color BLANC = color(255);
final color ROUGE = color(255, 0, 0);
final color VERT = color(0, 255, 0);
final color BLEU = color(0, 0, 255);
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
void keyPressed()
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
void setup()
{
  size(640, 400);

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
void draw()
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
void gestionDuScore()
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
