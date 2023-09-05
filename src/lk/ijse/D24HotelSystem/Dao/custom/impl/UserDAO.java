package lk.ijse.D24HotelSystem.Dao.custom.impl;


import lk.ijse.D24HotelSystem.Dao.CrudDAO;
import lk.ijse.D24HotelSystem.Entity.Users;
import org.hibernate.Session;

public interface UserDAO extends CrudDAO<Users> {
    void setSession(Session session) throws Exception;

    Users getUsers(String userName);

}
