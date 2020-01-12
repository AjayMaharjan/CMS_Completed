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
public class Doctors {
    private int doctor_id;
    private String name;
    private int service_id;
    private int department_id;
    private String address;
    private String gender;
    private int phone_no;
    private String status;
    
    public Doctors(int doctor_id,String name,int service_id,int department_id,String address,String gender,int phone_no,String status){
       this.doctor_id=doctor_id;
       this.name=name;
       this.service_id=service_id;
       this.department_id=department_id;
       this.address=address;
       this.gender=gender;
       this.phone_no=phone_no;
       this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }
    
}
