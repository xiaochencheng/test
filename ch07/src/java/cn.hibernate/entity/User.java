package cn.hibernate.entity;

import java.io.Serializable;

public class User implements Serializable {
    private  Integer ID;
    private  String NAME;
    private  String PASSWORD;
    private  String TELEPHONE;
    private  String USERNAME;
    private  Integer ISADMIN;

    public User() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(String TELEPHONE) {
        this.TELEPHONE = TELEPHONE;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public Integer getISADMIN() {
        return ISADMIN;
    }

    public void setISADMIN(Integer ISADMIN) {
        this.ISADMIN = ISADMIN;
    }
}
