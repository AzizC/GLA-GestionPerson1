/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketsManagement;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import persistence.Person;
import persistence.Ticket;

/**
 *
 * @author aziz
 */
@Stateful
public class TicketManagerBean implements TicketManager {

    private Ticket ticket;

    @PostConstruct
    public void initialize(){
        ticket = new Ticket();
    }
    
    @Override
    public void addCustomer(Person person) {
        ticket.setPerson(person);
    }

    @Override
    public void addTopic(String topic) throws WorkflowViolationException {
        
        if(ticket.getPerson() == null)
            throw new WorkflowViolationException("Enter customer infos. first !");
            
        ticket.setTopic(topic);
    }

    @Override
    public void addIssue(String issue) throws WorkflowViolationException {
        
        if(ticket.getTopic() == null)
            throw new WorkflowViolationException("Enter customer infos. and topic first !");
                
        ticket.setIssue(issue);
        
        registerTicket();
    }
    
    private void registerTicket(){
        
        // simulate a load time
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TicketManagerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(ticket.getPerson().getFirstName());
        System.out.println(ticket.getPerson().getLastName());
        System.out.println(ticket.getTopic());
        System.out.println(ticket.getIssue());
    }
}
