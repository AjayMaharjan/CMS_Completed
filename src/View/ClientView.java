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
    
    public void requestAppointment(){
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
        
        do{
        System.out.println("\t\t\tCLINIC MANAGEMENT SYSTEM\n");
        System.out.println("1.Request Appointment");
        System.out.println("2.View Schedules");
        System.out.println("3.View Appointments");
        System.out.println("4.Exit");
        System.out.println("\nEnter your choice(1-4):"); 
        int choice=scan.nextInt();
        switch(choice){
              case 1:requestAppointment();
            break;
            
            case 2:viewSchedule();
                break;
            case 3:viewAppointment();
            break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Input out of range.");
        }
        }while(true);
    }
    
/*    public boolean logIn() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please login by your email: ");
        String email = scanner.next();
        return PatientController.login(email);
    }
*/
}
