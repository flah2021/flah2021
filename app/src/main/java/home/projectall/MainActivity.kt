package home.projectall

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

const val KEY = "random int"
private const val HELLO_KEY = "hello"


class MainActivity : AppCompatActivity() {
    //Ранняя инициализация переменных
    lateinit var randomButton: Button
    lateinit var nextActivity: Button
    lateinit var openWeb:Button
    lateinit var randomTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // привязка переменных к кнопкам и полям по id
        randomButton = findViewById(R.id.button_random)
        nextActivity = findViewById(R.id.button_ferst_activity)
        openWeb = findViewById(R.id.button_open_web)
        randomTextView = findViewById(R.id.text_view_ferst_activity)

        //слушаем клики по кнопкам
        randomButton.setOnClickListener { ramdomClik() }

        openWeb.setOnClickListener {
            val webLink = Uri.parse("http://127.0.0.1")
            val intentOpenWeb: Intent = Intent(Intent.ACTION_VIEW, webLink)
            startActivity(intentOpenWeb)
        }

        nextActivity.setOnClickListener {
            val secondActivityIntend: Intent = Intent(this, SecondActivity::class.java)
            secondActivityIntend.putExtra(KEY,randomTextView.text.toString() )
            startActivity(secondActivityIntend)


        }

        //сохранение значения при повороти mainActivity
        if (savedInstanceState != null) {
            randomTextView.text = savedInstanceState.getString(KEY)
        }

    }


    //функции
    fun ramdomClik() {
        randomTextView.text = Random.nextInt(100).toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY, randomTextView.text.toString())
    }

}