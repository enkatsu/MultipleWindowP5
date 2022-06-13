// This code is based on
// The Nature of Code
// Daniel Shiffman
// http://natureofcode.com

import org.enkatsu.multiplewindowp5.*;
import processing.awt.PSurfaceAWT;

SubWindow subWindow;
ParticleSystem ps;

void setup() {
  size(640, 360);
  surface.setLocation(0, 0);
  ps = new ParticleSystem(new PVector(width/2, 50));

  subWindow = new SubWindow(this, 640, 360);
  subWindow.setup(self -> {
    self.rectMode(CENTER);
  }
  );
  subWindow.draw(self -> {
    self.background(0);
    self.translate(-self.getX(), -self.getY());
    ps.display(self);
  }
  );
  subWindow.setLocation(0, 360);
}

void draw() {
  background(255);
  translate(-getX(), -getY());

  PVector gravity = new PVector(0, 0.1);
  ps.applyForce(gravity);

  ps.addParticle();
  ps.run();
  ps.display(this);
}

int getX() {
  PSurfaceAWT.SmoothCanvas frame = (PSurfaceAWT.SmoothCanvas) this.surface.getNative();
  return frame.getFrame().getX();
}

int getY() {
  PSurfaceAWT.SmoothCanvas frame = (PSurfaceAWT.SmoothCanvas) this.surface.getNative();
  return frame.getFrame().getY();
}
