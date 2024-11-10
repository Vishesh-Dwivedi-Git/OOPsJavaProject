import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Specify the path to your CSV files
        String coursesFile = "data/courses.csv";
        String batchesFile = "data/batches.csv";

        // Read courses from CSV
        List<Course> courses = CSVReader.readCoursesFromCSV(coursesFile);
        
        // Create and run the time table generator
        TimeTableGenerator generator = new TimeTableGenerator();
        generator.generateTimeTables(courses);
        
        // Display all generated time tables
        generator.displayAllTimeTables();
    }
}