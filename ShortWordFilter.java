import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class ShortWordFilter implements Filter {

    @Override
    public boolean accept(Object x) {
        if (x instanceof String) {
            String str = (String) x;
            return str.length() < 5;
        }
        return false;
    }

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a Text File");
        fileChooser.showOpenDialog(null);

        File selectedFile = fileChooser.getSelectedFile();
        if (selectedFile != null) {
            String[] words = readWordsFromFile(selectedFile);
            Filter shortWordFilter = new ShortWordFilter();
            Object[] shortWords = collectAll(words, shortWordFilter);

            for (Object shortWord : shortWords) {
                System.out.println(shortWord);
            }
        }
    }

    private static String[] readWordsFromFile(File file) {
        // Implement logic to read words from the file
        // For simplicity, a placeholder is used here
        return new String[]{"apple", "banana", "cat", "dog", "elephant"};
    }

    private static Object[] collectAll(Object[] objects, Filter filter) {
        // Implement logic to collect objects based on the filter
        // For simplicity, a placeholder is used here
        return java.util.Arrays.stream(objects).filter(filter::accept).toArray();
    }
}
