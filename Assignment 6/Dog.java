import java.util.Date;

public class Dog extends Pet implements Boardable {
    private String size;
    private Date boardDateStart;
    private Date boardDateEnd;

    public Dog(String petName, String ownerName, String color, String size) {
        super(petName, ownerName, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "DOG:\n"
                + super.toString() + "\n"
                + "Size: " + size;
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        boardDateStart = Pet.convertDateIntToDate(month, day, year);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        boardDateEnd = Pet.convertDateIntToDate(month, day, year);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        Date givenDate = Pet.convertDateIntToDate(month, day, year);
        return (givenDate.before(boardDateStart) || givenDate.after(boardDateEnd));
    }
}
