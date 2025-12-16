// note that only one public class exists: Animal (global namespace)
// also: only 1 class in a single Java file can be public
// all other classes are using default modifier (package namespace)

public class Animal {
    private String name;
    private String food;
    
    public Animal(String name) {
        this.name = name;
    }
    public String sound() {
        return null;
    }
    public String toString() {
        return name.concat(" says ").
                concat(sound()).
                concat(" and eats ").
                concat(this.getFood());
    }
    public void setFood(String food) {
        this.food = food;
    }
    public String getFood() {
        if (this.food == null) {
            return "unknown food";
        }
        return this.food;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name); 
    }
    @Override
    public String sound() {
        return "Woof";
    }
    @Override
    public String getFood() {
        return super.getFood(); 
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name); 
    }
    @Override
    public String sound() {
        return "Meow";
    }
    @Override
    public String getFood() {
        return super.getFood();
    }
}

class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }
    @Override
    public String sound() {
        return "Moo";
    }
    @Override
    public String getFood() {
        return super.getFood();
    }
}
