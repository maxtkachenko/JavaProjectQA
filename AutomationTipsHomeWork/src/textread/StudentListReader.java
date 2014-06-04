package textread;

import java.util.*;
import java.io.*;


public class StudentListReader {
    public StudentListReader(String sFileName) throws Exception{
        ArrayList<Student> students = readFileToArrayList(sFileName);
        if (students != null){
        	printStudentList(students);
        	Collections.sort(students);// sort students
        	System.out.println("*************");
             printStudentList(students);
        }
    }
    public static ArrayList<Student> readFileToArrayList(String fileToRead) throws Exception{
        File file = new File(fileToRead);
        ArrayList<Student> groups = new ArrayList<Student>();
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
        String sNextLine = in.nextLine();
           
          String[] field = sNextLine.split(":");//Line to Line breaks
        
          if (field.length < 3) {
        	  System.out.println("Bad line!");
        	  continue;
          }
          Student student = new Student();
        
        	student.iAge = Integer.parseInt(field[2]);// set its fields (name, grade and age)
        	student.iGrade = Integer.parseInt(field[1]);
        	student.sName = field[0];
        	
        	groups.add(student);// add object to ArrayList
        	
        }

        return groups;
        }
    
    public static void printStudentList(ArrayList<Student> studentsList){

        for (Student s : studentsList){
            
        	System.out.println("Student second name: " + s.sName + "\t" + "Number ofgrade: " + s.iGrade + "\t" + "Student age: " + s.iAge);
        }
    }


    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Parameter with File name is missing.");
            System.exit(1);
        }
        try{
            StudentListReader studentlistreader = new StudentListReader(args[0]);
        }catch(Exception ex){
            System.out.println("Error occurred: " + ex.getMessage());
            System.exit(1);
        }
    }
}
