package pt.ipt.dama2024.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    /* Algorithm
        - criar 'ponteiros' para os objetos da interface
        - gerar um nº aleatório entre 1 e 6
        - atribuir o valor gerado à textView e
          a imagem correspondente à ImageView
     */

    // this var is not yet really created.
    // it will be created when we really need it
    private lateinit var auxDiceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // when we click the button an event is created
        // we want to catch that event
        val auxBt = findViewById<Button>(R.id.button)
        // val auxBt:Button=findViewById(R.id.button)

        // catch the event
        auxBt.setOnClickListener { rollTheDice() }
    }

    /**
     * function to guess the number to be used on dice
     * Roll the dice     *
     */
    private fun rollTheDice() {
        // get the random value
        val randomValue = Random().nextInt(6) + 1 // values from 1 to 6

        // assign the 'randomValue' to TextView
        val auxtxt = findViewById<TextView>(R.id.diceValue)
        auxtxt.text = randomValue.toString()

        // prepare the image to show
        val imageToShow = when (randomValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        // assign to the ImageView the 'imageToShow'
        auxDiceImage = findViewById(R.id.dice)
        auxDiceImage.setImageResource(imageToShow)
    }
}