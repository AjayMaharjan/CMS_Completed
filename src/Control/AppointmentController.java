/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Repository.AppointmentRepository;
import java.util.*;
/**
 *
 * @author riku
 */
public class AppointmentController {
      public void requestAppointment(int docId) throws Exception{
        Scanner scan=new Scanner(System.in);
        AppointmentRepository appointmentRepository=new AppointmentRepository();
        
        appointmentRepository.setAppointment(docId);
    }

}
