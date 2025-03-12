package taxes;

public class tax6 extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        System.out.println("Выбрана СНО: УСН доходы");
        return (int) Math.round(debit * 0.06);
    }
}