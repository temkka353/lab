import java.util.ArrayList;
import java.util.List;

public class Stud {
    private int student_id;
    private String first_name;
    private String last_name;
    private List<Grade> grades;

    public int getStudent_id() {
        return student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public Stud(int student_id, String first_name, String last_name) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.grades = new ArrayList<>();
    }

    public Stud(int student_id, String first_name, String last_name, List<Grade> grades) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.grades = grades;
    }
    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public float getAverageGrade(){
        float avg = 0;
        for (Grade grade : grades){
            avg += grade.getValue();
        }
        avg /= grades.size();
        return avg;
    }

    @Override
    public String toString(){
        return student_id + " " + first_name + " " + last_name + " " + getGradeValues();
    }
    private List<Integer> getGradeValues () {
        List<Integer> values = new ArrayList<> ();
        for (Grade grade : grades) {
            values.add(grade.getValue());
        }
        return values;
    }
}
