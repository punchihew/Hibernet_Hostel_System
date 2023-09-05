package lk.ijse.D24HotelSystem.Bo.custom;

import lk.ijse.D24HotelSystem.Bo.SuperBO;
import lk.ijse.D24HotelSystem.Dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    List<StudentDTO> loadAll() throws Exception;
    boolean saveStudent(StudentDTO studentDTO) throws Exception;
    boolean updateStudent(StudentDTO studentDTO) throws Exception;
    boolean deleteStudent(StudentDTO studentDTO) throws Exception;
    String generateNextStudentID() throws Exception;
}
