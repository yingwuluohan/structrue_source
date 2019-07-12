package com.struc.base.userapi.modle;

import java.io.Serializable;

public class Param implements Serializable {

    private String name;
    private Integer id;

    private Integer num;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
