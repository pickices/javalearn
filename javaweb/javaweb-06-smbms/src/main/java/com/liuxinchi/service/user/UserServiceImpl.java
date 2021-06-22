package com.liuxinchi.service.user;

import com.liuxinchi.dao.user.UserDao;
import com.liuxinchi.pojo.User;
import com.liuxinchi.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserServiceImpl implements UserService {

    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User userLogin(String userCode, String userPassword) {
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.userLogin(userCode, userPassword);
        return user;
    }

    @Override
    public boolean userUpdatePassword(String usercCode, String newPassword) {
        boolean flag = false;
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        if(mapper.userUpdatePassword(usercCode,newPassword)>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public int queryUsersCount(String userName, int userRole) {
        int count = 0;
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        count = mapper.queryUsersCount(userName,userRole);
        return count;
    }

    @Override
    public int queryUsersCount(String UserCode) {
        int count = 0;
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        count = mapper.queryUsersCountByCode(UserCode);
        return count;
    }

    @Override
    public int queryUsersCount(int id) {
        int count = 0;
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        count = mapper.queryUsersCountById(id);
        return count;
    }

    @Override
    public User queryUserById(int id) {
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.queryUserById(id);
        return user;
    }

    @Override
    public List<User> queryUsersList(String userName, int userRole, int currentCount, int pageSize) {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        List<User> userList = mapper.queryUsersList(userName,userRole,currentCount,pageSize);
//        sqlSession.close();
//        return userList;
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.queryUsersList(userName, userRole, currentCount, pageSize);
        return userList;
    }

    @Override
    public boolean insertUser(User user) {
        boolean flag = false;
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        if(mapper.insertUser(user)>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag = false;
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        if(mapper.updateUser(user)>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean flag =false;
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int count = mapper.deleteUser(id);
        if(count>0){
            flag = true;
        }
        return flag;
    }

    @Test
    public void mytest(){
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = userService.queryUsersList("系统",0,0,10);
        System.out.println(userList);
    }

}
