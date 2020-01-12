/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMS;
//import Control.PatientController;
import Repository.PatientRepository;
import View.ClientView;
//import View.Home;
/**
 *
 * @author 
 */
public class CMS {
    public static void main(String args[])throws Exception{        
 /*       Home home=new Home();
       home.homePage();
/*
        ClientView clientView=new ClientView();
        clientView.appointment();
 */       
          ClientView clientView=new ClientView();
          clientView.mainPage();
           
/*
        PatientRepository p=new PatientRepository();
        p.setPatients("Akaa Shahi","Teku,Kathmandu",9878098765,"Male","akaashahi22@gmail.com");

        PatientController p=new PatientController();
        p.login("amarmaharjann@gmail.com");
*/        

    }
}
