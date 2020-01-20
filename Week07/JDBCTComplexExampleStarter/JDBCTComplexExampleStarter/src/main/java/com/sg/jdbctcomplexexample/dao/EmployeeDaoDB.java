/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jdbctcomplexexample.dao;

import com.sg.jdbctcomplexexample.entity.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Boone
 */
@Repository
public class EmployeeDaoDB implements EmployeeDao {

    @Autowired //Autowire JDBCTemplate
    JdbcTemplate jdbc;
    
    //Add the EmployeeMapper, and make it public so that it can be accessed by the
        //Meeting DAO when adding a list of Employees to the Meeting
    public static final class EmployeeMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int index) throws SQLException {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setFirstName(rs.getString("firstName"));
            emp.setLastName(rs.getString("lastName"));
            return emp;
        }
    }
    
    //CRUD methods -------------------------------------------------------------
    @Override
    public List<Employee> getAllEmployees() {
        //declare the query as a string
        final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
        
        //return the results of the query (a list of employees) using the query String
            //and EmployeeMapper as parameters
        return jdbc.query(SELECT_ALL_EMPLOYEES, new EmployeeMapper());
    }

    @Override
    public Employee getEmployeeById(int id) {
        try {
            //same as getAllEmployees() method, except with the new parameter "id"
            final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id = ?";
            return jdbc.queryForObject(SELECT_EMPLOYEE_BY_ID, new EmployeeMapper(), id);
        } catch(DataAccessException ex) {
            //if no object is found, an exception will be thrown
            //return null as an indicator that no object was retrieved
            return null;
        }
    }    
    
    @Override
    @Transactional //This ensures that all the queries in this method run in a single transaction.
    public Employee addEmployee(Employee employee) {
        //create the INSERT string and fill it with the appropriate info.
        final String INSERT_EMPLOYEE = "INSERT INTO employee(firstName, lastName) "
                + "VALUES(?,?)";
        jdbc.update(INSERT_EMPLOYEE, 
                employee.getFirstName(),
                employee.getLastName());
        
        //Use a query with LAST_INSERT_ID() to get the ID of the Employee that was just inserted in the database.
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        
        //Put the ID into the Employee object and return it.
        employee.setId(newId);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        //update an employee; rather straight-forward
        final String UPDATE_EMPLOYEE = "UPDATE employee SET firstName = ?, lastName = ? "
                + "WHERE id = ?";
        jdbc.update(UPDATE_EMPLOYEE,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getId());
    }

    @Override
    @Transactional //Use this because we are making multiple database calls to perform the deletion
        //and this ensures that they all succeed or fail together
    public void deleteEmployeeById(int id) {
        
        //delete instances of that employee in the employee-bridge table
        final String DELETE_MEETING_EMPLOYEE = "DELETE FROM meeting_employee "
                + "WHERE employeeId = ?";
        jdbc.update(DELETE_MEETING_EMPLOYEE, id);
        
        //now, delete the employee
        final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id = ?";
        jdbc.update(DELETE_EMPLOYEE, id);
    }
    
}