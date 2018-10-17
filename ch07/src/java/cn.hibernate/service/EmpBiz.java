package cn.hibernate.service;

import cn.hibernate.dao.DeptDao;
import cn.hibernate.dao.EmpDao;
import cn.hibernate.entity.Dept;
import cn.hibernate.entity.Emp;
import org.hibernate.HibernateError;
import org.hibernate.Transaction;

import java.util.List;

public class EmpBiz {
    private EmpDao empDao=new EmpDao();

    public  void addNewEmp(Emp emp){
        Transaction tx=null;
        try {
            tx=empDao.currentSession().beginTransaction();
            empDao.save(emp);
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
    }

}
