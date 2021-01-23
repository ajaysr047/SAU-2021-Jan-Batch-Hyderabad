import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

public class MultiThreadedV1 extends Thread {


    static void wordFrequency(String filePath) throws Exception {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        Map<String, Integer> wordCount = new HashMap<>();

        String line;

        while ((line = reader.readLine()) != null) {
            // System.out.println(line);
            String tmpArray[] = line.split(" ");

            for (String temp : tmpArray) {
                // Remove all non-alphabets
                temp = temp.replaceAll("[^a-zA-Z ]", "");
                if (temp.length() != 0) {
                    if (wordCount.containsKey(temp))
                        wordCount.put(temp, wordCount.get(temp) + 1);
                    else
                        wordCount.put(temp, 1);
                }
            }
        }
        // Printing word count
        System.out.println("Word \t Count");
        for (Map.Entry<String, Integer> wordEntry : wordCount.entrySet())
            System.out.println(wordEntry.getKey() + " :\t" + wordEntry.getValue());

        reader.close();
    }

    static void countSentences(String filePath) throws Exception {
        Path file = Path.of(filePath);

        String bookString = Files.readString(file);

        int sentenceCount = 0;
        // Using sentence delimiters
        String tmpArray[] = bookString.split("[!.?:]+");
        sentenceCount = tmpArray.length;

        System.out.println("Number of sentences: " + sentenceCount);
    }

    static void countParagraphs(String filePath) throws Exception {
        Path file = Path.of(filePath);

        String bookString = Files.readString(file);

        String paragraphs[] = bookString.split("\n");

        System.out.println("Number of Paragraphs: " + paragraphs.length);
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();

        String filePath = "LargeBook.txt";

        System.out.println("\t Start counting words");
        Thread countWordThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    wordFrequency(filePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
			}
            
        });

        countWordThread.start();
        // countWordThread.join();
        System.out.println("\tWord Frequency identified!");

        System.out.println("\t Start counting sentences");
        Thread countSentencesThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    countSentences(filePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
			}
            
        });

        countSentencesThread.start();
        // countSentencesThread.join();
        System.out.println("\nSentence count identified!");

        System.out.println("\t Start counting paragraphs");
        Thread countParagraphsThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    countParagraphs(filePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
			}
            
        });

        countParagraphsThread.start();
        // countParagraphsThread.join();
        System.out.println("\nParagraph count identified!");

        countWordThread.join();
        countParagraphsThread.join();
        countSentencesThread.join();

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        double executionTimeInSeconds = (double) executionTime / 1_000_000_000.0;
        System.out.println("Execution time: " + executionTimeInSeconds);

    }
}
