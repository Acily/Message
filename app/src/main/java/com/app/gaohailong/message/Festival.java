package com.app.gaohailong.message;

/**
 * Created by donglinghao on 2015-10-13.
 */
public class Festival {
    private int id;
    private String name;

    public Festival(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
