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
//    public int loggedPatient;
/*    
    private PatientController(int patient_id) throws Exception{
        loggedPatient=patient_id;
    }
*/
    public boolean login(int patient_id,String email) throws Exception{
        PatientRepository patientRepository=new PatientRepository();
        List<Patients> patients=patientRepository.getPatients();
        boolean temp=false;
        for(Patients patient: patients){
            if((email.equals(patient.getEmail()))&&(patient_id==patient.getPatient_id())){
  //              loggedPatient=patient.getPatient_id();
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
    
/*    public void loggedPatient() throws Exception{
        PatientRepository patientRepository=new PatientRepository();
        List<Patients> patients=patientRepository.getPatients();
        int patientId;
        int patientName;
        int patientAddress;
        int patientPhone;
        int patientGender;
        int patientEmail;
   /*     for(Patients patient: patients){
            if((email.equals(patient.getEmail()))&&(patient_id==patient.getPatient_id())){
                loggedPatient=patient.getPatient_id();
                temp=true;
                break;
            }
            }

        }
 */
        
    
}
