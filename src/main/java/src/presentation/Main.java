package src.presentation;
import src.AppConfig;
import src.application.ApplicationService;
import com.sun.javafx.binding.StringFormatter;
import src.domain.StudentEntity;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationService service = applicationContext.getBean(ApplicationService.class);
        System.out.println("Начальноесостояниебазыданных");
        printStudentList(service.getAll());
        System.out.println("\nУдаляемстудентовсименамина \"К\"");
        service.removeEntitiesWithKChar();
        System.out.println("Добавляемкименамстундентовна \"Е\" слово \"_3\"");
        service.changeEntitiesWithEChar();
        System.out.println("Иполучаем");
        printStudentList(service.getAll());
    }
    public static void printStudentList(List<StudentEntity> list){
        System.out.println("|----|----------------|----------------|");
        System.out.println("|ID |First Name |Last Name |");
        System.out.println("|----|----------------|----------------|");
        for (StudentEntity student : list) {
            String s = StringFormatter.format(
                    "|%4d|%16s|%16s|",
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName()
            ).get();
            System.out.println(s);
        }
        System.out.println("|----|----------------|----------------|");
    }
}
