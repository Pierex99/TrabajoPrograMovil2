package pe.edu.ulima.pm.cookiemaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //obtener boton ingresar
        val btnIngresar : Button = findViewById(R.id.btnIngresar)
        btnIngresar.setOnClickListener{
            val bundle = Bundle()
            var etUsuario : EditText = findViewById(R.id.txtUsuario)
            var txtUsuario = etUsuario.text.toString()
            println("txtUsuario: "+txtUsuario)
            bundle.putString("nameUser", txtUsuario)
            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data", bundle)
            //cambiar a pantalla listadoRecetas
            startActivity(intent)
        }
    }
}