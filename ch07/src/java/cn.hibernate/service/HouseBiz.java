package cn.hibernate.service;

import cn.hibernate.dao.HouseDao;
import cn.hibernate.entity.House;
import org.hibernate.HibernateError;
import org.hibernate.Transaction;

import java.util.List;

public class HouseBiz {

    private HouseDao houseDao=new HouseDao();
    Transaction tx=null;

    /**
     * 使用左外连接查询所有用户及其发布的房屋信息
     * @return
     */
    public List<Object[]> getUserHouseInfo(){
        List<Object[]> list=null;
        try {
            tx= houseDao.currentSession().beginTransaction();
            list=houseDao.currentSession().
                    createQuery("from User u left outer join House h on u.ID=h.USER_ID").list();
            for (Object[] objects : list) {
                System.out.println(objects[0]+"\t"+objects[1]);
            }
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
     return  list;
    }

    /**
     * 使用迫切左外连接查询所有用户及其发布的房屋信息
     * @return
     */
    public List<Object[]> getUserHouseInfo_fetch(){
        List<Object[]> list=null;
        try {
            tx= houseDao.currentSession().beginTransaction();
            list=houseDao.currentSession().
                    createQuery("from User u left outer join fetch House h on u.ID=h.USER_ID").list();
            for (Object[] objects : list) {
                System.out.println(objects[0]+"\t"+objects[1]);
            }
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return  list;
    }
    /**
     * 使用隐藏内连接查询所有用户及其发布的房屋信息
     * @return
     */
    public List<House> getUserHouseInfo_Nei(){
        List<House> list=null;
        try {
            tx= houseDao.currentSession().beginTransaction();
            list=houseDao.currentSession().createQuery("from House h where h.user.NAME=?")
                    .setString(0,"jbit").list();
            for (House objects : list) {
                System.out.println(objects.getID()+"\t"+objects.getDESCRIPTION()+"\t"+objects.getPUBDATE());
            }
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return  list;
    }

    /**
     * 统计房屋的平均价格、最高价格、最低价格
     * @return
     */
    public  List<Object[]> getHouseAvgMax(){
        List<Object[]> list=null;
        try {
            tx=houseDao.currentSession().beginTransaction();
            list=houseDao.currentSession()
                    .createQuery("select avg(PRICE),max(PRICE),min(PRICE) from House group by TITLE").list();
            for (Object[] objects : list) {
                System.out.println("平均："+objects[0]+"\t最大："+objects[1]+"\t最小："+objects[2]);
            }
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return list;
    }

    /**
     * 统计各个街道的房屋平均价格、最高价格、最低价格
     * @return
     */
    public  List<Object[]> getHouseAvgMax_Street(){
        List<Object[]> list=null;
        try {
            tx=houseDao.currentSession().beginTransaction();
            list=houseDao.currentSession()
                    .createQuery("select avg(PRICE),max(PRICE),min(PRICE) from House h group by STREET_ID").list();
            for (Object[] objects : list) {
                System.out.println("平均："+objects[0]+"\t最大："+objects[1]+"\t最小："+objects[2]);
            }
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return list;
    }

    /**
     * 统计各个区县的房屋平均价格、最高价格、最低价格
     * @return
     */
    public  List<Object[]> getHouseAvgMax_Street_Title(){
        List<Object[]> list=null;
        try {
            tx=houseDao.currentSession().beginTransaction();
            list=houseDao.currentSession()
                    .createQuery("select avg(PRICE),max(PRICE),min(PRICE) from House h group by TITLE").list();
            for (Object[] objects : list) {
                System.out.println("平均："+objects[0]+"\t最大："+objects[1]+"\t最小："+objects[2]);
            }
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return list;
    }

    /**
     * 查询有50条以上房屋信息的街道
     * @return
     */
    public  List<Object[]> getHouse(){
        List<Object[]> list=null;
        try {
            tx=houseDao.currentSession().beginTransaction();
            list=houseDao.currentSession()
                    .createQuery("select h.CONTACT,h.TITLE from House h where 2>any(select count(h.STREET_ID) from House h group by h.STREET_ID)").list();
            for (Object[] objects : list) {
                System.out.println(objects[0]+"\t"+objects[1]);
            }
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return list;
    }

    /**
     * 查询所有房屋租金高于2000元的街道
     * @return
     */
    public  List<House> getHouse_Money(){
        List<House> list=null;
        try {
            tx=houseDao.currentSession().beginTransaction();
            list=houseDao.currentSession()
                    .createQuery("from  House h where h.STREET_ID").list();
            for (House objects : list) {
                System.out.println(objects.getSTREET_ID());
            }
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return list;
    }

    /**
     * 查询至少有一条房屋的租金低于6000元的街道
     * @return
     */
    public  List<House> getHouse_Money100(){
        List<House> list=null;
        try {
            tx=houseDao.currentSession().beginTransaction();
            list=houseDao.currentSession()
                    .createQuery("from  House h where h.PRICE <=6000").list();
            for (House objects : list) {
                System.out.println(objects.getSTREET_ID());
            }
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return list;
    }

    /**
     * 统计各个街道的房屋信息条数
     * @return
     */
    public  List<Object[]> getHouse_HouseNum(){
        List<Object[]> list=null;
        try {
            tx=houseDao.currentSession().beginTransaction();
            list=houseDao.currentSession()
                    .createQuery("select h.STREET_ID,count(h.STREET_ID) from  House h where h.STREET_ID=any(select s.ID from Street s group by s.ID) group by h.STREET_ID").list();
            for (Object[] objects : list) {
                System.out.println(objects[0]+"\t"+objects[1]);
            }
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return list;
    }

    /**
     * 统计各个街道的房屋信息条数
     * @return
     */
    public  List<Long> getHouse_HouseNum600(){
        List<Long> list=null;
        try {
            tx=houseDao.currentSession().beginTransaction();
            list=houseDao.currentSession()
                    .createQuery("select count(1) from House h where h.STREET_ID=any(select s.ID from Street s group by s.ID) and h.PRICE>5000").list();
            for (Long objects : list) {
                System.out.println(objects);
            }
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return list;
    }
}
