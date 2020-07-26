package practice10;


import java.util.List;

public class Teacher extends Person {
    private List<Klass> classes;

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public String introduce() {
        if (this.classes == null) return super.introduce() + " I am a Teacher. I teach No Class.";
        StringBuffer allClasses;
        allClasses = new StringBuffer();
        classes.forEach(classesItem -> allClasses.append(classesItem.getNumber()).append(", "));
        return super.introduce() + String.format(" I am a Teacher. I teach Class %s.",
                allClasses.substring(0, allClasses.length() - 2));
    }

    public String introduceWith(Student student) {
        if (isTeaching(student))
            return super.introduce() + String.format(" I am a Teacher. I teach %s.",
                    student.getName());
        return super.introduce() + String.format(" I am a Teacher. I don't teach %s.",
                student.getName());
    }

    public boolean isTeaching(Student student) {
        boolean flag = false;
        for (Klass classesItem : this.classes) {
            if (classesItem.isIn(student.getKlass())) {
                flag = true;
            }
        }
        return flag;
    }
}
