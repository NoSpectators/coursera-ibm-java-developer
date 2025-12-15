public class PersonMenu {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        System.out.println("Name: " + p1.getName());
        System.out.println("Age: " + p1.getAge()); 
        Person p2 = new Person("Bob", 25);
        System.out.println("Name: " + p2.getName());
        System.out.println("Age: " + p2.getAge());
        System.out.println("\nUpdating Person 2...");
        p2.setName("Bobby");
        p2.setAge(26);
        System.out.println("\nUpdated name: " + p2.getName());
        System.out.println("\nUpdated age: " + p2.getAge());
    }
}
