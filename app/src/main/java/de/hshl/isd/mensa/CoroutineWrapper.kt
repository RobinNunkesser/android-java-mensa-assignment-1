package de.hshl.isd.mensa

import io.github.italbytz.ports.meal.GetMealsCommand
import io.github.italbytz.ports.meal.MealCollection
import io.github.italbytz.ports.meal.MealQuery
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import java.util.concurrent.CompletableFuture

fun GetMealsCommand.executeFromJava(inDTO: MealQuery): CompletableFuture<List<MealCollection>> =
    GlobalScope.future {
        this@executeFromJava.execute(inDTO)
    }