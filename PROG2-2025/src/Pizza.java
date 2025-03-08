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
        
        while(true) {
        System.out.println("Please pick any three of the following ingredients:\r\n" + //
                        " 1. Mushroom\r\n" + //
                        " 2. Paprika\r\n" + //
                        " 3. Sun-dried tomatoes\r\n" + //
                        " 4. Chicken\r\n" + //
                        " 5. Pineapple\r\n" + //
                        " Enter any three choices (1, 2, 3,…) separated by spaces:");

        String ing1;
        String ing2;
        String ing3;

        int ingChoice1 = scanner.nextInt();
        int ingChoice2 = scanner.nextInt();
        int ingChoice3 = scanner.nextInt();
        
        ing1 = convertIngredidents(ingChoice1);
        ing2 = convertIngredidents(ingChoice2);
        ing3 = convertIngredidents(ingChoice3);
       
        String pizzaSize;

        while(true) {
            System.out.println("What size should your pizza be?\r\n" + //
                                " 1. Large\r\n" + //
                                " 2. Medium\r\n" + //
                                " 3. Small\r\n" + //
                                " Enter only one choice (1, 2, or 3):");
                                
            int sizeChoice = scanner.nextInt();

            switch(sizeChoice) {
                case 1:
                    pizzaSize = "Large";
                    break;
                case 2:
                    pizzaSize = "Medium";
                    break;
                case 3:
                    pizzaSize = "Small";
                    break;
                default:
                    System.out.println("Invalid choice(s). Please pick only from the given list:");
                    continue;
                
            }
            break;
        }
        
        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.nextLine();

        String sideDish;

        while(true) {
            System.out.println("Following are the side dish that go well with your pizza:\r\n" + //
                                " 1. Calzone\r\n" + //
                                " 2. Garlic bread\r\n" + //
                                " 3. Chicken puff\r\n" + //
                                " 4. Muffin\r\n" + //
                                " 5. Nothing for me\r\n" + //
                                " What would you like? Pick one (1, 2, 3,…):");
            
             int sideDishChoice = scanner.nextInt();

            switch(sideDishChoice) {
                case 1:
                    sideDish = "Calzone";
                    break;
                case 2:
                    sideDish = "Garlic bread";
                    break;
                case 3:
                    sideDish = "Chicken puff";
                    break;
                case 4:
                    sideDish = "Muffin";
                    break;
                case 5:
                    sideDish = "Nothing for me";
                    break;
                default:
                    System.out.println("Invalid choice(s). Please pick only from the given list:");
                    continue;
            }
            break;
        }

        String drinks;
        while(true) {
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:\r\n" + //
                                " 1. Coca Cola\r\n" + //
                                " 2. Cold coffee\r\n" + //
                                " 3. Cocoa Drink\r\n" + //
                                " 4. No drinks for me\r\n" + //
                                " Enter your choice:");
            int drinkChoice = scanner.nextInt();

            switch(drinkChoice) {
                case 1:
                    drinks = "Coca Cola";
                    break;
                case 2:
                    drinks = "Cold coffee";
                    break;
                case 3:
                    drinks = "Cocoa Drink";
                    break;
                case 4:
                    drinks = "No drinks for me";
                    break;
                default:
                    System.out.println("Invalid choice(s). Please pick only from the given list:");
                    continue;
            }
            break;
        }

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

        scanner.close();
    }
}

    public String convertIngredidents(int ingChoice) {
        String temp = null;
        switch(ingChoice) {
            case 1: 
                temp = "Mushroom";
                break;
         case 2:
                temp ="Paprika";
                break;
            case 3:
                temp = "Sun-dried tomatoes";
                break;
            case 4:
                temp = "Chicken";
                break;
            case 5:
                temp = "Pineapple";
                break;
            default:
                System.out.println("Invalid choice(s). Please pick only from the given list:");
                break;
        }
        return temp;
    }

    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        String birthdate = scanner.nextLine();
        LocalDate birthdate1 = LocalDate.parse(birthdate);
        LocalDate now = LocalDate.now();
        LocalDate fiveYearsAgo = now.minusYears(5);
        LocalDate twentyYearsAgo = now.minusYears(120);
        Period period = Period.between(birthdate1,now);
        int age = period.getYears();

        while(true) {
            System.out.println("Enter your birthday:");
            
            if(birthdate1.isAfter(fiveYearsAgo) || birthdate1.isBefore(twentyYearsAgo)) {
                System.out.println("Invalid date. You are either too young or too dead to order. Please enter a valid date:");
            }
            else {
                break;
            }
            scanner.close();

        }

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

        scanner.close();

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

        if (cardLength == 14) {
            System.out.println("Card accepted");
        }
            else {
                System.out.println ("Invalid card");
        }

        long firstCardDigit = Long.parseLong(cardNumber1.substring(0,1));

        long blacklistedNumber = 111111111111111L;

        if (cardNumber1.equals(blacklistedNumber) || cardNumber1.length() != 14) {
            System.out.println("”Card is blacklisted. Please use another card");
        }

        long lastFourDigits = Long.parseLong(cardNumber1.substring(10,14));

        String cardNumberToDisplay = cardNumber1.charAt(0) + "*********" + cardNumber1.substring(10,13);
 
    }
    
    public void specialOfTheDay( String pizzaOfTheDay,String sideOfTheDay,String specialPrice) {
        StringBuilder specialList = new StringBuilder();
        specialList.append(pizzaOfTheDay).append(sideOfTheDay).append(specialPrice);
    
        System.out.println(specialList.toString());
    
    }
    

    }


