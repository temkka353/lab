import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        FileStud fileStudents = new FileStud("/students.csv");
        FileGrades fileGrades = new FileGrades("/grades.csv");
        List<Stud> students = fileStudents.getStudents();
        List<Grade> grades = fileGrades.getGrades();

        for (Stud stud : students) {
            for (Grade grade : grades) {
                if (stud.getStudent_id() == grade.getStudentId()){
                    stud.addGrade(grade);
                }
            }
        }

        printStudents(students);
        printAverages(students);
        printInRange(students , 4.2F , 4.7F);
    }

    private static void printStudents(List<Stud> studs){
        System.out.println("Студенты и их оценки:");
        for (Stud stud : studs){
            System.out.println(stud.toString());
        }
        System.out.println();
    }

    private static void printAverages(List<Stud> studs){
        System.out.println("Средние оценки:");
        for (Stud stud : studs){
            int id = stud.getStudent_id();
            String firstName = stud.getFirst_name();
            String lastName = stud.getLast_name();
            float avgGrade = stud.getAverageGrade();
            System.out.println(id + " " + firstName + " " + lastName + " " + avgGrade);
        }
        System.out.println();
    }

    private static void printInRange(List<Stud> studs, float min, float max){
        System.out.println("Студенты из диапазона от " + min + " до " + max + ":" );
        for (Stud stud : studs){
            int id = stud.getStudent_id();
            String firstName = stud.getFirst_name();
            String lastName = stud.getLast_name();
            float avgGrade = stud.getAverageGrade();
            if (avgGrade <= max && avgGrade >= min) {
                System.out.println(id + " " + firstName + " " + lastName + " " + avgGrade);
            }
        }
        System.out.println();
    }
}