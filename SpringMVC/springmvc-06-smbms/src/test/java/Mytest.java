import com.liuxinchi.pojo.User;
import com.liuxinchi.service.user.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.queryUserByName("系统管理员");
        System.out.println(user);
    }
}
