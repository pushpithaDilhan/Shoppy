package tk.hackeytech.pushpitha.shoppy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button newlist;
    private Button mylists;
    private Button shops;
    private Button map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        newlist = (Button) findViewById(R.id.newlist);
        newlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newlist.setBackgroundResource(R.drawable.borderfocus);
                newlist.setTextColor(Color.WHITE);
                Intent intent = new Intent(getApplicationContext(),CreateList.class);
                startActivity(intent);
            }
        });


        mylists = (Button) findViewById(R.id.mylists);
        mylists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mylists.setBackgroundResource(R.drawable.borderfocus);
                mylists .setTextColor(Color.WHITE);
                Intent intent ;
                if(TransientMemory.getMylists().size()>0){
                    intent = new Intent(getApplicationContext(),MyLists.class);
                }else{
                    Toast t = Toast.makeText(getApplicationContext(),"You have not created any list.",Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER,0,0);
                    t.show();
                    intent = new Intent(getApplicationContext(),CreateList.class);
                }
                startActivity(intent);
            }
        });


        shops = (Button) findViewById(R.id.buttonShops);
        shops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Shop);

            }
        });


    }
}
