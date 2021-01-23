import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MultiThreadedV3 {

    public static void main(String[] args)throws Exception {

        long startTime = System.nanoTime();
        Path file = Path.of ("LargeBook.txt");
        String bookString = Files.readString(file);
        int partitionSize = 1688040;
        
        List<countWordsThread> countWordsThreads = new ArrayList<>();

        int beginIndex = 0, endIndex = 1688040;
        for(int i = 0; i < 10 ; i++)
        {
            countWordsThreads.add(new countWordsThread(bookString.substring(beginIndex, endIndex)));
            beginIndex = endIndex;
            endIndex = endIndex + partitionSize;
        }

        int totalCount = 0;

        for(countWordsThread c : countWordsThreads)
            c.start();
        
        for(countWordsThread c : countWordsThreads)
        {
            c.join();
            totalCount += c.getCount();
        }

        System.out.println("Number of words: " + totalCount);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        double executionTimeInSeconds = (double) executionTime / 1_000_000_000.0;
        System.out.println("Execution time: " + executionTimeInSeconds);
        
    }
}

class countWordsThread extends Thread{

    String subContent;
    private int count = 0;
    public countWordsThread(String sub){
        subContent = sub;
    }
    public int getCount(){
        return count;
    }
    @Override
    public void run(){
       
        String tmpArray[] = subContent.split("\\s+");
        count = tmpArray.length;
    }
}
