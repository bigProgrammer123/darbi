import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;


@Setter
@ToString
public class Person {
    private String name ;
    private String surname;
    private String datNum;
    private LocalDate date;

    public String getName() { return name; }

    public String getSurname() { return surname; }

    public String getDatNum() { return datNum; }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDate() { return date; }

    public Person() {}

    public Person(String name, String surname, LocalDate date, String datNum) {
        this.name = name;
        this.surname = surname;
        this.datNum = datNum;
        this.date = date;
    }
}
