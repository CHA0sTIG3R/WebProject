package edu.citytech.cst.WebProject;

import com.taxservice.cst4713.ITaxCalculator;
import com.taxservice.cst4713.Status;
import edu.citytech.cst.WebProject.marginaltaxrate.TaxCalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T1_TaxCalculatorService {

    static ITaxCalculator service = new TaxCalculatorService();

    @ParameterizedTest
    @CsvSource({
            "1, S, 150_000, .24, 36_000",
            "2, MFJ, 10_000, .10, 1_000.00",
            "3, HH, 210_000, .35, 73_500.00",
            "4, S, 1_000_000, .37, 370_000.00",
            "5, S, 522_000, .35, 182_700.00",
            "6, MFJ, 522_000, .35, 182_700.00",
            "7, S, 210_000, .35, 73_500.00",
            "8, MFJ, 210_000, .24, 50_400.00",
            "9, HH, 210_000, .35, 73_500.00",
            "10, S, 50_000, .22, 11_000.00",
            "11, MFJ, 50_000, .12, 6_000.00",
            "12, HH, 50_000, .12, 6_000.00",
            "13, S, 50_000, .22, 11_000.00",
            "14, S, 17_000, .12, 2_040.00",
            "15, MFJ, 17_000, .10, 1_700.00",
            "16, S,17_000, .12, 2_040.00"
    })
    void testWithCsvSource(int no, String status, float grossSalary, float taxRate, float taxOwned) {
        Status eStatus = TaxCalculatorService.getStatus(status);
        float actual = service.getTaxPaid(2021,eStatus, grossSalary);
        float expected = taxOwned;
        assertEquals(expected,actual);
    }
}