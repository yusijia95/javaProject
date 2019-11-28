package dao;

import database.Admin;
import database.Student;
import database.examine;

import java.util.List;

public interface AdminDao {
    public boolean add(Admin admin);
    public boolean delete(Admin admin);
    public boolean updateStu(Integer stuId,String stuName,String newStuName,Integer stuScore);
    public Student selectStu(Integer stuId,String stuName);
    public List<Student> selectStuName(String stuName);
    public boolean login(String admName,String admPassword);
    public boolean addStudent(List<Student> list);
    public boolean delStudent(List<Student> list);
    public boolean addExamine(List<examine> list);
    public List<examine> selectAllExamine();
    public List<examine> selectExamineKey(String string);
    public boolean delExamine(List<examine> list);
    public boolean upExamine(List<examine> list);

}
