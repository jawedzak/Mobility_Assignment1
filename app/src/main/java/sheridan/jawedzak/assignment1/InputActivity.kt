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
        // this function checks the user input
        private fun play() {
            val choice = when (binding.messageGroup.checkedRadioButtonId) {
                R.id.rock -> start("Rock")
                R.id.paper -> start("Paper")
                R.id.scissor -> start("Scissor")
                else -> start("undefined")
            }
        }

    // this function selects random choice for computer & then get the result
    private fun start(a:String) {
        var computerChoice = ""
        var userChoice = a
        var result = ""

        var randomChoice = Random.nextInt(3)
        if (randomChoice == 0) {
            computerChoice = "Rock"
        }
        if (randomChoice == 1) {
            computerChoice = "Paper"
        }
        if (randomChoice == 2) {
            computerChoice = "Scissor"
        }

        // compare the results now
        if (computerChoice == a){
            result = "Tie"
        }
        if (computerChoice == "Paper" && a == "Scissor"){
            result = "User"
        }
        if (computerChoice == "Scissor" && a == "Paper"){
            result = "Computer"
        }
        if (computerChoice == "Rock" && a == "Paper"){
            result = "User"
        }
        if (computerChoice == "Scissor" && a == "Rock"){
            result = "User"
        }
        if (computerChoice == "Rock" && a == "Scissor") {
            result = "Computer"
        }
        if (computerChoice == "Paper" && a == "Rock"){
            result = "Computer"
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