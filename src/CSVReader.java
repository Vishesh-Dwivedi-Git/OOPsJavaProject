import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Course> readCoursesFromCSV(String fileName) {
        List<Course> courses = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Skip header line
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Course course = new Course(
                    values[0].trim(), // courseCode
                    values[1].trim(), // name
                    values[2].trim(), // branch
                    values[3].trim(), // section
                    values[4].trim(), // type
                    values[5].trim(), // faculty
                    Integer.parseInt(values[6].trim()), // credits
                    values[7].trim()  // lectureRoom
                );
                courses.add(course);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return courses;
    }
}