import java.util.ArrayList;
import java.util.Scanner;

public class Invoice {

    public static final int NUM_OF_PRODUCTS_IN_STORE = 4;
    public static Products [] products_list = new Products[NUM_OF_PRODUCTS_IN_STORE];

    public static void main(String[] args) {

        populate_array();

        Scanner input = new Scanner(System.in);

        System.out.println("What do you want to do?");
        System.out.println("1)add purchase 2)change purchase 3)show purchases 4)finish transaction");
        System.out.print(">");

        int user_choice = input.nextInt();

        ArrayList <Products> order_list = new ArrayList<>();
        double total_cost = 0;

        while (user_choice != 4) {

            switch (user_choice) {

                case 1:
                    System.out.println("Enter desired item.");
                    Scanner product_choice = new Scanner(System.in);

                    String item = product_choice.nextLine().toLowerCase().trim();
                    boolean itemExists = false;

                    for(Products each_item : products_list) {
                        if(item.equals(each_item.getProduct_name())) {
                            order_list.add(each_item);
                            total_cost += each_item.getProduct_price();
                            itemExists = true;
                        }
                    }

                    if(!itemExists) {
                        System.out.println("Item does not exist.");
                    }
                    break;

                case 2: System.out.println("Enter desired item you wish to remove.");

                        Scanner remove_item = new Scanner(System.in);

                        String item_to_be_removed = remove_item.nextLine().toLowerCase().trim();

                        Boolean remove_item_exists = false;

                        for(Products each_item : products_list) {
                            if(item_to_be_removed.equals(each_item.getProduct_name())) {
                                order_list.remove(each_item);
                                total_cost -= each_item.getProduct_price();
                                remove_item_exists = true;
                            }
                        }

                        if(!remove_item_exists) {
                            System.out.println("Item does not exist.");
                        }
                        break;
                case 3:
                    System.out.println("Here are your purchases:");

                    if(order_list.size() > 0) {
                        for(Products each_order : order_list) System.out.println(each_order.getProduct_name() + " " + each_order.getProduct_price());
                        System.out.println();

                        System.out.printf("Total: %.2f", total_cost);
                        System.out.println();
                    }

                    else System.out.println("No orders placed yet.");

                    break;
            }

            System.out.println("What do you want to do?");
            System.out.println("1)add purchase 2)change purchase 3)show purchases 4)finish transaction");

            user_choice = input.nextInt();
        }

        System.out.println("Order Processing Finished.");
        for(Products order : order_list) {
            System.out.println(order.getProduct_name() + " " + order.getProduct_price());
            System.out.println();
        }

        System.out.printf("Total: %.2f", total_cost);

    }

    public static void populate_array() {

        products_list[0] = new Products("bison sweater", 55.99);
        products_list[1] = new Products("bison tee", 14.99);
        products_list[2] = new Products("bison hoodie", 23.99);
        products_list[3] = new Products("bison bumpersticker", 4.99);

    }
}

class Products {

    String product_name;
    double product_price;

    public Products(String product_name, double product_price) {

        this.product_name = product_name;
        this.product_price = product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }
}