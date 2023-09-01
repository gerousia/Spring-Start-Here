# Spring Start Here

wip

## Topics

**Chapter 2** - Introduction to Spring Context
- A place in memory of the app which we add all the object instances and establish relationships that the framework will manage.
- ```@Configuration``` class, a special class used to instruct Spring to do specific actions. i.e. adding beans.
- Adding instances called *"beans"* to the Spring Context in three different ways:
    - Method-level ```@Bean``` annotation inside the ```@Configuration``` class;
    - Class-level ```@Component``` and ```@ComponentScan``` stereotype annotations;
    - and ```registerBeans()``` method.
- Bean lifecycle and JSR-250 Common Annotations:
    - ```@PostConstruct```, instructs Spring to call that method after the constructor finishes its execution.
    - ```@PreDestroy```, signal that the instance is in the process of being removed by the container.
- ```getBean()``` method to retrieve instances inside the Spring Context.


**Chapter 3** - Wiring Beans
- Establish relationships among beans in the Spring context.
- Three ways to establish bean relationships:
    - Directly refer to the ```@Bean``` annotated method.
    - Define a parameter in the ```@Bean``` method.
    - Use ```@Autowired``` annotation on fields, constructors, or setters.
- Spring uses *Dependency Injection* (DI) to provide values or references.
- Avoid *circular dependencies* between beans.
- Resolve conflicts when multiple beans of the same type exist:
    - Use ```@Primary``` annotation for default injection.
    - Use ```@Qualifier``` annotation with named beans.
