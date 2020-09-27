package sheridan.jawedzak.assignment1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sheridan.jawedzak.assignment1.databinding.ActivityInputBinding
import kotlin.random.Random

class InputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.play.setOnClickListener { play() }
    }
        private fun play() {
            val choice = when (binding.messageGroup.checkedRadioButtonId) {
                R.id.rock -> start("rock")
                R.id.paper -> start("paper")
                R.id.scissor -> start("scissor")
                else -> start("undefined")
            }
        }

    private fun start(a:String) {
        var computerChoice = ""
        var userChoice = a
        var result = ""

        var randomChoice = Random.nextInt(3)
        if (randomChoice == 0) {
            computerChoice = "rock"
        }
        if (randomChoice == 1) {
            computerChoice = "paper"
        }
        if (randomChoice == 2) {
            computerChoice = "scissor"
        }

        // compare the results now
        if (computerChoice == a){
            result = "Tie"
        }
        if (computerChoice == "paper" && a == "scissor"){
            result = "User WON"
        }
        if (computerChoice == "scissor" && a == "paper"){
            result = "Computer WON"
        }
        if (computerChoice == "rock" && a == "paper"){
            result = "User WON"
        }
        if (computerChoice == "scissor" && a == "rock"){
            result = "User WON"
        }
        if (computerChoice == "rock" && a == "scissor") {
            result = "Computer WON"
        }
        if (computerChoice == "paper" && a == "rock"){
            result = "Computer WON"
        }
        //Toast.makeText(this, choice, Toast.LENGTH_SHORT).show()

        // pass the data to another acitivity
        val intent = Intent(this, OutputActivity::class.java).apply {
            putExtra(OutputActivity.USER_CHOICE, userChoice)
            putExtra(OutputActivity.COMPUTER_CHOICE, computerChoice)
            putExtra(OutputActivity.RESULT, result)
        }
        startActivity(intent)
    }
}