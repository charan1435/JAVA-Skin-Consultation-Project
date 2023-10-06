import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;


public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    static Scanner input = new Scanner(System.in);
    //Array List to store data
    static ArrayList<Doctor> DoctorList = new ArrayList<>();

    //Methods to array list
    public static void addToDoctorList(Doctor object) {
        DoctorList.add(object);
    }


    //Static Variable to count number of doctors and limit to 10

    static int count = 0;
    static String Doctor_Name;
    static String Doctor_Surname;
    static String Doctor_Dob;
    static int Doctor_Mobile_Number;
    static String Specialize;
    static int Doc_License_Number;

    public static void main(String[] args) throws IOException {

        // Read back the saved objects in the File
        try {
            FileInputStream fi = new FileInputStream(new File("DoctorsFile.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read back saved contents
            while (true) {
                Doctor savedDoctor = (Doctor) oi.readObject();
                DoctorList.add(savedDoctor);
                count++;
            }
        //Exception Handling
        } catch (FileNotFoundException f) {
            System.out.println("File not found");
        } catch (IOException f) {
            System.out.println("There is no previously saved objects.\nUse the consloe menu.");
        } catch (ClassNotFoundException f) {
            // TODO Auto-generated catch block
            f.printStackTrace();
        }

        // Delete the objects saved in the file
        new FileOutputStream("DoctorsFile.txt").close();





        //Array List to store data

        ArrayList<Patient> Patient = new ArrayList<>();
        ArrayList<Consultation> Consultation = new ArrayList<>();





        //Console
        String option;


        boolean exit = false;
        do {
            //Console Options
            System.out.println("-----------Welcome to Westminster Skin Care Consultation------------");
            System.out.println("""
                              
                    \n
                    A : Add new doctor
                    D : Delete a doctor
                    P : Print the list of doctors
                    S : Save in a file
                    G : GUI (For user)
                    X : Exit
                    """);
            option = input.nextLine().toUpperCase();
            switch (option) {
                case "A" -> Add_Doctor();
                case "D" -> Delete_Doctor();
                case "P" -> Print_Doctors();
                case "S" -> Save_File();
                case "G" -> Gui_Console();
                case "X" -> {
                    System.out.println("================ Thank you For Using Westminster Skin Consultation ! ==============");
                    exit = true;
                }
                default -> System.out.println("------INVALID INPUT// Please Try Again--------");


            }
        } while (!exit);


    }

    //private methods for the console options
    private static void Add_Doctor() {

        Scanner input = new Scanner(System.in);

        if (count > 9) {
            System.out.println("-------Doctors Limit has reached---------");
            System.out.println("------Cannot add anymore Doctors-----");
        } else {
            //ASK USER FOR DOCTORS NAME
            System.out.println("Enter the doctors Firstname");
            Doctor_Name = input.next();
            if (!Doctor_Name.matches("[a-zA-Z]+")) {
                System.out.println("Doctors Name should not contain numbers or special characters.");
                do {
                    // Request for name until proper name given
                    System.out.println("Enter First Name: ");
                    Doctor_Name = input.next();
                } while (!(Doctor_Name.matches("[a-zA-Z]+")));
            }
            System.out.println("Doctors Firstname is = " + Doctor_Name + " successfully added");
            System.out.println("");

            //Request for Doctors Surname
            System.out.println("Enter the doctors Surname");
            Doctor_Surname = input.next();
            if (!Doctor_Surname.matches("[a-zA-Z]+")) {
                System.out.println("Doctors Name should not contain numbers or special characters.");
                do {
                    // Request for name until proper name given
                    System.out.println("Enter Surname: ");
                    Doctor_Surname = input.next();
                } while (!(Doctor_Surname.matches("[a-zA-Z]+")));
            }
            System.out.println("Doctors Surname is = " + Doctor_Surname + " successfully added");
            System.out.println("");

            // Request for Date Of Birth
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            Date date;
            while (true) {
                try {
                    System.out.println("Enter date of birth(yyyy/mm/dd): ");
                    Doctor_Dob = input.next();
                    date = df.parse(Doctor_Dob);
                    break;
                } catch (ParseException e) {
                    System.out.println("Wrong Date format.Try Again");
                }
            }
            System.out.println("Date of Birth " + Doctor_Dob + " sucessfully loaded");
            System.out.println("");

            //REQUEST FOR MOBILE NUMBER
            while (true) {
                try {
                    System.out.println("Enter mobile number: ");
                    Doctor_Mobile_Number = Integer.parseInt(input.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong Number input Format.Try Again");
                }
            }
            System.out.println("successfully Mobile Number=" + Doctor_Mobile_Number + " Loaded");
            System.out.println("");

            //REQUEST FOR LICENSE NUMBER

            while (true) {
                try {
                    System.out.println("Enter medical licence number: ");
                    Doc_License_Number = Integer.parseInt(input.next());
                    for (Doctor value : DoctorList) {
                        if (value.getMedial_license_no() == Doc_License_Number) {
                            System.out.println("This medical licence number has already taken.");


                        } else {
                            break;
                        }
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong License number input type");
                }

            }
            System.out.println("successfully loaded medical license: " + Doc_License_Number);
            System.out.println("");

            // Request for specialization
            System.out.println("Enter specialization: ");
            Specialize = input.next();
            System.out.println("successfully loaded specialization: " + Specialize);

            //Create object of doctor class
            Doctor doctor = new Doctor(Doc_License_Number, Specialize, Doctor_Name, Doctor_Surname, Doctor_Dob, Doctor_Mobile_Number);

            // Add created Doctor objects to DoctorCentre array list
            addToDoctorList(doctor);
            count = count + 1;

        }


    }
        //delete the designated doctor object
    private static void Delete_Doctor() {
        while (true) {
            try {
                System.out.println("Enter medical licence number: "); // Request for licence number
                Doc_License_Number = Integer.parseInt(input.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input type");
            }
        }

        count--; // Decrease total number of Doctor objects in the Doctor class by one
        //traverse through to locate and delete
        for (Doctor value : DoctorList) {
            if (value.getMedial_license_no() == Doc_License_Number) {
                System.out.println(value);
                System.out.println("Total number of doctors in the centre = " + count);
                DoctorList.remove(value);
                break;
            }

        }

    }

    private static void Save_File() {
        // Save objects to File (File Handling)
        try {
            // Using byte stream to saved objects in File
            FileOutputStream fh = new FileOutputStream(new File("DoctorsFile.txt"), true);
            ObjectOutputStream os = new ObjectOutputStream(fh);

            // Save objects to file
            for (Doctor value : DoctorList) {
                os.writeObject(value);
            }

            os.close(); // Closing ObjectOutputStream
            fh.close(); // Closing FileOutputStream

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Exception ");
        }



    }

    private static void Print_Doctors() {
        //Sorting using comparator
        Collections.sort(DoctorList, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        System.out.println("After Sorting");
        for (Doctor value:DoctorList){
            System.out.println("Surname :"+value.getSurname()+" First Name: "+ value.getName()+ " Medical License: "+value.getMedial_license_no()+" Specialization: "+value.getSpecialization()+" Dob: "+value.getDate_of_birth()+" Mobile: "+value.getMobile_number());


        }


    }


        private static void Gui_Console () {
        }


    }



