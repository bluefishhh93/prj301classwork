/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author xuant
 */
public class StudentDao extends DBcontext {
    // Retrieve all records from the Categories table

    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM StudentTBL";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                boolean gender = rs.getBoolean("Gender");
                Date DOB = rs.getDate("DOB");
                Student newStudent = new Student(id, name, gender, DOB);
                list.add(newStudent);
            }
        } catch (Exception e) {
            e.printStackTrace(); // print the exception stack trace for debugging
        }
        return list;
    }

    //Insert value into database
    public void insert(Student c) {
        String sql = "INSERT INTO [dbo].[StudentTBL] " +
                "([name], [Gender], [DOB]) " +
                "VALUES (?, ?, ?)";

        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, c.getName());
            st.setBoolean(2, c.getGender());
            st.setDate(3, c.getDateOB());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //get a category by id
    public Student getStudentById(int id) {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM StudentTBL where id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student c = new Student(rs.getInt("id"), rs.getString("name"), rs.getBoolean("gender"), rs.getDate("DOB"));
                return c;
            }

        } catch (SQLException e) {
            System.out.println(e); // print the exception stack trace for debugging
        }
        return null;
    }

    public List<Student> getListByPage(ArrayList<Student> list, int start, int end) {
        ArrayList<Student> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    //Delete category by id
    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[StudentTBL]\n"
                + "      WHERE id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Student c) {
        String sql = "UPDATE [dbo].[StudentTBL]\n"
                + "   SET [name] = ?\n"
                + "      ,[gender] = ?\n"
                + "      ,[DOB] = ?\n"
                + " WHERE ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getName());
            st.setBoolean(2, c.getGender());
            st.setDate(3, c.getDateOB());
            st.setInt(4, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        StudentDao c = new StudentDao();
//        List<Student> list = c.getAll();
//        System.out.println(c.getStudentById(4));
        Date date;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
             date = new Date(sd.parse("2016-02-02").getTime());
        } catch (ParseException ex) {
            throw new RuntimeException("Invalid DOB");
        }
//        c.insert(new Student("newstudent", true, date));

        c.update(new Student(10, "haha", true, date));
    }
}
