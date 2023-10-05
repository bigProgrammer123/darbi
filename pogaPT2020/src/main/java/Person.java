import lombok.Setter;
import lombok.ToString;


@Setter
@ToString
public class Person {
    private String name ;
    private String gender;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public String getUsername() { return username; }

    public String getGender() {
        return gender;
    }

    public String getPassword() { return password; }

    public Person() {}

    public Person(String name, String username, String password, String gender) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }
}
