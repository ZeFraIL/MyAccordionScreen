package zeev.fraiman.myaccordionscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

    Button[] btns=new Button[4];
    TextView[] tvs=new TextView[4];
    int[] filesID=new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elementsInit();
    }

    private void elementsInit() {
        btns[0]=findViewById(R.id.b1);
        btns[1]=findViewById(R.id.b2);
        btns[2]=findViewById(R.id.b3);
        btns[3]=findViewById(R.id.b4);

        for (int i = 0; i < btns.length; i++) {
            btns[i].setOnClickListener(this);
        }

        tvs[0]=findViewById(R.id.tv1);
        tvs[1]=findViewById(R.id.tv2);
        tvs[2]=findViewById(R.id.tv3);
        tvs[3]=findViewById(R.id.tv4);

        for (int i = 0; i < tvs.length; i++) {
            tvs[i].setVisibility(View.GONE);
        }

        filesID[0]=R.raw.info1;
        filesID[1]=R.raw.info2;
        filesID[2]=R.raw.info3;
        filesID[3]=R.raw.info4;
    }

    @Override
    public void onClick(View view) {
        if (view==btns[0])  {
            if (tvs[0].getVisibility()==View.VISIBLE)
                tvs[0].setVisibility(View.GONE);
            else
                viewText(0);
        }
        if (view==btns[1])  {
            if (tvs[1].getVisibility()==View.VISIBLE)
                tvs[1].setVisibility(View.GONE);
            else
                viewText(1);
        }
        if (view==btns[2])  {
            if (tvs[2].getVisibility()==View.VISIBLE)
                tvs[2].setVisibility(View.GONE);
            else
                viewText(2);
        }
        if (view==btns[3])  {
            if (tvs[3].getVisibility()==View.VISIBLE)
                tvs[3].setVisibility(View.GONE);
            else
                viewText(3);
        }
    }

    private void viewText(int i) {
        for (int j = 0; j < tvs.length; j++)
            tvs[j].setVisibility(View.GONE);
        tvs[i].setVisibility(View.VISIBLE);
        InputStream is=getResources().openRawResource(filesID[i]);
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(isr);
        String temp="", all="";
        try {
            while ((temp=br.readLine())!=null)
            {
                all+=temp+"\n \n";
            }
            is.close();
            tvs[i].setText(all);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}