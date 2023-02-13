// Constantes - Couleurs
final color NOIR = color(0);
final color BLANC = color(255);
final color ROUGE = color(255, 0, 0);
final color VERT = color(0, 255, 0);
final color BLEU = color(0, 0, 255);

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
void setup()
{
  size(640, 400);

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
void draw()
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


void keyPressed() {
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


void keyReleased() {
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


void mousePressed() {
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
void checkPoint(Ball b) {
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
void drawPoint(int a, int b) {
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
void imageMenu() {
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
void imageRetourJeux() {
  if (pageC==1) {
    copy(boutonM, 0, 0, 200, 60, 285, 370, 100, 30);
    if (mouseX>285 && mouseX<360 && mouseY > 370 && mouseY < 415) {
      copy(boutonM, 200, 0, 200, 60, 285, 370, 100, 30);
    }
  }
}
