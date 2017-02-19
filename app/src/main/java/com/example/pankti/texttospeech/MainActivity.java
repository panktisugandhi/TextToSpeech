package com.example.pankti.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private Button btnspeech;
    private EditText ET;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET = (EditText) findViewById(R.id.et_text);
        btnspeech= (Button) findViewById(R.id.btn);
        tts = new TextToSpeech(this,this);

        btnspeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOutNow();
            }
        });
    }

    @Override
    public void onInit(int text) {

        if (text==TextToSpeech.SUCCESS){
            int language = tts.setLanguage(Locale.ENGLISH);
            if (language==TextToSpeech.LANG_MISSING_DATA || language==TextToSpeech.LANG_NOT_SUPPORTED){
                btnspeech.setEnabled(true);
                speakOutNow();
            }
            else {

            }
        }
        else {

        }
    }

    private void speakOutNow(){
        String text = ET.getText().toString();
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}