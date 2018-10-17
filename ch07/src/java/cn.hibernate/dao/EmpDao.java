package cn.hibernate.dao;

import cn.hibernate.entity.Dept;
import cn.hibernate.entity.Emp;
import cn.hibernate.uitl.BaseDao;

import java.io.Serializable;
import java.util.List;

public class EmpDao extends BaseDao {
    public   void  save(Emp emp){
        this.currentSession().save(emp);
    }

    public void findByDept(Emp emp){
         this.currentSession().save(emp);
    }

    public  List<Emp> findAll(){
        return  this.currentSession().createQuery("from Emp").list();
    }

    public Emp load(Serializable empNo){
        return this.currentSession().load(Emp.class,empNo);
    }
}
