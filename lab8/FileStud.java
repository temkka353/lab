import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStud {
    private List<Stud> studentsList;

    public List<Stud> getStudents() {
        return studentsList;
    }

    public FileStud (String filePath) {
        List<String> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        studentsList = mapStudents(data);
    }

    private List<Stud> mapStudents(List<String> lines){
        List<Stud> students = new ArrayList<>();
        for(int i = 1; i < lines.size(); i++) {
            String[] line = lines.get(i).split(";");
            students.add(new Stud(Integer.parseInt(line[0]), line[1], line[2]));
        }
        return students;
    }
}