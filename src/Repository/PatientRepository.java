/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import CMS.DBConnection;
import Model.Patients;
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
public class PatientRepository {
    public List<Patients> getPatients() throws SQLException{
        Connection connection=DBConnection.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from patients");
        List<Patients> patients=new ArrayList<>();
        while(resultSet.next()){
            Patients patient=new Patients(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6));
            patients.add(patient);
        }
        
        DBConnection.closeConnection();
        return patients;
    }
    
    public void setPatients(String name,String address,long phone,String gender,String email) throws Exception{
        Connection connection=DBConnection.getConnection();
        Statement statement=connection.createStatement();
     /*   ResultSet resultSet=*/statement.executeUpdate("insert into patients values(null,'"+name+"','"+address+"',"+phone+",'"+gender+"','"+email+"')");
        DBConnection.closeConnection();
    }
}
