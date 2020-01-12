/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import CMS.DBConnection;
import Model.Appointments;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author riku
 */
public class AppointmentRepository {
    public List<Appointments> getAppointment() throws SQLException{
        Connection connection=DBConnection.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from appointments");
        
        List<Appointments>appointments=new ArrayList<>();
        
        while(resultSet.next()){
           // Appointments appointment=new Appointments(/*resultSet.getInt(1),*/resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4));

            Appointments appointment=new Appointments(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4));
            appointments.add(appointment);
        }
        DBConnection.closeConnection();
        return appointments;
    }
    
    public void setAppointment(int doctor_id,String date,int patient_id) throws Exception{
        Connection connection=DBConnection.getConnection();
        Statement statement=connection.createStatement();
     /*   ResultSet resultSet=*/statement.executeUpdate("insert into appointments(doctor_id,date,patient_id) values("+doctor_id+",'"+date+"',"+patient_id+")");
        DBConnection.closeConnection();
    }
}
