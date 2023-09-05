package lk.ijse.D24HotelSystem.Dao.custom.impl;


import lk.ijse.D24HotelSystem.Dao.CrudDAO;
import lk.ijse.D24HotelSystem.Entity.Reservation;
import org.hibernate.Session;

public interface ReservationDAO extends CrudDAO<Reservation> {
    void setSession(Session session) throws Exception;
    boolean changePaidStatus(String id, String status);
}
