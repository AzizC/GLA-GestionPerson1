/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listPersons;

import interceptors.DoUpperCaseInterceptor.DoUpper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import persistence.Person;

/**
 *
 * @author chafi4u
 */
@Stateless
public class PersonManagerBean implements PersonManager {

    @Resource(lookup = "jdbc/gp1")
    private DataSource dataSource;
    private Connection connection;
    
    @PostConstruct
    public void initialize() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    @PreDestroy
    public void cleanup() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    @Override
    public void register(Person person) {
        try {
            
            Statement smt = connection.createStatement();
            smt.execute("INSERT INTO PERSONS(NICKNAME,FIRSTNAME,LASTNAME) VALUES("
                    + "\'"
                    + person.getNickName()
                    + "\',\'"
                    + person.getFirstName()
                    + "\',\'"
                    + person.getLastName() + "\')");
           
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    @Override
    public ArrayList<Person> getAllPersons() {
        
        ArrayList<Person> list = new ArrayList<>();
        
        try {
            
            Statement smt = connection.createStatement();
            ResultSet rs  = smt.executeQuery("SELECT * FROM PERSONS");
            
            while(rs.next()){
                list.add(new Person(rs.getString("firstname"), rs.getString("lastname"), rs.getString("nickname")));
            }
            
         } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return list;
    }
}
