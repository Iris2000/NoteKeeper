package com.example.notekeeper;

public class NoteClass {

    private long id;
    private String title;
    private String content;
    private String date;
    private String time;
    private String color;
//
//    public void Note(){};
//
//    public void Note(String title, String content, String date, String time) {
//
//    };
//
//    public void Note(long id, String title, String content, String date, String time) {
//
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
