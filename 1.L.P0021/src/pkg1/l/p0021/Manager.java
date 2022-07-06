/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.l.p0021;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ADMIN
 */
public class Manager {
    public static void create(int count,ArrayList<Student>studentList){
        if(count>=10){
            System.out.print("Do you want continue (Y/N)");
            if(!Valuecate.checkInputYN()){
                return;
            }
        }
        while(true){
            System.out.print("Enter ID :");
            String id = Valuecate.checkinputString();
            System.out.print("Enter Name Student :");
            String name = Valuecate.checkinputString();
            if(!Valuecate.checkIdExist(studentList, id,name)){
                System.out.println("ID and name exist");
                System.out.print("Enter again:");
                continue;
            }
            System.out.print("Enter Semester :");
            String semester = Valuecate.checkinputString();
            System.out.print("Enter Course name : ");
            String courseName = Valuecate.checkinputString();
            if(Valuecate.checkStudentExist(studentList, id, courseName, semester, courseName)){
                studentList.add(new Student(id, courseName, semester, courseName));
                count++;
                System.out.println("Add student success");
                      
            }
            System.out.println("Duplicate");
        }
    }
    public static void findandSort(ArrayList<Student>studentList){
        if(studentList.isEmpty()){
            System.out.println("List empty");
            return;
        }
        ArrayList<Student> listStudentFindByName = listStudentFindByName(studentList);
        if(listStudentFindByName.isEmpty()){
            System.out.println("Not exist");
        }else{
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            //loop from first to last element of list student
            for (Student student : listStudentFindByName) {
                student.print();
        }
    }
    }
    public static ArrayList<Student> listStudentFindByName(ArrayList<Student>studentList){
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = Valuecate.checkinputString();
        for (Student student : studentList) {
            //check student have name contains input
            if (student.getStudentName().contains(name)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName; 
    }
}
