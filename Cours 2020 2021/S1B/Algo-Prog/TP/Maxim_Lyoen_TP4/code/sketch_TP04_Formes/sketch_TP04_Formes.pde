color NOIR = color(0); //<>//
void setup()
{
  size(600, 600);
  background(NOIR);
  //premierChemin();
  //deuxiemeChamin();
  //carre(10,10,5);
  //escalier(10,310,4,10);
  //escargot(100,490,20);
  //zigzag1(300,300,100);
  zigzag2(300,300,100);
  touchBorder();
  randInt();
  frameRate(1);
}
//
void premierChemin()
{
  initForm(width / 3, height / 2, 'W');
  ligne(3);
  turnRight();
  ligne(2);
  turnLeft();
  for (int i = 0; i < 5; i++) {
    goDisplay();
  }
}
//
void  deuxiemeChamin()
{
  initForm(2 * width / 3, height / 2, 'S');
  ligne(10);
  turnLeft();
  goDisplay();
  turnLeft();
  goDisplay();
}
//
void ligne (int n){
  for (int i = 0; i < n; i++) {
    goDisplay();
  }
}
//
void carre(int x, int y, int n)
{
  initForm( x , y, 'E');
  ligne(n);
  turnRight();
  ligne(n);
  turnRight();
  ligne(n);
  turnRight();
  ligne(n-1);
}
//
void escalier(int x,int y, int n, int nbMarches)
{
  initForm( x , y, 'N');
  for (int i = 0; i < nbMarches; i++) 
  {
    ligne(n-1);
    turnRight();
    ligne(n-1);
    turnLeft();
  }
}
//
void escargot(int x, int y, int n)
{
  int a = 1;
  initForm( x , y, 'W');
  for (int i = 0; i < n; i++) 
  {
    ligne(a);
    turnRight();
    a = a + 1;
  }
}
//
void randTurn()
{
  float a = random(1);
  if (a <0.5)
  {
    turnLeft();
  }
  else
  {
    turnRight();
  }
}
//
char randInt()
{
  float a = random(1);
  if (a <0.25)
  {
    return 'N';
  }
  else
  {
    if (a <0.50)
    {
      return 'E';
    }
    else
    {
      if (a <0.75)
      {
        return 'W';
      }
      else
      {
        return 'E';
      }
    }
  }
}
//
void zigzag1(int x, int y, int n)
{
  initForm( x , y, 'W');
  for (int i = 0; i < n/10; i++) 
  {
    ligne(10);
    randTurn();
  }
}
//
boolean touchBorder()
{

  if (posX <=0 || posX >= width ||posY <=0 || posY >= height )
  {
    return false;
  }
  else
  {
    return true;
  } 
}
//
void zigzag2(int x, int y, int n)
{
  initForm( x , y, randInt());
  for (int i = 0; i < n/10; i++) 
  {
    ligne(10);
    randTurn();
    if (touchBorder() == false)
    {
    println ("Perdu !");
    noLoop();
    i=n;
    }
  } 
  if (touchBorder() == true)
  {
    println ("Gagné !");
    noLoop();
  }
}
//
void draw()
{
  //zigzag2(300,300,100);
  //touchBorder();
  //randInt();
}






  
