package sotp.semina.practicegitanddatabinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/*TODO step3 아래 BindingAdapter 에서 다음과 같은 일을 처리합니다.
*  1. 뷰 속성으로 app:image 라는 이름으로 Glide를 사용하여 결합합니다.
*  이후 다시 레이아웃에서 이미지 부분을 수정합니다.
*/
object BindingAdapter {
    @BindingAdapter("app:image")
    @JvmStatic
    fun imageBinding(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }

}