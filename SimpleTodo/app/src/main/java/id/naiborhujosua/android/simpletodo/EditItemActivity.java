package id.naiborhujosua.android.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


/**
 * Created by dell on 8/4/2017.
 */

public class EditItemActivity extends AppCompatActivity {
    EditText mEditText;
    int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String item = getIntent().getStringExtra("item");
        position = getIntent().getIntExtra("position",0);
        mEditText = (EditText) findViewById(R.id.editItem);
        mEditText.setText(item);

    }

    @Override
    //inflate menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle item click on the action bar
        int id = item.getItemId();

        if (id==R.id.action_settings){
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }

    public void onSubmit(View v){
        Intent item = new Intent();
        String itemValue = mEditText.getText().toString();
        item.putExtra("item", itemValue);
        item.putExtra("ItemList",position);
        setResult(RESULT_OK,item);
        finish();
    }
}
