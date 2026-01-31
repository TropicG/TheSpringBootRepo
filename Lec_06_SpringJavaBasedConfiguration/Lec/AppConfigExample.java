package config;

import model.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// with this annotation Spring knows which Java class to access in order to manage beans
@Configuration
public class AppConfigExample {

    // This is the same approach as creating the bean in XML file, but this time we only need to create a constructor
    // This method is called by Spring and the rest is managed by Spring, the only thing that the programmer must do is to create new Object
    @Bean(name = "Desktop")
    public Desktop desktop() {
        return new Desktop();
    }
}
