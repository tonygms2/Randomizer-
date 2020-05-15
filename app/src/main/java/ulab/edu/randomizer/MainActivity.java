package ulab.edu.randomizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView display ;
    SeekBar skBar;
    TextView skBarText;
     Typeface type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn = (Button)findViewById(R.id.GenerateButton);
         display = (TextView)findViewById(R.id.DisplayOutput);
         skBar = (SeekBar)findViewById(R.id.seekBar2);
         skBarText = (TextView)findViewById(R.id.seekbarText);
         type = Typeface.createFromAsset(getAssets(),"fonts/ShadowsIntoLight-Regular.ttf");

         skBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
             @Override
             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                skBarText.setTypeface(type);
                skBarText.setText(Integer.toString(skBar.getProgress()*10));
             }

             @Override
             public void onStartTrackingTouch(SeekBar seekBar) {

             }

             @Override
             public void onStopTrackingTouch(SeekBar seekBar) {

             }
         });
    }

    public void GenerateFunction(View view) {
        GenerateRandNumber();
    }

    public void GenerateRandNumber(){
        Random rand = new Random();
        int number = rand.nextInt(skBar.getProgress()*10);
        if(number<0){
            Toast.makeText(this, "Number Cannot Be Less than zero", Toast.LENGTH_SHORT).show();
        }else{
            String output = Integer.toString(number);
            display.setTypeface(type);
            display.setText(output);
        }





    }
}
