package me.mqueiroz.moviepedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.mqueiroz.home.presentation.HomeFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MainFragmentFactory()
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val fragmentFactory = supportFragmentManager.fragmentFactory as MainFragmentFactory
        supportFragmentManager
            .beginTransaction()
            .add(content.id, fragmentFactory.instantiate(classLoader, HomeFragment::class))
            .commit()
    }
}