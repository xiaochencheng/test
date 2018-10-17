package cn.hibernate.entity;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;

public class House implements Serializable {
    private  Integer ID;
    private  Integer USER_ID;
    private  Integer TYPE_ID;
    private  String  TITLE;
    private  String  DESCRIPTION;
    private  Double  PRICE;
    private  Date    PUBDATE;
    private  Integer FLOORAGE;
    private  String  CONTACT;
    private  Integer STREET_ID;
    private  User user;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public Integer getTYPE_ID() {
        return TYPE_ID;
    }

    public void setTYPE_ID(Integer TYPE_ID) {
        this.TYPE_ID = TYPE_ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Double getPRICE() {
        return PRICE;
    }

    public void setPRICE(Double PRICE) {
        this.PRICE = PRICE;
    }

    public Date getPUBDATE() {
        return PUBDATE;
    }

    public void setPUBDATE(Date PUBDATE) {
        this.PUBDATE = PUBDATE;
    }

    public Integer getFLOORAGE() {
        return FLOORAGE;
    }

    public void setFLOORAGE(Integer FLOORAGE) {
        this.FLOORAGE = FLOORAGE;
    }

    public String getCONTACT() {
        return CONTACT;
    }

    public void setCONTACT(String CONTACT) {
        this.CONTACT = CONTACT;
    }

    public Integer getSTREET_ID() {
        return STREET_ID;
    }

    public void setSTREET_ID(Integer STREET_ID) {
        this.STREET_ID = STREET_ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public House() {
    }


}
