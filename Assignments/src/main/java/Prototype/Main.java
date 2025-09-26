package Prototype;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static List<Book> books = Arrays.asList(
            new Book("Lord of the Rings", "J.R.R. Tolkien", "High Fantasy", 1216),
            new Book("The Way of Kings", "Brandon Sanderson", "High Fantasy", 1007)
    );

    public static List<Recommendation> recommendations = new ArrayList<>();

    public static void main(String[] args) {
        runMainMenu();
    }

    private static void runMainMenu() {
        System.out.println();
        while (true) {
            for (int i=0;i<recommendations.size();i++) {
                System.out.println(i+". "+recommendations.get(i).getGenre());
            }
            System.out.println("Input '0' to exit.");
            System.out.println("Input '1' to add a recommendation set.");
            System.out.println("Input number to view/edit/clone specific saved book recommendation set.");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    runAddRecommendationMenu();
                    break;
            }
        }
    }

    private static void runAddRecommendationMenu() {
        System.out.println();
        System.out.println("Type a genre for book recommendation set.");
        String genre = sc.next();

        Recommendation recommendation = new Recommendation();

        while (true) {
            for (int i=0;i<books.size();i++) {
                System.out.println(i+". "+books.get(i).toString());
            }

            System.out.println("Select a book from the list to add, 's' to stop and save recommendation");
            String choice = sc.next();

            if (Objects.equals(choice, "s")) {
                recommendations.add(recommendation);
                runMainMenu();
            } else {
                int chosenBookId = Integer.parseInt(choice);
                recommendation.addBook(books.get(chosenBookId).clone());
                recommendation.setGenre(genre);
            }
        }
    }

}
