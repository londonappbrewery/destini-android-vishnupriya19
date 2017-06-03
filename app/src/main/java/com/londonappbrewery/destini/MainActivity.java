package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTextView;
    Button Ans1;
    Button Ans2;
    int obj,a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        storyTextView = (TextView)findViewById(R.id.storyTextView);

        Ans1=(Button)findViewById(R.id.buttonTop);
        Ans2=(Button)findViewById(R.id.buttonBottom);
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        if(savedInstanceState != null)
        {
            storyTextView .setText(savedInstanceState.getInt("Ques"));
            Ans1.setText(savedInstanceState.getInt("Ans1"));
            Ans2.setText(savedInstanceState.getInt("Ans2"));
        }



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

            Ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if((Ans1.getText().toString()).equals(getString(R.string.T1_Ans1)))
                    {
                        obj=R.string.T3_Story;
                        a=R.string.T3_Ans1;
                        b=R.string.T3_Ans2;
                    }
                    else if( (Ans1.getText().toString()).equals( getString(R.string.T3_Ans1)))
                    {
                        obj=R.string.T5_End;
                        a=b=0;
                    }
                    else if( (Ans1.getText().toString()).equals(getString(R.string.T2_Ans1)))
                    {
                     obj=R.string.T3_Story;
                        a=R.string.T3_Ans1;
                        b=R.string.T3_Ans2;
                    }
                    storyTextView.setText(obj);
                    if( a == 0)
                    {
                        Ans1.setVisibility(GONE);
                        Ans2.setVisibility(GONE);
                    }
                    else{
                    Ans1.setText(a);
                    Ans2.setText(b);}

                }
            });

       Ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Ans2.getText().toString()).equals(getString(R.string.T1_Ans2)))
                {
                    obj=R.string.T2_Story;
                    a=R.string.T2_Ans1;
                    b=R.string.T2_Ans2;
                }
                else if((Ans2.getText().toString()).equals(getString( R.string.T2_Ans2)))
                {
                    obj=R.string.T4_End;
                    a=b=0;
                }
                else if((Ans2.getText().toString()).equals(getString(R.string.T3_Ans2)))
                {
                    obj=R.string.T5_End;
                    a=b=0;
                }
                storyTextView.setText(obj);
                if(a == 0)
                {
                    Ans1.setVisibility(GONE);
                    Ans2.setVisibility(GONE);
                }
                else {
                    Ans1.setText(a);
                    Ans2.setText(b);
                }

            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:


    }
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("Ques",obj);
        outState.putInt("Ans1",a);
        outState.putInt("Ans2",b);
    }

}
