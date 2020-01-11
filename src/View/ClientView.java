/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author riku
 */
import java.util.*;
import Control.PatientController;
import Model.Appointments;
import Model.Schedules;
import Repository.AppointmentRepository;
import Repository.ScheduleRepository;
import java.sql.SQLException;
import java.util.*;
public class ClientView {
    AppointmentRepository appointmentRepository=new AppointmentRepository();

    public void viewSchedule()throws SQLException{
        ScheduleRepository scheduleRepository=new ScheduleRepository();
        List<Schedules> schedules=scheduleRepository.getSchedules();
        System.out.println("Schedule_ID  :  Shift");
        for(Schedules schedule: schedules){
            System.out.println("\t"+schedule.getSchedule_id()+"\t"+schedule.getShift());
        }
    }
  
    public void viewAppointment() throws Exception{
//        AppointmentRepository appointmentRepository=new AppointmentRepository();
        List<Appointments> appointments=appointmentRepository.getAppointment();
        System.out.println("Appointment_id  :  Doctor");
        for(Appointments appointment: appointments){
            System.out.println("\t"+appointment.getAppointment_id()+/*"\t"+appointment.getDate()+*/"\t"+appointment.getDoctor_id());
        }
    }
    
    public void requestAppointment() throws Exception{
        Scanner scan=new Scanner(System.in);
        
        System.out.print("Enter doctor_ID:");
        int docId=scan.nextInt();
/*        System.out.print("Enter Date:");
        int date=scan.nextInt();
*/        
        appointmentRepository.setAppointment(docId);
    }
    
    public void mainPage() throws Exception{
        Scanner scan=new Scanner(System.in);
        patientVerificationPage();
      //  PatientController patientController=new PatientController();
        //int loggedPatient=patientController.loggedPatient();
       // int loggedPatient=patientController.loggedPatient;
        do{
            System.out.println("\t\t\tCLINIC MANAGEMENT SYSTEM\n");
//            System.out.println("Welcome "+patientController.);
            System.out.println("1. Request Appointment");
            System.out.println("2. View Schedules");
            System.out.println("3. View Appointments");
            System.out.println("4. Exit");
            System.out.println("\nEnter your choice(1-4):"); 
            int choice=scan.nextInt();
            switch(choice){
                case 1:
                    requestAppointment();
                    break;

                case 2:
                    viewSchedule();
                    break;
                    
                case 3:
                    viewAppointment();
                    break;
                    
                case 4:
                    System.exit(0);
                    
                default:
                    System.out.println("-----Input out of range-----\n");
            }
        }while(true);
    }
    
    public void logIn() throws Exception {
        PatientController patientController=new PatientController();
        Scanner scanner = new Scanner(System.in);
        int id,breaker;
        String email;
        do{
            breaker=0;
            System.out.print("Please enter your ID:");
            id=scanner.nextInt();
            System.out.print("Please login by your email: ");
            email = scanner.next();
            if((patientController.login(id,email))==false){
                System.out.println("-----ACCESS DENIED-----\n-----Either your ID OR email is incorrect-----\nPress 1 to try again:");
                breaker=scanner.nextInt();
            }
            
        }while(breaker==1);
//        return PatientController.login(email);
    }
    
    public void patientVerificationPage() throws Exception{
        Scanner scan=new Scanner(System.in);
        int breaker;
        do{
            breaker=0;
            System.out.println("\t\t\tWELCOME TO CLINIC MANAGEMENT SYSTEM\n");
            System.out.print("Log in OR Create an account to continue\n1) Log In\n2) Create Account\n3) Exit\n\nEnter choice:");
            int choice=scan.nextInt();
            switch(choice){
                case 1:
                    logIn();
                    break;

                case 2:
                    createPatient();              
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("-----Input out of range-----\n");
                    breaker=1;
            }
        }while(breaker==1);
        
    }
    
    public void createPatient() throws Exception{
        Scanner scan=new Scanner(System.in);
        PatientController patientController=new PatientController();
        System.out.print("Enter name:");
        String name=scan.nextLine();
        System.out.print("Enter address:");
        String address=scan.next();
        System.out.print("Enter phone no:");
        long phone=scan.nextLong();
        System.out.print("Enter gender:");
        String gender=scan.next();
        System.out.print("Enter email:");
        String email=scan.next();
        patientController.addPatient(name,address,phone,gender,email);
    }
}
