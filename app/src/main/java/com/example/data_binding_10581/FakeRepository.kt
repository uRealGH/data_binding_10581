package com.example.data_binding_10581

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

object FakeRepository {
    private val fruitNames: List<String> = listOf(
            "Apel","mangga","Pisang","Anggur","Stroberi",
            "Jambu","Rasberi","Bambu","Kiwi","Pir"
    )

    private val _currentRandomFruitName = MutableLiveData<String>()
    val currentRandomFruitName: LiveData<String>
        get() = _currentRandomFruitName

    init {
        _currentRandomFruitName.value = fruitNames.first()
    }

    fun getRandomFruitName(): String {
        val random = Random.nextInt(fruitNames.size)
        return fruitNames[random]
    }

    fun changeCurrentRandomFruitName() {
        _currentRandomFruitName.value = getRandomFruitName()
    }
}