package aziz.projet.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import aziz.projet.finalproject.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_sign_up)
        val binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth= FirebaseAuth.getInstance()

        binding.textView2.setOnClickListener {
            val intent= Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }


        binding.button.setOnClickListener {
            val email=binding.editTextTextPersonName.text.toString()
            val password=binding.editTextTextPersonName2.text.toString()
            val confirmpass=binding.editTextTextPersonName3.text.toString()



            if(email.isNotEmpty()&&password.isNotEmpty()&&confirmpass.isNotEmpty()){

                if (password==(confirmpass)){

                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                        if(it.isSuccessful){
                            val intent= Intent(this,SignInActivity::class.java)
                            startActivity(intent)

                        }else{
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this,"Password is fault", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this,"Empty Fields !!!!", Toast.LENGTH_SHORT).show()

            }
        }

    }
}

