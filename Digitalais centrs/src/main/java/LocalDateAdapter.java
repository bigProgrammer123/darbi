import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, java.time.LocalDate> {
    @Override
    public java.time.LocalDate unmarshal(String dateStr) {
        return java.time.LocalDate.parse(dateStr);
    }

    @Override
    public String marshal(java.time.LocalDate date) {
        return date.toString();
    }
}
