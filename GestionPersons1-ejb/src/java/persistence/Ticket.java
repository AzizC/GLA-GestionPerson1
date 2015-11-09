/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author cirstea
 */
public class Ticket {

    private Person person;
    private String topic;
    private String issue;

    public Ticket(){
        
    }
    
    public Ticket(Person person, String topic, String issue) {
        this.person = person;
        this.topic = topic;
        this.issue = issue;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Ticket{" + "person=" + person + ", topic=" + topic + ", issue=" + issue + '}';
    }

}
