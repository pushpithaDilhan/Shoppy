package tk.hackeytech.pushpitha.shoppy;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Pushpitha on 06-Sep-16.
 */
public class SaveFragment extends DialogFragment {

    Button savebtn;
    Button cancel;
    EditText nametext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.dialogview,container,false);
        getDialog().setTitle("Save");

        nametext = (EditText) rootview.findViewById(R.id.fragmnttext);
        savebtn = (Button) rootview.findViewById(R.id.savebtn);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransientMemory.saveInMemory(nametext.getText().toString());
                dismiss();
                Intent next = new Intent(getActivity(),MyLists.class);
                startActivity(next);
            }
        });
        cancel = (Button) rootview.findViewById(R.id.canclbtn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return rootview;
    }

}
