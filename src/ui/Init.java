package ui;
import model.*;

public class Init {

    public Init() { }

    public Student[][] initStudents(){

        Student[][] students=new Student [10][10];

        students=addStudent(students, " Camilo ", "123", 18, 1);

        students=addStudent(students, "Santiago", "456", 18, 2);

        students=addStudent(students, " Nelson ", "789", 16, 3);

    
        return students;
    }

    public int []emptypos(Student[][] students){

		int [] pos= new int[2];

		boolean found=false;

		for (int i=0; i<10 && found==false; i++){

			for (int e=0; e<10&& found==false; e++){

				if (students[i][e]==null){

					found=true;
					pos[0]=i;
					pos[1]=e;
				}
			}
		}
		return pos;
	}

	public Student[][] addStudent(Student[][] students,String name, String id, int age, double average) {
		
		Student newStudent= new Student(name, id, age, average);
		int [] pos=emptypos(students);

		students [pos[0]][pos[1]]= newStudent;

        return students;
	}


}
