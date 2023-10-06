import java.io.Serializable;

public class Doctor extends Person implements Serializable {
    private int medial_license_no;
    private String specialization;

    public Doctor(){

    }
    public Doctor(int medial_license_no,String specialization,String name,String surname,String date_of_birth,int mobile_number){
        super(name,surname,date_of_birth,mobile_number);
        this.medial_license_no=medial_license_no;
        this.specialization=specialization;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name= " + getName() +
                ", surname= " + getSurname() +
                ", date of birth= " + getDate_of_birth() +
                ", mobile num="+ getMobile_number() +
                ", medical licence num="+ getMedial_license_no()+
        ", specilization=" + getSpecialization() +
                '}';
    }
    public void setMedial_license_no(int medial_license_no) {
        this.medial_license_no = medial_license_no;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getMedial_license_no() {
        return medial_license_no;
    }

    public String getSpecialization() {
        return specialization;
    }
}
