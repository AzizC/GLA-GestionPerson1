/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketsManagement;

import javax.ejb.Local;
import javax.jms.Topic;
import persistence.Person;
import persistence.Ticket;

/**
 *
 * @author aziz
 */
@Local
public interface TicketManager {
    
    public void addCustomer(Person person);
    public void addTopic(String topic) throws WorkflowViolationException;
    public void addIssue(String issue) throws WorkflowViolationException;
}
