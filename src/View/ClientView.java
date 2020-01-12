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
import Control.AppointmentController;
import java.util.*;
import Control.PatientController;
import Model.Appointments;
import Model.Departments;
import Model.Doctors;
import Model.Patients;
import Model.Schedules;
import Repository.AppointmentRepository;
import Repository.DepartmentRepository;
import Repository.DoctorsRepository;
import Repository.PatientRepository;
import Repository.ScheduleRepository;
import java.sql.SQLException;
import java.util.*;
public class ClientView {
    int loggedPatient_Id;
    String loggedPatientEmail;
    AppointmentRepository appointmentRepository=new AppointmentRepository();
    public void viewSchedule()throws Exception{
        ScheduleRepository scheduleRepository=new ScheduleRepository();
        List<Schedules> schedules=scheduleRepository.getSchedules();
        DoctorsRepository doctorRepository=new DoctorsRepository();
        List<Doctors> doctors=doctorRepository.getDoctors();
        DepartmentRepository departmentRepository=new DepartmentRepository();
        List<Departments> departments=departmentRepository.getDepartments();
//        String doctor;
//         dep_id;
        System.out.println("Schedule_ID  :  Shift  :  Doctor  :  Department");
                
        for(Schedules schedule: schedules){
            System.out.print("\t"+schedule.getSchedule_id()+"\t"+schedule.getShift());
            int doctor_id=schedule.getDoctor_id();
            for(Doctors doctor: doctors){
                if(doctor_id==doctor.getDoctor_id()){
                    System.out.print("\t"+doctor.getName());
                }
                int department_id=doctor.getDepartment_id();
                for(Departments department: departments){
                    if(department_id==department.getDepartment_id()){
                        System.out.println("\t"+ department.getName());
                        break;
                    }
                    break;
                }
            }
            
        }
    }
  
    public void viewAppointment() throws Exception{
//        AppointmentRepository appointmentRepository=new AppointmentRepository();
        List<Appointments> appointments=appointmentRepository.getAppointment();
        DoctorsRepository doctorsRepository= new DoctorsRepository();
        List<Doctors> doctors=doctorsRepository.getDoctors();
        int doctor_id=0;
        System.out.println("Appointment_id  :  Date :  Doctor");
        for(Appointments appointment: appointments){
            if(loggedPatient_Id==appointment.getPatient_id()){
                System.out.print("\t"+appointment.getAppointment_id()+"\t"+appointment.getDate());
                doctor_id=appointment.getDoctor_id();
                for(Doctors doctor: doctors){
                    if(doctor_id==doctor.getDoctor_id()){
                        System.out.println("\t"+doctor.getName());
                    }
                }
            }
        }
    }
    
    public void requestAppointment() throws Exception{
        Scanner scan=new Scanner(System.in);
        AppointmentController appointmentController=new AppointmentController();
        System.out.print("Enter doctor_ID:");
        int docId=scan.nextInt();
        System.out.print("Enter Date:");
        String date=scan.next();
        boolean stat=appointmentController.requestAppointment(docId,date,loggedPatient_Id);
        if(stat==true){
            System.out.println("\t\t\t*****Request Sent*****");
        }else{
            System.out.println("*****DOCTOR IS NOT AVAILABLE*****\n*****SORRY FOR INCONVIENIENCE*****\n*****PLEASE REQUEST ANOTHER DOCTOR*****");
        }
  //      appointmentRepository.setAppointment(docId,date,loggedPatient_Id);
    }
    
    public void mainPage() throws Exception{
        Scanner scan=new Scanner(System.in);
        patientVerificationPage();
        PatientController patientController=new PatientController();
        //int loggedPatient=patientController.loggedPatient();
       // int loggedPatient=patientController.loggedPatient;
        do{
            System.out.println("\t\t\tCLINIC MANAGEMENT SYSTEM\n");
            System.out.print("\t\t\t*****WELCOME "+patientController.getLoggedPatientName(loggedPatient_Id)+"*****\n\t\t\t*****YOUR ID:"+loggedPatient_Id+"*****\n");
            System.out.println("1. Request Appointment");
            System.out.println("2. View Schedules");
            System.out.println("3. View Appointments");
            System.out.println("4. View Profile");
            System.out.println("5. Exit");
            System.out.println("\nEnter your choice(1-5):"); 
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
                    viewProfile();
                    break;
                    
                case 5:
                    System.exit(0);
                    break;
                    
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
            loggedPatient_Id=id;
            System.out.print("Please login by your email: ");
            email = scanner.next();
            loggedPatientEmail=email;
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
            System.out.print("Log in OR Create an account to continue\n1) Log In(As an old patient)\n2) Create account(for dental services)\n3) Create account(for eye care service)\n4) Exit\n\nEnter choice:");
            int choice=scan.nextInt();
            switch(choice){
                case 1:
                    logIn();
                    break;
                    
                case 2:
                    createPatient();
                    break;
                    
                case 3:
                    createPatient();
                    break;

                case 4:
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
        int id;
        id=patientController.getLoggedPatient_id(email);
        loggedPatient_Id=id;
        loggedPatientEmail=email;
    }
    
    public void viewProfile() throws Exception{
        PatientController patientController=new PatientController();
        System.out.println("\t\t\t*****MY PROFILE*****");
        System.out.println("Your \nID: "+patientController.getLoggedPatient_id(loggedPatientEmail));
        System.out.println("Name: "+patientController.getLoggedPatientName(loggedPatient_Id));
        System.out.println("Address: "+patientController.getLoggedPatientAddress(loggedPatient_Id));
        System.out.println("Phone number: "+patientController.getLoggedPatientPhone_no(loggedPatient_Id));
        System.out.println("Gender: "+patientController.getLoggedPatientGender(loggedPatient_Id));
        System.out.println("Email: "+patientController.getLoggedPatientEmail(loggedPatient_Id));
    }
}
