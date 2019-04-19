package src.application;
import src.domain.StudentEntity;
import java.util.List;
public interface ApplicationService {
    void removeEntitiesWithKChar();
    void changeEntitiesWithEChar();
    List<StudentEntity>getAll();
}
