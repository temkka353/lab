import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileGrades {
    private List<Grade> gradesList;

    public List<Grade> getGrades() {
        return gradesList;
    }

    public FileGrades(String filePath) {
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
        gradesList = mapGrades(data);
    }

    private List<Grade> mapGrades(List<String> lines) {
        List<Grade> grades = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] line = lines.get(i).split(";");
            try {
                grades.add(new Grade(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
        return grades;
    }
}