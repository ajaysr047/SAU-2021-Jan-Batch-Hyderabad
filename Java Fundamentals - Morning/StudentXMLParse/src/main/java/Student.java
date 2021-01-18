import javax.xml.bind.annotation.XmlElement;

public class Student {

    @XmlElement(name = "Roll" )
    private int Roll;
    @XmlElement(name = "Mark" )
    private int Mark;
    @XmlElement(name = "Subject" )
    private String Subject;

    public int getRoll() {
        return Roll;
    }

    public void setRoll(int roll) {
        Roll = roll;
    }

    public int getMark() {
        return Mark;
    }

    public void setMark(int mark) {
        Mark = mark;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
