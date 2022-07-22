package edu.citytech.cst.WebProject.marginaltaxrate;

import com.taxservice.cst4713.ITaxCalculator;
import com.taxservice.cst4713.Status;
import edu.citytech.cst.WebProject.marginaltaxrate.realmarginaltax.TaxRule;
import edu.citytech.cst.WebProject.marginaltaxrate.realmarginaltax.TaxRuleRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxCalculatorService implements ITaxCalculator {

    static Map<String, Status> map = new HashMap<>();
    static Map<Status, String> hashMap = new HashMap<>();

    static{
        map.put("S", Status.S);
        map.put("HH", Status.HH);
        map.put("MFJ", Status.MFJ);

        hashMap.put(Status.S, "S");
        hashMap.put(Status.HH, "HH");
        hashMap.put(Status.MFJ, "MFJ");
    }
    public static Status getStatus(String status){
        return map.get(status);
    }

    public static String getStatus(Status status){
        return hashMap.get(status);
    }

    static List<TaxRule> taxRules = new TaxRuleRepository().findAll(e -> true);

    @Override
    public float getTaxPaid(int taxYear, Status status, float grossPay) {

        var stat = getStatus(status);

        var taxPaid =
                taxRules.stream().filter( e -> e.getCode().equals(stat) && e.getYear() == taxYear
                                && e.getRange1() < grossPay  && e.getRange2() >= grossPay )
                .map(TaxRule::getRate)
                .findFirst()
                .get()*grossPay;

        return taxPaid;
    }

    @Override
    public float getTaxPaid(Status status, float grossPay) {

        var taxPaid = getTaxPaid(2021, status, grossPay);

        return taxPaid;
    }
}
