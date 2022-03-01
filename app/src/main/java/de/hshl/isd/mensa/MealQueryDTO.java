package de.hshl.isd.mensa;

import java.time.LocalDate;

import androidx.annotation.NonNull;
import io.github.italbytz.ports.meal.MealQuery;

public class MealQueryDTO implements MealQuery {

    private int mensa;
    private LocalDate date;

    public MealQueryDTO(int mensa, LocalDate date) {
        this.mensa = mensa;
        this.date = date;
    }

    @NonNull
    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public int getMensa() {
        return mensa;
    }
}
