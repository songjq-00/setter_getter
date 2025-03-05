import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three ingredients for your pizza (use spaces to separate  ingredients):");
        String ing1 = scanner.nextLine();
        String ing2 = scanner.nextLine();
        String ing3 = scanner.nextLine();

        System.out.println( "Enter size of pizza (Small, Medium, Large):");
        String pizzaSize = scanner.nextLine();

        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.nextLine();

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String sideDish = scanner.nextLine();

        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        String drinks = scanner.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.nextLine();

        if(wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday(); 
        }
            else {
                makeCardPayment();
            }

    

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

    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birthday:");
        String birthdate = scanner.nextLine();
        LocalDate birthdate1 = LocalDate.parse(birthdate);
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthdate1,now);
        int age = period.getYears();

        if(age < 18 && birthdate1.getDayOfYear() == now.getDayOfYear()) {
            System.out.println("Congratulations! You pay only half the price for your order");
        }
            else{
                System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
            }

    }

    public void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your card number:");
        long cardNumber = scanner.nextLong();

        System.out.println("Enter your expiry date");
        String expiryDate = scanner.next();

        System.out.println("Enter your card’s cvv number:");
        int cvv = scanner.nextInt();

        processCardPayment(cardNumber,expiryDate,cvv);



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

    private void processCardPayment(long cardNumber,String expiryDate,int cvv) {
        String cardNumber1 = Long.toString(cardNumber);
        int cardLength = cardNumber1.length();

        if (cardLength == 14 ) {
            System.out.println("Card accepted");
        }
            else {
                System.out.println ("Invalid card");
        }

         long firstCardDigit = Long.parseLong(cardNumber1.substring(0,1));

        long blacklistedNumber = 111111111111111L;

        if (cardNumber1.equals(blacklistedNumber)) {
            System.out.println("”Card is blacklisted. Please use another card");
        }

        long lastFourDigits = Long.parseLong(cardNumber1.substring(10,14));

        String cardNumberToDisplay = cardNumber1.charAt(0) + "*********" + cardNumber1.substring(10,13);

        
        
        public void specialOfTheDay( String pizzaOfTheDay,String sideOfTheDay,String specialPrice) {
            StringBuilder specialList = new StringBuilder();
            specialList.append(pizzaOfTheDay).append(sideOfTheDay).append(specialPrice);

            System.out.println(specialList.toString());

        }




    }
}