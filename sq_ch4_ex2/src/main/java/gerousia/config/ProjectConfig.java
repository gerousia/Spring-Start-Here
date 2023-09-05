package gerousia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {"proxies", "repository", "services"})
public class ProjectConfig {}
