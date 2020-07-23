package practice11;

import practice11.Student;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<JoinListener> joinListeners;
    public Klass(int number) {
        this.number = number;
        joinListeners = new ArrayList<>();
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
        for(JoinListener listener:this.joinListeners){
            listener.updateLeader(student);
        }
    }

    public void appendMember(Student student){
        student.setKlass(this);
        for(JoinListener listener:this.joinListeners){
            listener.update(student);
        }
//        this.joinListeners.forEach(listener -> {
//            listener.update(student);
//        });
    }

    public boolean isIn(Klass klass){
        if(klass.getNumber() == this.getNumber()) return true;
        return false;
    }

    public void registerListener(JoinListener joinListener) {
        this.joinListeners.add(joinListener);
    }
}
