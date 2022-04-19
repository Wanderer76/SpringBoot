package db_homework;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String event;

    public Event(){

    }

    public Event(String event){
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String task) {
        this.event = task;
    }

    @Override
    public String toString() {
        return event;
    }

}
