package ru.maxdexter.extansion

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.maxdexter.utils.R

@BindingAdapter("setImage")
fun ImageView.setImage(uri: String) {
    if (!uri.contentEquals("")) {
        Glide.with(this.context)
            .load(uri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_brocken_img)
            )
            .into(this)
    } else this.setImageResource(R.drawable.ic_baseline_image_24)

}