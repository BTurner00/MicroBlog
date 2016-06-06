package com.theironyard;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static Message message;
    static ArrayList<Message> messages;
    static ArrayList<User> userList;
    static User user;


    public static void main(String[] args) {
        Spark.init();
        Spark.get(
                "/",
                (request, response) -> {
                    HashMap m = new HashMap();

                    if (user == null) {
                        return new ModelAndView(m,"index.html");
                    } else {
                        m.put("name", user.name);
                        m.put("messages", messages);
                        m.put("message", message);
                        return new ModelAndView(m, "messages.html");
                    }
                },
                new MustacheTemplateEngine()
        );

        Spark.post(
                "/create-user",
                (request, response) -> {
                    String username = request.queryParams("username");
                    user = new User (username);
                    userList.add(user);
                    response.redirect("/");
                    return "";
                }
        );
        Spark.post(
                "/create-message",
                (request, response) -> {
                    String content = request.queryParams("message");
                    message = new Message(content);
                    messages.add(message);
                    response.redirect("/");
                    return "";
                }
        );
    }
}
