package arr;

public class StudentGrades {
    public static void main(String[] args) {

        
        String[] names = {"Asha", "Ravi", "Kiran", "Meena", "Arjun"};

     
        int[] marks = {85, 72, 91, 64, 78};

        System.out.println("Name\tMarks\tGrade");

        for (int i = 0; i < names.length; i++) {

            char grade;

            if (marks[i] >= 90)
                grade = 'A';
            else if (marks[i] >= 75)
                grade = 'B';
            else if (marks[i] >= 60)
                grade = 'C';
            else if (marks[i] >= 50)
                grade = 'D';
            else
                grade = 'F';

            System.out.println(names[i] + "\t" + marks[i] + "\t" + grade);
        }
    }
}
