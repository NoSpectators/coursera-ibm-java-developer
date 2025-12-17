public abstract class ClassWithAbstractMeth {
    // public abstract String absMeth1(int num); // compiles
    
    public abstract static String absMeth1(int num); // does not compile: abstract methods cannot be static
   
    // public abstract String absMeth2(); // compiles 
   
    private abstract String absMeth2(); // does not compile: abstract methods cannot be private 

    protected abstract boolean absMeth3(String str); // compiles
    
    abstract float absMeth4(int num, String str); // compiles

    public static void main(String[] args) {
        System.out.println("This is a class with abstract methods.");
    }
}
