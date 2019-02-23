package com.example.rshushilkumar.scalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

import mathjs.niltonvasques.com.mathjs.MathJS;

public class MainActivity extends AppCompatActivity {
    boolean justAnswered = false;
    private GestureDetector gesturedetector = null;

    private Intent i;
    private LinearLayout lContainer, ivLayer1, ivLayer2;
    public String term = "";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView mainView = findViewById(R.id.mainView);
        final MathJS math = new MathJS();
        final ArrayList<EqElement> exp = new ArrayList<>();
        final ArrayList<EqElement> brSym = new ArrayList<>();

        Button b0 = findViewById(R.id.button0);
        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);
        Button b5 = findViewById(R.id.button5);
        Button b6 = findViewById(R.id.button6);
        Button b7 = findViewById(R.id.button7);
        Button b8 = findViewById(R.id.button8);
        Button b9 = findViewById(R.id.button9);
        Button bdot = findViewById(R.id.buttonDot);
        Button bdel = findViewById(R.id.buttonDel);
        Button bmul = findViewById(R.id.buttonMul);
        Button bdiv = findViewById(R.id.buttonDiv);
        Button bplus = findViewById(R.id.buttonPlus);
        Button bsub = findViewById(R.id.buttonSub);
        Button beq = findViewById(R.id.buttonEq);

        Button binv = findViewById(R.id.inv);
        Button bsin = findViewById(R.id.sin);
        Button bcos = findViewById(R.id.cos);
        Button bln = findViewById(R.id.ln);
        Button blog = findViewById(R.id.log);
        Button blb = findViewById(R.id.lb);
        Button brb = findViewById(R.id.rb);
        Button bpi = findViewById(R.id.pi);
        Button bnapier = findViewById(R.id.napier);
        Button bdeg = findViewById(R.id.deg);
        Button bper = findViewById(R.id.per);
        Button bfacr = findViewById(R.id.fact);
        Button btan = findViewById(R.id.tan);
        Button bpow = findViewById(R.id.pow);
        Button broot = findViewById(R.id.root);


        lContainer = findViewById(R.id.container);
        ivLayer1 = findViewById(R.id.buttonLayout);
        ivLayer2 = findViewById(R.id.sciLayout);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        ViewGroup.LayoutParams params = ivLayer2.getLayoutParams();
        params.width = (int) (metrics.widthPixels * 0.9);
        ivLayer2.setLayoutParams(params);

        gesturedetector = new GestureDetector(new MyGestureListener());

        lContainer.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                gesturedetector.onTouchEvent(event);

                return true;

            }
        });

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String eq = mainView.getText().toString();
                if (!justAnswered) {
                    mainView.setText(eq + b.getText().toString());
                    if (Objects.equals(eq, new String("0")))
                        mainView.setText(b.getText().toString());
                } else {
                    mainView.setText(b.getText().toString());
                    justAnswered = false;
                }
            }
        };
        View.OnClickListener delListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!justAnswered) {
                    String str = mainView.getText().toString();
                    if (str != null && str.length() > 0) {
                        str = str.substring(0, str.length() - 1);
                    }
                    mainView.setText(str);
                } else {
                    mainView.setText("");
                    justAnswered = false;
                }

            }
        };
        View.OnClickListener eqListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyStringParser parser=new MyStringParser();
                parser.parse(mainView.getText().toString(),getApplicationContext());
                if (mainView.getText().toString().matches("([\\+\\-]\\d+[\\.\\-\\*\\/\\s]{3})+\\d+$")) {
                    if (!justAnswered) {
                        String answer = math.eval(mainView.getText().toString());
                        float ans = Float.valueOf(answer);
                        DecimalFormat format = new DecimalFormat("0.######");
                        mainView.setText(format.format(ans));
                        justAnswered = true;
                    }

                } else {
                    mainView.setText("Invalid Input");
                    justAnswered = true;
                }
            }
        };
        View.OnClickListener symListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp.add(new EqElement("num", term, exp.size()));
                term = "";
                Button b = (Button) view;
                String bText = b.getText().toString();
                if (bText.equals("/") | bText.equals("*") | bText.equals("-") | bText.equals("+") | bText.equals("^")) {
                    String eq = mainView.getText().toString();
                    mainView.setText(eq +" "+ bText+" ");


                } else if (bText.equals("Sin")) {

                } else if (bText.equals("ln")) {

                } else if (bText.equals("(")) {

                } else if (bText.equals("Cos")) {

                } else if (bText.equals("Log")) {

                } else if (bText.equals("Tan")) {

                } else if (bText.equals("\u221A")) {

                }
            }
        };

        View.OnClickListener perListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };

        View.OnClickListener factListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };

        View.OnClickListener rbListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };

        b0.setOnClickListener(btnListener);
        b1.setOnClickListener(btnListener);
        b2.setOnClickListener(btnListener);
        b3.setOnClickListener(btnListener);
        b4.setOnClickListener(btnListener);
        b5.setOnClickListener(btnListener);
        b6.setOnClickListener(btnListener);
        b7.setOnClickListener(btnListener);
        b8.setOnClickListener(btnListener);
        b9.setOnClickListener(btnListener);
        bdot.setOnClickListener(btnListener);
        bdel.setOnClickListener(delListener);
        bmul.setOnClickListener(symListner);
        bdiv.setOnClickListener(symListner);
        bplus.setOnClickListener(symListner);
        bsub.setOnClickListener(symListner);
        beq.setOnClickListener(eqListener);

        bdel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mainView.setText("");
                return true;
            }
        });
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {

        super.dispatchTouchEvent(ev);

        return gesturedetector.onTouchEvent(ev);

    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_MIN_DISTANCE = 20;

        private static final int SWIPE_MAX_OFF_PATH = 100;

        private static final int SWIPE_THRESHOLD_VELOCITY = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,

                               float velocityY) {

            float dX = e2.getX() - e1.getX();

            float dY = e1.getY() - e2.getY();

            if (Math.abs(dY) < SWIPE_MAX_OFF_PATH &&

                    Math.abs(velocityX) >= SWIPE_THRESHOLD_VELOCITY &&

                    Math.abs(dX) >= SWIPE_MIN_DISTANCE) {

                if (dX > 0) {


                    if (ivLayer2.getVisibility() == View.VISIBLE) {
                        Animation fadeInAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_right_out);
                        ivLayer2.startAnimation(fadeInAnimation);
                        ivLayer1.setAlpha(1);
                        ivLayer2.setVisibility(View.GONE);
                    }
                } else {


                    if (ivLayer2.getVisibility() == View.GONE) {
                        Animation fadeInAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_left_in);
                        ivLayer2.startAnimation(fadeInAnimation);
                        ivLayer2.setVisibility(View.VISIBLE);
                        ivLayer1.setAlpha((float) 0.6);
                    }

                }

                return true;

            } else if (Math.abs(dX) < SWIPE_MAX_OFF_PATH &&

                    Math.abs(velocityY) >= SWIPE_THRESHOLD_VELOCITY &&

                    Math.abs(dY) >= SWIPE_MIN_DISTANCE) {

                if (dY > 0) {


                } else {

                }

                return true;

            }

            return false;

        }

    }
}
