package aziz.projet.finalproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import aziz.projet.finalproject.databinding.ActivitySmsactivity2Binding

class SMSActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivitySmsactivity2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button10.setOnClickListener {
            val number =binding.editTextPhone2.text.toString()
            val texte =binding.editTextTextMultiLine.text.toString()
            val uri= Uri.parse("smsto:$number?body=$texte")
            val intent= Intent(Intent.ACTION_SENDTO,uri)
            startActivity(intent)

        }
    }
}