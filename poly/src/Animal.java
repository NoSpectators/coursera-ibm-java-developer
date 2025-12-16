// note that only one public class exists: Animal (global namespace)
// also: only 1 class in a single Java file can be public
// all other classes are using default modifier (package namespace)

public class Animal {
    private String name;
    public Animal(String name) {
        this.name = name;
    }
    public String sound() {
        return null;
    }
    public String toString() {
        return name.concat(" says ").concat(sound()); 
    }

}

class Dog extends Animal {
    public Dog(String name) {
        super(name); 
    }
    public String sound() {
        return "Woof";
    } 
}

class Cat extends Animal {
    public Cat(String name) {
        super(name); 
    }
    public String sound() {
        return "Meow";
    }
}

class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }
    public String sound() {
        return "Moo";
    }
}
