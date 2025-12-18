// same as previous lab, but now this is an abstract class
// in the main method, you can't instantiate any AnimalAbstract objects --ONLY subclasses!!! 
public abstract class AnimalAbstract {
    private String name;
    private String food;
    
    public AnimalAbstract(String name) {
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

class Dog extends AnimalAbstract {
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

class Cat extends AnimalAbstract {
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

class Cow extends AnimalAbstract {
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
