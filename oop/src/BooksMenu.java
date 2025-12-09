import java.util.Scanner;

public class BooksMenu {
    public static Book getExpensiveBook(Book book1, Book book2) {
        if (book1.getPrice() > book2.getPrice()) {
            return book1;
        } else {
            return book2;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int bkIdx = 0;
        while(true) {
            System.out.println("\nPress ... " + 
			    "\n1 to view books, " + 
			    "\n2 to add books, " + 
			    "\n3 to compare two books' prices, " + 
			    "\nany other key to exit");
            String userAction = scanner.nextLine();
            if (userAction.equals("1")) {
                for (int i = 0; i < books.length; i++) {
                    if (books[i] !=  null) {
                        System.out.println(books[i]);
                    }
                }
            } else if (userAction.equals("2")) {
                if (bkIdx == 10) {
                    System.out.println("10 books added already. Cannot add any more books!");
                    continue;
                }
                System.out.println("Enter book title");
                String tmpTitle = scanner.nextLine();
                System.out.println("Enter book author");
                String tmpAuthor = scanner.nextLine();
                System.out.println("Enter book price");
                float tmpPrice = Float.parseFloat(scanner.nextLine());
                Book bkTmp = new Book();
                bkTmp.setTitle(tmpTitle);
                bkTmp.setAuthor(tmpAuthor);
                bkTmp.setPrice(tmpPrice);
                books[bkIdx++] = bkTmp;
                // books[bkIdx] = bkTmp;
                // bkIdx++;
            } else if (userAction.equals("3")) {
                System.out.println("enter book 1 index");
		int bk1Idx = Integer.parseInt(scanner.nextLine());
                System.out.println("enter book 2 index"); 
                int bk2Idx = Integer.parseInt(scanner.nextLine());
                if (books[bk1Idx] != null && books[bk2Idx] != null) {
                    System.out.println("The details of the most expensive book is \n" +
				    getExpensiveBook(books[bk1Idx], books[bk2Idx]));
                } else {
                    System.out.println("One or both books do not exist!"); 
                }
            } else {
                break;
            }
        } 
    }
}
