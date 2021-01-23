import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MultiThreadedV2 {

    public static void main(String[] args)throws Exception {

        long startTime = System.nanoTime();
        Path file = Path.of ("LargeBook.txt");
        String bookString = Files.readString(file);
        // bookString = bookString.replaceAll("[^a-zA-Z ]", " ");  
        int partitionSize = 1688040;
        String partitionArray[] = bookString.split("(?<=\\G.{" + partitionSize + "})");

        List<Callable<Integer>> tasks = new ArrayList<>();

        for(String s : partitionArray)
            tasks.add(new countWordsCallable(s));
        
            
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> results = executorService.invokeAll(tasks);

        Integer count = 0;
        for(Future<Integer> f : results)
            count += f.get();
        System.out.println("Number of words: " + count);

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        double executionTimeInSeconds = (double) executionTime / 1_000_000_000.0;
        System.out.println("Execution time: " + executionTimeInSeconds);
        executorService.shutdown();
        
    }
}

class countWordsCallable implements Callable<Integer>{

    String subContent;
    public countWordsCallable(String sub){
        subContent = sub;
    }
    @Override
    public Integer call()throws Exception{
       
        String tmpArray[] = subContent.split("\\s+");
        return tmpArray.length;
    }
}
