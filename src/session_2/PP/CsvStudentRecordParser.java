package session_2.PP;

public class CsvStudentRecordParser {
    public static void parseStudentRecord(String csvLine) {
        String[] details = csvLine.split(",");

        if (details.length == 3) {
            System.out.println("Name: " + details[0] + " | Roll No: " + details[1]
                    + " | Dept: " + details[2]);
        } else {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
    }
}