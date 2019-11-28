package service;

import database.Student;
import database.examine;

import java.util.List;

public interface StuService {
    public boolean add(Student student);
    public boolean delete(String stuName,Integer stuId);
    public boolean update(Integer stuId,String stuName,String newStuName,String NewStuPassword);
    public Integer select(String stuName,String stuPassword);
    public boolean login(String stuName,String stuPassword);
    public List<examine> test();
    public boolean updateScore(Student student);
}
