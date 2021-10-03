package teachers;

public class Teacher {
    private String name;
    private int salary;

    public Teacher(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public int getSalary() {
        return this.salary;
    }
}
