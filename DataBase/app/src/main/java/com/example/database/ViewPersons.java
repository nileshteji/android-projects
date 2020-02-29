package com.example.database;

import android.database.Cursor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.database.DatabaseHelper;
import com.example.database.R;


public class ViewPersons extends AppCompatActivity {

    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextAdd;
    private Button btnShow;
    Button btnUpdate;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_persons);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAdd = (EditText) findViewById(R.id.editTextAddress);
btnUpdate=findViewById(R.id.Update);
        btnShow = (Button) findViewById(R.id.btnShow);

        db = new DatabaseHelper(this);


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPerson(Integer.parseInt(editTextId.getText().toString().trim()));
            }
        });

    btnUpdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String a=String.valueOf(editTextName.getText());
            db.delete(a);
        }
    });

    }


    private void showPerson(int id) {
        Cursor c = db.getPerson(id);
        c.moveToFirst();
        if (c != null) {
            editTextId.setText(c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_ID)));
            editTextName.setText(c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_NAME)));
            editTextAdd.setText(c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_ADD)));
        }
    }
}

