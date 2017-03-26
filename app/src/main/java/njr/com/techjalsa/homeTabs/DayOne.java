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
public class DayOne extends Fragment {

    private List<One> oneList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OneAdapter oneAdapter;
    private CustomDialog dialog;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
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
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.start)[3]);
                        dialog.show();
                        break;
                    case 1:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.setu)[3]);
                        dialog.show();
                        break;
                    case 2:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.tekken)[3]);
                        dialog.show();
                        break;
                    case 3:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.onset)[3]);
                        dialog.show();
                        break;
                    case 4:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.story)[3]);
                        dialog.show();
                        break;
                    case 5:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.avatar)[3]);
                        dialog.show();
                        break;
                    case 6:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.soccer)[3]);
                        dialog.show();
                        break;
                    case 7:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.roadies_one)[3]);
                        dialog.show();
                        break;
                    case 8:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.rocket)[3]);
                        dialog.show();
                        break;
                    case 9:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.stunt)[3]);
                        dialog.show();
                        break;
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
        One one = new One(R.drawable.inaguration,getResources().getStringArray(R.array.start)[0],getResources().getStringArray(R.array.start)[1],
                getResources().getStringArray(R.array.start)[2]);
        oneList.add(one);
        one = new One(R.drawable.setu,getResources().getStringArray(R.array.setu)[0],getResources().getStringArray(R.array.setu)[1],
                getResources().getStringArray(R.array.setu)[2]);
        oneList.add(one);
        one = new One(R.drawable.tekken,getResources().getStringArray(R.array.tekken)[0],getResources().getStringArray(R.array.tekken)[1],
                getResources().getStringArray(R.array.tekken)[2]);
        oneList.add(one);
        one = new One(R.drawable.onset,getResources().getStringArray(R.array.onset)[0],getResources().getStringArray(R.array.onset)[1],
                getResources().getStringArray(R.array.onset)[2]);
        oneList.add(one);
        one = new One(R.drawable.story,getResources().getStringArray(R.array.story)[0],getResources().getStringArray(R.array.story)[1],
                getResources().getStringArray(R.array.story)[2]);
        oneList.add(one);
        one = new One(R.drawable.face,getResources().getStringArray(R.array.avatar)[0],getResources().getStringArray(R.array.avatar)[1],
                getResources().getStringArray(R.array.avatar)[2]);
        oneList.add(one);
        one = new One(R.drawable.soccer,getResources().getStringArray(R.array.soccer)[0],getResources().getStringArray(R.array.soccer)[1],
                getResources().getStringArray(R.array.soccer)[2]);
        oneList.add(one);
        one = new One(R.drawable.roadies,getResources().getStringArray(R.array.roadies_one)[0],getResources().getStringArray(R.array.roadies_one)[1],
                getResources().getStringArray(R.array.roadies_one)[2]);
        oneList.add(one);
        one = new One(R.drawable.rocket,getResources().getStringArray(R.array.rocket)[0],getResources().getStringArray(R.array.rocket)[1],
                getResources().getStringArray(R.array.rocket)[2]);
        oneList.add(one);
        one = new One(R.drawable.stunt,getResources().getStringArray(R.array.stunt)[0],getResources().getStringArray(R.array.stunt)[1],
                getResources().getStringArray(R.array.stunt)[2]);
        oneList.add(one);
    }
}
