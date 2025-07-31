package app.labs.dept.service;

import java.util.List;

import app.labs.dept.model.Dept;

public interface DeptService {
	int getDeptCount();
    int getDeptCount(int deptno);
    
    List<Dept> getDeptList();
    Dept getDeptInfo(int deptno);
    
    void updateDept(Dept dept);
    void insertDept(Dept dept);
    int deleteDept(int deptno);
}
