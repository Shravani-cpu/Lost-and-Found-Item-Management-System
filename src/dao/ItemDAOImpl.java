package dao;

import dto.ItemDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/rnsitdb";
    private static final String USER = "root";
    private static final String PASS = "YOUR_PASSWORD";

    @Override
    public void addItem(ItemDTO item) {

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "INSERT INTO items(item_name, description, status) VALUES (?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, item.getItemName());
            pst.setString(2, item.getDescription());
            pst.setString(3, item.getStatus());

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ItemDTO getItemById(int id) {

        ItemDTO item = null;

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT * FROM items WHERE id=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                item = new ItemDTO(
                        rs.getInt("id"),
                        rs.getString("item_name"),
                        rs.getString("description"),
                        rs.getString("status")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public List<ItemDTO> getAllItems() {

        List<ItemDTO> list = new ArrayList<>();

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT * FROM items";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ItemDTO item = new ItemDTO(
                        rs.getInt("id"),
                        rs.getString("item_name"),
                        rs.getString("description"),
                        rs.getString("status")
                );

                list.add(item);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void updateItem(ItemDTO item) {

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "UPDATE items SET item_name=?, description=?, status=? WHERE id=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, item.getItemName());
            pst.setString(2, item.getDescription());
            pst.setString(3, item.getStatus());
            pst.setInt(4, item.getId());

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(int id) {

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "DELETE FROM items WHERE id=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
