import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class DeserializeAndPrint {

    static  List<Map.Entry<Integer, Integer>> deserializeAndSort(String fileName)throws Exception
    {
        HashMap<Integer, Integer> rollTotalMarks = null;

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        rollTotalMarks = (HashMap<Integer, Integer>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        List<Map.Entry<Integer, Integer>> tempList = new LinkedList<>(rollTotalMarks.entrySet());

        tempList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                return (entry2.getValue()).compareTo(entry1.getValue());
            }
        });

        System.out.println("\nRank\tRoll number\tTotal Marks(300)");
        for(int i = 0; i < tempList.size(); i++)
        {
            System.out.println(i + 1 + "\t\t\t" + tempList.get(i).getKey() + "\t\t\t" + tempList.get(i).getValue());
        }
        return tempList;
    }

    static void writeToCSV(List<Map.Entry<Integer, Integer>> data, String fileName)throws Exception    {

//        Writing top 5 to CSV
        data.subList(5, data.size()).clear();
        System.out.println(data);

        try (CSVPrinter printer = new CSVPrinter(new FileWriter(fileName), CSVFormat.EXCEL.withHeader("Rank", "Roll Number", "Total Marks(300"))) {

            for(int i = 0; i<data.size();i++)
                printer.printRecord(i + 1, data.get(i).getKey(), data.get(i).getValue());
            System.out.println("Data of 1 - 5 ranks has been written to rank.csv");
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public static void main(String[] args)throws Exception {
        List<Map.Entry<Integer, Integer>> deserializedSortedData =  deserializeAndSort("student.txt");
        writeToCSV(deserializedSortedData, "rank.csv");
    }
}
