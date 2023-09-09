package gerousia.config;

import gerousia.proxies.CommentNotificationProxy;
import gerousia.repository.CommentRepository;
import gerousia.services.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(
        basePackages = {"gerousia.proxies", "gerousia.repository", "gerousia.services"})
public class ProjectConfig {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    CommentService commentService() {
        return new CommentService();
    }
}
