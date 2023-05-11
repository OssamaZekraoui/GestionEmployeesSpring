import org.example.entities.Employee;
import org.example.respository.EmployeeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainApplicationApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    /* @Test
     public void TestCreateEmployee(){
        Employee employee = new Employee("Zekraoui","Ossama","Maarif","oussmix01","0767423358",2500);
        employeeRepository.save(employee);
    }*/
}
