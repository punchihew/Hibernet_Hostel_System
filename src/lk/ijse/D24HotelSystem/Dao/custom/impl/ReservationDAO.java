package lk.ijse.D24HotelSystem.Dao.custom.impl;


import lk.ijse.d24hostelsystem.dao.CrudDAO;
import lk.ijse.d24hostelsystem.entity.Reservation;
import org.hibernate.Session;

public interface ReservationDAO extends CrudDAO<Reservation> {
    void setSession(Session session) throws Exception;
    boolean changePaidStatus(String id, String status);
}
