public class Patient extends Person{

    private  int unique_id;

    public Patient(){

    }

    public Patient(int unique_id,String name,String surname,String date_of_birth,int mobile_number){
        super(name,surname,date_of_birth,mobile_number);
        this.unique_id=unique_id;

    }

    public int getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(int unique_id) {
        this.unique_id = unique_id;
    }
}
