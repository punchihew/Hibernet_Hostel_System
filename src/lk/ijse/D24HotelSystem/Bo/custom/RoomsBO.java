package lk.ijse.D24HotelSystem.Bo.custom;



import lk.ijse.D24HotelSystem.Bo.SuperBO;
import lk.ijse.D24HotelSystem.Dto.RoomDTO;

import java.util.List;

public interface RoomsBO extends SuperBO {
    List<RoomDTO> loadAll() throws Exception;
    boolean saveRoom(RoomDTO roomDTO) throws Exception;
    boolean updateRoom(RoomDTO roomDTO) throws Exception;
    boolean deleteRoom(RoomDTO roomDTO) throws Exception;
    String generateNextRoomID() throws Exception;
}
