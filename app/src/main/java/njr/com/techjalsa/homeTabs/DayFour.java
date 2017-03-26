package njr.com.techjalsa.homeTabs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import njr.com.techjalsa.CustomDialog;
import njr.com.techjalsa.R;
import njr.com.techjalsa.calling.RecyclerTouchListener;

/**
 * Created by dell on 19-02-2017.
 */
public class DayFour extends Fragment {

    private List<One> oneList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OneAdapter oneAdapter;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_four,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view4);
        oneList.clear();
        context = getContext();
        oneAdapter = new OneAdapter(oneList,context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(oneAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                switch(position){
                    case 0:
                        CustomDialog dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.last_day)[3]);
                        dialog.show();
                }
            }
            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        prepareEvent();
        oneAdapter.notifyDataSetChanged();
        return rootView;
    }
    private void prepareEvent() {
        One one = new One(R.drawable.last,getResources().getStringArray(R.array.last_day)[0],getResources().getStringArray(R.array.last_day)[1],
                getResources().getStringArray(R.array.last_day)[2]);
        oneList.add(one);
    }
}
