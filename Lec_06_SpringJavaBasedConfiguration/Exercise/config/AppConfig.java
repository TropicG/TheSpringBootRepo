package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// with this annotation Spring knows which Java class to access in order to manage beans
@Configuration
@ComponentScan("./")
public class AppConfig {
}
