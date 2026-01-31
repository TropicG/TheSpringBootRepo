package repository.pc;

import model.pc.Laptop;
import org.springframework.stereotype.Repository;

// This class is responsible to connect with the Database
@Repository
public class LaptopRepository {

    public void save(Laptop laptop) {
        System.out.println("Saved in the database");
    }

}
