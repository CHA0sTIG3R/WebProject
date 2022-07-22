package edu.citytech.cst.WebProject.marginaltaxrate.finalmarginaltaxrate;

import edu.citytech.cst.WebProject.marginaltaxrate.realmarginaltax.TaxRule;

import static edu.citytech.cst.WebProject.utility.FormatDataUtility.format;
import static edu.citytech.cst.WebProject.utility.FormatDataUtility.percentFormat;

public class TaxBracketDescription {
    private String bracket;
    private String computeDescription;
    private float taxPaid = 0;


    public TaxBracketDescription(TaxRule taxRule, float income){

        float range2 = Math.min(taxRule.getRange2(), income);
        this.bracket = percentFormat(taxRule.getRate())+ " Bracket: ";
        this.computeDescription = "("+format(range2)+ " - "+ format(taxRule.getRange1()) + ") x " + percentFormat(taxRule.getRate());
        this.taxPaid = (range2 - taxRule.getRange1()) * taxRule.getRate();
        this.computeDescription = taxPaid < 0? "Not Applicable" : this.computeDescription+" = " + format(taxPaid);
    }

    public String getBracket() {
        return bracket;
    }

    public String getComputeDescription() {
        return computeDescription;
    }

    public float getTaxPaid() {
        return taxPaid;
    }

    @Override
    public String toString() {
        return "TaxBracketDescription{" +
                "bracket='" + bracket + '\'' +
                ", computeDescription='" + computeDescription + '\'' +
                ", taxPaid=" + taxPaid +
                '}';
    }
}
