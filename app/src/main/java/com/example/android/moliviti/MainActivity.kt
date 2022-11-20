package com.example.android.moliviti

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
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

        binding.navView.setNavigationItemSelectedListener{ menuItem ->
            when(menuItem.itemId){
                R.id.nav_home -> {
                    Toast.makeText(this, "Inicio fue clickeado", Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                }
                R.id.nav_bus -> {
                    Toast.makeText(this, "Rutas fue clickeado", Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                }
                R.id.nav_card -> {
                    Toast.makeText(this, "Tu llave fue clickeado", Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
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

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (toggle.onOptionsItemSelected(item)){
        return true
    }
        return super.onOptionsItemSelected(item)
    }
}