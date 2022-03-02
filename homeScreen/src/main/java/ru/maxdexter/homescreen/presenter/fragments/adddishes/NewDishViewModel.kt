package ru.maxdexter.homescreen.presenter.fragments.adddishes

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.maxdexter.homescreen.presenter.model.DishUi

class NewDishViewModel : ViewModel() {
    var dish: DishUi = DishUi()

    private val _observeImage = MutableLiveData("")
    val observeImage: LiveData<String> = _observeImage

    private val _observeDishTitle = MutableLiveData("")
    val observeDishTitle: LiveData<String> = _observeDishTitle
    private val _observeDishType = MutableLiveData("")
    private val _observeDishCategory = MutableLiveData("")
    private val _observeDishIngredients = MutableLiveData("")
    private val _observeDishCookingTime = MutableLiveData("")
    private val _observeDishDirectionCooking = MutableLiveData("")

    fun setImage(uri: Uri) {
        _observeImage.value = uri.toString()
    }


    fun saveDishTitle(s: String?) {
        if (!s.isNullOrEmpty()) {
            _observeDishTitle.value = s
        }
    }

    fun saveDishType(s: String?) {
        if (!s.isNullOrEmpty()) {
            _observeDishType.value = s
        }
    }

    fun saveDishCategory(s: String?) {
        if (!s.isNullOrEmpty()) {
            _observeDishCategory.value = s
        }
    }

    fun saveDishIngredients(s: String?) {
        if (!s.isNullOrEmpty()) {
            _observeDishIngredients.value = s
        }
    }

    fun saveDishCookingTime(s: String?) {
        if (!s.isNullOrEmpty()) {
            _observeDishCookingTime.value = s
        }
    }

    fun saveDishDescriptionCooking(s: String?) {
        if (!s.isNullOrEmpty()) {
            _observeDishDirectionCooking.value = s
        }
    }

    fun newDishSave() {
        dish.dishType = _observeDishType.value ?: EMPTY_STRING
        dish.dishCategory = _observeDishCategory.value ?: EMPTY_STRING
        dish.dishName = _observeDishTitle.value ?: EMPTY_STRING
        dish.dishIngredients = _observeDishIngredients.value ?: EMPTY_STRING
        dish.dishCookingTime = _observeDishCookingTime.value ?: EMPTY_STRING
        dish.cookingADish = _observeDishDirectionCooking.value ?: EMPTY_STRING
        dish.dishImage = _observeImage.value ?: EMPTY_STRING

    }

    companion object {
        const val EMPTY_STRING = ""
    }
}