package dto;

public class ItemDTO {

    private int id;
    private String itemName;
    private String description;
    private String status;

    public ItemDTO() {}

    public ItemDTO(int id, String itemName, String description, String status) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
