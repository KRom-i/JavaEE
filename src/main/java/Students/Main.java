package Students;

import java.util.List;

public class Main {

    public static void main (String[] args) {

        List<Student> students = DataStudent.getStudents ("student.txt");

        if (students != null) {
            DataStudent.update (students);
            Sqlite.connectionClose ();

        } else {
            System.out.println ("Нет данных на обновление...");
        }


    }
}
