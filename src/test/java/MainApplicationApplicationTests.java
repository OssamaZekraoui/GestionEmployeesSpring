import org.example.entities.Employee;
import org.example.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MainApplicationApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;


    /* @Test
     public void TestCreateEmployee(){
        Employee employee = new Employee("Zekraoui","Ossama","Maarif","oussmix01","0767423358",2500);
        employeeRepository.save(employee);
    }*/

   /* @Test
    public void TestFindNameEmployee(){
        List<Employee> employees = employeeRepository.findAllEmployeesByName("ossama");
        employees.forEach(System.out::println);
    }*/

}
