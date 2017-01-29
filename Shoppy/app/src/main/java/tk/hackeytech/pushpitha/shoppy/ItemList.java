package tk.hackeytech.pushpitha.shoppy;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Pushpitha on 06-Sep-16.
 */
public class ItemList {
    private String name;
    private ArrayList<String> items;
    private Date date;

    public ItemList() {
        date = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
