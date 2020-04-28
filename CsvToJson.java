import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.FileReader;
import java.util.List;

public class CsvToJson {

    public static void main(String args[]) {

        try {
            CSVReader reader = new CSVReader(new FileReader("D://employee.csv"), ',');

            //ColumnPositionMappingStrategy<Employee> beanStrategy = new ColumnPositionMappingStrategy<Employee>();
            //beanStrategy.setType(Employee.class);
            //beanStrategy.setColumnMapping(new String[]{"id", "name", "organization", "salary"});

            HeaderColumnNameMappingStrategy<Employee> beanStrategy = new HeaderColumnNameMappingStrategy<Employee>();
            beanStrategy.setType(Employee.class);
            CsvToBean<Employee> csvToBean = new CsvToBean<Employee>();

            List<Employee> emps = csvToBean.parse(beanStrategy, reader);

            ObjectMapper mapper = new ObjectMapper();
            String empJSON = mapper.writeValueAsString(emps);

            System.out.println(empJSON);
        }catch(Exception ex) {
            System.out.println(ex);
        }
    }
}
