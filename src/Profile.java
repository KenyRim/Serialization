import java.io.Serializable;

/**
 * Created by kenyr on 19.09.2017.
 */
public class Profile implements Serializable{
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
