package tk.hackeytech.pushpitha.shoppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    int listnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        Intent previous = getIntent();
        listnum = previous.getIntExtra("position",0);
        ArrayList<String> temp = TransientMemory.getMylists().get(listnum).getItems();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,temp);
        ListView listView = (ListView) findViewById(R.id.listViewlist);
        listView.setAdapter(adapter);

    }
}
