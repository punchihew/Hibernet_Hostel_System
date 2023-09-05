package lk.ijse.D24HotelSystem.Bo;

import lk.ijse.D24HotelSystem.Bo.custom.impl.*;

public class BOFactory {
    private static BOFactory BOFactory;

    public BOFactory() {
    }

    public static BOFactory getInstance(){
        if (BOFactory ==null) {
            BOFactory =new BOFactory();
        }
        return BOFactory;
    }

    public enum BOTypes {
        Student,Rooms,Reservation,Users,Login
    }


    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case Student :
                return new StudentBOImpl();
            case Rooms:
                return new RoomsBOImpl();
            case Reservation:
                return new ReservationBOImpl();
            case Users:
                return new UsersBOImpl();
            case Login:
                return new LoginBOImpl();
            default:
                return null;
        }
    }
}
