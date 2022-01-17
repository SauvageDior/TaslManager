package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jdk.jfr.Name;
import org.w3c.dom.Attr;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Time;
import java.util.UUID;


@XmlRootElement
public class Task implements Serializable {




    private String description;
    private String name;
    private UUID userId;
    private UUID id;

    private Alert alert;

    public Task(String description, String name, UUID userId, UUID id, Time time){
        this.description = description;
        this.name = name;
        this.userId = userId;
        this.id = id;
        this.alert = new Alert(UUID.randomUUID(), time, "NULL");
    }

    public Task(String name, String description, UUID userId, UUID id, Alert alert){
        this.description = description;
        this.name = name;
        this.userId = userId;
        this.id = id;
        this.alert = alert;
    }

    public Task(){}



    public void setAlertTime(Time time){
        alert.setAlertTime(time);
    }


    public void setMessage(String message) {this.alert.setMessage(message);}

    public Alert getAlert() { return alert; }

    public String getDescription(){ return description; }

    public void setDescription(String description){ this.description = description; }

    public String getName(){ return name; }

    public void setName(String name){ this.name = name; }

    public UUID getId(){ return id; }

    public void setId(UUID id){ this.id = id; }

    public void setUserId(UUID userId){ this.userId = userId; }

    public UUID getUserId(){ return userId; }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id: " + id + " Name: " + name + " Description: " + description + " userId: " + userId );
        return sb.toString();
    }

}
