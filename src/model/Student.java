package model;


public class Student {

    private String name;
    private String id;
    private int age;
    private double average;
    private NoteSubject [] notes;

    public Student(String name, String id, int age, NoteSubject[] notes){

        this.name=name;
        this.age=age;
        this.id=id;
        this.notes= notes;
    }

    public String getName(){

        return name;
    }

    public String getId(){

        return id;
    }

    public String getAge(){

        return ""+age;
    }

    public String getAverage(){

        return ""+ calculateAverage();
    }

    public void addSubject(NoteSubject subject, int pos){

        notes [pos]=subject;
    }

    public String  showSubjects(){

        String [][]notesTable;
        String out="";

		notesTable= new String[4][1+notes.length];

        notesTable[0][0]="      ";
        notesTable[1][0]="Exam 1";
        notesTable[2][0]="Exam 2";
        notesTable[3][0]="Exam 3";

		for (int i=1; i<=(notes.length); i++){

			notesTable[0][i] = notes[i-1].getNameSubject();
            notesTable[1][i] = ""+notes[i-1].getValueNote1();
            notesTable[2][i] = ""+notes[i-1].getValueNote2();
            notesTable[3][i] = ""+notes[i-1].getValueNote3();
		}

		if (notes.length!=0){

			out = printString(notesTable);
		}
        return out;
    }

    private String printString(String[][] matrix) {
		String print ="";
		for (int i=0; i< matrix.length; i++ ) { // filas numbers.length
			for (int j = 0; j < matrix[0].length; j++) { //columnas numbers[0].length
				print += matrix[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}

    public double calculateAverage(){

        double noteAverage=0;
        int credits=0;

        for (int i=0; i<notes.length; i++){

            noteAverage+=(notes[i].getValueNote1()+ notes[i].getValueNote2()+ notes[i].getValueNote3())* notes[i].getCreditsSubject();
            credits+= notes[i].getCreditsSubject();
        }
        double total=(double)Math.round((noteAverage/credits)*100)/100;

        return total;
    }

    public String toString (){
        return "\nName: "+ name +"\nage: "+ age +"\naverage: "+ calculateAverage()+"\n"+"\n\n"+ showSubjects();
    }
}
