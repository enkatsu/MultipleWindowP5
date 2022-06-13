import org.enkatsu.multiplewindowp5.*;

SubWindow subWindow;

void setup() {
  size(640, 480);
  noStroke();
  rectMode(CENTER);
  surface.setLocation(0, 0);

  subWindow = new SubWindow(this, 640, 480);
  subWindow.setup(self -> {
    self.ellipseMode(CENTER);
    self.noStroke();
  });
  subWindow.draw(self -> {
    self.background(250, 200, 50);
    self.ellipse(subWindow.mouseX, subWindow.mouseY, 50, 50);
  });
  subWindow.setLocation(640, 0);
}

void draw() {
  background(50, 200, 250);
  rect(mouseX, mouseY, 50, 50);
}
