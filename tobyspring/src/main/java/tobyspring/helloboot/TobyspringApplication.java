package tobyspring.helloboot;


import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import tobyspring.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class TobyspringApplication {

@Bean
    ApplicationRunner applicationRunner(Environment env){
    return args -> {
      String name = env.getProperty("my.name");
      System.out.println("my.name : "+ name);
    };
}
    public static void main(String[] args) {
        SpringApplication.run(TobyspringApplication.class, args);
    }


}
