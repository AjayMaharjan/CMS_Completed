/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Model.Patients;
import Repository.PatientRepository;
import java.util.List;


/**
 *
 * @author riku
 */
public class PatientController{
/*    
    private PatientController(int patient_id) throws Exception{
        loggedPatient=patient_i
    }
*/
    public boolean login(int patient_id,String email) throws Exception{        
        PatientRepository patientRepository=new PatientRepository();
        List<Patients> patients=patientRepository.getPatients();
        
        boolean temp=false;
        for(Patients patient: patients){
            if((email.equals(patient.getEmail()))&&(patient_id==patient.getPatient_id())){
                temp=true;
                break;
            }
        }
        return temp;
        
    }
    
    public void addPatient(String name,String address,long phone,String gender,String email) throws Exception{
        PatientRepository patientRepo=new PatientRepository();
        patientRepo.setPatients(name, address, phone, gender, email);
    }
    
    public String getLoggedPatientName(int loggedPatient_Id) throws Exception{
        PatientRepository patientRepository=new PatientRepository();
        List<Patients> patients=patientRepository.getPatients();
        String loggedPatientName="null";
        for(Patients patient: patients){
            if(loggedPatient_Id==patient.getPatient_id()){
                loggedPatientName=patient.getName();
                break;
            }
        }
        return loggedPatientName;
    }
 
    public String getLoggedPatientAddress(int loggedPatient_Id) throws Exception{
        PatientRepository patientRepository=new PatientRepository();
        List<Patients> patients=patientRepository.getPatients();
        String loggedPatientAddress="null";
        for(Patients patient: patients){
            if(loggedPatient_Id==patient.getPatient_id()){
                loggedPatientAddress=patient.getAddress();
                break;
            }
        }
        return loggedPatientAddress;
    }
    
    public String getLoggedPatientGender(int loggedPatient_Id) throws Exception{
        PatientRepository patientRepository=new PatientRepository();
        List<Patients> patients=patientRepository.getPatients();
        String loggedPatientGender="null";
        for(Patients patient: patients){
            if(loggedPatient_Id==patient.getPatient_id()){
                loggedPatientGender=patient.getGender();
                break;
            }
        }
        return loggedPatientGender;
    }
    
    public String getLoggedPatientEmail(int loggedPatient_Id) throws Exception{
        PatientRepository patientRepository=new PatientRepository();
        List<Patients> patients=patientRepository.getPatients();
        String loggedPatientEmail="null";
        for(Patients patient: patients){
            if(loggedPatient_Id==patient.getPatient_id()){
                loggedPatientEmail=patient.getEmail();
                break;
            }
        }
        return loggedPatientEmail;
    }
    
    public long getLoggedPatientPhone_no(int loggedPatient_Id) throws Exception{
        PatientRepository patientRepository=new PatientRepository();
        List<Patients> patients=patientRepository.getPatients();
        long loggedPatientPhone_no=0;
        for(Patients patient: patients){
            if(loggedPatient_Id==patient.getPatient_id()){
                loggedPatientPhone_no=patient.getPhone_no();
                break;
            }
        }
        return loggedPatientPhone_no;
    }
    
    public int getLoggedPatient_id(String email) throws Exception{
        PatientRepository patientRepository=new PatientRepository();
        List<Patients> patients=patientRepository.getPatients();
        int id=0;
        for(Patients patient: patients){
            if(email.equals(patient.getEmail())){
                id=patient.getPatient_id();
                break;
            }
        }
        
        return id;
    }
}
