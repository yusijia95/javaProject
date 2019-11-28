package controller.controllerImpl;

import controller.AdmControl;
import database.Student;
import database.examine;
import service.AdmService;
import service.serviceImpl.AdmServiceImpl;

import java.util.List;

public class AdmControlImpl implements AdmControl {
    AdmService admService = new AdmServiceImpl();

    @Override
    public boolean login(String admName, String admPassword) {
        if (admService.login(admName, admPassword)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStu(Integer stuId, String stuName, String newStuName, Integer stuScore) {
        if (admService.updateStu(stuId, stuName, newStuName, stuScore)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addStudent(List<Student> list) {
        if (admService.addStudent(list)) {
            return true;
        }
        return false;
    }

    @Override
    public Student selectStu(Integer stuId, String stuName) {
        return admService.selectStu(stuId, stuName);
    }

    @Override
    public List<Student> selectStuName(String stuName) {
        return admService.selectStuName(stuName);
    }

    @Override
    public boolean delStudent(List<Student> list) {
        return admService.delStudent(list);
    }

    @Override
    public boolean addExamine(List<examine> list) {
        if(admService.addExamine(list)){
            return true;
        }
        return false;
    }

    @Override
    public List<examine> selectAllExamine() {
        return admService.selectAllExamine();
    }

    @Override
    public List<examine> selectExamineKey(String string) {
        return admService.selectExamineKey(string);
    }

    @Override
    public boolean delExamine(List<examine> list) {
        if(admService.delExamine(list)){
            return true;
        }
        return false;
    }

    @Override
    public boolean upExamine(List<examine> list) {
        if(admService.upExamine(list)){
            return true;
        }
        return false;
    }
}
