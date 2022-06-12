package pl.pjatk.movies.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class MovieConfig {
    @Bean
    public Docket get(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/db_movies/**"))
                .build().apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo(){
        return new ApiInfo(
                "Movies API",
                "Movies DB",
                "1.00",
                "TOS",
                new Contact("Mikołaj","default url","s22982@pjwstk.edu.pl"),
                "my own licence",
                "default url",
                Collections.emptyList()
        );
    }
}
