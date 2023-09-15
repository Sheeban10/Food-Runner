package com.example.foodruner.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.foodruner.R
import com.example.foodruner.databinding.ActivityMainBinding
import com.example.foodruner.fragments.HomeFragment
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var drawerLayout : DrawerLayout
    lateinit var coLayout : CoordinatorLayout
    lateinit var toolbar : Toolbar
    lateinit var frameLayout : FrameLayout
    lateinit var navigationView : NavigationView

    var previousMenuItem : MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        drawerLayout = binding.drawerLayout
        coLayout = binding.coLayout
        toolbar = binding.toolbar
        frameLayout = binding.frame
        navigationView = binding.navigationView

        sharedPreferences = getSharedPreferences(getString(R.string.shared_preference), Context.MODE_PRIVATE)

        firebaseAuth = FirebaseAuth.getInstance()

        openHome()
        setupToolBar()


        val actionBarDrawerToggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            if ( previousMenuItem != null){
                    previousMenuItem?.isChecked = false
            }
            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when(it.itemId){

                R.id.home ->{
                    openHome()

                    drawerLayout.closeDrawers()
                }

                R.id.profile ->{

                }

                R.id.favourites ->{

                }

                R.id.faq ->{

                }

                R.id.logOut ->{
                    logout()

                    drawerLayout.closeDrawers()
                }
            }


            return@setNavigationItemSelectedListener true
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun setupToolBar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Toolbar"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //for hambrgr icon to work
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == android.R.id.home)
            drawerLayout.openDrawer(GravityCompat.START)

        return super.onOptionsItemSelected(item)
    }


    fun logout(){

        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Log Out")
        dialog.setMessage("Do you want to LogOut?")

        dialog.setPositiveButton("Yes"){ text ,listener ->

            sharedPreferences.edit().remove("isLoggedIn").apply()
            firebaseAuth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        dialog.setNegativeButton("No"){ text ,listener ->
        }
        dialog.create()
        dialog.show()
    }

    fun openHome(){

        val fragment = HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.frame, fragment)
        transaction.commit()
        supportActionBar?.title = "Home"
        navigationView.setCheckedItem(R.id.home)
    }

//    override fun onBackPressed() {
//        val fragment = supportFragmentManager.findFragmentById(R.id.frame)
//
//        when(fragment){
//            !is HomeFragment -> openHome()
//
//            else ->super.onBackPressed()
//        }
//    }
}