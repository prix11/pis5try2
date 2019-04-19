package src.application;
import src.domain.StudentEntity;
import src.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private StudentRepository repository;
    public void removeEntitiesWithKChar() {
        List<StudentEntity> students = repository.getStudents();
        for (StudentEntity student : students) {
            if (student.getFirstName().startsWith("К")) {
                repository.removeStudent(student);
            }
        }
    }
    public void changeEntitiesWithEChar() {
        List<StudentEntity> list = repository.getStudents();
        for (StudentEntity student : list) {
            if (student.getFirstName().startsWith("Е")) {
                student.setFirstName(student.getFirstName() + "_3");
                repository.editStudent(student);
            }
        }
    }
    public List<StudentEntity>getAll() {
        return repository.getStudents();
    }
}
