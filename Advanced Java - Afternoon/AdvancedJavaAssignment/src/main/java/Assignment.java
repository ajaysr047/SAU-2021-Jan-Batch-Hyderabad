import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

public class Assignment {
    @ToUpper(toUpper = true)
    @XmlElement(name = "Name" )
    private String Name;

    @ToUpper(toUpper = true)
    @XmlElement(name = "Language" )
    private String Language;

    @XmlElement(name = "Status" )
    private String Status;

    @XmlElement(name = "Id")
    private int Id;

    @AddDate(addDate = true)
    private LocalDate localDate = null;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }


}
