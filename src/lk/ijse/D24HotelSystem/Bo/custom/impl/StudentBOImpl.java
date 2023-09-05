package lk.ijse.D24HotelSystem.Bo.custom.impl;

import lk.ijse.D24HotelSystem.Bo.custom.StudentBO;
import lk.ijse.D24HotelSystem.Dao.DAOFactory;
import lk.ijse.D24HotelSystem.Dao.custom.StudentDAO;
import lk.ijse.D24HotelSystem.Dto.StudentDTO;
import lk.ijse.D24HotelSystem.Entity.Student;
import lk.ijse.D24HotelSystem.Util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    private Session session;
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Student);
    @Override
    public List<StudentDTO> loadAll() throws Exception {
        session= SessionFactoryConfig.getInstance().getSession();
        studentDAO.setSession(session);
        List<Student> students = studentDAO.loadAll();
        List<StudentDTO>studentDTOS=new ArrayList<>();

        for (Student student:students) {
            studentDTOS.add(
                    new StudentDTO(
                            student.getStudentId(),
                            student.getStudentName(),
                            student.getNic(),
                            student.getHomeTown(),
                            student.getGender(),
                            student.getPhoneNumber(),
                            student.getUniversity()
                    )
            );
        }

        return studentDTOS;
    }

    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws Exception {
        session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            studentDAO.setSession(session);
            String id = studentDAO.save(
                    new Student(
                            studentDTO.getStudentId(),
                            studentDTO.getStudentName(),
                            studentDTO.getNic(),
                            studentDTO.getHomeTown(),
                            studentDTO.getGender(),
                            studentDTO.getPhoneNumber(),
                            studentDTO.getUniversity()
                    ));
            transaction.commit();
            session.close();
            if (id!=null){
                return true;
            }
        }catch (Exception e){
            transaction.rollback();
        }

        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            studentDAO.setSession(session);
            studentDAO.update(
                    new Student(
                            studentDTO.getStudentId(),
                            studentDTO.getStudentName(),
                            studentDTO.getNic(),
                            studentDTO.getHomeTown(),
                            studentDTO.getGender(),
                            studentDTO.getPhoneNumber(),
                            studentDTO.getUniversity()
                    ));
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
        }

        return false;
    }

    @Override
    public boolean deleteStudent(StudentDTO studentDTO) throws Exception {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            studentDAO.setSession(session);
            studentDAO.delete(
                    new Student(
                            studentDTO.getStudentId(),
                            studentDTO.getStudentName(),
                            studentDTO.getNic(),
                            studentDTO.getHomeTown(),
                            studentDTO.getGender(),
                            studentDTO.getPhoneNumber(),
                            studentDTO.getUniversity()
                    ));
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
        }

        return false;
    }

    @Override
    public String generateNextStudentID() throws Exception {
        session= SessionFactoryConfig.getInstance().getSession();
        studentDAO.setSession(session);
        return studentDAO.generateID();
    }
}
