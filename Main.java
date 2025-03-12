public class Main {
    public static void main(String[] args) {
        // Создаю компанию с СНО "УСН доходы"
        Company company = new Company("ООО \"Ромашка\"", new taxes.tax6());

        // Операции компании
        Deal[] deals = {
                new Sale("товар1", 1300),
                new Expenditure("товар2", 700),
                new Sale("товар3", 1700),
                new Expenditure("товар4", 300),
                new Sale("товар5", 500),
        };

        // Считаем налог и разницу доходов / расходов
        int income = company.applyDeals(deals);
        System.out.println("Прибыль компании до вычета налога: " + income + " руб.");
        System.out.println();

        // Меняю СНО на "УСН доходы минус расходы" и считаю разницу доходов / расходов еще раз
        company.setTaxSystem(new taxes.tax15());
        income = company.applyDeals(deals); // Вызов нужен для пересчета ставки налога по текущим операциям
        System.out.println("Прибыль компании до вычета налога: " + income + " руб.");
    }
}