package com.anton46.whatsapp_profile;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    @Bind(R.id.toolbar_header_view)
    protected HeaderView toolbarHeaderView;

    @Bind(R.id.float_header_view)
    protected HeaderView floatHeaderView;

    @Bind(R.id.appbar)
    protected AppBarLayout appBarLayout;

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

    @Bind(R.id.recyclerView)
    protected RecyclerView mRecyclerView;

    private boolean isHideToolbarView = false;

    CardAdapter mAdapter;
    List<Flower> mFlowers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUi();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        initializeData();

        mAdapter = new CardAdapter(mFlowers);

        mRecyclerView.setAdapter(mAdapter);
    }

    private void initUi() {
        appBarLayout.addOnOffsetChangedListener(this);

        toolbarHeaderView.bindTo("Larry Page", "Last seen today at 7.00PM");
        floatHeaderView.bindTo("Larry Page", "Last seen today at 7.00PM");
    }


    private void initializeData() {
        mFlowers = new ArrayList<>();
        mFlowers.add(new Flower("Flower 1", R.drawable.image2));
        mFlowers.add(new Flower("Flower 2", R.drawable.images3));
        mFlowers.add(new Flower("Flower 3", R.drawable.images4));
        mFlowers.add(new Flower("Flower 4", R.drawable.images6));
        mFlowers.add(new Flower("Flower 5", R.drawable.images7));
        mFlowers.add(new Flower("Flower 6", R.drawable.images10));
        mFlowers.add(new Flower("Flower 7", R.drawable.images11));
        mFlowers.add(new Flower("Flower 8", R.drawable.images12));
        mFlowers.add(new Flower("Flower 9", R.drawable.images14));
        mFlowers.add(new Flower("Flower 10", R.drawable.images17));
        mFlowers.add(new Flower("Flower 11", R.drawable.images18));
        mFlowers.add(new Flower("Flower 12", R.drawable.index));
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        if (percentage == 1f && isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.VISIBLE);
            isHideToolbarView = !isHideToolbarView;

        } else if (percentage < 1f && !isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.GONE);
            isHideToolbarView = !isHideToolbarView;
        }
    }
}
