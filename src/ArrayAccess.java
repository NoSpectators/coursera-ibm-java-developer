public class ArrayAccess {
    public static void main(String []args) {
        int []years = {2020, 2021, 2022, 2023, 2024, 2025};
        System.out.println(years[0]);
        System.out.println(years[1]);
        System.out.println(years[2]);
        System.out.println(years[3]);
        System.out.println(years[4]);
        System.out.println(years[5]);

        System.out.println();
        int []years2 = new int[6];
        years2[1] = 2021;
        years2[3] = 2023;
        System.out.println(years2[0]);
        System.out.println(years2[1]);
        System.out.println(years2[2]);
        System.out.println(years2[3]);
        System.out.println(years2[4]);
        System.out.println(years2[5]);

        System.out.println();
        for (int i = 0; i < years.length; i++) {
            System.out.println(years[i]);
        }
        
        System.out.println();
        int num_args = args.length;
        for (int i = 0; i < num_args; i++) {
            System.out.println(args[i]);
        }

        System.out.println();
        int []arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println();
        String j = "John";
        char []name = j.toCharArray();
        for (int i= 0; i < name.length; i++) {
            System.out.println(name[i]);
        }
    }
}
