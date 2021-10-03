import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private int mathGrade;
    private int economicGrade;
    private int englishGrade;
    private int computerScienceGrade;

    public Student(String name, int mathGrade, int economicGrade, int englishGrade, int computerScienceGrade) {
        this.name = name;
        this.mathGrade = mathGrade;
        this.economicGrade = economicGrade;
        this.englishGrade = englishGrade;
        this.computerScienceGrade = computerScienceGrade;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public int getEconomicGrade() {
        return economicGrade;
    }

    public int getEnglishGrade() {
        return englishGrade;
    }

    public int getComputerScienceGrade() {
        return computerScienceGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                ", economicGrade=" + economicGrade +
                ", englishGrade=" + englishGrade +
                ", computerScienceGrade=" + computerScienceGrade +
                '}';
    }
}
