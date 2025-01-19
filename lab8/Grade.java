public class Grade {
    private int studentId;
    private int value;

    public int getStudentId() {
        return studentId;
    }

    public int getValue() {
        return value;
    }

    public Grade(int studentId, int value) {
        this.studentId = studentId;
        this.value = value;
    }
}