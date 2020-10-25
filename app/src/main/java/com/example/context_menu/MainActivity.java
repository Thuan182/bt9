package com.example.context_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    ConstraintLayout rela;
    ArrayList<CountriesModel> countriesData;
    CustomAdapter customAdapter;
    CountriesModel countriesModel;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        listView = findViewById(R.id.listView);
        rela = (ConstraintLayout) findViewById(R.id.rela);
        countriesData = new ArrayList<>();

        //add Countries Data
        populateCountriesData();

        customAdapter = new CustomAdapter(context, countriesData);
        listView.setAdapter(customAdapter);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, countriesData.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Cập nhật");
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.example_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.them:
                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sua:
                Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.xoa:
                Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void populateCountriesData() {
        //music1
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setName("Banh Mi");
        countriesModel.setImage(R.drawable.banhmi);
        countriesModel.setArea("10 $");

        countriesData.add(countriesModel);

        //music2
        countriesModel = new CountriesModel();
        countriesModel.setId(2);
        countriesModel.setName("Ghe hap");
        countriesModel.setImage(R.drawable.ghe);
        countriesModel.setArea("20$");

        countriesData.add(countriesModel);

        //music3
        countriesModel = new CountriesModel();
        countriesModel.setId(3);
        countriesModel.setName("Su Si");
        countriesModel.setImage(R.drawable.kimchi);
        countriesModel.setArea("30$");

        countriesData.add(countriesModel);

        //music4
        countriesModel = new CountriesModel();
        countriesModel.setId(4);
        countriesModel.setName("Pho Bo");
        countriesModel.setImage(R.drawable.pho);
        countriesModel.setArea("10$");

        countriesData.add(countriesModel);

        //music5
        countriesModel = new CountriesModel();
        countriesModel.setId(5);
        countriesModel.setName("Tom hum Hap");
        countriesModel.setImage(R.drawable.tomhum);
        countriesModel.setArea("50$");
        countriesModel.setPopulation("Billie Eilish");
        countriesData.add(countriesModel);

    }
    }
