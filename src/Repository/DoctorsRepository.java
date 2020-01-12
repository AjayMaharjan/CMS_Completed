/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import CMS.DBConnection;
import Model.Doctors;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import static sun.misc.ClassFileTransformer.add;

/**
 *
 * @author riku
 */
public class DoctorsRepository {
    public List<Doctors> getDoctors() throws SQLException{
        Connection connection=DBConnection.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from doctors");
        List<Doctors>doctors=new ArrayList<>();
        
        while(resultSet.next()){
            Doctors doctor=new Doctors(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8));
            doctors.add(doctor);
        }
        
        DBConnection.closeConnection();
        return doctors;
    }
    
    
}
