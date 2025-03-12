package taxes;

public class tax15 extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        System.out.println("Выбрана СНО: УСН доходы минус расходы");
        return Math.max(0, (int)Math.round((debit - credit) * 0.15));
    }
}