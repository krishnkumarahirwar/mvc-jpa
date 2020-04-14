package org.capg.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CustomerDto {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private int age;

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }


}
