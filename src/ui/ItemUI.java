package ui;

import dto.ItemDTO;
import service.ItemService;

import javax.swing.*;
import java.util.List;

public class ItemUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lost & Found Item Management");
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ItemService service = new ItemService();

        JButton addBtn = new JButton("Add Item");
        addBtn.setBounds(150, 80, 200, 30);

        JButton viewBtn = new JButton("View Items");
        viewBtn.setBounds(150, 130, 200, 30);

        JButton deleteBtn = new JButton("Delete Item");
        deleteBtn.setBounds(150, 180, 200, 30);

        frame.add(addBtn);
        frame.add(viewBtn);
        frame.add(deleteBtn);

        frame.setVisible(true);

        // ADD
        addBtn.addActionListener(e -> {

            String name = JOptionPane.showInputDialog("Enter Item Name:");
            String desc = JOptionPane.showInputDialog("Enter Description:");
            String status = JOptionPane.showInputDialog("Enter Status (Lost/Found):");

            service.addItem(new ItemDTO(0, name, desc, status));

            JOptionPane.showMessageDialog(null, "Item Added!");
        });

        // VIEW
        viewBtn.addActionListener(e -> {

            List<ItemDTO> list = service.getAllItems();

            String[] cols = {"ID", "Item Name", "Description", "Status"};

            String[][] data = new String[list.size()][4];

            for (int i = 0; i < list.size(); i++) {

                ItemDTO item = list.get(i);

                data[i][0] = String.valueOf(item.getId());
                data[i][1] = item.getItemName();
                data[i][2] = item.getDescription();
                data[i][3] = item.getStatus();
            }

            JTable table = new JTable(data, cols);

            JOptionPane.showMessageDialog(null, new JScrollPane(table));
        });

        // DELETE
        deleteBtn.addActionListener(e -> {

            int id = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter Item ID:")
            );

            service.deleteItem(id);

            JOptionPane.showMessageDialog(null, "Item Deleted!");
        });
    }
}
