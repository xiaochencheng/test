import cn.hibernate.entity.Dept;
import cn.hibernate.entity.Emp;
import cn.hibernate.service.DeptBiz;
import org.junit.Test;

import java.util.Date;

public class TestDept {
    @Test
    public  void  testDeptFindAll(){
        DeptBiz deptBiz=new DeptBiz();
        deptBiz.getAllFindDetp();
    }

    @Test
    public  void  testDeptFindAll_2(){
        DeptBiz deptBiz=new DeptBiz();
        deptBiz.getAllFindDetp_2();
    }

    @Test
    public  void  testDeptFindAll_WaiLian(){
        DeptBiz deptBiz=new DeptBiz();
        deptBiz.getWaiJoin();
    }

    @Test
    public  void  testDeptFindAll_GroudBy(){
        DeptBiz deptBiz=new DeptBiz();
        deptBiz.getWaiJoin_GroupBy();
    }

    @Test
    public  void  testDeptFindAll_GroudBy2(){
        DeptBiz deptBiz=new DeptBiz();
        deptBiz.getAllFindDetp_GroupBy();
    }

    @Test
    public  void  testDeptFindAll_GroudBy3(){
        DeptBiz deptBiz=new DeptBiz();
        deptBiz.getAllFindDetp_GroupBy3();
    }

    @Test
    public  void  testDeptFindAll_GroudBy4(){
        DeptBiz deptBiz=new DeptBiz();
        deptBiz.getAllFindDetp_GroupBy4();
    }

    @Test
    public  void  testDeptFindAll_InnerJoin(){
        DeptBiz deptBiz=new DeptBiz();
        deptBiz.getWaiJoin_InnerJoin();
    }

    @Test
    public  void  testDeptFindAll_InnerJoin2(){
        DeptBiz deptBiz=new DeptBiz();
        deptBiz.getWaiJoin_InnerJoin2();
    }

    @Test
    public  void  testDeptFindAll_Size(){
        DeptBiz deptBiz=new DeptBiz();
        deptBiz.getWaiJoin_Size();
    }

    @Test
    public  void  testDeptFindAll_Size1(){
        DeptBiz deptBiz=new DeptBiz();
        deptBiz.getWaiJoin_Size1();
    }

    @Test
    public  void tests(){
        Dept dept=new Dept(32,"SALES");
        Emp emp=new Emp();
        emp.setENAME("OKOKOK");
        emp.setHIREDATE(new Date());
        dept.getEmps().add(emp);
        emp.setDept(dept);
        new DeptBiz().addNewDept(dept);
    }
}
