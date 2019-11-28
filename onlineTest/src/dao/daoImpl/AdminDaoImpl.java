package dao.daoImpl;

import dao.AdminDao;
import database.Admin;
import database.Student;
import database.examine;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3p0_Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    Connection connection = null;
    PreparedStatement statement = null;

    @Override
    public boolean add(Admin admin) {
        return false;
    }

    @Override
    public boolean delete(Admin admin) {
        return false;
    }

    @Override
    public boolean updateStu(Integer stuId, String stuName, String newStuName, Integer stuScore) {
        String str = "update student set stuName=?,stuScore=? where stuId=? && stuName=? ";
        try {
            connection = C3p0_Util.getConnection();
            statement = connection.prepareStatement(str);
            statement.setString(1, newStuName);
            statement.setInt(2, stuScore);
            statement.setInt(3, stuId);
            statement.setString(4, stuName);
            int result = statement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public Student selectStu(Integer stuId, String stuName) {
        Student student = new Student();
        String str = "select * from student where stuId=? && stuName=?";
        ResultSet set = null;
        try {
            connection = C3p0_Util.getConnection();
            statement = connection.prepareStatement(str);
            statement.setInt(1, stuId);
            statement.setString(2, stuName);
            set = statement.executeQuery();
            System.out.println(stuId);
            if (set.next()) {
                student.setStuId(set.getInt(1));
                student.setStuName(set.getString(2));
                student.setStuScore(set.getInt(3));
                System.out.println(student.getStuId());
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return student;
    }

    @Override
    public List<Student> selectStuName(String stuName) {
        List<Student> list = new ArrayList<>();
        String str = "select * from student where stuName=?";
        ResultSet set = null;
        try {
            connection = C3p0_Util.getConnection();
            statement = connection.prepareStatement(str);
            statement.setString(1, stuName);
            set = statement.executeQuery();
            while (set.next()) {
                Student student = new Student();
                student.setStuId(set.getInt(1));
                student.setStuName(set.getString(2));
                student.setStuScore(set.getInt(3));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public boolean login(String admName, String admPassword) {
        String str = "select * from admin where adminName=? && adminPassword=?";
        ResultSet set = null;
        try {
            connection = C3p0_Util.getConnection();
            statement = connection.prepareStatement(str);
            statement.setString(1, admName);
            statement.setString(2, admPassword);
            set = statement.executeQuery();
            if (set.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean addStudent(List<Student> list) {
        String str = "insert into student(stuName) values (?)";
        try {
            connection = C3p0_Util.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        QueryRunner query = new QueryRunner();
        Object[][] obj = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            obj[i] = new Object[]{list.get(i).getStuName()};
        }
        try {
            int[] count = query.batch(connection, str, obj);
            if (count.length > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean delStudent(List<Student> list) {
        String string = "delete from student where stuId=?";
        try {
            connection = C3p0_Util.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("*******list");
        System.out.println(list);
        QueryRunner query = new QueryRunner();
        Object[][] obj = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            obj[i] = new Object[]{list.get(i).getStuId()};
        }
        try {
            int[] count = query.batch(connection, string, obj);
            System.out.println(count);
            if (count.length > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean addExamine(List<examine> list) {
        String str = "insert into examine(content,A,B,C,D,Answer) values (?,?,?,?,?,?)";
        try {
            connection = C3p0_Util.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        QueryRunner query = new QueryRunner();
        Object[][] obj = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            obj[i] = new Object[]{list.get(i).getContent(), list.get(i).getA(), list.get(i).getB(), list.get(i).getC(), list.get(i).getD(), list.get(i).getAnswer()};
        }
        try {
            int[] count = query.batch(connection, str, obj);
            if (count.length > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public List<examine> selectAllExamine() {
        List<examine> list = new ArrayList<>();
        String str = "select e.eId,e.content from examine e ";
        QueryRunner query = new QueryRunner();
        try {
            connection = C3p0_Util.getConnection();
            list = query.query(connection, str, new BeanListHandler<examine>(examine.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<examine> selectExamineKey(String string) {
        List<examine> list = new ArrayList<>();
        String str = "select * from examine where content like ? || A like ? || B like ? ||C like ? || D like ? ";
        QueryRunner query = new QueryRunner();
        System.out.println(string);
        try {
            connection = C3p0_Util.getConnection();
            list = query.query(connection, str, new BeanListHandler<examine>(examine.class), "%" + string + "%", "%" + string + "%", "%" + string + "%", "%" + string + "%", "%" + string + "%");
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delExamine(List<examine> list) {
        String string = "delete from examine where eId=?";
        try {
            connection = C3p0_Util.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("*******list");
        System.out.println(list);
        QueryRunner query = new QueryRunner();
        Object[][] obj = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            obj[i] = new Object[]{list.get(i).geteId()};
        }
        try {
            int[] count = query.batch(connection, string, obj);
            System.out.println(count);
            if (count.length > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean upExamine(List<examine> list) {
        String str = "update examine set content=?,A=?,B=?,C=?,D=?,Answer=? where eId=? ";
        QueryRunner query=new QueryRunner();
        Object [] [] obj=new Object[list.size()][];
        System.out.println(list);
        for (int i = 0; i <list.size() ; i++) {
            obj[i]=new Object[]{list.get(i).getContent(),list.get(i).getA(),list.get(i).getB(),list.get(i).getC(),list.get(i).getD(),list.get(i).getAnswer(),list.get(i).geteId()};
        }
        try {
            connection=C3p0_Util.getConnection();
            int [] count=query.batch(connection,str,obj);
            if(count.length>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
