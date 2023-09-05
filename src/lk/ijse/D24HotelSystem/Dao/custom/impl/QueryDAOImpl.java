package lk.ijse.D24HotelSystem.Dao.custom.impl;


import lk.ijse.D24HotelSystem.Dao.custom.QueryDAO;
import lk.ijse.D24HotelSystem.Projection.StudentDetailsDTO;
import lk.ijse.D24HotelSystem.Util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    private Session session;
    @Override
    public List<StudentDetailsDTO> getUnpaidStudents() {
        session= SessionFactoryConfig.getInstance().getSession();

        String sql="SELECT new lk.ijse.D24HotelSystem.Projection.StudentDetailsDTO(s.studentId, s.studentName, s.phoneNumber,r.date ,r.id,r.room) FROM Student s INNER JOIN s.reservationList r WHERE r.status = 'unPaid'";

        Query query = session.createQuery(sql);
        List<StudentDetailsDTO> list = query.list();
        session.close();
        return list;
    }
}
