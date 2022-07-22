package edu.citytech.cst.WebProject;

import com.taxservice.cst4713.ITaxCalculator;
import com.taxservice.cst4713.Status;
import edu.citytech.cst.WebProject.marginaltaxrate.TaxCalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T2_TaxCalculatorService_2020 {

    static Map<String, Status> map = new HashMap<>();
    static{
        map.put("S", Status.S);
        map.put("HH", Status.HH);
        map.put("MFJ", Status.MFJ);
    }

    static ITaxCalculator service = new TaxCalculatorService();

    @ParameterizedTest
    @CsvSource({
            "1, S, 150_000, .24,  36_000.00",
            "2, MFJ, 10_000, .10,  1_000.00",
            "3, HH, 210_000, .35,  73_500.00",
            "4, S, 1_000_000, 37,  370_000.00",
            "5, S, 522_000, .37,  193_140.00",
            "6, MFJ, 522_000, .35,  182_700.00",
            "7, S, 210_000, .35,  73_500.00",
            "8, MFJ, 210_000, .24,  50_400.00",
            "9, HH, 210_000, .35,  73_500.00",
            "10, S, 50_000, .22,  11_000.00",
            "11, MFJ, 50_000, .12,  6_000.00",
            "12, HH, 50_000, .12,  6_000.00",
            "13, S, 50_000, .22,  11_000.00",
            "14, S, 17_000, .12,  2_040.00",
            "15, MFJ, 17_000, .10,  1_700.00",
            "16, S, 17_000, .12,  2_040.00"
    })
    void testWithCsvSource(int no, String status, float grossSalary, float taxRate, float taxOwned) {
        Status eStatus = map.get(status);
        float actual = service.getTaxPaid(2020,eStatus, grossSalary);
        float expected = taxOwned;
        assertEquals(expected,actual);
    }
}