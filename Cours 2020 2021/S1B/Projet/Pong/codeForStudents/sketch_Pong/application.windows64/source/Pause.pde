/**
 * Quand on appelle cette fonction on vérifie si b == 1 et s'il y est égal à 1 ou la donne la valeur 0 puis on loop.
 *
 *@param val b
 *@return b
 *@author Maxim Lyoen
 */
int Pause1(int b)
{
  if (b == 1)
  {
    b = 0;
    loop();
    println("Pas pause");
  }
  return b;
}
/**
 * Quand on appelle cette fonction on vérifie si b == 0 et s'il y est égal à 0 ou la donne la valeur 1 puis on noLoop.
 *
 *@param val
 *@return
 *@author Maxim Lyoen
 */
int Pause2(int b)
{
  if (b == 0)
  {
    b = 1;
    noLoop();
    println("pause");
  }
  return b;
}
