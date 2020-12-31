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
    private lateinit var binding: ActivityMainBinding
    var profilename = "profileName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this
        initView()
    }

    private fun initView() {
        initProfileImage()
        setProfileName(DEFAULT_USER_NAME)
        addButtonClickEvent()
    }


    private fun initProfileImage() {
        Glide.with(this)
            .load(IMAGE_URL)
            .into(binding.imageProfileImage)
    }

    private fun setProfileName(content:String) {
        profilename = content
        binding.invalidateAll()
    }

    private fun addButtonClickEvent() {
        binding.buttonProfileChangeButton.setOnClickListener {
            setProfileName(getEditTextToString(findViewById(R.id.input_changed_profile)))
        }
    }

    private fun getEditTextToString(content:EditText):String = content.text.toString()


    companion object {
        private const val IMAGE_URL = "https://avatars3.githubusercontent.com/u/45380072?s=460&u=b9fc82996ec2cc568a7dfcbf8846944dc16a7ccd&v=4"
        private const val DEFAULT_USER_NAME = "Default User Name"
    }
}