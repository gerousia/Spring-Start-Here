package gerousia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {"gerousia.proxies", "gerousia.repository", "gerousia.services"})
public class ProjectConfig {}
