/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import CMS.DBConnection;
import Model.Schedules;
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
public class ScheduleRepository {
    public List<Schedules> getSchedules() throws SQLException{
        Connection connection=DBConnection.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from schedules");
        List<Schedules>schedules=new ArrayList<>();
        
        while(resultSet.next()){
            Schedules schedule = new Schedules(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5));
//            Schedules schedule = new Schedules(resultSet.getInt(1), resultSet.getString(4));
            schedules.add(schedule);
        }
        DBConnection.closeConnection();
        return schedules;
    }
    
    public void setSchedules(int seatAvailable,int schedule_id) throws Exception{
        Connection connection=DBConnection.getConnection();
        Statement statement=connection.createStatement();
     /*   ResultSet resultSet=*/statement.executeUpdate("update schedules set seat_available="+seatAvailable+" where schedule_id="+schedule_id+";");
        DBConnection.closeConnection();
    }
    
    
}
