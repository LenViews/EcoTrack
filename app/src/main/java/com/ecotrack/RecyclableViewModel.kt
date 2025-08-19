package com.ecotrack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class RecyclableViewModel : ViewModel() {
    private val _recyclables = MutableLiveData<List<Recyclable>>(emptyList())
    val recyclables: LiveData<List<Recyclable>> = _recyclables
    
    private val _totalPoints = MutableLiveData(0)
    val totalPoints: LiveData<Int> = _totalPoints

    fun addRecyclable(item: Recyclable) {
        val currentList = _recyclables.value ?: emptyList()
        _recyclables.value = currentList + item
        _totalPoints.value = (_totalPoints.value ?: 0) + item.points
    }

    fun getRecyclablesCount(): Int {
        return _recyclables.value?.size ?: 0
    }
}