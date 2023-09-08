package gerousia.config;

import gerousia.proxies.CommentNotificationProxy;
import gerousia.repository.CommentRepository;
import gerousia.services.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {"gerousia.proxies", "gerousia.repository", "gerousia.services"})
public class ProjectConfig {

    @Bean
    CommentService commentService(
            CommentRepository commentRepository,
            @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        return new CommentService(
                commentRepository,
                commentNotificationProxy);
    }
}
