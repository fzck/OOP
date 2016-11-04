/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdb2;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
        


/**
 *
 * @author ADMIN
 */
public class Studentdb2 {

    /**
     * @param args the command line arguments
     */
    
    private static final String FILE_NAME = "C:\\temp\\db.ser";
    
    public static void main(String[] args) {
    
    
      FileOutputStream fos = null;
      ObjectOutputStream oos = null;
      FileInputStream fis = null;
      ObjectInputStream ois= null;
      
      List<Student> studentList = new ArrayList<>();   
      
      
       try{
        fis = new FileInputStream(FILE_NAME);
           ois = new ObjectInputStream(fis);
           try{
             if (ois.read() == -1){
               studentList = (List<Student>) ois.readObject();
             }
             ois.close();
           }catch (EOFException | ClassNotFoundException e){
          
           } 
          } catch (IOException e) {
        }  
              
       
       while (true){
        System.out.println("\tMENU");
        System.out.println("1. REGISTER\n2. DELETE\n3. SEARCH\n4. SAVE\n5. EXIT");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        s.nextLine();
      
        switch(choice){           
            case 1:
            boolean flag = true;
             System.out.print("Enter Student Number: ");
             String studnum = s.nextLine();
             for (Student stu : studentList) {
                     if ((stu.getStudentNumber()).equals(studnum)) {
                         System.out.println("EXISTS ALREADY");
                         flag = false;
                     }
                 }
            
             if(flag == false){
                break; 
             }
             System.out.print("First Name: "); String first = s.nextLine();
             System.out.print("Middle Initial: "); String midd = s.nextLine();
             System.out.print("Last Name: "); String last = s.nextLine();
             System.out.print("Course: ");String course = s.nextLine();
             System.out.print("Year level: "); String y = s.nextLine();
             int yr = Integer.parseInt(y);
             System.out.print("Crush name: "); String crush = s.nextLine();
             System.out.print("Favorite course: "); String fav = s.nextLine();
             System.out.print("Course description: "); String description = s.nextLine();
             Student newStud = new Student(studnum, first, midd.charAt(0), last, course, yr, crush, new Course(fav, description));
             studentList.add(newStud);
             break;
                
            case 2:
             System.out.println("Enter Student Number of the Student to be deleted: ");
             String del = s.next();
             for (Student todelete : studentList) {
                 if (todelete.getStudentNumber().equals(del)) {
                     studentList.remove(todelete);
                     
                 }
             }
            break;
            
            case 3:
            boolean check = true;
             System.out.println("Enter Student Number to be searched: ");
             String stsearch = s.next();
               for (Student some : studentList) {
                 if ((some.getStudentNumber()).equals(stsearch)) {
                     System.out.println(String.format("Student Number: %s\nFirst Name: %s\nMiddle Initial: %c\nLast Name: %s\nCourse: %s\nYear Level: %d\nFavorite Course: %s\nCrush Name: %s\n",some.getStudentNumber(),some.getFirstName(),some.getMiddleInitial(),some.getLastName(),some.getCourse(),some.getYearLevel(),some.getFavoriteCourse(),some.getCrushName()));
                     check = false;
                 }
             }
             if(check){
                 System.out.println("STUDENT NOT FOUND");
             }
                break;
            case 4:
            try{
           fos = new FileOutputStream(FILE_NAME);
           oos = new ObjectOutputStream(fos);
           oos.writeObject(studentList);
           oos.close();
           
           
           } catch (IOException e) {
            // standard file handling exception
            e.printStackTrace();
        }  finally {

            // make sure to close the files!
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         
            
             case 5:   
                    System.exit(0);
                    break;
             default:
                 System.out.println();
                 break;
       }
       }
     }
                                    
}
        
