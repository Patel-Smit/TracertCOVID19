package com.smit.tracertcovid_19;

public class Post {
    String title;
    String update;

    public Post() {
    }

    @Override
    public String toString() {
        return "com.smit.tracertcovid_19.Post{" +
                "title='" + title + '\'' +
                ", update='" + update + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
