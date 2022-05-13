package model;


public class Student {

    private String name;
    private String id;
    private int age;
    private double average;

    public Student(String name, String id, int age, double average){

        this.name=name;
        this.age=age;
        this.id=id;
        this.average=average;
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

        return ""+average;
    }

    public String toString (){
        return "\nName: "+ name +"\nage: "+ age +"\naverage: "+ average+"\n" ;
    }
}
