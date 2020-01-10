/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import CMS.DBConnection;
import Model.Services;
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
public class ServicesRepository {
    public List<Services> getServices() throws SQLException{
        Connection connection=DBConnection.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from services");
        List<Services> services=new ArrayList<>();
        
        while(resultSet.next()){
            Services service=new Services(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
            services.add(service);
        }
        
        DBConnection.closeConnection();
        return services;
    }
}
