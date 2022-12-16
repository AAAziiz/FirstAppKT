package aziz.projet.finalproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import aziz.projet.finalproject.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var etext: EditText
    private var id=0
    private lateinit var dbr:DatabaseReference
    private lateinit var logout:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        etext=findViewById<EditText>(R.id.editTextTextPersonName7)
        dbr=FirebaseDatabase.getInstance().getReference("rfid")



        binding.button4.setOnClickListener {
            val intent=Intent(android.content.Intent.ACTION_VIEW)
            intent.data= Uri.parse("https://lastproject-4a6da-default-rtdb.europe-west1.firebasedatabase.app/")
            startActivity(intent)
        }


        logout=findViewById(R.id.floatingActionButton)
        binding.floatingActionButton.setOnClickListener {
            Firebase.auth.signOut()
            val intent=Intent(this,SignInActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"Logout Successfully",Toast.LENGTH_SHORT).show()
        }

        val firebaseDatabase=FirebaseDatabase.getInstance()
        val reference=firebaseDatabase.getReference()
        reference.child("rfid").addValueEventListener(object :ValueEventListener {
            override fun onDataChange(datasnapshot: DataSnapshot) {
                val children = datasnapshot.children
                children.forEach {
                    Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")}
        })




        val d= Date()
        val df= DateFormat.getDateInstance(DateFormat.LONG)
        val fd=df.format(d)
        binding.textView4.text=fd
        val tf= DateFormat.getTimeInstance(DateFormat.LONG)
        val ft=tf.format(d)
        binding.textView4.text=fd+"\n"+ft
        binding.button3.setOnClickListener {

            IData()
        }
        binding.button5.setOnClickListener {
            val intent=Intent(this,AfterMainActivity::class.java)
            startActivity(intent)
        }
    }





        private fun IData(){

            val txt=etext.text.toString()
            if(txt.isEmpty()){
                etext.error="Empty Name"
            }else{
                dbr.child(id.toString()).setValue(txt)
                    .addOnCompleteListener {
                        Toast.makeText(this,"Name inserted Correctlt",Toast.LENGTH_LONG).show()
                        etext.text.clear()

                }
                    .addOnFailureListener {
                        err ->
                        Toast.makeText(this,"Fail,${err.message}",Toast.LENGTH_SHORT).show()

                    }
                id+=1
            }
        }
        }
