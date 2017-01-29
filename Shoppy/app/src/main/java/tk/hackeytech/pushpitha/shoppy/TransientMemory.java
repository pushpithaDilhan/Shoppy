package tk.hackeytech.pushpitha.shoppy;

import android.database.SQLException;
import android.os.Environment;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Pushpitha on 05-Sep-16.
 */
// this class acts as the central unit of controlling and memory handling
public class TransientMemory {

    private static String listname;
    private static ArrayList<String> items;
    private static ArrayList<ItemList> mylists = new ArrayList<ItemList>();

    public static String getListname() {
        return listname;
    }

    public static void setListname(String listname) {
        TransientMemory.listname = listname;
    }

    public static ArrayList<String> getItems() {
        return items;
    }

    public static void setItems(ArrayList<String> items) {
        TransientMemory.items = items;
    }


    public static ArrayList<ItemList> getMylists() {
        // read from storage and return
        return mylists;
    }

    public static void setMylists(ArrayList<ItemList> mylists) {
        TransientMemory.mylists = mylists;
    }

    public static void saveInMemory(String name){  // save arraylist in phone memory
        System.out.println("saved in memory");
        //create a object using related fields and save
        ItemList itemList = new ItemList();
        itemList.setName(name);
        System.out.println(items.get(0));
        itemList.setItems(items);
        mylists.add(itemList);
        //save mylist in memory
    }


}
