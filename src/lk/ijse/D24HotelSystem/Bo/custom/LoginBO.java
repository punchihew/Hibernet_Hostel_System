package lk.ijse.D24HotelSystem.Bo.custom;

import lk.ijse.D24HotelSystem.Bo.SuperBO;
import lk.ijse.D24HotelSystem.Dto.UsersDTO;

import java.util.List;

public interface LoginBO extends SuperBO {
    UsersDTO getUsersDto(String userName) throws Exception;

    List<UsersDTO> loadAll() throws Exception;
}
