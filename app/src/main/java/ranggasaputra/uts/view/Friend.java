package ranggasaputra.uts.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import ranggasaputra.uts.R;

/**
 * Created by Rangga on 23/05/2019.
 */

public class Friend extends AppCompatActivity {
    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    EditText itemText;
    Button addButton;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lv = (ListView) findViewById(R.id.listView);
        itemText = (EditText)findViewById(R.id.addText);
        addButton = (Button) findViewById(R.id.addBtn);

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(Friend.this ,android.R.layout.simple_list_item_multiple_choice, itemList);

        View.OnClickListener addlistiner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemList.add(itemText.getText().toString());
                itemText.setText("");
                adapter.notifyDataSetChanged();

            }
        };

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray positionchecker = lv.getCheckedItemPositions();
                int count = lv.getCount();

                for (int item = count-1; item>=0; item--){

                    if (positionchecker.get(item)){
                        adapter.remove(itemList.get(item));

                    }
                }
                positionchecker.clear();

                adapter.notifyDataSetChanged();

                return false;
            }
        });

        addButton.setOnClickListener(addlistiner);
        lv.setAdapter(adapter);

    }
}