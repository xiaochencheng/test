package cn.hibernate.service;

import cn.hibernate.dao.DeptDao;
import cn.hibernate.entity.Dept;
import cn.hibernate.entity.Emp;
import cn.hibernate.uitl.HibernateUtil;
import org.hibernate.HibernateError;
import org.hibernate.Transaction;

import java.util.List;

public class DeptBiz {
    private DeptDao deptDao=new DeptDao();
    Transaction tx=null;

    /**
     * 内连接1
     */
    public void getAllFindDetp(){
        tx=HibernateUtil.currentSession().beginTransaction();
        try {
            List<Object[]> list=HibernateUtil.currentSession().createQuery("from Dept d inner join d.emps").list();
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
    }

    /**
     * 内连接2
     */
    public void getAllFindDetp_2(){
        tx=HibernateUtil.currentSession().beginTransaction();
        try {
            List<Dept> list=HibernateUtil.currentSession().createQuery("select distinct d from Dept d inner join fetch d.emps").list();
            for (Dept objects : list) {
                System.out.println(objects.getDeptName()+"\t"+objects.getEmps());
            }
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    /**
     * 外连接
     */
    public  void getWaiJoin(){
       tx=HibernateUtil.currentSession().beginTransaction();
       try {
           List<Emp> list=HibernateUtil.currentSession().createQuery("from Emp e where e.dept.deptName=?").setString(0,"SALES").list();
           for (Emp emp : list) {
               System.out.println(emp.getENAME()+"???????????????????????");
           }
           tx.commit();
       }catch (HibernateError e){
           e.printStackTrace();
           if(tx!=null){
               tx.rollback();
           }
       }
    }

    /**
     * 分组查询
     */
    public  void getWaiJoin_GroupBy(){
        tx=HibernateUtil.currentSession().beginTransaction();
        try {
                     //需要注意属性是否与实体类一致（大小写）
            List<Object []> list=HibernateUtil.currentSession().
                    createQuery("select e.JOB,COUNT(e) from Emp e group by e.JOB").list();
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
    }

    /**
     *分组查询2
     */
    public void getAllFindDetp_GroupBy(){
        tx=HibernateUtil.currentSession().beginTransaction();
        try {
            List<Object[]> list=HibernateUtil.currentSession()
                    .createQuery("select e.dept.deptName,avg(e.SAL) from Emp e group by e.dept.deptName").list();
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
    }

    /**
     *分组查询3
     */
    public void getAllFindDetp_GroupBy3(){
        tx=HibernateUtil.currentSession().beginTransaction();
        try {
            List<Object[]> list=HibernateUtil.currentSession()
                    .createQuery("select JOB,min(SAL),max(SAL) from Emp e group by JOB").list();
            for (Object[] objects : list) {
                System.out.println(objects[0]+"\t"+objects[1]+"\t"+objects[2]);
            }
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    /**
     *分组查询4
     */
    public void getAllFindDetp_GroupBy4(){
        tx=HibernateUtil.currentSession().beginTransaction();
        try {
            List<Object[]> list=HibernateUtil.currentSession()
                    .createQuery("select e.dept.deptName,avg(e.SAL) from Emp e group by e.dept.deptName having avg(e.SAL)>1000").list();
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
    }

    /**
     * 子查询1
     */
    public  void getWaiJoin_InnerJoin(){
        tx=HibernateUtil.currentSession().beginTransaction();
        try {
            List<Dept> list=HibernateUtil.currentSession().createQuery("from Dept d where 1000>all(select e.SAL from d.emps e)").list();
            for (Dept dept : list) {
                System.out.println(dept.getDeptName()+"???????????????????????");
            }
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    /**
     * 子查询2
     */
    public  void getWaiJoin_InnerJoin2(){
        tx=HibernateUtil.currentSession().beginTransaction();
        try {
            List<Dept> list=HibernateUtil.currentSession().createQuery("from Dept d where 1000>any(select e.SAL from d.emps e)").list();
            for (Dept dept : list) {
                System.out.println(dept.getDeptName()+"???????????????????????");
            }
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    /**
     * 操作集合的函数或属性
     */
    public  void getWaiJoin_Size(){
        Emp emp =new Emp();
        emp.setEMPNO(7369);
        tx=HibernateUtil.currentSession().beginTransaction();
        try {
            List<Dept> list=HibernateUtil.currentSession().createQuery("from Dept d where ? in elements(d.emps)").setParameter(0,emp).list();
            for (Dept dept : list) {
                System.out.println(dept.getDeptName()+"???????????????????????");
            }
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    /**
     * 操作集合的函数或属性
     */
    public  void getWaiJoin_Size1(){
        Emp emp =new Emp();
        emp.setEMPNO(7369);
        tx=HibernateUtil.currentSession().beginTransaction();
        try {
            List<Dept> list=HibernateUtil.currentSession().createQuery("from Dept d where d.emps.size>5").list();
            for (Dept dept : list) {
                System.out.println(dept.getDeptName()+"???????????????????????");
            }
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
    }

    public void  addNewDept(Dept dept){

        try {
            tx=deptDao.currentSession().beginTransaction();
            deptDao.save(dept);
            tx.commit();
        }catch (HibernateError e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
    }

}
