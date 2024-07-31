package com.example.myapp
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sportSpinner: Spinner
    private lateinit var showInstructionsButton: Button
    private lateinit var instructionsText: TextView
    private var selectedSport: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sportSpinner = findViewById(R.id.sport_spinner)
        showInstructionsButton = findViewById(R.id.show_instructions_button)
        instructionsText = findViewById(R.id.instructions_text)

        val sports = arrayOf("Football", "Basketball", "Tennis")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sports)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sportSpinner.adapter = adapter

        sportSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedSport = sports[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        showInstructionsButton.setOnClickListener {
            val instructions = when (selectedSport) {
                "Football" -> getString(R.string.football_instructions)
                "Basketball" -> getString(R.string.basketball_instructions)
                "Tennis" -> getString(R.string.tennis_instructions)
                else -> "No instructions available"
            }
            instructionsText.text = instructions
            instructionsText.visibility = View.VISIBLE
        }
    }
}
