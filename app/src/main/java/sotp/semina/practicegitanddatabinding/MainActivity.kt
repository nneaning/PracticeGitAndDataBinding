package sotp.semina.practicegitanddatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
            .into(findViewById(R.id.image_profile_image))
    }

    private fun setProfileName(content:String) {
        findViewById<TextView>(R.id.text_profile_name).text = content
    }

    private fun addButtonClickEvent() {
        findViewById<Button>(R.id.button_profile_change_button).setOnClickListener {
            setProfileName(getEditTextToString(findViewById(R.id.input_changed_profile)))
        }
    }

    private fun getEditTextToString(content:EditText):String = content.text.toString()


    companion object {
        private const val IMAGE_URL = "https://avatars3.githubusercontent.com/u/45380072?s=460&u=b9fc82996ec2cc568a7dfcbf8846944dc16a7ccd&v=4"
        private const val DEFAULT_USER_NAME = "Default User Name"
    }
}