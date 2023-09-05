package lk.ijse.D24HotelSystem.Bo.custom.impl;

import lk.ijse.D24HotelSystem.Bo.custom.LoginBO;
import lk.ijse.D24HotelSystem.Dao.DAOFactory;
import lk.ijse.D24HotelSystem.Dao.custom.UserDAO;
import lk.ijse.D24HotelSystem.Dto.UsersDTO;
import lk.ijse.D24HotelSystem.Entity.Users;
import lk.ijse.D24HotelSystem.Util.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.List;

public class LoginBOImpl implements LoginBO {
    private Session session;
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Users);

    @Override
    public UsersDTO getUsersDto(String userName) throws Exception {
        session= SessionFactoryConfig.getInstance().getSession();
        userDAO.setSession(session);

        Users users = userDAO.getUsers(userName);
        return new UsersDTO(
                users.getId(),
                users.getName(),
                users.getUserName(),
                users.getPassword(),
                users.getEmail()
        );
    }

    @Override
    public List<UsersDTO> loadAll() throws Exception {
        return null;
    }
}
