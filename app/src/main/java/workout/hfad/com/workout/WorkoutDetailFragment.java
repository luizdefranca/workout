package workout.hfad.com.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import workout.hfad.com.workout.model.Workout;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    public static final String WORKOUT_ID = "workoutID";
    private int workoutId;
    private Workout mWorkout;

    View view;

    TextView mTxtViewTitle;
    TextView mTxtViewDescription;


    public WorkoutDetailFragment() {}


    /**
     * Este método é chamadado quando o Android precisa do layout do Fragment
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //pegar as variáveis da View quando ela é destruida
        if(savedInstanceState !=null){
            workoutId = savedInstanceState.getInt(WORKOUT_ID);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false); // Este método informa ao Android qual o layout o framegment utiliza
    }


    @Override
    public void onStart() {
        super.onStart();

        view = getView();
        if(view != null){
            mWorkout = Workout.worktouts[workoutId];
            mTxtViewTitle = (TextView) view.findViewById(R.id.textTitle);
            mTxtViewDescription = (TextView) view.findViewById(R.id.textDescription);
            mTxtViewTitle.setText(mWorkout.getName());
            mTxtViewDescription.setText(mWorkout.getDescription());

        }


    }

    //Salva a variável workoutId caso o aparelho seja girado
    public void setWorkoutId(int id){
        this.workoutId = id;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    outState.putInt(WORKOUT_ID, workoutId);
    }
}
