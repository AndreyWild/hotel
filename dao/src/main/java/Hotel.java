import com.senla.api.dao.IGuestDao;
import com.senla.api.dao.IMaintenanceDao;
import com.senla.api.dao.IOrderDao;
import com.senla.api.dao.IRoomDao;
import com.senla.dao.impl.GuestDao;
import com.senla.dao.impl.MaintenanceDao;
import com.senla.dao.impl.OrderDao;
import com.senla.dao.impl.RoomDao;
import com.senla.model.entityes.Guest;
import com.senla.model.entityes.Maintenance;
import com.senla.model.entityes.Order;
import com.senla.model.entityes.Room;
import com.senla.model.entityes.enums.RoomStars;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class Hotel {
    private static IGuestDao guestDao = new GuestDao();
    private static IRoomDao roomDao = new RoomDao();
    private static IMaintenanceDao maintenanceDao= new MaintenanceDao();
    private static IOrderDao orderDao = new OrderDao();

    public static void main(String[] args) {
//        File file = new File("C:\\Users\\Andrey\\Desktop\\SENLA_JavaEE\\hotel\\dao\\src\\main\\java\\hibernate.cfg.xml");
//        SessionFactory sessionFactory = new Configuration().configure(file)
//                .addAnnotatedClass(Order.class)
//                .addAnnotatedClass(Room.class)
//                .addAnnotatedClass(Guest.class)
//                .addAnnotatedClass(Maintenance.class)
//                .buildSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
////
//        session.beginTransaction();
//        Guest entity = session.get(Guest.class, 2L);
//        session.getTransaction().commit();
//        System.out.println(entity);

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//        Guest guest = new Guest("Bob", 25);
//        guestDao.save(guest);

//        Room room = new Room(555, 1,200.0, RoomStars.FOUR);
//        roomDao.save(room);

//        Maintenance maintenance = new Maintenance("Cleaning", 200.0);
//        maintenanceDao.save(maintenance);

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        Guest guestGet = guestDao.getById(6L);
//        guestGet.setId(null);
        System.out.println(guestGet);
//
        Room roomGet = roomDao.getById(6L);
//        roomGet.setId(null);
        System.out.println(roomGet);
//
        Maintenance maintenanceGet = maintenanceDao.getById(5L);
        System.out.println(maintenanceGet);

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//        maintenanceGet.setName("TEST");
//        maintenanceDao.update(maintenanceGet);
//
//        maintenanceDao.delete(maintenanceGet);

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//        List<Maintenance> maintenanceList = maintenanceDao.getAll();
//        System.out.println(maintenanceList);

//        Order order = orderDao.getById(1L);
//        System.out.println(order);

//        Order setOrder = new Order(guestGet, roomGet, LocalDate.now(), LocalDate.now());
//        orderDao.save(setOrder);





//        Room room = roomDao.getById(11L);
//        System.out.println(room);
//
////        Room room = new Room(333, 5, 200.0, RoomStars.FOUR);
////        roomDao.save(room);
////        System.out.println(room);

//        Guest guest = guestDao.getById(1L);
//        guest.setName("Hello");
//        System.out.println(guest);
////        guestDao.update(guest);



    }
}
