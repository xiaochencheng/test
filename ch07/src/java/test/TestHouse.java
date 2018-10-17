import cn.hibernate.dao.HouseDao;
import cn.hibernate.service.HouseBiz;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

public class TestHouse {

    @Test
    public void testUserHouseAllInfo(){
        HouseBiz h=new HouseBiz();
        h.getUserHouseInfo();
    }

    @Test
    public void testUserHouseAllInfo_fetch(){
        HouseBiz h=new HouseBiz();
        h.getUserHouseInfo();
    }

    @Test
    public void testUserHouseAllInfo_Nei(){
        HouseBiz h=new HouseBiz();
        h.getUserHouseInfo_Nei();
    }

    @Test
    public void testUserHouseAllInfo_House(){
        HouseBiz h=new HouseBiz();
        h.getHouseAvgMax();
    }

    @Test
    public void testUserHouseAllInfo_House_Street(){
        HouseBiz h=new HouseBiz();
        h.getHouseAvgMax_Street();
    }

    @Test
    public void testUserHouseAllInfo_House_QuXian(){
        HouseBiz h=new HouseBiz();
        h.getHouseAvgMax_Street_Title();
    }

    @Test
    public void testUserHouse(){
        HouseBiz h=new HouseBiz();
        h.getHouse();
    }

    @Test
    public void testUserHouse_Money(){
        HouseBiz h=new HouseBiz();
        h.getHouse_Money();
        }
    @Test
    public void testUserHouse_Money_Street(){
        HouseBiz h=new HouseBiz();
        h.getHouse_Money100();
        }
    @Test
    public void testUserHouse_Money_Num(){
        HouseBiz h=new HouseBiz();
        h.getHouse_HouseNum();
        }

    @Test
    public void testUserHouse_Money_Num6000(){
        HouseBiz h=new HouseBiz();
        h.getHouse_HouseNum600();
        }


}
