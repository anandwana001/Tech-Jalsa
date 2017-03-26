package njr.com.techjalsa.homeTabs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import njr.com.techjalsa.R;

/**
 * Created by dell on 21-02-2017.
 */

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.MyViewHolder> {

    private List<One> oneList;
    private Context context;

    public OneAdapter(List<One> oneList, Context context) {
        this.context = context;
        this.oneList = oneList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_listitem, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        One one = oneList.get(position);
        Picasso.with(context).load(one.getmImageView()).into(holder.mImageView);
        holder.mEventName.setText(one.getmEventName());
        holder.mEventTime.setText(one.getmEventTime());
        holder.mEventVenue.setText(one.getmEventVenue());
    }

    @Override
    public int getItemCount() {
        return oneList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView mEventName;
        private TextView mEventTime;
        private TextView mEventVenue;
        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.thumbnail);
            mEventName = (TextView) itemView.findViewById(R.id.event_name);
            mEventTime = (TextView) itemView.findViewById(R.id.event_time);
            mEventVenue = (TextView) itemView.findViewById(R.id.event_venue);
        }
    }
}
