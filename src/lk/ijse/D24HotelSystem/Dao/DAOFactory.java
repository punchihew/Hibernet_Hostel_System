package lk.ijse.D24HotelSystem.Dao;

import lk.ijse.D24HotelSystem.Dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getInstance(){
        if (daoFactory==null) {
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
        Student,Rooms,Reservation,Users,Query
    }


    public  SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case Student :
                return new StudentDAOImpl();
            case Rooms:
                return new RoomsDAOImpl();
            case Reservation:
                return new ReservationDAOImpl();
            case Users:
                return new UserDAOImpl();
            case Query:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
