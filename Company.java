import taxes.TaxSystem;

public class Company {
    private final String companyName;
    private int debit = 0;
    private int credit = 0;
    private TaxSystem taxSystem;

    public Company(String companyName, TaxSystem taxSystem) {
        this.companyName = companyName;
        this.taxSystem = taxSystem;
    }

    // Счетчики доходов и расходов компании
    public void shiftMoney(int amount){
        switch (Integer.signum(amount)) {
            case 1: debit+=amount; break;
            case -1: credit+=Math.abs(amount); break;
            case 0: break;
        }
    }
    // Устанавливаем СНО
    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }
    // Расчет суммы налога с выбранной СНО
    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания " + companyName + " уплатила налог в размере: " + tax + " руб.");
        debit = 0;
        credit = 0;
    }

    // Подсчет всех сделок и налогов
    public int applyDeals(Deal[] deals) {
        for (Deal deal : deals) {
            shiftMoney(deal.getDebitChange());
            shiftMoney(-deal.getCreditChange());
            System.out.println(deal.getComment());
        }
        int result = debit - credit;
        payTaxes(); // здесь мы обнуляем debit и credit
        return result;
    }
}