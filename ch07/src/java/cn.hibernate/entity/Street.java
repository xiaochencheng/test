package cn.hibernate.entity;

import java.io.Serializable;

public class Street implements Serializable {
    private  Integer ID;
    private  String  NAME;
    private  Integer DISTRICT_ID;

    public Street() {
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

    public Integer getDISTRICT_ID() {
        return DISTRICT_ID;
    }

    public void setDISTRICT_ID(Integer DISTRICT_ID) {
        this.DISTRICT_ID = DISTRICT_ID;
    }
}
