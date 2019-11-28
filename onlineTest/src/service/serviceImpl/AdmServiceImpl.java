package service.serviceImpl;

import dao.AdminDao;
import dao.daoImpl.AdminDaoImpl;
import database.Student;
import database.examine;
import service.AdmService;

import java.util.List;

public class AdmServiceImpl implements AdmService {
    AdminDao adminDao= new AdminDaoImpl();
    @Override
    public boolean login(String admName, String admPassword) {
        if (adminDao.login(admName,admPassword)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStu(Integer stuId, String stuName, String newStuName, Integer stuScore) {
        if(adminDao.updateStu(stuId, stuName, newStuName, stuScore)){
            return true;
        }
        return false;
    }

    @Override
    public boolean addStudent(List<Student> list) {
        if(adminDao.addStudent(list)){
            return true;
        }
        return false;
    }

    @Override
    public Student selectStu(Integer stuId, String stuName) {
        return adminDao.selectStu(stuId, stuName);
    }

    @Override
    public List<Student> selectStuName(String stuName) {
        return adminDao.selectStuName(stuName);
    }

    @Override
    public boolean delStudent(List<Student> list) {
        return adminDao.delStudent(list);
    }

    @Override
    public boolean addExamine(List<examine> list) {
        if(adminDao.addExamine(list)){
            return true;
        }
        return false;
    }

    @Override
    public List<examine> selectAllExamine() {
        return adminDao.selectAllExamine();
    }

    @Override
    public List<examine> selectExamineKey(String string) {
        return adminDao.selectExamineKey(string);
    }

    @Override
    public boolean delExamine(List<examine> list) {
        if(adminDao.delExamine(list)){
            return true;
        }
        return false;
    }

    @Override
    public boolean upExamine(List<examine> list) {
        if(adminDao.upExamine(list)){
            return true;
        }
        return false;
    }
}
