package Students;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataStudent {

    public static List<Student> getStudents(String path)  {
        File file = new File (path);
        if (!file.exists ()) return null;
        return readFile(file);
    }

    private static List<Student> readFile (File file) {

        List<Student> students = null;

        try(FileReader reader = new FileReader (file);
            BufferedReader buffered = new BufferedReader (reader)) {

            while (buffered.ready ()){

                String[] fields = buffered.readLine ().split (" ");

                if (fields.length > 1){

                    Student student = new Student ();
                    student.setId (Integer.parseInt (fields[0]));
                    student.setScore (Integer.parseInt (fields[1]));

                    if (students == null) students = new ArrayList<> ();

                    students.add (student);
                }

            }

        } catch (Exception e){
            e.printStackTrace ();
        }

        return students;
    }


    public static void update(List<Student> students){
        for (Student student: students) {
            update (student);
        }
    }

    private static void update(Student student){

        try (PreparedStatement statement = Sqlite.getConnection ().prepareStatement(
                "UPDATE scores SET score = ? WHERE id_student = ?;"))
        {
            statement.setInt (1, student.getScore ());
            statement.setInt(2, student.getId ());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
