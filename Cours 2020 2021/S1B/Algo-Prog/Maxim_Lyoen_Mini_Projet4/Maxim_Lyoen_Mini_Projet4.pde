/*

 1) Pour chaque fonction, écrire son entête (mais PAS LE CORPS) de telle sorte que le code compile.
 
 Par exemple si les tests sont : 
 
 void testFct0(){
 assert fct0(  0, 1) == -1;
 assert fct0(  9, 1) == 8;
 assert fct0(  1, 0) == 1;
 assert fct0( -1,-1) == 0;
 assert fct0(  0, 0) == 0;
 assert fct0( -5, 1) == -6;
 assert fct0(-10,10) == -20;
 }
 
 alors vous devez écrire :
 
 int fct0(int a, int b){
 	return (0); // cette ligne est temporaire et permet de compiler votre code.
 }
 
 car cette fonction prend 2 entiers en paramètres et retourne un entier.
 Remarque : il ne sert à rien d'exécuter votre code car la fonction retourne tout le temps 0. Par contre il est censé compiler.
 
 2) Écrire la javadoc de chaque fonction.
 
 Normalement vous avez deviné que fct0 retourne la différence de deux entiers (car 0-1=-1 ; 9-1=8 ; -1-(-1)=0 ... ).
 */
/**
 * Retourne la différence de deux entiers.
 *
 * A minima dans ce projet vous devez utiliser les tags :
 *
 * @param a,b    2 entiers
 * @return       un entier qui correspond au calcul a-b
 * @author       Nicholas Journet
 */
/*

 3) Pour les fonctions 1 à 6 UNIQUEMENT : écrire le corps de la fonction.
 
 int fct0(int a, int b){
 	return a-b;
 }
 */


//A VOUS DE JOUER 


int fct1 ( int a , int b )
{
  return a + b ;
}
void testFct1() {
  assert(fct1( 0,  1)== 1);
  assert(fct1( 1,  0)== 1);
  assert(fct1(-1, -1)==-2);
  assert(fct1( 0,  0)== 0);
  assert(fct1(-5,  1)==-4);
  assert(fct1(-10, 10)==0);
}
/**
 * Retourne la somme des deux entiers.
 *
 * A minima dans ce projet vous devez utiliser les tags :
 *
 * @param a,b    2 entiers
 * @return       un entier qui correspond au calcul a+b
 * @author       Maxim Lyoen
 */


int fct2 ( int a )
{
  return -a;
}
void testFct2() {
  assert(fct2(  1)== -1);
  assert(fct2(  0)==  0);
  assert(fct2( -1)==  1);
  assert(fct2( 10)==-10);
  assert(fct2( -5)==  5);
  assert(fct2(-10)== 10);
}
/**
 * Retourne l'inverse d'un entier.
 *
 * A minima dans ce projet vous devez utiliser les tags :
 *
 * @param a      1 entiers
 * @return       un entier qui correspond au calcul -a
 * @author       Maxim Lyoen
 */


boolean fct3 ( int a )
{
  boolean b;
  if (a % 2 == 1)
  {
    b = false;
  }
  else
  {
    b = true;
  }
  return b;
}
void testFct3() {
  assert(!fct3(1));
  assert( fct3(1)==false); // équivalent mais il faut éviter cette forme

  assert( fct3(2));
  assert( fct3(2)==true); // équivalent mais il faut éviter cette forme

  assert( fct3(2));
  assert(!fct3(3));
  assert( fct3(4));
  assert(!fct3(5));
  assert( fct3(6));
  assert(!fct3(7));
  assert( fct3(8));
  assert(!fct3(9));
  assert( fct3(10));
}
/**
 * Retourne un booléen.
 *
 * A minima dans ce projet vous devez utiliser les tags :
 *
 * @param a      1 entiers
 * @return       un booléen qui corespond a un chiffre pair ou impair
 * @author       Maxim Lyoen
 */


boolean fct4 (char a )
{
  boolean b;
  if ( a == 'a' || a == 'e' || a == 'i' || a == 'A' || a == 'E' || a == 'I' )
  {
    b = true;
  }
  else
  {
    b = false;
  }
  return (b);
}

void testFct4() {
  assert( fct4('a'));
  assert(!fct4('b'));
  assert(!fct4('c'));
  assert(!fct4('d'));
  assert( fct4('e'));
  assert( fct4('i'));

  assert( fct4('A'));
  assert(!fct4('B'));
  assert(!fct4('C'));
  assert(!fct4('D'));
  assert( fct4('E'));
  assert( fct4('I'));

  assert(!fct4('@'));
  assert(!fct4('-'));
  assert(!fct4('$'));
}
/**
 * Retourne un booléen.
 *
 * A minima dans ce projet vous devez utiliser les tags :
 *
 * @param a      1 caractère
 * @return       un booléen qui corespond aux caractères A,E,I,a,e,i
 * @author       Maxim Lyoen
 */
 
 
int fct5 ( int a, int b)
{
  if ( a >= b )
  {
    return (a);
  }
  else
  {
    return (b);
  }
}
void testFct5() {
  assert(fct5(-4, -6)==-4);
  assert(fct5(-6, -4)==-4);
  assert(fct5(-11, -2)==-2);
  assert(fct5(2, -8)==2);
  assert(fct5(0, 6)==6);
  assert(fct5(-1, -1)==-1);
  assert(fct5(0, 0)==0);
  assert(fct5(4, 6)==6);
  assert(fct5(6, 4)==6);
  assert(fct5(11, 10)==11);
}
/**
 * Retourne un entier.
 *
 * A minima dans ce projet vous devez utiliser les tags :
 *
 * @param a,b    2 entiers
 * @return       l'entier le plus grand entre a et b
 * @author       Maxim Lyoen
 */


boolean fct6(int a, int b)
{
   if (b==0) 
   {
     return false;
   }
   else if ((a%b)==0) 
   {
     return true;
   }
   else return false;
 }
void testFct6() {
  assert(!fct6(8, 0));
  assert( fct6(8, 1));
  assert( fct6(8, 2));
  assert(!fct6(8, 3));
  assert( fct6(8, 4));
  assert(!fct6(8, 5));
  assert(!fct6(8, 6));
  assert(!fct6(8, 7));
  assert( fct6(8, 8));
  assert(!fct6(8, 9));
  assert(!fct6(8, 10));
  assert(!fct6(8, 11));

  assert(!fct6(9, 0));
  assert( fct6(9, 1));
  assert(!fct6(9, 2));
  assert( fct6(9, 3));
  assert(!fct6(9, 4));
  assert(!fct6(9, 5));
  assert(!fct6(9, 6));
  assert(!fct6(9, 7));
  assert(!fct6(9, 8));
  assert( fct6(9, 9));
  assert(!fct6(9, 10));
  assert(!fct6(9, 11));
}
/**
 * Retourne un booléen.
 *
 * A minima dans ce projet vous devez utiliser les tags :
 *
 * @param a,b    2 entiers
 * @return       un booléen qui signifient si b et une racine carre de 2
 * @author       Maxim Lyoen
 */
 

boolean fct7 ( int a )
{
  return (true);
}

void testFct7() {

  assert(!fct7(2005));
  assert(!fct7(2006));
  assert(!fct7(2007));
  assert( fct7(2008));

  assert( fct7(2016));
  assert(!fct7(2017));
  assert(!fct7(2018));
  assert(!fct7(2019));

  assert( fct7(2020));  
  assert(!fct7(2021));
  assert(!fct7(2022));
  assert(!fct7(2023));


  assert( fct7(2296));
  assert(!fct7(2297));
  assert(!fct7(2298));
  assert(!fct7(2299));

  assert(!fct7(2300));
  assert(!fct7(2301));
  assert(!fct7(2302));
  assert(!fct7(2303));

  assert( fct7(2400));
}
/**
 * retourn un booléen
 *
 * A minima dans ce projet vous devez utiliser les tags :
 *
 * @param a,b    2 entiers
 * @return       je n'ai pas compris celui la
 * @author       Maxim Lyoen
 */
 
 
boolean fct8 (char a , char b)
{
  return (true);
}

void testFct8() {
  assert( fct8('f', 'f'));
  assert( fct8('f', 'F'));
  assert( fct8('F', 'f'));
  assert( fct8('F', 'F'));
  assert(!fct8('f', 'g'));
  assert(!fct8('f', 'G'));
  assert(!fct8('!', '!'));
}
/**
 * Retourne un booléen.
 *
 * A minima dans ce projet vous devez utiliser les tags :
 *
 * @param a,b    2 caractères
 * @return       un booléen qui signifie si il sagit de la meme lettre
 * @author       Maxim Lyoen
 */
 

boolean fct9 (int a , int b)
{
  return (true);
}
void testFct9() {
  assert( fct9(0, 0));
  assert( fct9(1, 1));
  assert( fct9(2, 2));
  assert( fct9(2, 11));
  assert( fct9(11, 2));
  assert( fct9(11, 11));
  assert( fct9(42, 33));
  assert( fct9(82, 55));
  assert( fct9(37, 55));
  assert( fct9(31, 22));
  assert( fct9(45, 63));
  assert( fct9(11, 02));
  assert(!fct9(54, 22));
  assert(!fct9(13, 14));
  assert(!fct9(63, 11));
  assert(!fct9(34, 21));
  assert(!fct9(24, 74));
  assert(!fct9(12, 13));
}
/**
 * Retourne un booléen.
 *
 * A minima dans ce projet vous devez utiliser les tags :
 *
 * @param a,b    2 entiers
 * @return       je ne l'ai pas compris
 * @author       Maxim Lyoen
 */
 

boolean fct10 (char a, char b)
{
  return (true);
}

void testFct10() {
  assert( fct10('0', '0'));
  assert( fct10('1', '1'));
  assert( fct10('9', '9'));
  assert( fct10('0', '1'));
  assert( fct10('1', '0'));
  assert( fct10('9', '1'));
  assert( fct10('a', 'a'));
  assert( fct10('z', 'a'));
  assert(!fct10('0', 'a'));
  assert(!fct10('b', '9'));
  assert( fct10('Z', 'A'));
  assert(!fct10('z', 'Z'));
}
/**
 * Retourne un booléen.
 *
 * A minima dans ce projet vous devez utiliser les tags :
 *
 * @param a,b    2 caratères
 * @return       pas compris nomplus
 * @author       Maxim Lyoen
 */


void setup() {
  testFct1();
  testFct2();
  testFct3();
  testFct4();
  testFct5();
  testFct6();
  testFct7();
  testFct8();
  testFct9();
  testFct10();
}
