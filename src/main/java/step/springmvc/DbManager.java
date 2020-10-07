package step.springmvc;

import java.util.ArrayList;
import java.util.Arrays;

public class DbManager {
    private static ArrayList<Book> books;

    static {
        books = new ArrayList<>(Arrays.asList(
           new Book(1, "Clean Code", "Bob", 1221),
           new Book(2, "CLR via C#", "Jeff", 20000),
           new Book(2, "C# Professional", "Someone", 40000),
           new Book(3, "Богатый папа, бедный папа", "Роберт Кийосаки", 6000)
        ));
    }

    public static ArrayList<Book> getAllBooks() {
        return books;
    }

    public static ArrayList<Book> getBooksByName(String name) {
        var result = new ArrayList<Book>();

        books.stream().filter(book ->
                book.getName().toLowerCase().contains(name.toLowerCase()))
                .forEach(result::add);

        return result;
    }
}
