package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddItemActivity extends AppCompatActivity {

    private int index = 0;private Item item;
    private TextInputLayout item_title_name;
    private TextInputLayout item_title_class;
    private TextInputLayout item_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = this.getIntent();
        index = intent.getIntExtra("index",-1);
        Log.d("asd", String.valueOf(index));
        if(index != -1){
            item = (Item) intent.getParcelableExtra("item");
            item_title_name = (TextInputLayout) findViewById(R.id.item_title_name);
            item_title_name.getEditText().setText(item.itemName);
            item_title_class = (TextInputLayout) findViewById(R.id.item_title_class);
            item_title_class.getEditText().setText(item.itemClassification);
            item_size = (TextInputLayout) findViewById(R.id.item_size);
            item_size.getEditText().setText(item.itemSize);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem itemMenu){
        if (itemMenu.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        if (itemMenu.getItemId() == R.id.action_save) {
            item = new Item();
            item.itemName = ((TextInputLayout)findViewById(R.id.item_title_name)).getEditText().getText().toString();
            item.itemClassification = ((TextInputLayout)findViewById(R.id.item_title_class)).getEditText().getText().toString();
            item.itemSize = ((TextInputLayout)findViewById(R.id.item_size)).getEditText().getText().toString();
            Intent intent = new Intent();
            intent.putExtra("index", index);

            intent.putExtra("item", item);
            setResult(Activity.RESULT_OK,intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(itemMenu);
    }
}