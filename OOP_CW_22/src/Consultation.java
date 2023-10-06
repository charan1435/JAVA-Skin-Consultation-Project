import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.text.DateFormat;

public class Consultation extends Patient {
    private int cost;
    private String notes;
    private String date_and_time;






    public Consultation(int cost,String notes,String date_and_time,int unique_id,String name,String surname,String date_of_birth,int mobile_number){
        super(unique_id,name,surname,date_of_birth,mobile_number);
        this.cost=cost;
        this.notes=notes;
        this.date_and_time=date_and_time;

    }



    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate_and_time() {
        return date_and_time;
    }

    public void setDate_and_time(String Date_and_time){
        this.date_and_time=date_and_time;


    }
}
