package com.example.dell.twmusic;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.twmusic.adapters.AdapterNavigation;
import com.example.dell.twmusic.fragments.OflineFragment;
import com.example.dell.twmusic.fragments.OnlineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ListView listView_navigation;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private List<Navi> navis;
    private AdapterNavigation adapter;
    private TextView tvtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);

        viewPager=(ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout=(TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tvtoolbar=(TextView) findViewById(R.id.tvtoolbar);

        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                tvtoolbar.setText("Bảng điều hướng");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                tvtoolbar.setText("Màn hình chính");
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();





        listView_navigation=(ListView) findViewById(R.id.listview_navi);
        navis=new ArrayList<>();
        navis.add(new Navi(R.drawable.home,"Home"));
        navis.add(new Navi(R.drawable.chatforfun,"Chat For Fun"));
        navis.add(new Navi(R.drawable.feedback,"Feedback"));
        navis.add(new Navi(R.drawable.about,"About"));
        navis.add(new Navi(R.drawable.exit,"Exit"));
        adapter=new AdapterNavigation(this,navis);


        listView_navigation.setAdapter(adapter);
        listView_navigation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                        break;
                }
            }
        });

    }

    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OnlineFragment(),"ONLINE");
        adapter.addFragment(new OflineFragment(),"OFLINE");
        viewPager.setAdapter(adapter);
    }
}
