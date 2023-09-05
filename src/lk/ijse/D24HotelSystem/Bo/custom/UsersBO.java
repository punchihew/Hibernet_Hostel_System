package lk.ijse.D24HotelSystem.Bo.custom;



import lk.ijse.D24HotelSystem.Bo.SuperBO;
import lk.ijse.D24HotelSystem.Dto.UsersDTO;

import java.util.List;

public interface UsersBO extends SuperBO {
    List<UsersDTO> loadAll() throws Exception;
    boolean saveUsers(UsersDTO usersDTO) throws Exception;
    boolean updateUsers(UsersDTO usersDTO) throws Exception;
    boolean deleteUsers(UsersDTO usersDTO) throws Exception;

    String generateNextUserID() throws Exception;
}
