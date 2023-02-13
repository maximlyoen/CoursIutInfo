// variables pour la gestion des jets
int NB_JETS_MAX = 100;  // la longueur maximale des séquences de jets
int[] jets1;  // la séquence de jets du joueur 1
int nbJets1;  // la longueur de la séquence de jets du joueur 1
int[] jets2;  // la séquence de jets du joueur 2
int nbJets2;  // la longueur de la séquence de jets du joueur 2
int joueurCourant;

// somme des éléments d'une séquence de jets (faces).
int somme(int[] seqJets) {
  int numJet = 0;
  int som = 0;
  while ( seqJets[numJet] != 1 )
  {
    som += seqJets[numJet];
    numJet++;
  }
  return som;
}

// initialisation des variables
void init() {
  joueurCourant = 1;
  nbJets1 = 0;
  jets1 = new int[NB_JETS_MAX];
  nbJets2 = 0;
  jets2 = new int[NB_JETS_MAX];
}

// initialisation
void setup() 
{
  test_somme();
  test_yAfficherJets();
  test_stockerJet();
  // test_changerDeJoueur();
  // test_yScore();
  size(640, 200);
  init();
  afficherDes();
}

// clic quelque part
void mousePressed() {
  int face = calculerFace(mouseX, mouseY);
  if (face > 0) { // si l'utilisateur a cliqué sur une face
    afficherDes(); // on affiche le fond
    stockerJet(face);
    afficherJets(jets1, nbJets1, 1);
    if(joueurCourant == 2)
      afficherJets(jets2,nbJets2,2);
    if (face == 1) {
      finSequence();
    }
  }
}

// enregistrer un nouveau jet
void stockerJet(int face) {
  if (joueurCourant == 1) {
    jets1[nbJets1] = face;
    nbJets1++;
  } else {
    jets2[nbJets2] = face;
    nbJets2++;
  }
}

// afficher la séquence
void afficherJets(int[] jets, int nbJets, int numJoueur) {
  int ySeq = yAfficherJets(numJoueur); // y pour l'affichage de la séquence de jets
  text("séquence du joueur "+numJoueur+" : ", 30, ySeq);
  int jet = 0;
  while (jet < nbJets) {
    text(jets[jet], 20 * jet + 165, ySeq);
    jet++;
  }
}

// ordonnée pour l'affichage des jets
int yAfficherJets(int numJoueur) {
  if (numJoueur == 1)
  {
    return(20);
  }
  else
  {
    return(40);
  }
}

// afficher le score
void afficherScore(int score, int numJoueur) {
  text("score = " + score, 30, yScore(numJoueur));
}

// ordonnée pour l'affichage du score
int yScore(int numJoueur) {
  return 170;
}

// passer au joueur suivant
void changerDeJoueur() 
{
  if(joueurCourant == 1)
  {
    joueurCourant = 2;
  }
  else
  {
     joueurCourant = 1;
  }
  
}

// gérer la fin d'une séquence de jets (une fois le 1 saisi).
void finSequence() {
  // TODO Exercice 2 : modifier le code ci-dessous
  afficherScore(somme(jets1), 1);
  nbJets1 = 0; // nouvelle séquence
  changerDeJoueur();
}

void draw() {
} // requis par mousePressed()
