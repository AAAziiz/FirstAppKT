package aziz.projet.finalproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import aziz.projet.finalproject.databinding.ActivityAfterMainBinding

class AfterMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityAfterMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.button6.setOnClickListener {
            var intent= Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","mohamedaziz2234@gmail.com",null))
            startActivity(Intent.createChooser(intent,"Send email ......"))}
        binding.button7.setOnClickListener {
            val intent=Intent(this,CallActivity::class.java)
            startActivity(intent)
        }
        binding.button8.setOnClickListener {
            val intent=Intent(this,SMSActivity2::class.java)
            startActivity(intent)
        }


        supportActionBar!!.title = "Go Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

}}