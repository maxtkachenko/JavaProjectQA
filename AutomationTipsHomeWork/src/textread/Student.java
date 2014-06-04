package textread;


public class Student implements Comparable<Student>{
    public String sName = "";
    public int iGrade = 0;
    public int iAge = 0;
    
    public int compareTo(Student s){
        return sName.compareToIgnoreCase(s.sName);//"z-a" s.sName.compareToIgnoreCase(sName)
    }
    
}
