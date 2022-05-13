package model;

public class NoteSubject {
    
    private double  valueNote1;
    private double valueNote2;
    private double valueNote3;
    private String nameSubject;
    private int creditsSubject;


    public NoteSubject(double valueNote1,  double valueNote2,  double valueNote3, String nameSubject, int creditsSubject){

        this.valueNote1=valueNote1;
        this.valueNote2=valueNote2;
        this.valueNote3=valueNote3;
        this.nameSubject=nameSubject;
        this.creditsSubject=creditsSubject;
    }


    public double getValueNote1(){
        return valueNote1;
    }

    public double getValueNote2(){
        return valueNote2;
    }

    public double getValueNote3(){
        return valueNote3;
    }

    public String getNameSubject(){
        return nameSubject;
    }

    public int getCreditsSubject(){
        return creditsSubject;
    }


}
