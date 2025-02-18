package vazquez.ivan.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vazquez.ivan.popcornfactory.databinding.ActivityDetallePeliculaBinding


class DetallePeliculaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityDetallePeliculaBinding = ActivityDetallePeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_pelicula)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val s= intent.getStringExtra("seats")

        findViewById<ImageView>(R.id.headerImageView).setImageResource(intent.getStringExtra("header")!!.toInt())
        val tit=intent.getStringExtra("titulo")
        findViewById<TextView>(R.id.tituloTextView).text=tit
        findViewById<TextView>(R.id.sinopsisTextView).text=intent.getStringExtra("sinop")
        val ts=findViewById<TextView>(R.id.numSeats)
        ts.text="Asientos disponibles: ${20-s!!.length}"

        if(s.isEmpty())
            ts.isActivated=false
        else
            ts.setOnClickListener { startActivity(Intent(this,SeatSelectionActivity::class.java).putExtra("titulo",tit)) }

    }
}