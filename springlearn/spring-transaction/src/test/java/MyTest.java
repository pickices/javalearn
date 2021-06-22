import com.liuxinchi.dao.UserMapper;
import com.liuxinchi.pojo.User;
import org.apache.ibatis.transaction.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void getUserList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper usermapper = context.getBean("userMapper",UserMapper.class);
        List<User> userList = usermapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

    }
}
