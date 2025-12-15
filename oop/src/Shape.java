// abstract classes cannot be instantiated
// this works as a blueprint from which other classes can inherit
// THIS IS THE STRUCTURAL FOUNDATION FOR POLYMORPHISM, 
// which is a contract to manage different implementations of Shape. 
// the key elements of polymorphism are:
// 1) inheritance (circle extends shape)
// 2) abstract method (abstract void draw in Shape) forces the binding contract (any Shape has a draw())
// 3) method overriding (void draw in Circle)
public abstract class Shape {
    // abstract methods serve as a contract, ensuring any concrete subclasses
    // that inherit Shape MUST provide its own unique implementation for the draw() method.
    abstract void draw();
}

