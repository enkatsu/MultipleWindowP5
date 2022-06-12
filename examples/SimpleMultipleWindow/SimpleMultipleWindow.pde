import org.enkatsu.multiplewindowp5.*;

SubWindow subWindow;

void setup() {
  size(640, 480);
  noStroke();
  rectMode(CENTER);

  Runnable subWindowSetup = () -> {
    subWindow.ellipseMode(CENTER);
    subWindow.noStroke();
  };
  Runnable subWindowDraw = () -> {
    subWindow.background(250, 200, 50);
    subWindow.ellipse(subWindow.mouseX, subWindow.mouseY, 50, 50);
  };
  subWindow = new SubWindow(this, 640, 480, subWindowSetup, subWindowDraw);
}

void draw() {
  background(50, 200, 250);
  rect(mouseX, mouseY, 50, 50);
}
