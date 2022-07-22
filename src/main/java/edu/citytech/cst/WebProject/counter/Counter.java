package edu.citytech.cst.WebProject.counter;

public class Counter implements Comparable<Counter>{
    private String displayValue;
    private Number value;
    private String className = "numbers";

    public Counter() {
    }

    public Counter(String displayValue, Number value) {
        this.displayValue = displayValue;
        this.value = value;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "displayValue='" + displayValue + '\'' +
                ", value=" + value +
                ", className='" + className + '\'' +
                '}';
    }

    @Override
    public int compareTo(Counter o) {
        return Integer.compare(this.value.intValue(), o.value.intValue());
    }
}
