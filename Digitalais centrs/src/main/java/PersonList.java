import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class PersonList {
    private List<Person> list;


    @XmlElement
    public List<Person> getList() {
        return list;
    }

    public PersonList()
    {
        list = new ArrayList<>();
    }
    public PersonList(List<Person> list) {
        this.list = list;
    }

    public void addPerson(Person person) {
        list.add(person);
    }

    public Person getPerson(String surname) {
        for (Person person : list) {
            if (person.getSurname().equals(surname)) {
                return person;
            }
        }
        return null;
    }
    public static PersonList getInstance(String filePath) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(PersonList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("qwerty.xml");
        PersonList pers = (PersonList) unmarshaller.unmarshal(file);

        return pers;
    }


}


