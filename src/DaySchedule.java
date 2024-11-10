import java.util.ArrayList;
import java.util.List;

public class DaySchedule {
    private String day;
    private List<TimeSlot> timeSlots;

    public DaySchedule(String day) {
        this.day = day;
        this.timeSlots = new ArrayList<>();
        initializeTimeSlots();
    }

    private void initializeTimeSlots() {
        timeSlots.add(new TimeSlot("09:00", "09:30"));
        timeSlots.add(new TimeSlot("09:30", "10:30"));
        timeSlots.add(new TimeSlot("10:45", "12:15")); // After morning break
        timeSlots.add(new TimeSlot("12:15", "13:15"));
        timeSlots.add(new TimeSlot("14:30", "16:00")); // After lunch break
        timeSlots.add(new TimeSlot("16:00", "16:30"));
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public String getDay() {
        return day;
    }
}