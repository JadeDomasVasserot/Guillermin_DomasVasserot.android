package com.example.androidtodo.pojo;

import java.io.Serializable;

public class Todo implements Serializable {
    private int id;
    private static int idInc = 0;
    private String name;
    private String urgency;

    public Todo(){

    }
    public Todo(String name, String urgency) {
        idInc++;
        this.id = idInc;
        this.name = name;
        this.urgency = urgency;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
       this.id= id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

}
