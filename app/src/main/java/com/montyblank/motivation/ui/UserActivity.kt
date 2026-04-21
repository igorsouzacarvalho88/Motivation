package com.montyblank.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.montyblank.motivation.helper.MotivationConstants
import com.montyblank.motivation.R
import com.montyblank.motivation.databinding.ActivityUserBinding
import com.montyblank.motivation.repository.SecurityPreferences

class UserActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityUserBinding
    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        securityPreferences = SecurityPreferences(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setListeners()
        verifyUserName()

    }
    private fun verifyUserName(){
        val name = securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if (name.isNotEmpty()){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }


    override fun onClick(v: View) {
        if (v.id == R.id.button_save){
            handleSave()
        }
    }
    private fun handleSave(){
        val name =binding.edittextName.text.toString()

        if (name.isEmpty()){
            Toast.makeText(this,"Informe seu nome!", Toast.LENGTH_SHORT).show()
        }else{
            securityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME,name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
    private fun setListeners(){
        binding.buttonSave.setOnClickListener (this)
    }

}