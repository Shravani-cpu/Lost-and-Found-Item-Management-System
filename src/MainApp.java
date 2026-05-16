import dto.ItemDTO;
import service.ItemService;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        ItemService service = new ItemService();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Item");
            System.out.println("2. Get Item By ID");
            System.out.println("3. Get All Items");
            System.out.println("4. Update Item");
            System.out.println("5. Delete Item");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Item Name: ");
                    String name = sc.next();

                    System.out.print("Enter Description: ");
                    String desc = sc.next();

                    System.out.print("Enter Status (Lost/Found): ");
                    String status = sc.next();

                    service.addItem(
                            new ItemDTO(0, name, desc, status)
                    );

                    break;

                case 2:

                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();

                    ItemDTO item = service.getItem(id);

                    if (item != null) {

                        System.out.println(
                                item.getId() + " " +
                                item.getItemName() + " " +
                                item.getDescription() + " " +
                                item.getStatus()
                        );
                    }

                    break;

                case 3:

                    List<ItemDTO> list = service.getAllItems();

                    list.forEach(i ->
                            System.out.println(
                                    i.getId() + " " +
                                    i.getItemName() + " " +
                                    i.getDescription() + " " +
                                    i.getStatus()
                            )
                    );

                    break;

                case 4:

                    System.out.print("Enter Item ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter New Item Name: ");
                    String newName = sc.next();

                    System.out.print("Enter New Description: ");
                    String newDesc = sc.next();

                    System.out.print("Enter New Status: ");
                    String newStatus = sc.next();

                    service.updateItem(
                            new ItemDTO(uid, newName, newDesc, newStatus)
                    );

                    break;

                case 5:

                    System.out.print("Enter Item ID: ");
                    int did = sc.nextInt();

                    service.deleteItem(did);

                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
