import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class StudentsXMLParseAndSerialize {

    static void serialize(HashMap<Integer, Integer> rollTotalMarks, String fileName) throws Exception {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(rollTotalMarks);
        objectOutputStream.close();
        fileOutputStream.close();

    }

    public static void main(String[] args)throws Exception {
        File studentXmlFile = new File("src/main/resources/Students.xml");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            Students students = (Students) jaxbUnMarshaller.unmarshal(studentXmlFile);

            HashMap<Integer, Integer> rollTotalMarks = new HashMap<>();

            for(Student s : students.getStudentList())
            {
                if(s.getMark() < 0 || s.getMark() > 100) {
                    throw new InvalidMarkException("Mark should be between 0 - 100, Student roll number: " + s.getRoll());
                }
                else
                {
                    if(rollTotalMarks.containsKey(s.getRoll()))
                        rollTotalMarks.put(s.getRoll(), (rollTotalMarks.get(s.getRoll()) + s.getMark()));
                    else
                        rollTotalMarks.put(s.getRoll(), s.getMark());
                }
            }
            serialize(rollTotalMarks, "student.txt");
            System.out.println(rollTotalMarks);
            System.out.println("Serialized to student.txt");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        catch (InvalidMarkException e)
        {
            System.out.println("Mark exception: " + e);
        }
    }
}
