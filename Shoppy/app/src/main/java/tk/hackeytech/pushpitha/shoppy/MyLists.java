package tk.hackeytech.pushpitha.shoppy;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLists extends AppCompatActivity {

    ListView listView;
    ArrayList<ItemList> mylists;
    boolean isFromMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lists);
        Intent previous = getIntent();
        isFromMain = previous.getBooleanExtra("isFromMain",false);

        //bring old lists from memory
        mylists = TransientMemory.getMylists();

        // create adapter
        List<Map<String,String>> data = new ArrayList<Map<String,String>>();
        for(ItemList itemlist : mylists){
            Map<String,String> datum = new HashMap<String, String>();
            datum.put("name",itemlist.getName());
            datum.put("date",itemlist.getDate().toString());
            data.add(datum);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,data,android.R.layout.simple_expandable_list_item_2,
                new String[]{"name","date"},new int[]{android.R.id.text1,android.R.id.text2});

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent= new Intent(getApplicationContext(),ShowList.class);
                 intent.putExtra("position",position);
                 startActivity(intent);
            }
        });

    }
}
