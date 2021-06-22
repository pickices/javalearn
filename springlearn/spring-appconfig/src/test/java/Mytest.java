import com.liuxinchi.configer.Myconfig;
import com.liuxinchi.pojo.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
        User getuser = (User) context.getBean("getUser");
        User user = (User) context.getBean("user");
        System.out.println(getuser.getName());
        System.out.println(user);
        System.out.println(user == getuser);
    }
}
