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
public class DayThree extends Fragment {

    private List<One> oneList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OneAdapter oneAdapter;
    private CustomDialog dialog;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_three,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view3);
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
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.iGenius)[3]);
                        dialog.show();
                        break;
                    case 1:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.impromptu)[3]);
                        dialog.show();
                        break;
                    case 2:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.mehandi)[3]);
                        dialog.show();
                        break;
                    case 3:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.fifa)[3]);
                        dialog.show();
                        break;
                    case 4:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.rush)[3]);
                        dialog.show();
                        break;
                    case 5:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.wall)[3]);
                        dialog.show();
                        break;
                    case 6:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.roadies_four)[3]);
                        dialog.show();
                        break;
                    case 7:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.codex)[3]);
                        dialog.show();
                        break;
                    case 8:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.tamasha)[3]);
                        dialog.show();
                        break;
                    case 9:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.roadies_final)[3]);
                        dialog.show();
                        break;
                    case 10:
                        dialog = new CustomDialog(getActivity(),getResources().getStringArray(R.array.closing)[3]);
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
        One one = new One(R.drawable.igen,getResources().getStringArray(R.array.iGenius)[0],getResources().getStringArray(R.array.iGenius)[1],
                getResources().getStringArray(R.array.iGenius)[2]);
        oneList.add(one);
        one = new One(R.drawable.extemporary,getResources().getStringArray(R.array.impromptu)[0],getResources().getStringArray(R.array.impromptu)[1],
                getResources().getStringArray(R.array.impromptu)[2]);
        oneList.add(one);
        one = new One(R.drawable.mehandi,getResources().getStringArray(R.array.mehandi)[0],getResources().getStringArray(R.array.mehandi)[1],
                getResources().getStringArray(R.array.mehandi)[2]);
        oneList.add(one);
        one = new One(R.drawable.fifa,getResources().getStringArray(R.array.fifa)[0],getResources().getStringArray(R.array.fifa)[1],
                getResources().getStringArray(R.array.fifa)[2]);
        oneList.add(one);
        one = new One(R.drawable.rush,getResources().getStringArray(R.array.rush)[0],getResources().getStringArray(R.array.rush)[1],
                getResources().getStringArray(R.array.rush)[2]);
        oneList.add(one);
        one = new One(R.drawable.wall,getResources().getStringArray(R.array.wall)[0],getResources().getStringArray(R.array.wall)[1],
                getResources().getStringArray(R.array.wall)[2]);
        oneList.add(one);
        one = new One(R.drawable.roadies,getResources().getStringArray(R.array.roadies_four)[0],getResources().getStringArray(R.array.roadies_four)[1],
                getResources().getStringArray(R.array.roadies_four)[2]);
        oneList.add(one);
        one = new One(R.drawable.cdng,getResources().getStringArray(R.array.codex)[0],getResources().getStringArray(R.array.codex)[1],
                getResources().getStringArray(R.array.codex)[2]);
        oneList.add(one);
        one = new One(R.drawable.nukkad,getResources().getStringArray(R.array.tamasha)[0],getResources().getStringArray(R.array.tamasha)[1],
                getResources().getStringArray(R.array.tamasha)[2]);
        oneList.add(one);
        one = new One(R.drawable.roadies,getResources().getStringArray(R.array.roadies_final)[0],getResources().getStringArray(R.array.roadies_final)[1],
                getResources().getStringArray(R.array.roadies_final)[2]);
        oneList.add(one);
        one = new One(R.drawable.clsng,getResources().getStringArray(R.array.closing)[0],getResources().getStringArray(R.array.closing)[1],
                getResources().getStringArray(R.array.closing)[2]);
        oneList.add(one);
    }
}
