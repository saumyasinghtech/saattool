import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class NewPage {
    public static Map<String,Integer> findRepatedString(ArrayList<String> strings){
        Map<String,Integer> repatedMap = new HashMap<>();

        for(String str : strings){
            repatedMap.put(str,repatedMap.getOrDefault(str,0) + 1);
        }
        return repatedMap;  
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("Java");
        list.add("PHP");
        list.add("Python");

        Map<String ,Integer> repated = findRepatedString(list);
        for(Map.Entry<String,Integer> entry : repated.entrySet()){
            System.out.println("Result "+entry.getKey());
        }
    }
}

import java.util.Arrays;

public class Result {

    private static final int MOD = 1000000007;

    public static int countBalancedWords(int n, int d) {
        int[][] dp = new int[n][26];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                int count = 0;
                for (int k = Math.max(0, j - d); k <= Math.min(25, j + d); k++) {
                    count = (count + dp[i - 1][k]) % MOD;
                }
                dp[i][j] = count;
            }
        }

        int result = 0;
        for (int j = 0; j < 26; j++) {
            result = (result + dp[n - 1][j]) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample test
        System.out.println(countBalancedWords(2, 2));  // Output: 124
    }
}


------------------------------------------------------------------------


import java.util.*;
import java.util.stream.Collectors;

// IBook Interface
interface IBook {
    int getId();
    String getTitle();
    String getAuthor();
    String getCategory();
    int getPrice();
}

// ILibrarySystem Interface
interface ILibrarySystem {
    void addBook(IBook book, int quantity);
    void removeBook(IBook book, int quantity);
    int calculateTotal();
    Map<String, Integer> categoryTotalPrice();
    List<BooksInfo> booksInfo();
    List<CategoryAuthorWithCount> categoryAndAuthorWithCount();
}

// Book class implementing IBook
class Book implements IBook {
    private int id;
    private String title;
    private String author;
    private String category;
    private int price;

    public Book(int id, String title, String author, String category, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public int getPrice() {
        return price;
    }
}

// BooksInfo class to store book information
class BooksInfo {
    private String title;
    private int quantity;
    private int price;

    public BooksInfo(String title, int quantity, int price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Book Name: %s, Quantity: %d, Price: %d", title, quantity, price);
    }
}

// CategoryAuthorWithCount class to store category and author information with count
class CategoryAuthorWithCount {
    private String category;
    private String author;
    private int count;

    public CategoryAuthorWithCount(String category, String author, int count) {
        this.category = category;
        this.author = author;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("Category: %s, Author: %s, Count: %d", category, author, count);
    }
}

// LibrarySystem class implementing ILibrarySystem
class LibrarySystem implements ILibrarySystem {
    private Map<IBook, Integer> _books = new HashMap<>();

    @Override
    public void addBook(IBook book, int quantity) {
        _books.put(book, _books.getOrDefault(book, 0) + quantity);
    }

    @Override
    public void removeBook(IBook book, int quantity) {
        _books.put(book, _books.getOrDefault(book, 0) - quantity);
        if (_books.get(book) <= 0) {
            _books.remove(book);
        }
    }

    @Override
    public int calculateTotal() {
        return _books.entrySet().stream().mapToInt(e -> e.getKey().getPrice() * e.getValue()).sum();
    }

    @Override
    public Map<String, Integer> categoryTotalPrice() {
        return _books.entrySet().stream()
                .collect(Collectors.groupingBy(e -> e.getKey().getCategory(),
                        Collectors.summingInt(e -> e.getKey().getPrice() * e.getValue())));
    }

    @Override
    public List<BooksInfo> booksInfo() {
        return _books.entrySet().stream()
                .map(e -> new BooksInfo(e.getKey().getTitle(), e.getValue(), e.getKey().getPrice()))
                .sorted(Comparator.comparing(BooksInfo::toString))
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryAuthorWithCount> categoryAndAuthorWithCount() {
        Map<String, Map<String, Integer>> categoryAuthorCount = new HashMap<>();

        for (Map.Entry<IBook, Integer> entry : _books.entrySet()) {
            String category = entry.getKey().getCategory();
            String author = entry.getKey().getAuthor();
            int count = entry.getValue();

            categoryAuthorCount
                    .computeIfAbsent(category, k -> new HashMap<>())
                    .merge(author, count, Integer::sum);
        }

        List<CategoryAuthorWithCount> result = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> entry : categoryAuthorCount.entrySet()) {
            for (Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                result.add(new CategoryAuthorWithCount(entry.getKey(), subEntry.getKey(), subEntry.getValue()));
            }
        }

        result.sort(Comparator.comparing(CategoryAuthorWithCount::toString));
        return result;
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        IBook book1 = new Book(1, "PeterPan", "James Matthew Barrie", "KidsClassics", 193);
        IBook book2 = new Book(2, "TheWizardOfOz", "Frank Baum", "KidsClassics", 394);

        ILibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook(book1, 11);
        librarySystem.addBook(book2, 3);

        System.out.println("Book Info:");
        librarySystem.booksInfo().forEach(System.out::println);

        System.out.println("\nCategory: KidsClassics, Total Price: " + librarySystem.categoryTotalPrice().get("KidsClassics"));

        System.out.println("\nCategory And Author With Count:");
        librarySystem.categoryAndAuthorWithCount().forEach(System.out::println);

        System.out.println("\nTotal Price: " + librarySystem.calculateTotal());
    }
}