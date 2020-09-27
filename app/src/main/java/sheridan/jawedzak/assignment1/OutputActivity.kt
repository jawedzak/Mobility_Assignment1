package sheridan.jawedzak.assignment1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sheridan.jawedzak.assignment1.databinding.ActivityOutputBinding

class OutputActivity : AppCompatActivity() {

    companion object{
        const val USER_CHOICE = "userChoice"
        const val COMPUTER_CHOICE = "computerChoice"
        const val RESULT = "result"
    }

    private lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.user.text = "User Choice: " + intent.getStringExtra(USER_CHOICE)
        binding.computer.text = "Computer Choice: " + intent.getStringExtra(COMPUTER_CHOICE)
        binding.result.text = "Winner: " +  intent.getStringExtra(RESULT)

        // make the play button work
        binding.playAgain.setOnClickListener { finish() }
    }
}