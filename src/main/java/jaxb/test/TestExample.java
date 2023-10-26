package jaxb.test;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: User
 * Date: 17.01.2022
 * Time: 19:43
 */

import jaxb.model.Country;
import jaxb.model.Department;
import jaxb.model.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample {

    private static final String XML_FILE = "src/main/java/jaxb/dept-info.xml";

    public static void main(String[] args) {

        Employee emp1 = new Employee("E01", "Tom", null);
        Employee emp2 = new Employee("E02", "Mary", "E01");
        Employee emp3 = new Employee("E03", "John", null);

        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        Department dept1 = new Department("D01", "ACCOUNTING1", "NEW YORK1");
        Department dept2 = new Department("D02", "ACCOUNTING2", "NEW YORK2");
        Department dept3 = new Department("D03", "ACCOUNTING3", "NEW YORK3");
        List<Department> list1 = new ArrayList<Department>();
        list1.add(dept1);
        list1.add(dept2);
        list1.add(dept3);

        //List<Department> list1 = new ArrayList<Department>();
        dept1.setEmployees(list);
        dept2.setEmployees(list);
        dept3.setEmployees(list);
        Country country=new Country("Belarus");
        country.setDepartments(list1);
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Country.class);

            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(country, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
            m.marshal(country, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());
            // (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();

            // XML file create before.


            Country deptFromFile1 = (Country) um.unmarshal(new FileReader(
                    XML_FILE));
            System.out.println("Country: " + country.getNameOFCountry());
            List< Department> deps = deptFromFile1.getDepartments();
            for (Department dep : deps) {
                System.out.println("Department: " + dep.getDeptName());
                List<Employee> emps = dep.getEmployees();
                for (Employee emp : emps) {
                    System.out.println("Employee: " + emp.getEmpName());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
