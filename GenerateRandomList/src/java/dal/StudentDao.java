/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author xuant
 */
public class StudentDao {
    public static ArrayList<Student> list;
    public StudentDao() {
    }
    
    public List<Student> getListByPage(ArrayList<Student> list, int start, int end){
        ArrayList<Student> arr = new ArrayList<>();
        for(int i = start; i<end; i++){
            arr.add(list.get(i));
        }
        return arr;
}
}
