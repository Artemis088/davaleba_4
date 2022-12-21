package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.myapplication2.Feagments.FragmentFiles
import com.example.myapplication2.Feagments.FragmentHome
import com.example.myapplication2.Feagments.FragmentShearedFolders
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigation = findViewById(R.id.bottomNavigation)

        val homeFragment = FragmentHome()
        val shearedFoldersFragment = FragmentShearedFolders()
        val filesFragment = FragmentFiles()

        setCurrentFragment(homeFragment)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navHome -> setCurrentFragment(homeFragment)
                R.id.navSharedFolders -> setCurrentFragment(shearedFoldersFragment)
                R.id.navFiles -> setCurrentFragment(filesFragment)
            }
            true
        }

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            callActivity()
        }
    }

    private fun callActivity(){
        val editText = findViewById<EditText>(R.id.etName)
        val message = editText.text.toString()

        val intent = Intent(this,MainActivity2::class.java).also {
            it.putExtra("EXTRA_MESSAGE",message)
            startActivity(it)
        }
    }

    private fun setCurrentFragment(Fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, Fragment)
            commit()
        }
    }
}