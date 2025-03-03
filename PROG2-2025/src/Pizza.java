public class Pizza {
    public String storeName;
    public String storeAddress;

    public String storeEmail;
    public long storePhone;

    public String storeMenu;
    private String pizzaIngredients;

    public double pizzaPrice;
    public String sides;
    public String drinks;
    
    private String orderID;
    private double orderTotal;

    public static final String DEF_ORDER_ID = "DEF-SOH-099";

    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";

    public static final double DEF_ORDER_TOTAL = 15.00;

    public Pizza () {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
    }


    public void takeOrder(String id, double total,String ingredients) {
        orderID = id;
        orderTotal = total;
        pizzaIngredients = ingredients;


        System.out.println("Order accepted!");

        System.out.println("Order is being prepared");

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            System.out.println("Order is ready for pickup!");
        }

        System.out.println("Your order is ready!");

        printReceipt();


    }

    public void makePizza(){
        System.out.println("Make pizza with ingredients:" + pizzaIngredients);


    }
    
    private void printReceipt(){
        System.out.println("********RECEIPT********");
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Total: " + orderTotal);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
    }

    public String getpizzaIngredients() {
        return pizzaIngredients;
    }

    public String setpizzaIngredients() {
        return pizzaIngredients;
    }


    public String getorderID() {
        return orderID;
    }

    public String setorderID() {
        return orderID;
    }

    public double getorderTotal() {
        return orderTotal;
    }

    public double setorderTotal() {
        return orderTotal;
    }

    private void processCardPayment(String cardNumber,String expiryDate,int cvv) {
        int cardLength = cardNumber.length();
        if (cardLength == 14 ) {
            System.out.println("Card accepted");
        }
            else {
                System.out.println ("Invalid card");
        }

        int firstCardDigit = Integer.parseInt(cardNumber.substring(0,1));

        String blacklistedNumber = "11111111111111";

        if (cardNumber.equals(blacklistedNumber)) {
            System.out.println("”Card is blacklisted. Please use another card");
        }

        int lastFourDigits = Integer.parseInt(cardNumber.substring(10,14));

        String cardNumberToDisplay = cardNumber.charAt(0) + "*********" + cardNumber.substring(10,13);

        public void specialOfTheDay( String pizzaOfTheDay,String sideOfTheDay,String specialPrice) {
            StringBuilder specialList = new StringBuilder();
            specialList.append(pizzaOfTheDay).append(sideOfTheDay).append(specialPrice);

            System.out.println(specialList.toString());

        }




    }
}