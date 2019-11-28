package controller.controllerImpl;

import controller.StuControl;
import database.Student;
import database.examine;
import service.serviceImpl.StuServiceImpl;

import java.util.List;

public class StuControlImpl implements StuControl {
    StuServiceImpl stuService = new StuServiceImpl();

    @Override
    public boolean add(Student student) {
        if (stuService.add(student)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String stuName, Integer stuId) {
        if (stuService.delete(stuName, stuId)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Integer stuId, String stuName, String newStuName, String NewStuPassword) {
        if (stuService.update(stuId, stuName, newStuName, NewStuPassword)) {
            return true;
        }
        return false;
    }

    @Override
    public Integer select(String stuName, String stuPassword) {
        return stuService.select(stuName, stuPassword);
    }

    @Override
    public boolean login(String stuName, String stuPassword) {
        if (stuService.login(stuName, stuPassword)) {
            return true;
        }
        return false;
    }

    @Override
    public List<examine> test() {
        List<examine> list = stuService.test();
        return list;
    }

    @Override
    public boolean updateScore(Student student) {
        if (stuService.updateScore(student)) {
            return true;
        }
        return false;
    }

}
