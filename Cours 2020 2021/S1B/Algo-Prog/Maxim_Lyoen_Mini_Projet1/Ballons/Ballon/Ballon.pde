int origineX;
int origineY;
void setup() {
  background(180,234,234);
  size(300, 200);
  origineX = width/2;
  origineY = height;
}
void draw() {
  fill(random(255), random(255), random(255));
}
void mousePressed() {
  line( origineX, origineY, mouseX, mouseY);
  ellipse(mouseX, mouseY, 30, 30);
}
