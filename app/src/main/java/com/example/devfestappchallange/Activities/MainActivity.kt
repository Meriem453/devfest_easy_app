package com.example.devfestappchallange.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.devfestappchallange.Fragments.AboutusFragment
import com.example.devfestappchallange.Fragments.HomeFragment
import com.example.devfestappchallange.R
import com.example.devfestappchallange.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bind : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableViewBinding()
        setupNavDrawer()
        setupScreens(1)

    }

    private fun setupScreens(sceen: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        when(sceen){
            1 ->  {transaction.replace(R.id.screens_layout, HomeFragment())
                    bind.drawerHome.background = resources.getDrawable(R.color.blue)
                bind.drawerAboutus.background = resources.getDrawable(R.color.white)
            }
            2 ->  {transaction.replace(R.id.screens_layout, AboutusFragment())
                bind.drawerHome.background = resources.getDrawable(R.color.white)
                bind.drawerAboutus.background = resources.getDrawable(R.color.blue)
            }
        }
        transaction.commit()
    }

    private fun setupNavDrawer() {
        bind.homeMenu.setOnClickListener {
            bind.layoutDrawer.open()
        }
        bind.drawerHome.setOnClickListener {
            setupScreens(1)

            bind.layoutDrawer.close()
        }
        bind.drawerAboutus.setOnClickListener {
            setupScreens(2)
            bind.layoutDrawer.close()


        }

    }

    private fun enableViewBinding() {
        bind=ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)    }
}