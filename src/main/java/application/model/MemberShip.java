package application.model;

public class MemberShip {

    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String leader;
    private String discipleship;
    private Courses courses;

    public MemberShip() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getDiscipleship() {
        return discipleship;
    }

    public void setDiscipleship(String discipleship) {
        this.discipleship = discipleship;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
