package src.domain;

import java.util.List;
public interface StudentRepository {
    StudentEntity getStudent(int id);
    void editStudent(StudentEntity updatedEntity);
    void removeStudent(StudentEntity updatedEntity);
    List<StudentEntity>getStudents();
}