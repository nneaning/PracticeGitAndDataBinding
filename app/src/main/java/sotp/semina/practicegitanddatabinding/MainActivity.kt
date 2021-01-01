package sotp.semina.practicegitanddatabinding

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import sotp.semina.practicegitanddatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    var editText = ObservableField<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        binding.userProfile = UserData(IMAGE_URL, DEFAULT_USER_NAME)
    }

    private fun setProfileName(content: String) {
        binding.userProfile = UserData(IMAGE_URL,content)
    }

    fun changeName(){
        setProfileName(editText.get()?: DEFAULT_USER_NAME)
    }

    companion object {
        private const val IMAGE_URL =
            "https://avatars3.githubusercontent.com/u/45380072?s=460&u=b9fc82996ec2cc568a7dfcbf8846944dc16a7ccd&v=4"
        private const val DEFAULT_USER_NAME = "Default User Name"
    }
}