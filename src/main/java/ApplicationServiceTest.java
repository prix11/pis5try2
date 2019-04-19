import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
        import src.application.ApplicationService;
        import src.application.ApplicationServiceImpl;
        import src.domain.StudentEntity;
        import src.domain.StudentRepository;
        import java.util.ArrayList;
        import java.util.List;
        import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceTest {
@Mock
private StudentRepository repository;
@InjectMocks
private ApplicationService service = new ApplicationServiceImpl();
        private List<StudentEntity>createStudentList(String... name) {
        List<StudentEntity>list = new ArrayList<StudentEntity>();
        for (int i = 0; i <name.length; i++) {
        StudentEntity entity = new StudentEntity();
        entity.setId(i + 1);
        entity.setFirstName(name[i]);
        entity.setLastName(name[i]);
        list.add(entity);
        }
        return list;
        }
@Test
public void testCallRemoveEntitiesWithKChar() {
        List<StudentEntity>mockStudentList = createStudentList("Карп", "Ерофей",
        "Иосиф", "Егор", "Кузьма", "Адам");
        when(repository.getStudents()).thenReturn(mockStudentList);
        service.removeEntitiesWithKChar();
        verify(repository).getStudents();
        verify(repository).removeStudent(mockStudentList.get(0));
        verify(repository, never()).removeStudent(mockStudentList.get(1));
        verify(repository, never()).removeStudent(mockStudentList.get(2));
        verify(repository, never()).removeStudent(mockStudentList.get(3));
        verify(repository).removeStudent(mockStudentList.get(4));
        verify(repository, never()).removeStudent(mockStudentList.get(5));
        }
@Test
public void testWithoutNeededEntityRemoveEntitiesWithKChar() {
        List<StudentEntity>mockStudentList = createStudentList("Филимон", "Иосиф",
        "Ерофей", "Нестор", "Адам");
        when(repository.getStudents()).thenReturn(mockStudentList);
        service.removeEntitiesWithKChar();
        verify(repository).getStudents();
        verify(repository, never()).removeStudent(any(StudentEntity.class));
        }
@Test
public void testEmptyListRemoveEntitiesWithKChar() {
        List<StudentEntity>mockStudentList = createStudentList();
        when(repository.getStudents()).thenReturn(mockStudentList);
        service.removeEntitiesWithKChar();
        verify(repository).getStudents();
        verify(repository, never()).removeStudent(any(StudentEntity.class));
        }
@Test
public void testCallChangeEntitiesWithEChar() {
        List<StudentEntity>mockStudentList = createStudentList("Карп", "Ерофей",
        "Иосиф", "Егор", "Кузьма", "Адам");
        when(repository.getStudents()).thenReturn(mockStudentList);
        service.changeEntitiesWithEChar();
        verify(repository).getStudents();
        verify(repository, never()).editStudent(mockStudentList.get(0));
        verify(repository).editStudent(mockStudentList.get(1));
        verify(repository, never()).editStudent(mockStudentList.get(2));
        verify(repository).editStudent(mockStudentList.get(3));
        verify(repository, never()).editStudent(mockStudentList.get(4));
        verify(repository, never()).editStudent(mockStudentList.get(5));
        }
@Test
public void testWithoutNeededEntityChangeEntitiesWithEChar() {
        List<StudentEntity>mockStudentList = createStudentList("Филимон", "Иосиф",
        "Кузьма", "Нестор", "Адам");
        when(repository.getStudents()).thenReturn(mockStudentList);
        service.changeEntitiesWithEChar();
        verify(repository).getStudents();
        verify(repository, never()).editStudent(any(StudentEntity.class));
        }
@Test
public void testEmptyListChangeEntitiesWithEChar() {
        List<StudentEntity>mockStudentList = createStudentList();
        when(repository.getStudents()).thenReturn(mockStudentList);
        service.changeEntitiesWithEChar();
        verify(repository).getStudents();
        verify(repository, never()).editStudent(any(StudentEntity.class));
        }
        }
