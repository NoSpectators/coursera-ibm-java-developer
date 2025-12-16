public class AnimalFarm {
    public static void main(String[] args) {
        // the key polymorphism here are the object declarations:
        // type Animal, but instances of specific classes
        // each sound is specific based on the object type
        Animal a1 = new Dog("Sami");
        Animal a2 = new Cat("Hershey");
        Animal a3 = new Cow("Molly");
        System.out.println("animal1 sound " + a1.sound());
        System.out.println("animal2 sound " + a2.sound());
        System.out.println("animal3 sound " + a3.sound());

    }
}
