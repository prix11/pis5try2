package src.domain;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    SessionFactory factory;
    public StudentEntity getStudent(int id) {
        return factory.getCurrentSession().find(StudentEntity.class, id);
    }
    @Transactional
    public void editStudent(StudentEntity updatedEntity) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.update(updatedEntity);
        session.getTransaction().commit();
    }
    @Transactional
    public void removeStudent(StudentEntity updatedEntity) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.remove(updatedEntity);
        session.getTransaction().commit();
    }
    @Transactional
    public List<StudentEntity> getStudents() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List list = session.createQuery("from StudentEntity").list();
        session.getTransaction().commit();
        return ((List<StudentEntity>) list);
    }
}