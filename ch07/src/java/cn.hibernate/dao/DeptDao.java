package cn.hibernate.dao;



import cn.hibernate.entity.Dept;
import cn.hibernate.uitl.BaseDao;

import java.io.Serializable;
import java.util.UUID;

public class DeptDao extends BaseDao {

    public void  save(Dept dept){
        this.currentSession().save(dept);
    }

    public Dept load(Serializable deptNo){
        return this.currentSession().load(Dept.class,deptNo);
    }

    public void  delete(Dept dept){
        this.currentSession().delete(this.load(dept.getDeptNo()));
    }


}
