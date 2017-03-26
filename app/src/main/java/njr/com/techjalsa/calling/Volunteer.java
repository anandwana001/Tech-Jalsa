package njr.com.techjalsa.calling;

/**
 * Created by dell on 20-02-2017.
 */

public class Volunteer {

    private String name;
    private String number;

    public Volunteer() {
    }

    public Volunteer(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
