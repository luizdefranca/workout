package workout.hfad.com.workout;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WorkoutListListener{

    private WorkoutDetailFragment fragmentDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //O método getSupportFragmentManager é utilizado para pegar uma instância do Fragment
        // existe também o método getFragmentManager, mas neste caso é usado apenas se o seu
        //Fragment herdar de Fragment do android.app.Fragment, invés do Fragment do android.support.v4.app.Fragment;

    }


    @Override
    public void itemClicked(long id) {


        if (isPhone()) {

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(WorkoutDetailFragment.WORKOUT_ID, (int) id);
            startActivity(intent);
        } else {
            fragmentDetail = new WorkoutDetailFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragmentDetail);
            fragmentDetail.setWorkoutId((int)id);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.commit();
        }
    }

    private  boolean isPhone(){
        return getResources().getBoolean(R.bool.phone);
    }
}
