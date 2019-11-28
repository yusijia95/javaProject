package service.serviceImpl;

import dao.daoImpl.StuDaoImpl;
import database.Student;
import database.examine;
import service.StuService;

import java.util.List;

public class StuServiceImpl implements StuService {
    StuDaoImpl studao = new StuDaoImpl();

    @Override
    public boolean add(Student student) {
        if (studao.add(student)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String stuName,Integer stuId) {
        if (studao.delete(stuName,stuId)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Integer stuId,String stuName,String newStuName,String NewStuPassword) {
        if (studao.update(stuId, stuName, newStuName,  NewStuPassword)) {
            return true;
        }
        return false;
    }

    @Override
    public Integer select(String stuName,String stuPassword) {
        return studao.select(stuName,stuPassword);
    }

    @Override
    public boolean login(String stuName, String stuPassword) {
        if (studao.login(stuName,stuPassword)) {
            return true;
        }
        return false;
    }

    @Override
    public List<examine> test() {
        List<examine> list=studao.test();
        return list ;
    }

    @Override
    public boolean updateScore(Student student) {
        if(studao.updateScore(student)){
            return true;
        }
        return false;
    }
}
