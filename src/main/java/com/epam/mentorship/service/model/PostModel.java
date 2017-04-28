package com.epam.mentorship.service.model;

public class PostModel {

    private int userId;
    private int id;
    private String title;
    private String body;

    public PostModel(){

    }

    public PostModel(String line) {
        String[] split = line.split(",");
        this.userId = Integer.parseInt(split[0]);
        this.id = Integer.parseInt(split[1]);
        this.title = split[2];
        this.body = split[3];
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public String toString(){
        return "\n\nuserID: "+getUserId()+ ", \n"
                + "ID: "+ getId() + ", \n"
                + "title: " + getTitle() + ",\n"
                + "body: "+getBody() ;
    }
}
