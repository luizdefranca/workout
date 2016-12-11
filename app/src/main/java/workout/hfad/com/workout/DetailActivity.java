package workout.hfad.com.workout;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.R.attr.fragment;

public class DetailActivity extends AppCompatActivity {
   // private int workoutId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WorkoutDetailFragment fragment = (WorkoutDetailFragment) getSupportFragmentManager()
                                                            .findFragmentById(R.id.detail_fragment);
        int workoutId = getIntent().getExtras().getInt(WorkoutDetailFragment.WORKOUT_ID);
        fragment.setWorkoutId(workoutId);
    }


}
