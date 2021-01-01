package sotp.semina.practicegitanddatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import sotp.semina.practicegitanddatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initProfileImage(binding.imageProfileImage)
        setProfileName(binding.textProfileName, DEFAULT_USER_NAME)
        addButtonClickEvent(binding)
    }

    private fun initProfileImage(imageView: ImageView) {
        Glide.with(imageView.context)
            .load(IMAGE_URL)
            .into(imageView)
    }

    private fun setProfileName(profileName:TextView, content:String) {
        profileName.text = content
    }

    private fun addButtonClickEvent(binding : ActivityMainBinding) {
        binding.buttonProfileChangeButton.setOnClickListener {
            setProfileName(binding.textProfileName, getEditTextToString(binding.inputChangedProfile))
        }
    }

    private fun getEditTextToString(content:EditText):String = content.text.toString()


    companion object {
        private const val IMAGE_URL = "https://avatars3.githubusercontent.com/u/45380072?s=460&u=b9fc82996ec2cc568a7dfcbf8846944dc16a7ccd&v=4"
        private const val DEFAULT_USER_NAME = "Default User Name"
    }
}