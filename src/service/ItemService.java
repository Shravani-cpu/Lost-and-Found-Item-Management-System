package service;

import dao.*;
import dto.ItemDTO;

import java.util.List;

public class ItemService {

    private ItemDAO dao = new ItemDAOImpl();

    public void addItem(ItemDTO item) {

        if (item.getItemName() == null || item.getItemName().isEmpty()) {
            System.out.println("Item name cannot be empty");
            return;
        }

        if (item.getStatus() == null || item.getStatus().isEmpty()) {
            System.out.println("Status cannot be empty");
            return;
        }

        dao.addItem(item);
    }

    public ItemDTO getItem(int id) {
        return dao.getItemById(id);
    }

    public List<ItemDTO> getAllItems() {
        return dao.getAllItems();
    }

    public void updateItem(ItemDTO item) {
        dao.updateItem(item);
    }

    public void deleteItem(int id) {
        dao.deleteItem(id);
    }
}
