import java.util.ArrayList;
import java.util.Scanner;

public class InvoicePubescentApproach {

   public static final int NUM_OF_PRODUCTS_IN_STORE = 4;
   public static ArrayList <String> products_name_list = new ArrayList<>();
   public static ArrayList<Double> products_price_list = new ArrayList<>();

   public static void main(String[] args) {

      populate_array();

      Scanner input = new Scanner(System.in);

      System.out.println("What do you want to do?");
      System.out.println("1)add purchase 2)change purchase 3)show purchases 4)finish transaction");
      System.out.print(">");

      int user_choice = input.nextInt();
      ArrayList<String> order_name_list = new ArrayList<>();
      ArrayList<Double> order_price_list = new ArrayList<>();
      double total_cost = 0;

      while (user_choice != 4) {

         switch (user_choice) {

            case 1:
               System.out.println("Enter desired item.");
               Scanner product_choice = new Scanner(System.in);

               String item = product_choice.nextLine().toLowerCase().trim();
               boolean itemExists = false;

               for(int i = 0; i < products_name_list.size(); i++) {

                  if(item.equals(products_name_list.get(i))) {
                     order_name_list.add(products_name_list.get(i));
                     order_price_list.add(products_price_list.get(i));
                     total_cost += products_price_list.get(i);
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

               for(int i = 0; i < products_name_list.size(); i++) {

                  if(item_to_be_removed.equals(products_name_list.get(i))) {
                     order_name_list.remove(i);
                     order_price_list.remove(i);
                     total_cost -= products_price_list.get(i);
                     remove_item_exists = true;
                  }

               }

               if(!remove_item_exists) {
                  System.out.println("Item does not exist.");
               }
               break;
            case 3:
               System.out.println("Here are your purchases:");

               if(order_name_list.size() > 0) {
                  for(int i = 0; i < order_name_list.size(); i++)  System.out.println(order_name_list.get(i) + " " + order_price_list.get(i));

                  System.out.println();

                  System.out.printf("Total: %.2f", total_cost);
                  System.out.println();
               }

               else System.out.println("No orders placed yet.");

               break;
         }

         System.out.println("What do you want to do?");
         System.out.println("1)add purchase 2)change purchase 3)show purchases 4)finish transaction");

         Scanner continuous_input = new Scanner(System.in);
         user_choice = continuous_input.nextInt();
      }

      System.out.println("Order Processing Finished.");
      for(int i = 0; i < order_name_list.size(); i++)  System.out.println(order_name_list.get(i) + " " + order_price_list.get(i));

      System.out.printf("Total: %.2f", total_cost);

   }

   public static void populate_array() {

      products_name_list.add(0, "bison sweater");
      products_price_list.add(0, 55.99 );

      products_name_list.add(1, "bison tee");
      products_price_list.add(1, 14.99 );

      products_name_list.add(2, "bison hoodie");
      products_price_list.add(2, 23.99 );

      products_name_list.add(3, "bison bumpersticker");
      products_price_list.add(3, 4.99 );

   }

}
