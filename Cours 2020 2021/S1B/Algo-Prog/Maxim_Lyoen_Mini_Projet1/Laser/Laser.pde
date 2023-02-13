float y ;
float x ;
void setup(){
  y = random(100);
  x = random(100);
  frameRate(25);
  
}
void draw() {
  background(0);
  stroke(0,random(255),0);
  line(y, x, random(100), random(100));
}
