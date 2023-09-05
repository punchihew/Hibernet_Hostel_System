package lk.ijse.D24HotelSystem.Dao.custom.impl;


import lk.ijse.d24hostelsystem.dao.CrudDAO;
import lk.ijse.d24hostelsystem.entity.Room;
import org.hibernate.Session;

import java.util.List;

public interface RoomsDAO extends CrudDAO<Room> {
    void setSession(Session session) throws Exception;
    List<String> getIds() throws Exception;
}
