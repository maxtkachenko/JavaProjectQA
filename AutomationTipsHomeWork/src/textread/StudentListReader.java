package textread;

import java.util.*;
import java.io.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2014</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class StudentListReader {
    public StudentListReader(String sFileName) throws Exception{
        ArrayList<Student> students = readFileToArrayList(sFileName);
        if (students != null){
        	
        	// sort students by Name//Collections.sort();????
             printStudentList(students);
        }
    }
    public static ArrayList<Student> readFileToArrayList(String fileToRead) throws FileNotFoundException{
        File file = new File(fileToRead);
        ArrayList<Student> names = new ArrayList<Student>();
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
           // read next line to String variable sNextLine
           // parse sNextLine by ":" to 3 parts
           // create new object Student
           // set its fileds (name, grade and age)
           // add object to ArrayList
        }
        in.close();
        return names;
    }
    public static void printStudentList(ArrayList<Student> studentsList){

        for (Student s : studentsList){
            
        	System.out.println("Student second name: " + s.sName + "\n" + "Number ofgrade: " + s.iGrade + "\n" + "Student age: " + s.iAge);
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
