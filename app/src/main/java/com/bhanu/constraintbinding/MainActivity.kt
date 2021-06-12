package com.bhanu.constraintbinding

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.bhanu.constraintbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.textView2.text = "Data Binding"

        binding.button.setOnClickListener {
            binding.textView2.text = binding.editTextTextPersonName.text

        }
        //second -> open second button in screen 1
        binding.second.setOnClickListener{
            var intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }


        binding.browser.setOnClickListener{
            var data = Uri.parse( "https://www.google.com")

            var intent = Intent(Intent.ACTION_VIEW,data)

            startActivity(intent)
        }

        binding.sms.setOnClickListener{
            var data = Uri.parse("smsto:9818469387")
            var intent = Intent(Intent.ACTION_SENDTO,data)
            startActivity(intent)
        }
    }
}