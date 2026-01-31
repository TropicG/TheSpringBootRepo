import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // creates the IoC container and it will look for xml resource file so that Spring can manage the classes
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // applicationContext will search for Alien in the xml file
        Alien alien = applicationContext.getBean(Alien.class);
        alien.code();
    }
}
