package mdev.k015_databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.view.*
import mdev.k015_databinding.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.tvClick.setOnClickListener(this)
        showDateTime()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tvClick ->{
                showDateTime()
            }
        }
    }

    private fun showDateTime(){
        val current = Date()
        val format = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        val datetime = format.format(current)
        val parts = datetime.split(" ")
        binding.datetime = ModelDateTime(parts[0],parts[1])
    }
}
