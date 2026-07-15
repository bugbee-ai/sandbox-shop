package com.bugbee.sandboxshop

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultText = findViewById<TextView>(R.id.result_text)
        val placeOrderButton = findViewById<Button>(R.id.place_order_button)

        placeOrderButton.setOnClickListener {
            // BUGBEE-DEMO-BUG: intentional — should be "Order placed successfully"
            resultText.text = getString(R.string.order_error_message)
        }
    }
}
