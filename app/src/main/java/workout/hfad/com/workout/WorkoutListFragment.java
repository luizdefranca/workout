package workout.hfad.com.workout;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import workout.hfad.com.workout.model.Workout;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {

    private static WorkoutListListener mListener;

    public WorkoutListFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<String> names = new ArrayList<>();
        for (Workout workout: Workout.worktouts) {
            names.add(workout.getName());

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext()
                                                                , android.R.layout.simple_list_item_1
                                                                , names);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mListener = (WorkoutListListener) context;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
        if(mListener != null){
            mListener.itemClicked(id);
        }
    }
}
