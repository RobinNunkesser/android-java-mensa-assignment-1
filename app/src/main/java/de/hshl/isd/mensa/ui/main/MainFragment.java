package de.hshl.isd.mensa.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.time.LocalDate;
import java.util.List;

import de.hshl.isd.mensa.MealQueryDTO;
import de.hshl.isd.mensa.R;
import io.github.italbytz.adapters.meal.MockGetMealsCommand;
import io.github.italbytz.ports.meal.GetMealsCommand;
import io.github.italbytz.ports.meal.MealCollection;
import static de.hshl.isd.mensa.CoroutineWrapperKt.*;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private GetMealsCommand command = new MockGetMealsCommand();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try {
            executeFromJava(command,new
                    MealQueryDTO(42, LocalDate.now())).thenAccept(meals -> {
                        Log.i("MainFragment", meals.toString());
                    });
        } catch (Exception ex) {
            Log.e("MainFragment", ex.getLocalizedMessage());
        }

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel

    }

}