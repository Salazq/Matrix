package ui;
import model.*;

public class Init {

    public Init() { }

    public Student[][] initStudents(){

        Student[][] students=new Student [10][10];

        NoteSubject[] notes1= new NoteSubject[1];
        notes1[0]= new NoteSubject(1, 2, 3, "APO", 2);

        students=addStudent(students, " Camilo ", "123", 18, notes1);

        NoteSubject[] notes2= new NoteSubject[2];
        notes2[0]= new NoteSubject(1, 2, 3, "APO", 2);
        notes2[1]= new NoteSubject(2, 3, 4, "MATH", 3);

        students=addStudent(students, "Santiago", "456", 2, notes2);

        NoteSubject[] notes3= new NoteSubject[3];
        notes3[0]= new NoteSubject(1, 2, 3, "APO", 2);
        notes3[1]= new NoteSubject(2, 3, 4, "MATH", 3);
        notes3[2]= new NoteSubject(5, 5, 7, "COE", 4);

        students=addStudent(students, " Nelson ", "789", 3, notes3);

    
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

	public Student[][] addStudent(Student[][] students,String name, String id, int age, NoteSubject[] notes) {
		
		Student newStudent= new Student(name, id, age, notes);
		int [] pos=emptypos(students);

		students [pos[0]][pos[1]]= newStudent;

        return students;
	}


}
