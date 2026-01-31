package service.pc;

import model.pc.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.pc.LaptopRepository;

@Service
public class LaptopService {

    // Spring will inject the dependency for the repository for laptop
    @Autowired
    private LaptopRepository repo;


    public void addLaptop(Laptop laptop) {
        System.out.println("Laptop successfully added");
    }

    public boolean isGoodForProg(Laptop laptop) {
        return true;
    }

}
