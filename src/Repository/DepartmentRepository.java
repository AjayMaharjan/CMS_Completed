/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import CMS.DBConnection;
import Model.Departments;
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
public class DepartmentRepository {
    public List<Departments> getDepartments() throws SQLException{
        Connection connection=DBConnection.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet =statement.executeQuery("select * from departments");
        List<Departments>departments=new ArrayList<>();
        
        while (resultSet.next()){
            Departments departments1=new Departments(resultSet.getInt(1),resultSet.getString(2));
            departments.add(departments1);
        }
        DBConnection.closeConnection();
        return departments;
    }
}
