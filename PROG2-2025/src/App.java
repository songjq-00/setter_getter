public class App {
    public static void main(String[] args) throws Exception {
        Pizza pizza = new Pizza();
        pizza.takeOrder(Pizza.DEF_ORDER_ID,Pizza.DEF_ORDER_TOTAL,Pizza.DEF_PIZZA_INGREDIENTS);
        pizza.specialOfTheDay("a","b","c");
        
    }
}