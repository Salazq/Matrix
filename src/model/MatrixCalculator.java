package model;

import java.util.ArrayList;
import java.lang.Math;

public class MatrixCalculator {
	
	private ArrayList<int[][]> numericMatrices;
	private ArrayList<char[][]> stringMatrices;
	private Student[][] students;
	private final static int MAX_STUDENTS=10;
	
	public MatrixCalculator( Student[][] students) {

		numericMatrices= new ArrayList<int[][]>();
		stringMatrices= new ArrayList<char[][]>();
		this.students= students;
	}
	
	public String showMatrices() {
		String out="";
		out += "\nNumeric matrices \n";
		for(int i=0; i< numericMatrices.size(); i++) {
			out+= "\n" + printNumeric(numericMatrices.get(i));
		}
		out += "\nString matrices \n";
		for(int i=0; i< stringMatrices.size(); i++) {
			out+= "\n" + printString(stringMatrices.get(i));
		}
		
		return out;
	}

	private String printString(char[][] matrix) {
		String print ="";
		for (int i=0; i< matrix.length; i++ ) { // filas numbers.length
			for (int j = 0; j < matrix[0].length; j++) { //columnas numbers[0].length
				print += matrix[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}

	private String printString2(String[][] matrix) {
		String print ="";
		for (int i=0; i< matrix.length; i++ ) { // filas numbers.length
			for (int j = 0; j < matrix[0].length; j++) { //columnas numbers[0].length
				print += matrix[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}


	private String printNumeric(int[][] numbers) {
		String print ="";
		for (int i=0; i< numbers.length; i++ ) { // filas numbers.length
			for (int j = 0; j < numbers[0].length; j++) { //columnas numbers[0].length
				print += numbers[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}
	
	

	public String createMatrix(int type, int rows, int columns) {
		String out="";
		switch(type) {
		case 1: //numeric Matrix
			int [][] newMatrix;
			newMatrix= new int[rows][columns];

			for (int i=0; i<rows; i++){

				for (int e=0; e<columns; e++){

					newMatrix[i][e] = (int)(Math.random()*(100)+1);
				}
			}
			numericMatrices.add(newMatrix);
			out = printNumeric(newMatrix);
			
			break;
		case 2:
			char [][] newMatrixx;
			newMatrixx= new char[rows][columns];

			for (int i=0; i<rows; i++){

				for (int e=0; e<columns; e++){

					newMatrixx[i][e] = (char)(int)(Math.random() *(90 - 65) + 65);
				}
			}
			stringMatrices.add(newMatrixx);
			out = printString(newMatrixx);
			
			break;
		}
		return out;
	}


	public int []emptypos(){

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

	public int[] addStudent(String name, String id, int age, int numSubjects) {
		
		NoteSubject[] notes= new NoteSubject[numSubjects];
		Student newStudent= new Student(name, id, age, notes);
		int [] pos=emptypos();
		students [pos[0]][pos[1]]= newStudent;

		return pos;
	}

	public void addSubjecttoStudent(String nameSubject, int creditsSubject, double valueNote1, double valueNote2, double valueNote3, 
		int subPos, int [] studentPos) {
		
		NoteSubject newSubject= new NoteSubject(valueNote1, valueNote2, valueNote3, nameSubject, creditsSubject);
		students [studentPos[0]][studentPos[1]].addSubject(newSubject,subPos);
	}

	public ArrayList <Student> createList(){

		ArrayList<Student>studentsList= new ArrayList<Student>();

		boolean empty=false;

		for (int i=0; i<MAX_STUDENTS &&empty==false; i++){

			for (int e=0; e<MAX_STUDENTS &&empty==false; e++){

				if (students[i][e]==null){

					empty=true;
				} 
				else {

					studentsList.add(students[i][e]);
				}
			}
		}
		return studentsList;
	}


	public String createTable(){

		String [][]newStudentList;
		String out="";

		newStudentList= new String[(createList().size())][5];

		for (int i=0; i<createList().size(); i++){

			Student currentStudent= createList().get(i);

			newStudentList[i][0] = "  Student " + (i+1);
			newStudentList[i][1] = "   "+currentStudent.getName()+"   ";
			newStudentList[i][2] = "    "+currentStudent.getAge()+"   ";
			newStudentList[i][3] = "    "+currentStudent.getAverage()+"   ";
			newStudentList[i][4] = "   "+currentStudent.getId()+"   ";
					
		}

		if (createList().size()!=0){

			out = "\n|          |     Name     |   Age   |  Agerage  |  ID  |\n"+ printString2(newStudentList);
		}
		return out;
	}

	public String showNames(){

		String out="";

		for (int i=0; i<createList().size(); i++){

			out+="\n"+ createList().get(i).getName()+"\n";
		}
		return out;
	}

	public int searchPos(String id){
		int pos=-1;
		for (int i=0; i<createList().size(); i++){

			if (createList().get(i).getId(). equals(id) )
			pos=i;
		}
		return pos;
	}

	public String showInfo(String id){

		String out="";
		int pos= searchPos(id);

		if (pos==-1){

			out="\nThis student is not registered\n";
		}
		else{
			out=createList().get(pos).toString();
		}
		return out;
	}
	
	public void addNumeric (int[][] numMatrix) {
		numericMatrices.add(numMatrix);
	}

	public void addString (char[][] strMatrix) {
		stringMatrices.add(strMatrix);
	}
	

}
