package cn.hibernate.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="`EMP`")
public class Emp implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_emp")
    @SequenceGenerator(name = "seq_emp",sequenceName = "seq_emp_id",allocationSize = 10,initialValue = 1)
    private  Integer EMPNO;
    @Column(name = "ENAME")
    private  String ENAME;
    @Column(name = "JOB")
    private  String JOB;
    @Column(name = "MGR")
    private  Long MGR;
    @Column(name = "HIREDATE")
    private  Date HIREDATE;
    @Column(name = "SAL")
    private  Long SAL;
    @Column(name = "COMM")
    private  Long COMM;
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPTNO")
    private  Dept dept;

    public Emp(Integer EMPNO, Dept dept) {
        this.EMPNO = EMPNO;
        this.dept = dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void setEMPNO(Integer EMPNO) {
        this.EMPNO = EMPNO;
    }

    public void setENAME(String ENAME) {
        this.ENAME = ENAME;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public void setMGR(Long MGR) {
        this.MGR = MGR;
    }

    public void setHIREDATE(Date HIREDATE) {
        this.HIREDATE = HIREDATE;
    }

    public void setSAL(Long SAL) {
        this.SAL = SAL;
    }

    public void setCOMM(Long COMM) {
        this.COMM = COMM;
    }

//    public void setDEPTNO(Long DEPTNO) {
//        this.DEPTNO = DEPTNO;
//    }

    public Integer getEMPNO() {
        return EMPNO;
    }

    public String getENAME() {
        return ENAME;
    }

    public String getJOB() {
        return JOB;
    }

    public Long getMGR() {
        return MGR;
    }

    public Date getHIREDATE() {
        return HIREDATE;
    }

    public Long getSAL() {
        return SAL;
    }

    public Long getCOMM() {
        return COMM;
    }

//    public Long getDEPTNO() {
//        return DEPTNO;
//    }

    public Emp() {
    }

}
