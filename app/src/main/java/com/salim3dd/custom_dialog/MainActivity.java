package com.salim3dd.custom_dialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog dialog_list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ////////////
        dialog_list = new Dialog(this);
        dialog_list.setContentView(R.layout.dialog_listview);
        Button btn_ok = (Button)dialog_list.findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        String[] array = {"السؤال الاول", "السؤال الثاني", "السؤال الثالث", "السؤال الرابع", "السؤال الخامس"};
        ListView listView = (ListView) dialog_list.findViewById(R.id.listview_d);
        ArrayAdapter<String> listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, i+"", Toast.LENGTH_SHORT).show();
            }
        });

        dialog_list.show();
        /////////////

    }


    @Override
    public void onBackPressed() {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_1);
        Button btn_OK = (Button) dialog.findViewById(R.id.btn_ok);
        Button btn_close = (Button) dialog.findViewById(R.id.btn_close);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        dialog.show();
    }
}
