package com.example.demo.modal;

import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Events {

    @Id
    private String id;
    private String name;

    public Events() {

    }

    public Events(@RequestParam("id") String id, @RequestParam("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
