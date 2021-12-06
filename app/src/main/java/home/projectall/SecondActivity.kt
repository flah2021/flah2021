package home.projectall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

private const val HELLO_KEY = "hello"


class SecondActivity : AppCompatActivity() {

    lateinit var secondTextView:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        secondTextView = findViewById<TextView>(R.id.text_view_second_activity)

        val textValue: String? = intent.extras?.getString(KEY, "XAXAXA")
        secondTextView.text = textValue
    }
}