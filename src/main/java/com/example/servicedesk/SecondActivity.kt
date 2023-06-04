package com.example.servicedesk

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class SecondActivity : AppCompatActivity() {

    lateinit var userName : TextInputEditText
    lateinit var password : TextInputEditText
    lateinit var logInBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initializationView()
        sharedGetData()
        loginButton()

}


    private fun initializationView (){

        userName = findViewById(R.id.userNameEditText)
        password = findViewById(R.id.PasswordEditText)
        logInBtn = findViewById(R.id.logInButton)
    }

    private fun sharedGetData(){

        var sharedPreferences =getSharedPreferences("userNameS",Context.MODE_PRIVATE)
        var userNameTwo = sharedPreferences.getString("user_name","None")
        userName.setText(userNameTwo)
    }
    private fun loginButton(){

        logInBtn.setOnClickListener{

            val userNameI = userName.text.toString()
            val passwordI = password.text.toString()

            var sharedPreferences = getSharedPreferences("userNameS" , Context.MODE_PRIVATE)
           // Snackbar.make(userName,"sucssfull",Snackbar.LENGTH_SHORT).show()
            var editier = sharedPreferences.edit()

            editier.putString("user_name" , userName.text.toString() )
            editier.commit()


            if (userName.text.toString().isNotEmpty()) {

                val myIntent = Intent (this , thirdActivity::class.java)

                myIntent.putExtra("userName",userNameI)

                startActivity(myIntent)

            }else {
                Snackbar.make(userName,"User Name is required",Snackbar.LENGTH_SHORT).show()
            }

//            val myIntent = Intent (this , thirdActivity::class.java)
//
//            myIntent.putExtra("userName",userNameI)
//            myIntent.putExtra("password", passwordI)
//
//            startActivity(myIntent)


        }
    }
}