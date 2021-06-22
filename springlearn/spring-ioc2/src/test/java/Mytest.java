import com.liuxinchi.pojo.User;
import com.liuxinchi.pojo.UserT;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserT user = (UserT) context.getBean("user2");
        user.show();
        ((AbstractApplicationContext) context).close();
    }
}
