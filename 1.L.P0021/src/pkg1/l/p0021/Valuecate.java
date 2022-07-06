
package pkg1.l.p0021;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Valuecate {
   private final static Scanner sc = new Scanner(System.in);
   private final static String name_regex = "[a-zA-Z]+";
   private final static String phone_regex = "[0-9]{10,12}+";
   private final static String email_regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
   
 public static int checkInputLimit(int min, int max){
       while(true){
           try{
               int result = Integer.parseInt(sc.nextLine().trim()); 
               if(result<min||result>max){
                   throw new NumberFormatException();
               }
               return result; 
           }catch(NumberFormatException e){
               System.out.println("Please enter number in range["+min+","+max+"]");
               System.out.print("Enter again : ");
               
           }
       }
   }
   public static String checkinputString(){
       while(true){
           
           String result = sc.nextLine().trim();
           if(result.isEmpty()){
               System.out.println("Not empty");
               System.out.print("Enter again :");
           }else{
               return  result;
               
           }
       }
   }
   public static String checkphone(){
       while(true){
           String phone = checkinputString();
           if(phone.matches(phone_regex)){
               return phone; 
           }else{
               System.out.println("Phone is number with minium 10 characters");
               System.out.print("Enter again :");
           }
           
       }
   } 
   public static String checkEmail(){
   while(true){
      String email = checkinputString();
           if(email.matches(email_regex)){
               return email; 
           }else{
               System.out.println("Email must be in the form abc@fpt.edu.vn ");
               System.out.print("Enter again :");
           } 
   }
   }
   public static String checkInputGraduationRank() {
        while (true) {
            String result = checkinputString();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }
   public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkinputString();
            //check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    public static boolean checkIdExist(ArrayList<Student> studentList, String id,
            String studentName) {
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)&& !studentName.equalsIgnoreCase(student.getStudentName())) {
               
                return false;
            }
        }
        return true;
    }
    public static boolean checkStudentExist(ArrayList<Student> studentList,String id,String studentName,String semester,String course ){
       for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    &&student.getSemester().equalsIgnoreCase(semester)
                    &&student.getCourseName().equalsIgnoreCase(course)) {
               
                return false;
            }
        }
        return true; 
    }
/*
    //check experience must be smaller then age
    public static int checkInputExprience(int birthDate) {
        LocalDate localDate = LocalDate.now();
        int yearCurrent = localDate.getYear();
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputLimit(1, 100);
            if (yearExperience > age) {
                System.out.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }

    }*/
}
