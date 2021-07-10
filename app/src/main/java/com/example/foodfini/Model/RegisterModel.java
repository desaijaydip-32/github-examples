package com.example.foodfini.Model;

public class RegisterModel {

    String uid, mname, mpassword, memail;






    public RegisterModel(String uid, String mname, String mpassword, String memail) {
        this.mname = mname;
        this.mpassword = mpassword;
        this.memail = memail;
        this.uid = uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }
}
