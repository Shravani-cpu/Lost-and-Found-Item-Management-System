package dao;

import dto.ItemDTO;
import java.util.List;

public interface ItemDAO {

    void addItem(ItemDTO item);

    ItemDTO getItemById(int id);

    List<ItemDTO> getAllItems();

    void updateItem(ItemDTO item);

    void deleteItem(int id);
}
