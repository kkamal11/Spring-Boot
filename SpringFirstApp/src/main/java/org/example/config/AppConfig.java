package org.example.config;


import org.example.Desktop;
import org.springframework.context.annotation.Configuration;


//Java based configuration
@Configuration
public class AppConfig {

    public Desktop desktop(){
        return new Desktop();
    }
}
