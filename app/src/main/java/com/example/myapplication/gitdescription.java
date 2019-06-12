package com.example.myapplication;

public class gitdescription {

    String fullname;
    String htmlurl;
    String descrition;
    String language;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getHtmlurl() {
        return htmlurl;
    }

    public void setHtmlurl(String htmlurl) {
        this.htmlurl = htmlurl;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public gitdescription(String fullname, String htmlurl, String descrition, String language) {
        this.fullname = fullname;
        this.htmlurl = htmlurl;
        this.descrition = descrition;
        this.language = language;
    }
}
