import com.liuxinchi.pojo.People;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = (People) context.getBean("people");
        people.getCat().shout();
        people.getDog().shout();
    }
}
