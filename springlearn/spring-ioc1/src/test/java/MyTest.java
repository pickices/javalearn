import com.liuxinchi.service.UserService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.crypto.Data;
import java.util.Date;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userservice = (UserService) context.getBean("UserServiceImpl");
        userservice.getUser();
        ((AbstractApplicationContext) context).close();
    }



}
