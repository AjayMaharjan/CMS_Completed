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
public class Schedules {
    private int schedule_id;
    private int doctor_id;
    private int department_id;
    private String shift;
    private int seatAvailable;
    public Schedules(int schedule_id,int doctor_id,int department_id,String shift,int seatAvailable){
        this.schedule_id=schedule_id;
        this.doctor_id=doctor_id;
        this.department_id=department_id;
        this.shift=shift;
        this.seatAvailable=seatAvailable;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public int getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(int seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
}
