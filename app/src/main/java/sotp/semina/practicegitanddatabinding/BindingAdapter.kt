package sotp.semina.practicegitanddatabinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {


    @JvmStatic
    @BindingAdapter("showImage")
    fun showImage(view: ImageView, imageUrl: String){
        Glide.with(view.context)
            .load(imageUrl)
            .into(view)
    }

}