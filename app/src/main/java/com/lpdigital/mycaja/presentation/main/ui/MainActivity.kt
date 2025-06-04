package com.lpdigital.mycaja.presentation.main.ui

import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.lpdigital.mycaja.R
import com.lpdigital.mycaja.databinding.ActivityMainBinding
import com.lpdigital.mycaja.ui.theme.MyCajaTheme

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Declaramos nuestra custom Toolbar como la barra de accion principal.
        setSupportActionBar(binding.toolbar)

        // Drawer toggle (hamburguesa)
        // Conecta el ícono de la Toolbar con el DrawerLayout para manejar el menú lateral (hamburguesa).
        drawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        // Obtenemos el NavHostFragment, que actúa como contenedor dinámico de los fragments definidos en el nav_graph.xml
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Accedemos al NavController del NavHostFragment. El NavController es el encargado de manejar la navegación entre fragments.
        val navController = navHostFragment.navController

        // Vinculamos el NavigationView (menú lateral) con el NavController. Esto permite que al seleccionar un ítem del menú,
        // se navegue automáticamente al fragment correspondiente definido en el nav_graph.xml
        NavigationUI.setupWithNavController(binding.navigationView, navController)

        // Configuramos el ActionBar (barra superior) para que funcione con el NavController y el DrawerLayout (menú lateral).
        // Esto habilita el ícono de "hamburguesa" para abrir/cerrar el menú lateral de forma automática.
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
    }

}
