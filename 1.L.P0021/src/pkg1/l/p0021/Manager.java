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
            String courseName = Valuecate.checkInputCourse();
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
    public static void updateOrDelete(int count ,ArrayList<Student>studentList){
        if(studentList.isEmpty()){
            System.out.println("List empty");
            return;
        }
        System.out.print("Enter ID");
        String id = Valuecate.checkinputString();
        ArrayList<Student> listStudentFindById = getlistStudentFindById(studentList, id);
        if(listStudentFindById.isEmpty())
        {
            System.out.println("Not found Student");
            return;
        }else{
            Student student = getStudentByListFound(listStudentFindById);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            if(Valuecate.checkInputUD()){
            System.out.print("Enter ID :");
            String iD = Valuecate.checkinputString();
            System.out.print("Enter Name Student :");
            String name = Valuecate.checkinputString();
            System.out.print("Enter Semester :");
            String semester = Valuecate.checkinputString();
            System.out.print("Enter Course name : ");
            String courseName = Valuecate.checkInputCourse();
            if(Valuecate.checkStudentExist(studentList, iD, courseName, semester, courseName)){
                 student.setId(iD);
                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(courseName);
                    System.out.println("Update success.");
                }
                return;
            
            }else{
                studentList.remove(student);
                count--;
                System.out.println("Delete success.");
                return;
            }
        }
        
    }
     public static Student getStudentByListFound(ArrayList<Student> listStudentFindById) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        //display list student found
        for (Student student : listStudentFindById) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter student: ");
        int choice = Valuecate.checkInputLimit(1, listStudentFindById.size());
        return listStudentFindById.get(choice - 1);
    }

    public static ArrayList<Student> getlistStudentFindById(ArrayList<Student>studentList,String id){
        ArrayList<Student> getlistStudentFindById = new ArrayList<>();
      
        for (Student student : studentList) {
            //check student have name contains input
            if (student.getId().contains(id)) {
                getlistStudentFindById.add(student);
            }
         
        }
        return getlistStudentFindById;

    }
    public static void report(ArrayList<Student> studentlist) {
        if (studentlist.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        ArrayList<Report> lr = new ArrayList<>();
        int size = studentlist.size();
        for (int i = 0; i < size; i++) {
            int total = 0;
            for (Student student : studentlist) {
                String id = student.getId();
                String courseName = student.getCourseName();
                String studentName = student.getStudentName();
                for (Student studentCountTotal : studentlist) {
                    if (id.equalsIgnoreCase(studentCountTotal.getId())
                            && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                        total++;
                    }
                }
                if (Valuecate.checkReportExist(lr, studentName,
                        courseName, total)) {
                    lr.add(new Report(student.getStudentName(), studentName, total));
                }
            }
        }
        //print report
        for (int i = 0; i < lr.size(); i++) {
            System.out.printf("%-15s|%-10s|%-5d\n", lr.get(i).getName(),
                    lr.get(i).getCourse(), lr.get(i).getTotalCourse());
        }
    }
}
