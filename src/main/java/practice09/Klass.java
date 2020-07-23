package practice09;

public class Klass {
    private final int number;
    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public String getDisplayName() {
        return "Class " + this.number;
    }

    public void assignLeader(Student student) {
        if (student.getKlass() != this) {
            System.out.print("It is not one of us.\n");
            return;
        }
        this.setLeader(student);
    }

    public void appendMember(Student student) {
        student.setKlass(this);
    }
}
