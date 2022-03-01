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

    fun setImage(uri: Uri) {
        _observeImage.value = uri.toString()
    }

}