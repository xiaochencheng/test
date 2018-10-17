package cn.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "DEPT")
public class Dept implements Serializable {
    @Id
    @Column(name = "DEPTNO")
    private  Integer deptNo;
    @Column(name = "deptName")
    private  String deptName;
    @Column(name = "location")
    private  String location;
    @OneToMany(mappedBy = "dept",cascade = {CascadeType.ALL})
    private Set<Emp> emps=new HashSet<Emp>();

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getLocation() {
        return location;
    }

    public Dept() {
    }

    public Dept(Integer deptNo, String deptName) {
        this.deptNo = deptNo;
        this.deptName = deptName;
    }

    public Dept(Integer deptNo, String deptName, String location) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.location = location;
    }
}
