import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TimeTableGenerator {
    private Map<String, TimeTable> timeTables;

    public TimeTableGenerator() {
        this.timeTables = new HashMap<>();
    }

    public void generateTimeTables(List<Course> courses) {
        // Group courses by branch and semester
        Map<String, List<Course>> branchSemesterCourses = new HashMap<>();
        
        for (Course course : courses) {
            String key = course.getBranch() + "-" + course.getSection();
            branchSemesterCourses.computeIfAbsent(key, k -> new ArrayList<>()).add(course);
        }

        // Generate time table for each branch and semester
        for (Map.Entry<String, List<Course>> entry : branchSemesterCourses.entrySet()) {
            String[] parts = entry.getKey().split("-");
            String branch = parts[0];
            String section = parts[1];
            
            TimeTable timeTable = new TimeTable(section, branch);
            for (Course course : entry.getValue()) {
                timeTable.addCourse(course);
            }
            
            assignCoursesToTimeSlots(timeTable, entry.getValue());
            timeTables.put(entry.getKey(), timeTable);
        }
    }

    private void assignCoursesToTimeSlots(TimeTable timeTable, List<Course> courses) {
        Random random = new Random();
        List<DaySchedule> weekSchedule = timeTable.getWeekSchedule();
        
        for (Course course : courses) {
            int creditsRemaining = course.getCredits();
            
            while (creditsRemaining > 0) {
                // Try to find a suitable time slot
                boolean slotFound = false;
                int maxAttempts = 50; // Prevent infinite loop
                int attempts = 0;
                
                while (!slotFound && attempts < maxAttempts) {
                    int day = random.nextInt(weekSchedule.size());
                    int slot = random.nextInt(weekSchedule.get(day).getTimeSlots().size());
                    
                    TimeSlot timeSlot = weekSchedule.get(day).getTimeSlots().get(slot);
                    
                    if (timeSlot.getCourse() == null) {
                        timeSlot.setCourse(course);
                        slotFound = true;
                        creditsRemaining--;
                    }
                    attempts++;
                }
                
                if (!slotFound) {
                    System.err.println("Warning: Could not allocate all credits for " + course.getCourseCode());
                    break;
                }
            }
        }
    }

    public void displayAllTimeTables() {
        for (TimeTable timeTable : timeTables.values()) {
            timeTable.displayTimeTable();
            System.out.println("\n" + "=".repeat(100) + "\n");
        }
    }
}