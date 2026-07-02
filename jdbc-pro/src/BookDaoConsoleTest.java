

import com.mmcoe.dao.BookDao;
import com.mmcoe.dao.BookDaoJdbcImpl;
import com.mmcoe.pojo.Book;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BookDaoConsoleTest {

    public static void main(String[] args) {
        BookDao bookDao = new BookDaoJdbcImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Book DAO Test Menu ---");
            System.out.println("1. Add a new Book");
            System.out.println("2. Find a Book by ISBN");
            System.out.println("3. List all Books");
            System.out.println("4. Delete a Book");
            System.out.println("5. Find Books by Price Range");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ISBN: ");
                        int isbn = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        Book newBook = new Book();
                        newBook.setIsbn(isbn);
                        newBook.setTitle(title);
                        newBook.setAuthor(author);
                        newBook.setPrice(price);

                        if (bookDao.save(newBook)) {
                            System.out.println("Book saved successfully!");
                        } else {
                            System.out.println("Failed to save the book.");
                        }
                        break;

                    case 2:
                        System.out.print("Enter ISBN to search: ");
                        int searchIsbn = Integer.parseInt(scanner.nextLine());
                        Optional<Book> foundBook = bookDao.find(searchIsbn);
                        
                        if (foundBook.isPresent()) {
                            Book b = foundBook.get();
                            System.out.println("Found Book: " + b.getIsbn() + " - " + b.getTitle() + " by " + b.getAuthor() + " (Price: $" + b.getPrice() + ")");
                        } else {
                            System.out.println("Book with ISBN " + searchIsbn + " not found.");
                        }
                        break;

                    case 3:
                        List<Book> books = bookDao.list();
                        if (books != null && !books.isEmpty()) {
                            System.out.println("\n--- List of all Books ---");
                            for (Book b : books) {
                                System.out.println(b.getIsbn() + " | " + b.getTitle() + " | " + b.getAuthor() + " | $" + b.getPrice());
                            }
                        } else {
                            System.out.println("No books found in the database.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter ISBN to delete: ");
                        int deleteIsbn = Integer.parseInt(scanner.nextLine());
                        if (bookDao.delete(deleteIsbn)) {
                            System.out.println("Book deleted successfully!");
                        } else {
                            System.out.println("Failed to delete the book.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter Minimum Price: ");
                        double minPrice = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter Maximum Price: ");
                        double maxPrice = Double.parseDouble(scanner.nextLine());
                        
                        List<Book> priceRangeBooks = bookDao.findByPrice(minPrice, maxPrice);
                        if (priceRangeBooks != null && !priceRangeBooks.isEmpty()) {
                            System.out.println("\n--- Books in Price Range ---");
                            for (Book b : priceRangeBooks) {
                                System.out.println(b.getIsbn() + " | " + b.getTitle() + " | " + b.getAuthor() + " | $" + b.getPrice());
                            }
                        } else {
                            System.out.println("No books found in this price range.");
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please select from 1 to 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format entered. Returning to menu...");
            }
        }
    }
}
