package com.rishi.puzzlemath.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rishi.puzzlemath.R;

public class NumberRecyclerAdapter extends RecyclerView.Adapter<NumberRecyclerAdapter.NumbersViewHolder>{

    private String[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public NumberRecyclerAdapter(Context context,String[] data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public NumbersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.number_recycler_item, parent,false);
        return new NumbersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NumbersViewHolder holder, int position) {
        holder.mNumberButton.setText(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class NumbersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        Button mNumberButton;

        public NumbersViewHolder(View itemView) {
            super(itemView);
            mNumberButton = itemView.findViewById(R.id.num_button);
            mNumberButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view,getAdapterPosition());

        }
    }
    public String getItem(int id) {
        return mData[id];
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
