package aziz.projet.finalproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import aziz.projet.finalproject.databinding.ActivityCallBinding

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityCallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button9.setOnClickListener {
            val num=binding.editTextPhone.text.toString()
            val uri= Uri.parse("tel:$num")
            val i= Intent(Intent.ACTION_DIAL,uri)
            startActivity(i)
    }
}}