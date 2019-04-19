package src;
import org.hibernate.SessionFactory;
import src.application.ApplicationService;
import src.application.ApplicationServiceImpl;
import src.domain.StudentRepository;
import src.domain.StudentRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan("java")
public class AppConfig {
    @Bean
    public ApplicationService getApplicationService(){
        return new ApplicationServiceImpl();
    }
    @Bean
    public StudentRepository getStudentRepository(){
        return new StudentRepositoryImpl();
    }
    @Bean
    public SessionFactory getHibernateSessionFactory() {
        return HibernateSessionFactory.getSessionFactory();
    }}