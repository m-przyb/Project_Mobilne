package com.example.project_mobilne;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Activity_shop extends AppCompatActivity {

    String FILENAME = "Temporary_data";
    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ImageButton button = findViewById(R.id.Add_Button);
        ListView LV = findViewById(R.id.List_Item);
        EditText itemText = findViewById(R.id.ItemText);

        itemList = new ArrayList<>();

        adapter = new ArrayAdapter<String>(Activity_shop.this, android.R.layout.simple_list_item_multiple_choice, itemList);

        try {
            readData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        View.OnClickListener addlist = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                itemList.add(itemText.getText().toString());
                itemText.setText("");
                adapter.notifyDataSetChanged();
            }
        };
        button.setOnClickListener(addlist);
        LV.setAdapter(adapter);
        }

        @Override
        protected void onStop(){
        super.onStop();
            try {
                saveData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    private void saveData() throws Exception {
        FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);

        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(itemList.size());
        for (String s: itemList)
        {
            dos.writeUTF(s);
        }
        dos.close();
    }
    private void readData() throws Exception{
        FileInputStream fis = openFileInput(FILENAME);
        DataInputStream dis = new DataInputStream(fis);
        int length = dis.readInt();
        for (int i=0;i<length;i++)
        {
            String s = dis.readUTF();
            itemList.add(s);
        }
        dis.close();
    }
}

