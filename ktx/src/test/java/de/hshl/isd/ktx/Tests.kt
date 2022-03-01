package de.hshl.isd.ktx

import io.github.italbytz.adapters.meal.MockGetMealsCommand
import org.junit.Test
import java.time.LocalDate

class Tests {
    @Test
    fun testWrapper() {
        val service = MockGetMealsCommand()
        val meals = service.executeFromJava(
            MealQueryDTO(mensa = 42, date = LocalDate.now())
        ).get()
        assert(meals.isNotEmpty())
    }
}

