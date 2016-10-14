package odravison.com.br.todoexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import odravison.com.br.todoexample.R;

/**
 * Created by odravison on 11/10/16.
 */

public class CustomRecycleViewAdapter extends RecyclerView.Adapter<CustomRecycleViewAdapter.LineViewHolder> {

    private ArrayList<String> setOfData;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class LineViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public LineViewHolder(View v) {
            super(v);
            mTextView = (TextView) v;
        }
    }

    public CustomRecycleViewAdapter(ArrayList<String> dataSet) {
        this.setOfData = dataSet;
    }


    //This method is invoked by LayoutManager
    @Override
    public LineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_view_recycleview_line, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new LineViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomRecycleViewAdapter.LineViewHolder holder, int position) {
        // - get element from dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(setOfData.get(position));
    }

    // Return the size of dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return setOfData.size();
    }
}
