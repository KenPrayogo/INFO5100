import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pet {
    private String petName;
    private String ownerName;
    private String color;
    protected int sex;

    // Definitions
    public static final int genderMale = 1;
    public static final int genderFemale = 2;
    public static final int genderSpayed = 3;
    public static final int genderNeutered = 4;

    public Pet(String petName, String ownerName, String color) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.color = color;
        // Default to unspecified
        this.sex = 0;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public String getSex() {
        switch (sex) {
            case genderMale:
                return "Male";
            case genderFemale:
                return "Female";
            case genderSpayed:
                return "Spayed";
            case genderNeutered:
                return "Neutered";
            case 0:
                return "Unspecified";
            default:
                return "Invalid gender ID";
        }
    }

    public void setSex(int sexId) {
        this.sex = sexId;
    }

    @Override
    public String toString() {
        return petName + " owned by " + ownerName + '\n' +
                "Color: " + color + '\n' +
                "Sex: " + getSex();
    }

    public static Date convertDateIntToDate (int month, int day, int year) {
        String monthString = month < 10 ? "0" + month : "" + month;
        String dayString = day < 10 ? "0" + day : "" + day;
        String dateString = "" + year + "-" + monthString + "-" + dayString;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = fmt.parse(dateString);
            return date;
        } catch (ParseException e) {
            System.out.println("Date conversion failed (invalid format): " + e);
            return null;
        }
    }
}
