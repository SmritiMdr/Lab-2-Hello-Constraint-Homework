package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloconstraint.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //binding class extends view binding
    ActivityMainBinding binding;

    private int mCount = 0;
    private TextView mShowCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //creating binding object or instance
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //getRoot() is used to get reference to the root view
        View view = binding.getRoot();

        setContentView(view);

        mShowCount = (TextView) findViewById(R.id.show_count);


        //for button zero
        binding.button.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {
                    mCount = 0;
                    binding.showCount.setText("" + mCount);
                    binding.button.setBackgroundColor(Color.GRAY);
                    binding.buttonCount.setBackgroundColor(Color.BLUE);
                }
            }
        );

        //for button count

        binding.buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;

                if (mCount > 0) {
                    binding.button.setBackgroundColor(Color.MAGENTA);

                    if (mCount % 2 == 0) {
                        mShowCount.setText(Integer.toString(mCount));
                        binding.buttonCount.setBackgroundColor(Color.GREEN);
                    }

                    else {
                        mShowCount.setText(Integer.toString(mCount));
                        binding.buttonCount.setBackgroundColor(Color.RED);
                    }

                }
            }
        });

    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }


}