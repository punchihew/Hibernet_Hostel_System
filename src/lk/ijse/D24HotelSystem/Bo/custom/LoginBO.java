package lk.ijse.D24HotelSystem.Bo.custom;

import lk.ijse.d24hostelsystem.bo.SuperBO;
import lk.ijse.d24hostelsystem.dto.UsersDTO;

import java.util.List;

public interface LoginBO extends SuperBO {
    UsersDTO getUsersDto(String userName) throws Exception;

    List<UsersDTO> loadAll() throws Exception;
}
