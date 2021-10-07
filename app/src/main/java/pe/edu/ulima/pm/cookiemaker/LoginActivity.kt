package pe.edu.ulima.pm.cookiemaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //obtener boton ingresar
        val btnIngresar : Button = findViewById(R.id.btnIngresar)
        btnIngresar.setOnClickListener{
            //cambiar a pantalla listadoRecetas
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}