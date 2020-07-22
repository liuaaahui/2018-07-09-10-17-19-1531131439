package practice10;

import practice10.Klass;

public class Student extends Person{
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce(){
        if(this == klass.getLeader()) return super.introduce() + " I am a Student. I am Leader of Class " + this.klass.getNumber() + ".";
        return super.introduce() + " I am a Student. I am at Class " + this.klass.getNumber() + ".";
    }
}
