import java.util.ArrayList;
import java.util.List;

public class TimeTable {
    private String section;
    private String branch;
    private List<DaySchedule> weekSchedule;
    private List<Course> courses;

    public TimeTable(String section, String branch) {
        this.section = section;
        this.branch = branch;
        this.weekSchedule = new ArrayList<>();
        this.courses = new ArrayList<>();
        initializeWeekSchedule();
    }

    private void initializeWeekSchedule() {
        weekSchedule.add(new DaySchedule("Monday"));
        weekSchedule.add(new DaySchedule("Tuesday"));
        weekSchedule.add(new DaySchedule("Wednesday"));
        weekSchedule.add(new DaySchedule("Thursday"));
        weekSchedule.add(new DaySchedule("Friday"));
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayTimeTable() {
        System.out.println("\nTime Table for " + branch +
            (branch.equalsIgnoreCase("CSE") ? " - Section " + section : ""));
        System.out.println("=".repeat(100));
        
        // Print header
        System.out.printf("%-15s", "Time/Day");
        for (DaySchedule day : weekSchedule) {
            System.out.printf("%-20s", day.getDay());
        }
        System.out.println("\n" + "-".repeat(100));
        
        // Print schedule for each time slot
        for (int slotIndex = 0; slotIndex < weekSchedule.get(0).getTimeSlots().size(); slotIndex++) {
            String timeRange = weekSchedule.get(0).getTimeSlots().get(slotIndex).getTimeRange();
            System.out.printf("%-15s", timeRange);
        
            for (DaySchedule day : weekSchedule) {
                TimeSlot slot = day.getTimeSlots().get(slotIndex);
                String courseInfo = slot.getCourse() != null ? 
                    slot.getCourse().getCourseCode() : 
                    "-";
                System.out.printf("%-20s", courseInfo);
            }
            System.out.println();
        }
        
        // Print course information
        System.out.println("\nCourse Information:");
        System.out.println("-".repeat(100));
        System.out.printf("%-15s%-30s%-15s%-15s\n", 
            "Course Code", "Course Name", "Faculty", "Credits");
        System.out.println("-".repeat(100));
        for (Course course : courses) {
            System.out.printf("%-15s%-30s%-15s%-15d\n",
                course.getCourseCode(),
                course.getName(),
                course.getFaculty(),
                course.getCredits());
        }
    }
    

    public List<DaySchedule> getWeekSchedule() {
        return weekSchedule;
    }
}
