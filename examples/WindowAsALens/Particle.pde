// This code is based on
// The Nature of Code
// Daniel Shiffman
// http://natureofcode.com

class Particle {
  PVector position;
  PVector velocity;
  PVector acceleration;
  float lifespan;

  float mass = 1; // Let's do something better here!

  Particle(PVector l) {
    acceleration = new PVector(0, 0);
    velocity = new PVector(random(-1, 1), random(-2, 0));
    position = l.get();
    lifespan = 255.0;
  }

  void applyForce(PVector force) {
    PVector f = force.get();
    f.div(mass);
    acceleration.add(f);
  }

  // Method to update position
  void update() {
    velocity.add(acceleration);
    position.add(velocity);
    acceleration.mult(0);
    lifespan -= 2.0;
  }

  // Method to display
  void display(PApplet app) {
    app.strokeWeight(2);
    if (app.getClass() == SubWindow.class) {
      app.stroke(255, lifespan);
      app.fill(127, lifespan);
      app.rect(position.x, position.y, 12, 12);
    } else {
      app.stroke(0, lifespan);
      app.fill(127, lifespan);
      app.ellipse(position.x, position.y, 12, 12);
    }
  }

  // Is the particle still useful?
  boolean isDead() {
    if (lifespan < 0.0) {
      return true;
    } else {
      return false;
    }
  }
}
