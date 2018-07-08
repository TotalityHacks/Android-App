package productions.redefining.com.totalityhacks.adaptors;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import productions.redefining.com.totalityhacks.R;
import productions.redefining.com.totalityhacks.classes.CellClass;

/**
 * Created by MikeD on 7/8/2018.
 */

public class ScheduleAdaptor extends RecyclerView.Adapter<ScheduleAdaptor.ViewHolder> {
    private List<CellClass> cellData;
    private Context context;

    // Provide a reference to the views for each data item
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView eventName;
        public TextView eventLocationAndTime;
        public ImageView category;
        public ImageButton starButton;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            eventName = (TextView) v.findViewById(R.id.eventNameCell);
            eventLocationAndTime = (TextView) v.findViewById(R.id.eventTimeAndLocation);
            category = (ImageView) v.findViewById(R.id.categoryCircle);
            starButton = (ImageButton) v.findViewById(R.id.favoriteButton);
        }
    }

    public void add(int position, CellClass item) {
        cellData.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        cellData.remove(position);
        notifyItemRemoved(position);
    }

    public ScheduleAdaptor(List<CellClass> myDataset, Context context) {
        cellData = myDataset;
        this.context = context;
    }

    @Override
    public ScheduleAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.schedule_cell, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final CellClass currCell = cellData.get(position);
        holder.eventName.setText(currCell.getEventName());
        //TODO determine time difference
        holder.eventLocationAndTime.setText(currCell.getLocation() + currCell.getStartTime());

        final Drawable starFilled = context.getResources().getDrawable(R.drawable.star_filled);
        final Drawable star = context.getResources().getDrawable(R.drawable.star);
        final Drawable circle = context.getResources().getDrawable(R.drawable.circle);

        //TODO handle category color
        holder.category.setImageDrawable(circle);

        if (currCell.isFavorite()) {
            holder.starButton.setImageDrawable(starFilled);
        }
        else {
            holder.starButton.setImageDrawable(star);
        }

        holder.starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currCell.setFavorite(!currCell.isFavorite());
                if (currCell.isFavorite()) {
                    holder.starButton.setImageDrawable(starFilled);
                }
                else {
                    holder.starButton.setImageDrawable(star);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return cellData.size();
    }

}
