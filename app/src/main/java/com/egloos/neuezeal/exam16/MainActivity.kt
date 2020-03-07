package com.egloos.neuezeal.exam16

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendButton.setOnClickListener(View.OnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.contentFrame)
            if (fragment is ContentFragment){
                fragment.setActivityText(inputText.text.toString())
            }
        })

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contentFrame, ContentFragment())
        transaction.commit()
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is ContentFragment){
            fragment.onInputTextListener = object: ContentFragment.OnInputTextListener{
                override fun onInputText(text: String?) {
                    fragmentText.text = text
                }
            }
        }
    }
}
