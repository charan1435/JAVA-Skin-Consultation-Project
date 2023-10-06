import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private String surname;
    private String date_of_birth;
    private int mobile_number;

    public Person(){

    }


    public Person (String name,String surname,String date_of_birth,int mobile_number){
        this.name=name;
        this.surname=surname;
        this.date_of_birth=date_of_birth;
        this.mobile_number=mobile_number;
    }

    public void setName(String n){
        name= n;
    }

    public void  setSurname(String s){
        surname=s;
    }

    public void  setDate_of_birth(String dob){
        date_of_birth=dob;
    }

    public void setMobile_number(int mn){
        mobile_number=mn;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return  surname;
    }

    public String getDate_of_birth(){
        return date_of_birth;
    }
    public long getMobile_number(){
        return mobile_number;
    }




    }
