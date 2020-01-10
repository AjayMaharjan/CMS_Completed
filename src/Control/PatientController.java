/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import CMS.DBConnection;
import Model.Patients;
import Repository.PatientRepository;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author riku
 */
public class PatientController {
    public void login(String email) throws Exception{
        PatientRepository patientRepository=new PatientRepository();
        List<Patients> patients=patientRepository.getPatients();
        for(Patients patient: patients){
            if(email.equals(patient.getEmail())){
                System.out.println("yes");
                break;
            }
        }
        
    }
    
    public void addPatient() throws Exception{
        Scanner scan=new Scanner(System.in);
        PatientRepository patientRepo=new PatientRepository();
        System.out.print("Enter name:");
        String name=scan.nextLine();
        System.out.print("Enter address:");
        String address=scan.nextLine();
        System.out.print("Enter phone no:");
        long phone=scan.nextInt();
        System.out.print("Enter gender:");
        String gender=scan.nextLine();
        System.out.print("Enter email:");
        String email=scan.nextLine();
        patientRepo.setPatients(name, address, phone, gender, email);
    }
}
