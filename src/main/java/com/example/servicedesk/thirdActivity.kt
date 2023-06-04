package com.example.servicedesk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class thirdActivity : AppCompatActivity() {

    lateinit var titleMsg : TextView
    private val hardware = "Hardwaer"
    private val software = "Softwaer"

    private val firstTec = "Abdullah"
    private val SecondTec = "Zeyad"
    private val thirdTec = "foog"

    lateinit var serviceList : AutoCompleteTextView
    lateinit var secondServiceList : AutoCompleteTextView
    lateinit var issueTxt : TextInputEditText
    lateinit var submentBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        initializationValue()
        userDetails()
        adapterList()
        sumBtn()


    }

    private fun userDetails(){

        val username = intent.getStringExtra("userName")
        val welcomeMsg = "Welcome $username"
        titleMsg.setText(welcomeMsg)
    }

    private fun initializationValue(){

        secondServiceList = findViewById(R.id.secondServiceList)
        serviceList = findViewById(R.id.serviceList)
        titleMsg = findViewById(R.id.textView)
        submentBtn = findViewById(R.id.button)
        issueTxt = findViewById(R.id.textInputEditText3)
    }

    private fun adapterList(){

        val listOfService = listOf(hardware , software)
        var adapter = ArrayAdapter(this , R.layout.drop_down_list_service , listOfService)
        serviceList.setAdapter(adapter)

        val listOfSecondService = listOf(firstTec,SecondTec,thirdTec)

        adapter = ArrayAdapter(this, R.layout.drop_down_second_list_service,listOfSecondService)
        secondServiceList.setAdapter(adapter)
    }

    private fun sumBtn(){
        submentBtn.setOnClickListener{

            if (issueTxt.text.toString().isNotEmpty()) {
                val myIntent = Intent(this, lastActivity::class.java)
                startActivity(myIntent)
            }else {
                Snackbar.make(issueTxt,"Text Field is required", Snackbar.LENGTH_SHORT).show()}



        }
    }
}