public class Teacher {
    private String name;
    private int salary;

    public Teacher(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Teacher() {
    }

    public String getName() {
        return this.name;
    }

    public int getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
