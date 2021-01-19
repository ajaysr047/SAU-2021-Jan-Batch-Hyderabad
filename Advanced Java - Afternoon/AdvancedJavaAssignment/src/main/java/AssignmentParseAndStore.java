import com.mysql.cj.jdbc.Driver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class AssignmentParseAndStore {

    static Assignments xmlParse(String fileName)throws Exception
    {
        File assignmentXmlFile = new File(fileName);

        JAXBContext jaxbContext = JAXBContext.newInstance(Assignments.class);
        Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
        Assignments assignments = (Assignments) jaxbUnMarshaller.unmarshal(assignmentXmlFile);

        for(Assignment a : assignments.assignmentList) {
//        Testing upper case annotation
            ToUpperConversion.toUpper(a);
//        Testing add date annotation
            AddDateConversion.addDate(a);
            System.out.println(a.getId() + ") " + a.getName() + " : " + a.getLanguage() + " : " + a.getStatus() + " : " + a.getLocalDate());
        }
        return assignments;
    }

    static void createTable(Connection connection)
    {
        try{
            Statement statement = connection.createStatement();
            String createTableQuery = "create table assignments (id int primary key, name varchar(30), language varchar(20), status varchar(15), assignmentDate date);";
            statement.execute(createTableQuery);
            System.out.println("Table successfully created!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    static void insertData(Connection connection, Assignments assignments)
    {
        String insertDataQuery = "insert into assignments values (?, ?, ?, ?, ?)";

        for(Assignment assignment : assignments.assignmentList){
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(insertDataQuery);
                preparedStatement.setInt(1, assignment.getId());
                preparedStatement.setString(2, assignment.getName());
                preparedStatement.setString(3, assignment.getLanguage());
                preparedStatement.setString(4, assignment.getStatus());
                preparedStatement.setDate(5, Date.valueOf(assignment.getLocalDate()));
                preparedStatement.execute();
                System.out.println("Assignment " + assignment.getId() + " Inserted");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)throws Exception {
       Assignments assignments = xmlParse("src/main/resources/Assignments.xml");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password for SQL user ajay: ");
        String password = scanner.nextLine();

       Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/springau", "ajay", password);
        createTable(connection);
        insertData(connection, assignments);
    }
}
