
int vaisseauX;
int vaisseauY;
int vitesse;
void setup(){
  background(0);
  size(300, 200);  // Car elle ne va pas changer donc on a pas besoin de la mettre dans draw sinon elle serait verifier plusieur fois pas seconde.
  noStroke();  // Cette comande permet de faire en sorte que rien ne sois dessiné dans le vaisseaux.
  vaisseauX = 30;
  vaisseauY = 100;
  vitesse = 1;
}
void draw() {
  background(0);
  stroke(255, 255, 255);
  ellipse (vaisseauX, vaisseauY, 50, 15);
  vaisseauX = vaisseauX + vitesse;
}
void mousePressed() {
  vitesse = -vitesse;
}
void mouseDragged() {
  vaisseauX = mouseX;
  vaisseauY = mouseY;
  
}
