import java.util.Date;

public class Cat extends Pet implements Boardable {
    private String hairLength;
    private Date boardDateStart;
    private Date boardDateEnd;

    public Cat(String petName, String ownerName, String color, String hairLength) {
        super(petName, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return hairLength;
    }

    @Override
    public String toString() {
        return "CAT:\n"
                + super.toString() + "\n"
                + "Hair: " + hairLength;
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
        if (boardDateStart == null || boardDateEnd == null) {
            System.out.println("This pet is missing a start/end date");
            return false;
        }
        return (givenDate.equals(boardDateStart) || givenDate.equals(boardDateEnd))
                || (givenDate.after(boardDateStart) && givenDate.before(boardDateEnd));
    }
}
