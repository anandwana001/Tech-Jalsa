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
public class DayTwo extends Fragment {

    private List<One> oneList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OneAdapter oneAdapter;
    private CustomDialog dialog;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view2);
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
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.cs)[3]);
                        dialog.show();
                        break;
                    case 1:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.sketch)[3]);
                        dialog.show();
                        break;
                    case 2:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.debate)[3]);
                        dialog.show();
                        break;
                    case 3:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.mini)[3]);
                        dialog.show();
                        break;
                    case 4:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.roadies_two)[3]);
                        dialog.show();
                        break;
                    case 5:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.iot)[3]);
                        dialog.show();
                        break;
                    case 6:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.omg)[3]);
                        dialog.show();
                        break;
                    case 7:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.rangoli)[3]);
                        dialog.show();
                        break;
                    case 8:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.btb)[3]);
                        dialog.show();
                        break;
                    case 9:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.robowar)[3]);
                        dialog.show();
                        break;
                    case 10:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.gd)[3]);
                        dialog.show();
                        break;
                    case 11:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.roadies_three)[3]);
                        dialog.show();
                        break;
                    case 12:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.closing_two)[3]);
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
        One one = new One(R.drawable.cs,getResources().getStringArray(R.array.cs)[0],getResources().getStringArray(R.array.cs)[1],
                getResources().getStringArray(R.array.cs)[2]);
        oneList.add(one);
        one = new One(R.drawable.sketch,getResources().getStringArray(R.array.sketch)[0],getResources().getStringArray(R.array.sketch)[1],
                getResources().getStringArray(R.array.sketch)[2]);
        oneList.add(one);
        one = new One(R.drawable.debate,getResources().getStringArray(R.array.debate)[0],getResources().getStringArray(R.array.debate)[1],
                getResources().getStringArray(R.array.debate)[2]);
        oneList.add(one);
        one = new One(R.drawable.mini,getResources().getStringArray(R.array.mini)[0],getResources().getStringArray(R.array.mini)[1],
                getResources().getStringArray(R.array.mini)[2]);
        oneList.add(one);
        one = new One(R.drawable.roadies,getResources().getStringArray(R.array.roadies_two)[0],getResources().getStringArray(R.array.roadies_two)[1],
                getResources().getStringArray(R.array.roadies_two)[2]);
        oneList.add(one);
        one = new One(R.drawable.iot,getResources().getStringArray(R.array.iot)[0],getResources().getStringArray(R.array.iot)[1],
                getResources().getStringArray(R.array.iot)[2]);
        oneList.add(one);
        one = new One(R.drawable.omg,getResources().getStringArray(R.array.omg)[0],getResources().getStringArray(R.array.omg)[1],
                getResources().getStringArray(R.array.omg)[2]);
        oneList.add(one);
        one = new One(R.drawable.rangoli,getResources().getStringArray(R.array.rangoli)[0],getResources().getStringArray(R.array.rangoli)[1],
                getResources().getStringArray(R.array.rangoli)[2]);
        oneList.add(one);
        one = new One(R.drawable.btb,getResources().getStringArray(R.array.btb)[0],getResources().getStringArray(R.array.btb)[1],
                getResources().getStringArray(R.array.btb)[2]);
        oneList.add(one);
        one = new One(R.drawable.war,getResources().getStringArray(R.array.robowar)[0],getResources().getStringArray(R.array.robowar)[1],
                getResources().getStringArray(R.array.robowar)[2]);
        oneList.add(one);
        one = new One(R.drawable.gd,getResources().getStringArray(R.array.gd)[0],getResources().getStringArray(R.array.gd)[1],
                getResources().getStringArray(R.array.gd)[2]);
        oneList.add(one);
        one = new One(R.drawable.roadies,getResources().getStringArray(R.array.roadies_three)[0],getResources().getStringArray(R.array.roadies_three)[1],
                getResources().getStringArray(R.array.roadies_three)[2]);
        oneList.add(one);
        one = new One(R.drawable.dj,getResources().getStringArray(R.array.closing_two)[0],getResources().getStringArray(R.array.closing_two)[1],
                getResources().getStringArray(R.array.closing_two)[2]);
        oneList.add(one);
    }
}
