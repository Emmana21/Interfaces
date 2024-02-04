import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String shortListerFilePath = "path/to/your/short/words/file.txt";
        String bigRectListerFilePath = "path/to/your/big/rectangles/file.txt";


        System.out.println("=== ShortLister ===");
        String[] shortListerWords = readWordsFromFile(new File(shortListerFilePath));
        Filter shortWordFilter = new ShortWordFilter();
        Object[] shortWords = collectAll(shortListerWords, shortWordFilter);

        System.out.println("Short Words:");
        for (Object shortWord : shortWords) {
            System.out.println(shortWord);
        }


        System.out.println("\n=== BigRectLister ===");
        ArrayList<Rectangle> bigRectListerRectangles = createRectangles();
        Filter bigRectangleFilter = new BigRectangleFilter();
        Object[] bigRectangles = collectAll(bigRectListerRectangles.toArray(), bigRectangleFilter);

        System.out.println("Big Rectangles:");
        for (Object bigRectangle : bigRectangles) {
            System.out.println(bigRectangle);
        }
    }

    private static String[] readWordsFromFile(File file) {
        try {

            return new String[]{"apple", "banana", "cat", "dog", "elephant"};
        } catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    private static ArrayList<Rectangle> createRectangles() {
        ArrayList<Rectangle> rectangles = new ArrayList<>();


        rectangles.add(new Rectangle(2, 3));  // Perimeter: 10
        rectangles.add(new Rectangle(4, 2));  // Perimeter: 12
        rectangles.add(new Rectangle(3, 4));  // Perimeter: 14
        rectangles.add(new Rectangle(5, 2));  // Perimeter: 14
        rectangles.add(new Rectangle(6, 2));  // Perimeter: 16
        rectangles.add(new Rectangle(4, 4));  // Perimeter: 16
        rectangles.add(new Rectangle(7, 2));  // Perimeter: 18
        rectangles.add(new Rectangle(5, 6));  // Perimeter: 22
        rectangles.add(new Rectangle(8, 3));  // Perimeter: 22
        rectangles.add(new Rectangle(6, 6));  // Perimeter: 24

        return rectangles;
    }

    private static Object[] collectAll(Object[] objects, Filter filter) {
        return java.util.Arrays.stream(objects).filter(filter::accept).toArray();
    }
}