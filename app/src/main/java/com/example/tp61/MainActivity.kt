package com.example.tp61

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var sharedPreference: SharedPreference

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreference = SharedPreference(this)

        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val button = findViewById<Button>(R.id.button)
        editText1.setText(sharedPreference.getValueString("editText1"))
        editText2.setText(sharedPreference.getValueString("editText2"))
        checkBox.isChecked = sharedPreference.getValueBoolien("checkBox", false)

        button.setOnClickListener {
            if (checkBox.isChecked) {
                sharedPreference.save("editText1", editText1.text.toString())
                sharedPreference.save("editText2", editText2.text.toString())
                sharedPreference.save("checkBox", true)
            } else {
                sharedPreference.removeValue("editText1")
                sharedPreference.removeValue("editText2")
                sharedPreference.save("checkBox", false)
            }
        }




    }
}