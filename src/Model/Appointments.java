/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author riku
 */
public class Appointments {
    private int appointment_id;
    private String date;  
    private int doctor_id;
    private int patient_id;
    public Appointments(int appointment_id,String date,int doctor_id,int patient_id){
        this.appointment_id=appointment_id;
        this.doctor_id=doctor_id;
        this.patient_id=patient_id;
        this.date=date;  
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }
    
}
