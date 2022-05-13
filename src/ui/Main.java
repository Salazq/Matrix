package ui;

import java.util.Scanner;

import model.MatrixCalculator;

public class Main {
	
	private Scanner sc;
	private MatrixCalculator calculator;
	
	public Main(){
		sc= new Scanner(System.in);
		Init init=new Init();
		calculator = new MatrixCalculator(init.initStudents());
	}

	public static void main(String[] args) {
		
		System.out.println("\nWelcome to the matrix calculator");
		Main ppal= new Main();
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
		
	}
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Main menu, please pick an option\n" +
				"(1) Create a matrix \n" +
				"(2) Show the contents of all matrices \n"+
				"(3) Numeric matrices\n"+
				"(4) String matrices\n" +  
				"(5) Create a student\n" + 
				"(6) Show students' name\n" +
				"(7) Search student\n" +
				"(8) Show students's information\n" +
				"(0) To leave the application"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			createMatrix();
			break;
		case 2:
			System.out.println(calculator.showMatrices());
			break;
	
		case 3:
			createNumericMatrix();
			break;

		case 4:
			createStringMatrix();
			break;

		case 5:

			createStudent();
			
			break;

		case 6:

			System.out.println(calculator.showNames());
			
			break;

		case 7:

			showStudentInfo();
			
			break;

		case 8:

			System.out.println(calculator.createTable());
			
			break;
	
		
		default:
			System.out.println("Error, wrong option");
		
		}
	

	}

	private void createMatrix() {
		System.out.println("Please select the type of matrix \n (1) Numeric matrix\n (2) String's matrix");
		int type= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Please digit the number of rows");
		int rows= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Please digit the number of columns");
		int columns= sc.nextInt();
		sc.nextLine();
		
		System.out.println("new matrix");
		System.out.println(calculator.createMatrix(type, rows, columns));
	}
	
	public void createNumericMatrix() {
		
		int row, col, num;
		
		System.out.println("Digite el num de filas");
		row= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digite el num de columnas");
		col= sc.nextInt();
		sc.nextLine();
		
		int [][] tmp= new int[row][col];

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.println( "What is the number you want to register in the " + i + 
					" " + j + " pos");
				num= sc.nextInt();
				sc.nextLine();
				tmp[i][j]=num;
			}
		}
		calculator.addNumeric(tmp);
		
		
	}

	public void createStringMatrix() {
		
		int row, col;
		int num;
		
		System.out.println("Digite el num de filas");
		row= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digite el num de columnas");
		col= sc.nextInt();
		sc.nextLine();
		
		char [][] tmp= new char[row][col];

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.println( "What is the letter you want to register in the " + i + 
					" " + j + " pos");
				num= sc.nextInt();
				sc.nextLine();
				tmp[i][j]=(char)num;
			}
		}
		calculator.addString(tmp);
	}

	public void createStudent(){

		String name;
		String id;
		int age;
		double average;

		System.out.println("Type the name");
		name=sc.next();

		System.out.println("Type the id");
		id=sc.next();

		System.out.println("Type the age");
		age=sc.nextInt();

		System.out.println("Type the average");
		average=sc.nextDouble();

		calculator.addStudent(name, id, age, average);
	}

	public void showStudentInfo(){

		String id;

		System.out.println("Type the id");
		id=sc.next();

		System.out.println(calculator.showInfo(id));
	}

}
