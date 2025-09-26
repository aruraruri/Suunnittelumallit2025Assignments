package Prototype;

import java.util.*;
import java.util.regex.Pattern;

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
        System.out.println("=== Recommendation sets by Genre ===");
        while (true) {
            for (int i=0;i<recommendations.size();i++) {
                System.out.println(i+". "+recommendations.get(i).getGenre());
            }
            System.out.println("Input 'x' to exit.");
            System.out.println("Input 'a' to add a recommendation set.");
            System.out.println("Input number to view/edit/clone specific saved book recommendation set.");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("x")) {
                return;
            }
            if (choice.equalsIgnoreCase("a")) {
                runAddRecommendationMenu();
            }
            if (Pattern.matches("^\\d+$", choice)) {
                int chosenRecommendationIdx = Integer.parseInt(choice);
                runEditRecommendationMenu(chosenRecommendationIdx);
            }
        }
    }

    private static void runEditRecommendationMenu(int recommendationIdx) {
        System.out.println();

        System.out.println("Recommendation set #"+recommendationIdx);
        System.out.println(recommendations.get(recommendationIdx).toString());
        while (true) {
            System.out.println();
            System.out.println("Input 'c' to clone set");
            System.out.println("Input 'r' to remove set");
            System.out.println("Input 'e' to edit set");
            System.out.println("Input 'b' to go back to main menu");
            System.out.println();
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("b")) {
                runMainMenu();
                break;
            } else if (choice.equalsIgnoreCase("c")) {
                recommendations.add(recommendations.get(recommendationIdx).clone());
                System.out.println("Cloned recommendation set.");
            } else if (choice.equalsIgnoreCase("r")) {
                recommendations.remove(recommendationIdx);
                System.out.println("Removed recommendation set.");
                runMainMenu();
                break;
            } else if (choice.equalsIgnoreCase("e")) {
                editSingleRecommendations(recommendationIdx);
                break;
            }



        }
    }

    private static void editSingleRecommendations(int recommendationIdx) {
        System.out.println();
        Recommendation recommendation = recommendations.get(recommendationIdx);
        while (true) {
            System.out.println();
            System.out.println(recommendation.toString());
            System.out.println("Input 'a' to add a book to the set");
            System.out.println("Input 'd' to delete a book from the set");
            System.out.println("Input 'b' to go back to previous menu");
            String editChoice = sc.nextLine();
            if (editChoice.equalsIgnoreCase("b")) {
                runEditRecommendationMenu(recommendationIdx);
                break;
            } else if (editChoice.equalsIgnoreCase("a")) {
                for (int i=0;i<books.size();i++) {
                    System.out.println(i+". "+books.get(i).toString());
                }
                System.out.println("Select a book from the list to add");
                String bookChoice = sc.nextLine();
                if (Pattern.matches("^\\d+$", bookChoice)) {
                    int chosenBookId = Integer.parseInt(bookChoice);
                    recommendation.addBook(books.get(chosenBookId).clone());
                }
            } else if (editChoice.equalsIgnoreCase("d")) {
                System.out.println("Select a book from the list to delete");
                String bookChoice = sc.nextLine();
                if (Pattern.matches("^\\d+$", bookChoice)) {
                    int chosenBookId = Integer.parseInt(bookChoice);
                    recommendation.removeBook(chosenBookId);
                }
            }
        }
    }

    private static void runAddRecommendationMenu() {
        System.out.println();
        System.out.println("Type a genre for book recommendation set.");
        String genre = sc.nextLine();

        Recommendation recommendation = new Recommendation();

        while (true) {
            for (int i=0;i<books.size();i++) {
                System.out.println(i+". "+books.get(i).toString());
            }

            System.out.println("Select a book from the list to add, 's' to stop and save recommendation");
            String choice = sc.nextLine();

            if (Objects.equals(choice, "s")) {
                recommendations.add(recommendation);
                runMainMenu();
                break;
            } else if (Pattern.matches("^\\d+$", choice)) {
                int chosenBookId = Integer.parseInt(choice);
                recommendation.addBook(books.get(chosenBookId).clone());
                recommendation.setGenre(genre);
            }
        }
    }

}
