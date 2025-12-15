class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }
    public String getName() {
       return this.name; 
    }
    public void setName(String name) {
        this.name = name; 
    }
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("age cannot be negative.");
        }
    }
    public int getAge() {
        return this.age;
    }
}
