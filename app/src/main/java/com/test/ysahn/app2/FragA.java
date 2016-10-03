package com.test.ysahn.app2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragA extends Fragment {
    private static final String ARG_SECTION_NUMBER = "test";
    private String output="";
    private String priv=null;
    private String mark=null;
    private Button[] mButton = new Button[16];
    private TextView mTextView;

    public FragA() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragA newInstance(int sectionNumber) {
        FragA fragment = new FragA();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_a, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.view);
        mTextView.clearComposingText();


        mButton[1] = (Button) rootView.findViewById(R.id.one);
        mButton[2] = (Button) rootView.findViewById(R.id.two);
        mButton[3] = (Button) rootView.findViewById(R.id.three);
        mButton[4] = (Button) rootView.findViewById(R.id.four);
        mButton[5] = (Button) rootView.findViewById(R.id.five);
        mButton[6] = (Button) rootView.findViewById(R.id.six);
        mButton[7] = (Button) rootView.findViewById(R.id.seven);
        mButton[8] = (Button) rootView.findViewById(R.id.eight);
        mButton[9] = (Button) rootView.findViewById(R.id.nine);
        mButton[0] = (Button) rootView.findViewById(R.id.zero);
        mButton[10] = (Button) rootView.findViewById(R.id.plus);
        mButton[11] = (Button) rootView.findViewById(R.id.minus);
        mButton[12] = (Button) rootView.findViewById(R.id.mult);
        mButton[13] = (Button) rootView.findViewById(R.id.dvi);
        mButton[14] = (Button) rootView.findViewById(R.id.cancel);
        mButton[15] = (Button) rootView.findViewById(R.id.equl);

        for(int i=0;i<10;i++){
            final int num = i;
            mButton[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    output += num;
                    mTextView.setText(output);
                }
            });
        }

        mButton[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priv = output;
                Log.d("out",priv);
                output = "";
                mark = "+";
                mTextView.setText("");
            }
        });

        mButton[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priv = output;
                output = "";
                mark = "-";
                mTextView.setText("");
            }
        });

        mButton[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priv = output;
                output = "";
                mark = "*";
                mTextView.setText("");
            }
        });

        mButton[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priv = output;
                output = "";
                mark = "/";
                mTextView.setText("");
            }
        });

        mButton[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priv=null;
                mark = null;
                output = "";
                mTextView.setText("");
            }
        });

        mButton[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((priv!=null)||(mark!=null)) {
                    int a = Integer.parseInt(priv);
                    int b = Integer.parseInt(output);
                    switch (mark) {
                        case "+":
                            output = (a + b) + "";
                            break;
                        case "-":
                            output = (a - b) + "";
                            break;
                        case "*":
                            output = (a * b) + "";
                            break;
                        case "/":
                            if (b != 0) output = (a / b) + "";
                            else output = "0";
                            break;
                        default:
                            output = "0";
                    }
                }
                mTextView.setText(output);
            }
        });

        return rootView;
    }
}
