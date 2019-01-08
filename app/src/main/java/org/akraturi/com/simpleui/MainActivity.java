package org.akraturi.com.simpleui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecylerView1;
    private RecyclerView mRecylerView2;
    private RecyclerView mRecyclerView3;
    private ContentAdapter adapter1,adapter2,adapter3;
    private List<Content> contents1,contents2,contents3;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_draft:
                    return true;
                case R.id.navigation_notification:
                    return true;
                case R.id.navigation_user:
                    return true;

            }
            return false;
        }
    };
    private void initViews(){

        mRecylerView1 = findViewById(R.id.recylerview1);
        mRecylerView2 = findViewById(R.id.recylerview2);
        mRecyclerView3 = findViewById(R.id.recylerview3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_draft);


        initViews();

        contents1 = new ArrayList<>();
        contents2 = new ArrayList<>();
        contents3 = new ArrayList<>();

        genrateContent();

        LinearLayoutManager linearLayoutManager1 =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecylerView1.setLayoutManager(linearLayoutManager1);

        LinearLayoutManager linearLayoutManager2 =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecylerView2.setLayoutManager(linearLayoutManager2);

        LinearLayoutManager linearLayoutManager3 =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView3.setLayoutManager(linearLayoutManager3);

        adapter1 = new ContentAdapter(contents1,this,R.layout.top_menu_row_item);
        adapter2 = new ContentAdapter(contents2,this,R.layout.card_row_item);
        adapter3 = new ContentAdapter(contents3,this,R.layout.card_row_item);


        mRecylerView1.setAdapter(adapter1);
        mRecylerView2.setAdapter(adapter2);
        mRecyclerView3.setAdapter(adapter3);



    }

    public void genrateContent(){

        int list2[] = { R.mipmap.picnic,R.mipmap.traveling,R.mipmap.groccery, R.mipmap.game,R.mipmap.burger,R.mipmap.holween , R.mipmap.juice ,
        R.mipmap.travel_party, R.mipmap.question , R.mipmap.party};

        int list1[] = {
                R.drawable.ic_directions_bike,R.drawable.ic_restaurant , R.drawable.ic_time_to_leave , R.drawable.ic_ondemand_video ,
        };



        for(int i=0;i<list2.length;i++){

            Content content2 = new Content();
            Content content3 = new Content();


            content2.setImageID(list2[i]);
            content3.setImageID(list2[list2.length-i-1]);


            contents2.add(content2);
            contents3.add(content3);


        }

        for(int i=0;i<list1.length;i++){
            Content content1 = new Content();
            content1.setImageID(list1[i]);
            contents1.add(content1);
        }



    }


}
