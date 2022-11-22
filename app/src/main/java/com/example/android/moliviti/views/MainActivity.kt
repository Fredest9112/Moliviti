package com.example.android.moliviti.views

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import com.example.android.moliviti.R
import com.example.android.moliviti.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    navController.popBackStack(R.id.home_fragment, true)
                    navController.navigate(R.id.home_fragment)
                    binding.drawerLayout.close()
                }
                R.id.nav_bus -> {
                    Toast.makeText(this, "Rutas fue clickeado", Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                }
                R.id.nav_card -> {
                    if (navController.currentDestination == navController.findDestination(R.id.checkBusCardFragment)) {
                        binding.drawerLayout.close()
                    } else {
                        navController.navigate(R.id.action_home_fragment_to_checkBusCardFragment)
                        binding.drawerLayout.close()
                    }

                }
                R.id.nav_fav -> {
                    Toast.makeText(this, "Favoritos fue clickeado", Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                }
                R.id.nav_about -> {
                    Toast.makeText(this, "Acerca de fue clickeado", Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                }
                R.id.nav_settings -> {
                    Toast.makeText(this, "Configuracion fue clickeado", Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                }
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}