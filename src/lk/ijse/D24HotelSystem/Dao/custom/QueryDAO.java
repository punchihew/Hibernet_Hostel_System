package lk.ijse.D24HotelSystem.Dao.custom;

import lk.ijse.D24HotelSystem.Dao.SuperDAO;
import lk.ijse.D24HotelSystem.Projection.StudentDetailsDTO;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    //List<StudentDetailsDTO> getUnpaidStudents();
    List<StudentDetailsDTO> getUnpaidStudents();
}
