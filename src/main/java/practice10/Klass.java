package practice10;

import practice10.Student;

public class Klass {
    private int number;
    private Student leader;
    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public String getDisplayName(){
        return "Class " + this.number;
    }

    public void assignLeader(Student student){
        if(student.getKlass() != this){
            System.out.print("It is not one of us.\n");
            return;
        }
        this.setLeader(student);
    }

    public void appendMember(Student student){
        student.setKlass(this);
    }

    public boolean isIn(Klass klass){
        if(klass.getNumber() == this.getNumber()) return true;
        return false;
    }
}
