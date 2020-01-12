/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Doctors;
import Model.Patients;
import Model.Schedules;
import Repository.AppointmentRepository;
import Repository.DoctorsRepository;
import Repository.ScheduleRepository;
import java.util.*;
/**
 *
 * @author riku
 */
public class AppointmentController {
    public boolean requestAppointment(int doctor_id,String date,int patient_id) throws Exception{
        Scanner scan=new Scanner(System.in);
        AppointmentRepository appointmentRepository=new AppointmentRepository();
        DoctorsRepository doctorRepository=new DoctorsRepository();
        List<Doctors> doctors=doctorRepository.getDoctors();
        String status="Available";
        boolean stat=false;
        for(Doctors doctor: doctors){
                if(doctor_id==doctor.getDoctor_id()){
                    if(status.equals(doctor.getStatus()))
                    {
                        appointmentRepository.setAppointment(doctor_id, date, patient_id);
                        stat=true;
                        seatAvailableController(doctor_id);
                        break;
                    }else if(status.equals("Unavailable"))
                    {
                        stat=false;
                        break;
                    }
                    
                }
                
            }
        return stat;
//        appointmentRepository.setAppointment(doctor_id);
    }
    public void seatAvailableController(int doctor_id) throws Exception{
        DoctorsRepository doctorRepository=new DoctorsRepository();
        List<Doctors> doctors=doctorRepository.getDoctors();
        ScheduleRepository scheduleRepository=new ScheduleRepository();
        List<Schedules> schedules=scheduleRepository.getSchedules();
        int schedule_id=0;
        int seatAvailable=0;
        for(Schedules schedule : schedules){
                if(schedule.getDoctor_id()==doctor_id){
                    //status=doctor.getStatus();
                    seatAvailable=schedule.getSeatAvailable();
                    seatAvailable--;
                    schedule_id=schedule.getSchedule_id();
                }
        }
        scheduleRepository.setSchedules(seatAvailable,schedule_id);
    }
}
