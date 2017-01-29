package tk.hackeytech.pushpitha.shoppy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateList extends AppCompatActivity {

    String[] names={"dhal","sugar","rice"};
    ListView listView;
    Button addbtn,savebtn;
    AutoCompleteTextView textView;
    ArrayList<String> itemlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);
        itemlist = new ArrayList<String>();

        final android.app.FragmentManager fm = getFragmentManager();
        final SaveFragment sf = new SaveFragment();

        addbtn = (Button) findViewById(R.id.addbtn);
        savebtn = (Button) findViewById(R.id.savebtn);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,names);
        textView = (AutoCompleteTextView) findViewById(R.id.autotext);
        textView.setAdapter(adapter);

        listView = (ListView) findViewById(R.id.listview);
        final ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemlist);
        listView.setAdapter(adapter1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Snackbar.make(view, "Do you want to delete this item ?", Snackbar.LENGTH_LONG)
                        .setAction("YES", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                itemlist.remove(position);
                                adapter1.notifyDataSetInvalidated();
                            }
                        }).show();
            }
        });


        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String in = textView.getText().toString().trim();
                if(in.equals("")){
                    Toast toast= Toast.makeText(getApplicationContext(),
                            "You have not typed anything.", Toast.LENGTH_SHORT);
                    toast.setGravity( Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }else{
                    itemlist.add(in);
                    adapter1.notifyDataSetChanged();
                    textView.setText("");
                }
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransientMemory.setItems(itemlist);
                sf.show(fm,"Save Fragment");
            }
        });
    }


}
