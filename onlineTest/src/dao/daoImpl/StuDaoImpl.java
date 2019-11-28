package dao.daoImpl;

import dao.StuDao;
import database.Student;
import database.examine;
import util.C3p0_Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StuDaoImpl implements StuDao {
    Connection connection = null;
    PreparedStatement statement = null;

    @Override
    public boolean add(Student student) {
        try {
            String str = "insert into student(stuName,stuPassword) values (?,?)";
            connection = C3p0_Util.getConnection();
            statement = connection.prepareStatement(str);
            statement.setString(1, student.getStuName());
            statement.setString(2, student.getStuPassword());
            int result = statement.executeUpdate();
            if (result != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(String stuName, Integer stuId) {
        String str = "delete from student where stuName=? && stuId=?";
        try {
            connection = C3p0_Util.getConnection();
            statement = connection.prepareStatement(str);
            statement.setString(1, stuName);
            statement.setInt(2, stuId);
            int result = statement.executeUpdate();
            if (result != 0) {
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
    public boolean update(Integer stuId, String stuName, String newStuName, String newStuPassword) {
        String str = "update student set stuName=?,stuPassword=? where stuId=? && stuName=? ";
        try {
            connection = C3p0_Util.getConnection();
            statement = connection.prepareStatement(str);
            statement.setString(1, newStuName);
            statement.setString(2, newStuPassword);
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
    public Integer select(String stuName, String stuPassword) {
        String str = "select stuScore from student where stuName=? && stuPassword=?";
        ResultSet set=null;
        try {
            connection = C3p0_Util.getConnection();
            statement = connection.prepareStatement(str);
            statement.setString(1, stuName);
            statement.setString(2, stuPassword);
            set = statement.executeQuery();
            if(set.next()){
                return set.getInt(1);
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
        return 0;
    }

    @Override
    public boolean login(String stuName, String stuPassword) {
        String str = "select * from student where stuName=? && stuPassword=?";
        ResultSet set = null;
        try {
            connection = C3p0_Util.getConnection();
            statement = connection.prepareStatement(str);
            statement.setString(1, stuName);
            statement.setString(2, stuPassword);
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
    public List<examine> test() {
        List<examine> list = new ArrayList<>();
        List<examine> listmysql = new ArrayList<>();
        ResultSet set = null;
        Set<Integer> hasSet = new HashSet<Integer>();
        try {
            connection = C3p0_Util.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String str = "select * from examine ";
            try {
                statement = connection.prepareStatement(str);
                set = statement.executeQuery();
                while (set.next()) {
                    listmysql.add(new examine(set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        while (hasSet.size() < 20) {
            hasSet.add((Integer) (int) (listmysql.size() * Math.random()));
        }
        for (Integer in:hasSet) {
            list.add(listmysql.get(in));
        }
        return list;
    }

    @Override
    public boolean updateScore(Student student) {
        String str = "update student set stuScore=?,startTime=?,endTime=? where stuName=? && stuPassword=? ";
        try {
            connection = C3p0_Util.getConnection();
            statement = connection.prepareStatement(str);
            statement.setString(4, student.getStuName());
            statement.setString(5, student.getStuPassword());
            statement.setInt(1, student.getStuScore());
            statement.setTimestamp(2,new java.sql.Timestamp(student.getStartTime().getTime()));
            statement.setTimestamp(3,new java.sql.Timestamp(student.getEndTime().getTime()));
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
}
