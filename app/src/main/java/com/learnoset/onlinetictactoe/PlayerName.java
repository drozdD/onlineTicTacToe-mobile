package com.learnoset.onlinetictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);

        final EditText playerNameEt = findViewById(R.id.playerNameEt);
        final AppCompatButton startGameBtn = findViewById(R.id.startGameBtn);

        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting playername from EditText to a String variable
                final String getPlayerName = playerNameEt.getText().toString();

                // checking wheather player has entered his name
                if(getPlayerName.isEmpty()){
                    Toast.makeText(PlayerName.this, "Please enter player name", Toast.LENGTH_SHORT).show();
                }
                else{

                    // creating intent to open MainActivity
                    Intent intent = new Intent(PlayerName.this, MainActivity.class);

                    // adding player name along with intent
                    intent.putExtra("playerName", getPlayerName);

                    // opening MainActivity
                    startActivity(intent);

                    // destroy this(PlayerName) activity
                    finish();
                }
            }
        });
    }
}