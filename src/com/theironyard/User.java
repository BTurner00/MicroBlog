package com.theironyard;

import java.util.ArrayList;

/**
 * Created by Ben on 6/6/16.
 */
public class User {
    String name;
    String pass;
    ArrayList<Message> messages = new ArrayList<>();

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
}
