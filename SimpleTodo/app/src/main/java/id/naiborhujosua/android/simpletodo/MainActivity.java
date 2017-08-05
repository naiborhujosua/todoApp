package id.naiborhujosua.android.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;
    EditText etNewItem;
    private static final int REQUEST_CODE =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readItems();
        lvItems = (ListView) findViewById(R.id.lvItems);
        //items =new ArrayList<>();

        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        lvItems.setAdapter(itemsAdapter);
        setListViewListener();
        setupEditListener();
    }

    public void onAddItem(View v){
        etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems();
    }

    private void setListViewListener(){
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                items.remove(i);
                itemsAdapter.notifyDataSetChanged();
                writeItems();
                return true;
            }
        });
    }

    private void setupEditListener(){
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,EditItemActivity.class);
                intent.putExtra("position", i);
                intent.putExtra("item", items.get(i));
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    protected void onActivityResult(int requestCode,int resultCode, Intent data ){
        if (resultCode ==RESULT_OK && requestCode ==REQUEST_CODE){
            int position = data.getIntExtra("position",0);
            String item = data.getStringExtra("item");
            items.set(position,item);
            itemsAdapter.notifyDataSetChanged();
            writeItems();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_todo,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void readItems(){
        File fileDir =getFilesDir();
        File todoFile = new File(fileDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));

        } catch (IOException e) {
            items = new ArrayList<>();
        }
    }

    private  void writeItems(){
        //FileUtils from library in the dependency(commonns-io:2.4)
        File fileDir = getFilesDir();
        File todoFile = new File(fileDir,"todo.txt");
        try {
            FileUtils.writeLines(todoFile,items);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
