package sotp.semina.practicegitanddatabinding

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import sotp.semina.practicegitanddatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.userProfile = UserData(IMAGE_URL, DEFAULT_USER_NAME)
        addButtonClickEvent(binding)
    }

    private fun setProfileName(binding: ActivityMainBinding, content: String) {
        binding.userProfile = UserData(IMAGE_URL,content)
    }

    private fun addButtonClickEvent(binding: ActivityMainBinding) {
        binding.buttonProfileChangeButton.setOnClickListener {
            setProfileName(
                binding,
                getEditTextToString(binding.inputChangedProfile)
            )
        }
    }

    private fun getEditTextToString(content: EditText): String = content.text.toString()


    companion object {
        private const val IMAGE_URL =
            "https://avatars3.githubusercontent.com/u/45380072?s=460&u=b9fc82996ec2cc568a7dfcbf8846944dc16a7ccd&v=4"
        private const val DEFAULT_USER_NAME = "Default User Name"
    }
}