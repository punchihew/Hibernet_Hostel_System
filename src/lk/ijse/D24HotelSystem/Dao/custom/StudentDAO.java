package lk.ijse.D24HotelSystem.Dao.custom;

import lk.ijse.D24HotelSystem.Dao.CrudDAO;
import lk.ijse.D24HotelSystem.Entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {
    void setSession(Session session) throws Exception;
    List<String> getIds() throws Exception;
}
