package productions.redefining.com.totalityhacks;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import productions.redefining.com.totalityhacks.adaptors.ScheduleAdaptor;
import productions.redefining.com.totalityhacks.classes.CellClass;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        initNavBar(bottomNavigationView);

        //set up recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.schedule_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<CellClass> cellData = new ArrayList<CellClass>();

        //TODO make API Call
        CellClass cellClass = new CellClass();
        cellClass.setEventName("Event Name");
        cellClass.setLocation("Here");
        cellClass.setStartTime("Now");
        cellData.add(cellClass);

        mAdapter = new ScheduleAdaptor(cellData, getApplicationContext());
        recyclerView.setAdapter(mAdapter);

    }


    //common functions for all activities

    public void initNavBar(BottomNavigationView bottomNavigationView) {
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_schedule:

                            case R.id.action_event:

                            case R.id.action_check_in:

                            case R.id.action_announcements:

                            case R.id.action_maps:

                        }
                        return true;
                    }
                });
    }
}
