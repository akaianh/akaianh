/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.l.p0021;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class LP0021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList();
        int count=10;
        while(true){
            System.out.println("WELCOME TO STUDENT MANAGEMENT\n" +
                        "1.	Create\n" +
                        "2.	Find and Sort\n" +
                        "3.	Update/Delete\n" +
                        "4.	Report\n" +
                        "5.	Exit");
             int choose = Valuecate.checkInputLimit(1, 5);
             switch(choose){
                 case 1:
                     Manager.create(count, studentList);
                     break;
                 case 2:
                     Manager.findandSort(studentList);
                     break;
                 case 3:
                     Manager.updateOrDelete(count, studentList);
                     break;
                 case 4:
                     Manager.report(studentList);
                     break;
                 case 5:
                     return;
             }
        }
       
        
    }
    
}
