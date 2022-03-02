package ru.maxdexter.homescreen.presenter.model

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

data class DishUi(
    val id: String = UUID.randomUUID().toString(),
    var dishName: String = "",
    var dishType: String = "",
    var dishCategory: String = "",
    var dishIngredients: String = "",
    var dishCookingTime: String = "",
    var cookingADish: String = "",
    var dishImage: String = ""
) {
    companion object{
        fun createFileImage(context: Context): Uri {
            val timeStamp: String =
                SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val fileDir: File = context.filesDir
            val file = File.createTempFile("JPEG_${timeStamp}_", ".png", fileDir)
            return file.let {
                FileProvider.getUriForFile(
                    context,
                    "ru.maxdexter.myrecipes.fileprovider",
                    it
                )
            }
        }
    }

}
