package com.example.storezaapdemo3.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.example.storezaapdemo.R
import com.example.storezaapdemo.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        /*if (ECONSTANT.logedUser != null) {
            navView.inflateMenu(R.menu.activity_home_drawer_login)
        } else {
            navView.inflateMenu(R.menu.activity_home_drawer_without_login)
        }
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()*/

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_stores,
                R.id.nav_services,
                R.id.newsFragment,
                R.id.userFragment,
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        NavigationUI.setupWithNavController(binding.appBarMain.bottomNavigationView,navController)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val menu = navigationView.menu

        val logoutMenuItem = menu.findItem(R.id.logout)
        logoutMenuItem.setOnMenuItemClickListener { menuItem ->
            // Clear user session
            clearUserSession()

            true
        }

    }

    private fun clearUserSession() {

        // Redirect user to Home screen
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)

        TODO("Not yet implemented")
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}