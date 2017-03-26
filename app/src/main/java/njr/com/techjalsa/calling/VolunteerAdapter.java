package njr.com.techjalsa.calling;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import njr.com.techjalsa.R;

/**
 * Created by dell on 20-02-2017.
 */

public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerAdapter.MyViewHolder> {

    private List<Volunteer> volunteerList;

    public VolunteerAdapter(List<Volunteer> volunteerList) {
        this.volunteerList = volunteerList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.calling_listitem, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Volunteer volunteer = volunteerList.get(position);
        holder.volunteer_name.setText(volunteer.getName());
        holder.volunteer_no.setText(volunteer.getNumber());
    }

    @Override
    public int getItemCount() {
        return volunteerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView volunteer_name;
        private TextView volunteer_no;
        private RelativeLayout relativeLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            volunteer_name = (TextView) itemView.findViewById(R.id.vol_name);
            volunteer_no = (TextView) itemView.findViewById(R.id.vol_no);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.list_row);
        }
    }
}
