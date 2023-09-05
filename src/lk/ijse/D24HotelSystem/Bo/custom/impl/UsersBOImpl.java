package lk.ijse.D24HotelSystem.Bo.custom.impl;


import lk.ijse.D24HotelSystem.Bo.custom.UsersBO;
import lk.ijse.D24HotelSystem.Dao.DAOFactory;
import lk.ijse.D24HotelSystem.Dao.custom.UserDAO;
import lk.ijse.D24HotelSystem.Dto.UsersDTO;
import lk.ijse.D24HotelSystem.Entity.Users;
import lk.ijse.D24HotelSystem.Util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UsersBOImpl implements UsersBO {
    private Session session;
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Users);
    @Override
    public List<UsersDTO> loadAll() throws Exception {
        session= SessionFactoryConfig.getInstance().getSession();
        userDAO.setSession(session);
        List<Users> users = userDAO.loadAll();
        List<UsersDTO> usersDTOS=new ArrayList<>();

        for (Users users1:users) {
            usersDTOS.add(
                    new UsersDTO(
                            users1.getId(),
                            users1.getName(),
                            users1.getUserName(),
                            users1.getPassword(),
                            users1.getEmail()
                    )
            );
        }

        return usersDTOS;
    }

    @Override
    public boolean saveUsers(UsersDTO usersDTO) throws Exception {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            userDAO.setSession(session);
            userDAO.save(
                    new Users(
                            usersDTO.getId(),
                            usersDTO.getName(),
                            usersDTO.getUserName(),
                            usersDTO.getPassword(),
                            usersDTO.getEmail()
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
    public boolean updateUsers(UsersDTO usersDTO) throws Exception {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            userDAO.setSession(session);
            userDAO.update(
                    new Users(
                            usersDTO.getId(),
                            usersDTO.getName(),
                            usersDTO.getUserName(),
                            usersDTO.getPassword(),
                            usersDTO.getEmail()
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
    public boolean deleteUsers(UsersDTO usersDTO) throws Exception {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            userDAO.setSession(session);
            userDAO.delete(
                    new Users(
                            usersDTO.getId(),
                            usersDTO.getName(),
                            usersDTO.getUserName(),
                            usersDTO.getPassword(),
                            usersDTO.getEmail()
                    )
            );
            transaction.commit();
            session.close();
        }catch (Exception e){
            transaction.rollback();
        }

        return false;
    }



    @Override
    public String generateNextUserID() throws Exception {
        return userDAO.generateID();
    }
}
