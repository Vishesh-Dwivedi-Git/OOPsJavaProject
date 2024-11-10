public class Course {
    private String courseCode;
    private String name;
    private String branch;
    private String section;
    private String type;
    private String faculty;
    private int credits;
    private String lectureRoom;

    public Course(String courseCode, String name, String branch, String section, 
                 String type, String faculty, int credits, String lectureRoom) {
        this.courseCode = courseCode;
        this.name = name;
        this.branch = branch;
        this.section = section;
        this.type = type;
        this.faculty = faculty;
        this.credits = credits;
        this.lectureRoom = lectureRoom;
    }

    // Getters
    public String getCourseCode() { return courseCode; }
    public String getName() { return name; }
    public String getBranch() { return branch; }
    public String getSection() { return section; }
    public String getType() { return type; }
    public String getFaculty() { return faculty; }
    public int getCredits() { return credits; }
    public String getLectureRoom() { return lectureRoom; }
}