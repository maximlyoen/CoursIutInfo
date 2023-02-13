// Constantes - Couleurs //<>//

final color NOIR = color(0);
final color BLANC = color(255);
final color ROUGE = color(255, 0, 0);
final color VERT = color(0, 255, 0);
final color BLEU = color(0, 0, 255);

/** largeur (ou diamètre) de la balle */
final int BALL_WIDTH = 6;
/** vitesse de déplacement de la balle */
final int BALL_SPEED = 3;
/** couleur de la balle */
final color BALL_COLOR = BLANC; 


final int TAILLE_POLICE = 14;

final int CLIP_PLAY_x = 0;
final int CLIP_PLAY_y = 100;
final int CLIP_PLAY_w = 150;
final int CLIP_PLAY_h = 60;

final int CLIP_PLAY_OVER_x = 200;
final int CLIP_PLAY_OVER_y = 100;
final int CLIP_PLAY_OVER_w = 150;
final int CLIP_PLAY_OVER_h  = 60;



final int CLIP_QUIT_x = 0;
final int CLIP_QUIT_y = 0;
final int CLIP_QUIT_w = 150;
final int CLIP_QUIT_h = 60;
    
  final int CLIP_QUIT_OVER_x = 200;
final int CLIP_QUIT_OVER_y = 0;
final int CLIP_QUIT_OVER_w = 150;
final int CLIP_QUIT_OVER_h = 60;  
    
// Etat du jeu

/** Gestion de la pause */
boolean enPause = false;

/** La balle */
Ball ball;

/** La première raquette */
Racket racket1;

/** La deuxième raquette */
Racket racket2;

/** fonte pour afficahge **/
PFont font;


/** Image du  Background**/
PImage back;

/** Image du  Background Menu**/
PImage backMenu;

/** Image du  boutton Menu**/
PImage bouttonMenu;

/*
gestion du menu
*/
boolean onMenu=true;
boolean mouseonPLay=false;

void setup()
{
  size(640, 400);
  //chargement de la fonte Zapfino-48.vlw
  font = loadFont("data/Zapfino-48.vlw");
  //chargement de l'image de fond space.jpg pour le menu
  back = loadImage("data/space.jpg");
  //chargement de l'image de fond qui est fond.png pour le menu
  backMenu= loadImage("fond.png");
  //chargement de l'image des boutons qui est button.png pour le menu
  bouttonMenu = loadImage("data/button.png");
  // on crée une balle
  ball = new Ball();
  //on crée une raquette avec un BORDER_SPACE, BLEU,1
  racket1 = new Racket(BORDER_SPACE, BLEU,1);
  //on crée une raquette avec width - RACKET_WIDTH - BORDER_SPACE, VERT,2
  racket2 = new Racket(width - RACKET_WIDTH - BORDER_SPACE, VERT,2);
  
}

/**
 * Fonction de rafraichissement Processing.
 */
void draw()
{
  if (onMenu==true){
    background(backMenu);
     if (mouseX>100 && mouseX<100+CLIP_PLAY_w && mouseY>100 && mouseY< CLIP_PLAY_y+CLIP_PLAY_h )
    mouseonPLay=true;
    else
    mouseonPLay=false; 
    if (!mouseonPLay)
    copy(bouttonMenu,CLIP_PLAY_x, CLIP_PLAY_y, CLIP_PLAY_w, CLIP_PLAY_h, 100, 100, CLIP_PLAY_w, CLIP_PLAY_h);
    else
    copy(bouttonMenu,CLIP_PLAY_OVER_x, CLIP_PLAY_OVER_y, CLIP_PLAY_OVER_w, CLIP_PLAY_OVER_h, 100, 100, CLIP_PLAY_OVER_w, CLIP_PLAY_OVER_h);
  }
  else{
    textSize(TAILLE_POLICE);
    background(back);
    //image(img, 0, 0);
    showBall(ball); 
    showRacket(racket1);
    showRacket(racket2);
    gestionClavierDepuisDraw();
    moveBall(ball,racket1,racket2);
    point(ball,racket1,racket2);
    fill(255, 255, 255);
    textFont(font);
    text("Score", 260, 60);
    text(racket1.score,230,120);
    text(racket2.score,370,120);
  }
    
}

void drawOld()
{
    textSize(TAILLE_POLICE);
    background(back);
    showBall(ball); 
    showRacket(racket1);
    showRacket(racket2);
    gestionClavierDepuisDraw();
    moveBall(ball,racket1,racket2);
    point(ball,racket1,racket2);
    fill(255, 255, 255);
}
 //<>//
void mousePressed()
{
  onMenu=false;
}


/**
 * Gestion des touches claviers depuis la méthode draw().
 */
void gestionClavierDepuisDraw() {
  if (keyPressed)
  {
    switch (key)
    {
      // raquette 1
    case 's' :
      moveRacketUp(racket1);
      break;
    case 'x' :
      moveRacketDown(racket1);
      break;
      
      // raquette 2
    case CODED :
      if (keyCode == UP) 
      {
        moveRacketUp(racket2);
      } else if (keyCode == DOWN) 
      {
        moveRacketDown(racket2);
      } 
    default :
      // println("player1 : s x   player 2 : Up Down");
      break;
    }
  }
}

void keyPressed()
{
  if (!enPause && key == ' ' )
  {
    println("pause");
    enPause = true; 
    noLoop();
  } else if (enPause && key == ' ')
  {
    println("restart");
    enPause = false;
    loop();
  }
}
