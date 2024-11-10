public class TimeSlot {
    private String startTime;
    private String endTime;
    private Course course;

    public TimeSlot(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = null;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public String getTimeRange() {
        return startTime + "-" + endTime;
    }
}