package practice07;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce() {
        if (this.klass == null)
            return super.introduce() + " I am a Teacher. I teach No Class.";
        return super.introduce() + String.format(" I am a Teacher. I teach Class %s.",
                this.klass.getNumber());
    }

    public String introduceWith(Student student) {
        if (student.getKlass().getNumber() == this.getKlass().getNumber())
            return super.introduce() + String.format(" I am a Teacher. I teach %s.",
                    student.getName());
        return super.introduce() + String.format(" I am a Teacher. I don't teach %s.",
                student.getName());
    }
}
