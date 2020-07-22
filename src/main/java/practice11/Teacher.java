package practice11;

import practice11.Klass;
import practice11.Student;

import java.util.List;

public class Teacher extends Person implements JoinListener{
    private List<Klass> classes;
    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        this.classes.forEach(klass -> {
            klass.registerListener(this);
        });
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public void setClasses(List<Klass> classes) {
        this.classes = classes;
    }

    public String introduce(){
        if(this.classes == null) return super.introduce() + " I am a Teacher. I teach No Class.";
        StringBuffer allClasses  = new StringBuffer();
        classes.forEach(classesItem ->{
            allClasses.append(classesItem.getNumber() + ", ");
        });
        return super.introduce() + " I am a Teacher. I teach Class " + allClasses.substring(0,allClasses.length()-2) + ".";
    }

    public String introduceWith(Student student){
        if(isTeaching(student)) return super.introduce() + " I am a Teacher. I teach " + student.getName() +".";
        return super.introduce() + " I am a Teacher. I don't teach " + student.getName() +".";
    }

    public boolean isTeaching(Student student){
        boolean flag = false;
        for(Klass classesItem:this.classes){
            if(classesItem.isIn(student.getKlass())){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void update(Student student) {
        System.out.println(String.format("I am %s. I know %s has joined  Class %s.\n",
                this.getName(), student.getName(), student.getKlass().getNumber()));
    }
}
