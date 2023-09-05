package lk.ijse.D24HotelSystem.Dao.custom.impl;

import lk.ijse.d24hostelsystem.dao.CrudDAO;
import lk.ijse.d24hostelsystem.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {
    void setSession(Session session) throws Exception;
    List<String> getIds() throws Exception;
}
