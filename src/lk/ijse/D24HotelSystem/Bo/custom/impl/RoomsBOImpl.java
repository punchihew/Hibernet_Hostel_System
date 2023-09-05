package lk.ijse.D24HotelSystem.Bo.custom.impl;


import lk.ijse.D24HotelSystem.Bo.custom.RoomsBO;
import lk.ijse.D24HotelSystem.Dao.DAOFactory;
import lk.ijse.D24HotelSystem.Dao.custom.RoomsDAO;
import lk.ijse.D24HotelSystem.Dto.RoomDTO;
import lk.ijse.D24HotelSystem.Entity.Room;
import lk.ijse.D24HotelSystem.Util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RoomsBOImpl implements RoomsBO {
    private Session session;
    RoomsDAO roomsDAO = (RoomsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Rooms);
    @Override
    public List<RoomDTO> loadAll() throws Exception {
        session= SessionFactoryConfig.getInstance().getSession();
        roomsDAO.setSession(session);
        List<Room> rooms = roomsDAO.loadAll();
        List<RoomDTO> roomDTOS=new ArrayList<>();

        for(Room room: rooms){
            roomDTOS.add(
              new RoomDTO(
                      room.getId(),
                      room.getType(),
                      room.getKeyMoney(),
                      room.getQty()
              )
            );
        }

        return roomDTOS;
    }

    @Override
    public boolean saveRoom(RoomDTO roomDTO) throws Exception {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            roomsDAO.setSession(session);
            roomsDAO.save(
                    new Room(
                            roomDTO.getId(),
                            roomDTO.getType(),
                            roomDTO.getKeyMoney(),
                            roomDTO.getQty()
                    )
            );
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
        }

        return false;
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) throws Exception {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            roomsDAO.setSession(session);
            roomsDAO.update(
                    new Room(
                            roomDTO.getId(),
                            roomDTO.getType(),
                            roomDTO.getKeyMoney(),
                            roomDTO.getQty()
                    )
            );
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
        }

        return false;
    }

    @Override
    public boolean deleteRoom(RoomDTO roomDTO) throws Exception {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            roomsDAO.setSession(session);
            roomsDAO.delete(
                    new Room(
                            roomDTO.getId(),
                            roomDTO.getType(),
                            roomDTO.getKeyMoney(),
                            roomDTO.getQty()
                    )
            );
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
        }

        return false;
    }

    @Override
    public String generateNextRoomID() throws Exception {
        session= SessionFactoryConfig.getInstance().getSession();
        roomsDAO.setSession(session);
        return roomsDAO.generateID();
    }
}
