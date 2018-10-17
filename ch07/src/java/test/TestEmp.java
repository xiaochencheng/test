import cn.hibernate.entity.Emp;
import cn.hibernate.service.EmpBiz;
import org.junit.Test;

import java.beans.Transient;
import java.util.Date;

public class TestEmp {
    @Test
    public void  testAll(){
        Emp emp=new Emp();
        emp.setENAME("SMITH");
        emp.setHIREDATE(new Date());
        new EmpBiz().addNewEmp(emp);
    }
}
