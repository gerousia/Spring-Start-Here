package gerousia.config;

import gerousia.proxies.CommentNotificationProxy;
import gerousia.proxies.EmailCommentNotificationProxy;
import gerousia.repository.CommentRepository;
import gerousia.repository.DBCommentRepository;
import gerousia.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {"gerousia.proxies", "gerousia.repository", "gerousia.services"})
public class ProjectConfig {

    @Bean
    CommentRepository commentRepository() {
        return new DBCommentRepository();
    }

    @Bean
    CommentNotificationProxy commentNotificationProxy() {
        return new EmailCommentNotificationProxy();
    }

    @Bean
    CommentService commentService(
            CommentRepository commentRepository,
            CommentNotificationProxy commentNotificationProxy) {
        return new CommentService(
                commentRepository,
                commentNotificationProxy);
    }
}
