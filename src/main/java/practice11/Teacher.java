package practice11;


import java.util.List;

public class Teacher extends Person implements JoinListener {
    private List<Klass> classes;

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
//        for( Klass klass:this.classes){
//            klass.registerListener(this);
//        }
        this.classes.forEach(klass -> klass.registerListener(this));
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

    @Override
    public void update(Student student) {
//        System.out.print("I am " + this.getName() + ". I know " + student.getName() + " has joined Class " + student.getKlass().getNumber() + ".\n");
        System.out.print(String.format("I am %s. I know %s has joined Class %s.\n",
                this.getName(), student.getName(), student.getKlass().getNumber()));
    }

    @Override
    public void updateLeader(Student student) {
        System.out.print(String.format("I am %s. I know %s become Leader of Class %s.\n",
                this.getName(), student.getName(), student.getKlass().getNumber()));
    }
}
