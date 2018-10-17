package cn.hibernate.dao;

import cn.hibernate.entity.House;
import cn.hibernate.uitl.BaseDao;

import java.util.List;

public class HouseDao extends BaseDao {

    public   void  save(House house){
        this.currentSession().save(house);
    }

}
