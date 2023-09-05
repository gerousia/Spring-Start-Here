package gerousia.config;

import gerousia.proxies.CommentNotificationProxy;
import gerousia.proxies.CommentPushNotificationProxy;
import gerousia.proxies.EmailCommentNotificationProxy;
import gerousia.repository.CommentRepository;
import gerousia.repository.DBCommentRepository;
import gerousia.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(
        basePackages = {"gerousia.proxies", "gerousia.repository", "gerousia.services"})
public class ProjectConfig {}
