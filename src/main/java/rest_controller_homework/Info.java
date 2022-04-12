package rest_controller_homework;

import java.util.Date;

public class Info {

    private Date date;
    private static Long id = null;

    public Info() {

    }

    public Info(Date date, Long id) {
        this.date = date;
        //this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId() {
        if(id == null)
            id = 0L;
        else
            id++;
    }
}
