import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {

        User u1 = new User(1,"a",21);
        User u2 = new User(2,"b", 22);
        User u3 = new User(3,"c", 23);
        User u4 = new User(4,"d", 24);
        User u5 = new User(5,"e", 25);
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        //计算交给 stream流
        list.stream().
        filter(u->{return u.getId()%2==0;}).
        filter(u->{return u.getAge()>=22;}).
        map(u->{return u.getName().toUpperCase();}).
        sorted((uu1,uu2)->{return uu2.compareTo(uu1);}).
        limit(1).
        forEach(System.out::println);
    }
}

class User{
    int id;
    String name;
    int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}