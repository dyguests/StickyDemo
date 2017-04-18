package com.fanhl.stickydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assginViews();
    }

    private void assginViews() {
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new StickyRecyclerHeadersDecoration(adapter));
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements StickyRecyclerHeadersAdapter<MyAdapter.HeaderViewHolder> {
        @Override
        public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
            return new HeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false));
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item, parent, false));
        }

        @Override
        public void onBindHeaderViewHolder(HeaderViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public long getHeaderId(int position) {
            return position / 5;
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        public class HeaderViewHolder extends RecyclerView.ViewHolder {

            public HeaderViewHolder(View itemView) {
                super(itemView);
            }

            public void bind(int position) {
                ((TextView) itemView).setText("header " + position);
            }
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(View itemView) {
                super(itemView);
            }

            public void bind(int position) {
                ((TextView) itemView).setText("item " + position);
            }
        }
    }
}
