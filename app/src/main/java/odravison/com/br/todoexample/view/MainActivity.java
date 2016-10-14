package odravison.com.br.todoexample.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import odravison.com.br.todoexample.R;
import odravison.com.br.todoexample.adapter.CustomRecycleViewAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton mFloatingActionButton;
    private LayoutInflater inflater;
    private String[] data = {"teste", "teste", "teste", "teste", "teste", "teste", "teste", "teste",
            "teste", "teste", "teste", "teste", "teste", "teste", "teste", "teste", "teste", "teste",
            "teste", "teste", "teste", "teste", "teste", "teste", "teste", "teste", "teste", "teste",
            "teste", "teste", "teste", "teste", "teste", "teste", "teste", "teste", "teste", "teste"};


    private ArrayList<String> setOfData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_main);

        setOfData = new ArrayList<String>();
        for (int i = 0; i < data.length; i++){
            setOfData.add(data[i]);
        }


        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.add_button_task);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_todo);
        mAdapter = new CustomRecycleViewAdapter(setOfData);
        mLayoutManager = new LinearLayoutManager(this);



        /*
        This are defined as true if you have sure that, don't matter the data, the changes
        never will change layout size of the RecyclerView.
         */
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        //Setting up Refresh Listener to my SwipeRefreshLayout.
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showViewCreateTask();


            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshItems();

    }

    private void showViewCreateTask() {
        Intent intent = new Intent(MainActivity.this, TaskCreateActivity.class);
        startActivity(intent);
    }


    //Setting up methods that will be use by my SwipeRefreshLayoutListener
    public void refreshItems() {
        //LOAD ITEM
        // ....


        //Items LOAD COMPLETED
        onItemsCompleted();
    }

    public void onItemsCompleted(){
        // Update the adapter and notify data set changed
        // ...

        // Stop refresh animation
        mSwipeRefreshLayout.setRefreshing(false);
    }


}
