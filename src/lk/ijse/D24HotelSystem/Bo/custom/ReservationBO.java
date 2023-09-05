package lk.ijse.D24HotelSystem.Bo.custom;



import lk.ijse.D24HotelSystem.Bo.SuperBO;
import lk.ijse.D24HotelSystem.Dto.ReservationDTO;
import lk.ijse.D24HotelSystem.Dto.RoomDTO;
import lk.ijse.D24HotelSystem.Dto.StudentDTO;
import lk.ijse.D24HotelSystem.Projection.StudentDetailsDTO;

import java.util.List;

public interface ReservationBO extends SuperBO {
    List<ReservationDTO> loadAll() throws Exception;
    boolean saveReservation(ReservationDTO reservationDTO) throws Exception;
    boolean updateReservation(ReservationDTO reservationDTO) throws Exception;
    StudentDTO getStudent(String id) throws Exception;
    RoomDTO getRoom(String id) throws Exception;

    boolean deleteReservation(ReservationDTO reservationDTO) throws Exception;

    String generateNextReservationID() throws Exception;

    List<String> getStudentIds() throws Exception;

    List<String> getRoomIds() throws Exception;

    boolean updateRoomQty(RoomDTO roomDTO) throws Exception;

    List<StudentDetailsDTO> getUnpaidStudents();

    boolean changePaidStatus(String id,String status) throws Exception;
}
