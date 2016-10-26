public interface Boardable {

    // Month = 1-12, Day = 1-31, Year = XXXX

    void setBoardStart(int month, int day, int year);

    void setBoardEnd(int month, int day, int year);

    boolean boarding(int month, int day, int year);

}
