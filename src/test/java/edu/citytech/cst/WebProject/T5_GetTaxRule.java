package edu.citytech.cst.WebProject;


import edu.citytech.cst.helper.utility.Location;
import edu.citytech.cst.helper.utility.ReadExcelUtility;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Author: Olowu, Hamza")
public class T5_GetTaxRule {

    static class Model{
        float taxRate;
        float salary;

        public Model(Row row) {
            this.taxRate = (float) row.getCell(1).getNumericCellValue();
            this.salary = (float) row.getCell(2).getNumericCellValue();
        }

        @Override
        public String toString() {
            return "Model{" +
                    "taxRate=" + taxRate +
                    ", salary=" + salary +
                    '}';
        }
    }

    private static List<Model> models;
    static {
        models = ReadExcelUtility.processRange(Location.RESOURCE,
                "static/SimpleTaxRate.xlsx", "rules2021",
                "B2:C8", 2, Model::new);
    }

    @ParameterizedTest
    @DisplayName("Testing Data from the Single Column of Year 2021")
    @CsvSource({
            "0,.10,0",
            "1,.12,9_950.00",
            "2,.22,40_525.00",
            "3,.24,86_375.00",
            "4,.32,164_925.00",
            "5,.35,209_425.00",
            "6,.37,523_600.00",
    })
    void testWithCsvSource(int index, float taxRate, float salary) {

        models.forEach(System.out::println);
        var actual = models.get(index).taxRate == taxRate &&
                     models.get(index).salary == salary;

        var expected = true;
        assertEquals(expected, actual);
    }
}
