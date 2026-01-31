import config.AppConfig;

import model.space.Alien;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // Instead of XML file, the AnnotationConfig application context works with Java class for the creation of beans
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Alien alien = applicationContext.getBean(Alien.class);
        alien.coding();
    }
}
