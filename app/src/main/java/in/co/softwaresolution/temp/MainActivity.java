package in.co.softwaresolution.temp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bAC,bCLEAR,bDIV,bMUL,bMINUS,bADD,bEQUAL,bPERC,bDOT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.textView1);
        tv2=findViewById(R.id.textView2);
        b0=findViewById(R.id.button6);
        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button7);
        b3=findViewById(R.id.button12);
        b4=findViewById(R.id.button3);
        b5=findViewById(R.id.button8);
        b6=findViewById(R.id.button13);
        b7=findViewById(R.id.button4);
        b8=findViewById(R.id.button9);
        b9=findViewById(R.id.button14);
        bAC=findViewById(R.id.button5);
        bCLEAR=findViewById(R.id.button10);
        bDIV=findViewById(R.id.button15);
        bMUL=findViewById(R.id.button16);
        bMINUS=findViewById(R.id.button17);
        bADD=findViewById(R.id.button18);
        bEQUAL=findViewById(R.id.button19);
        bPERC=findViewById(R.id.button);
        bDOT=findViewById(R.id.button11);
        bDOT.setEnabled(false);
        bPERC.setEnabled(false);

    }
    String str=new String("");
    String sub1;
    String sub2;
    float result;
    float a;
    float b;
    int flag=0;
    int pos;

    public void convert(View view){


        int id=view.getId();
        if(id == R.id.button6)
        {
            str= str+"0";

        }
        else if(id == R.id.button2)
        {
            str= str+"1";

        }
        else if(id == R.id.button7)
        {
            str=str+"2";

        }
        else if(id == R.id.button12)
        {
            str= str+"3";

        }
        else if(id == R.id.button3)
        {
            str= str+"4";

        }
        else if(id == R.id.button8)
        {
            str= str+"5";

        }
        else if(id == R.id.button13)
        {
            str= str+"6";

        }
        else if(id == R.id.button4)
        {
            str= str+"7";

        }
        else if(id == R.id.button9)
        {
            str= str+"8";

        }
        else if(id == R.id.button14)
        {
            str= str+"9";

        }
        else if(id == R.id.button5)
        {
            str=" ";
            flag=1;

        }
        else if(id == R.id.button10)
        {
            if(str.length()==0)
            {
                tv2.setText(" ");
            }
            else
            {
                str = str.substring(0, str.length() - 1);
            }
        }
        else if(id == R.id.button15)
        {
            str= str+"/";
            pos=str.indexOf('/');
            button_disable();

        }
        else if(id == R.id.button16)
        {
            str= str+"*";
            pos=str.indexOf('*');
            button_disable();

        }
        else if(id == R.id.button17)
        {
            str= str+"-";
            pos=str.indexOf('-');
            button_disable();

        }
        else if(id == R.id.button18)
        {
            str= str+"+";
            pos=str.indexOf('+');
            button_disable();

        }
        else if(id == R.id.button19) {

            try{

            if (str.length() == 0) {
                str = "";
                result = 0.0f;
                button_enable();
                tv2.setText(Float.toString(result));
            }
            else if(flag==1)
            {

                sub1 = str.substring(0, pos);
                a = Float.parseFloat(sub1);
                result=a/100;
                tv2.setText(" ");
                button_enable();
                str = Float.toString(result);

            }
            else {

                sub1 = str.substring(0, pos);
                sub2 = str.substring(pos + 1, str.length());
                a = Float.parseFloat(sub1);
                b = Float.parseFloat(sub2);
                char c;
                c = str.charAt(pos);
                switch (c) {
                    case '+':
                        result = a + b;
                        break;

                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;


                }


                tv2.setText(" ");
                button_enable();
                str = Float.toString(result);

            }}
            catch(Exception e)
            {
                str = "";
                result = 0.0f;
                button_enable();
                tv2.setText(Float.toString(result));

            }
        }
        else if(id == R.id.button)
        {
            str= str+"%";
            flag=1;
            pos=str.indexOf('%');
            button_disable();
        }
        else if(id == R.id.button11)
        {
            str= str+".";

        }

        tv1.setText(str);
        if(flag==1) {

            result=0;
            tv2.setText(Float.toString(result));
            flag=0;
        }
        else
        {
            tv2.setText(Float.toString(result));
        }
    }
    public void button_enable()
    {

        bDIV.setEnabled(true);
        bMUL.setEnabled(true);
        bMINUS.setEnabled(true);
        bADD.setEnabled(true);
        bPERC.setEnabled(true);
        bDOT.setEnabled(true);

    }
    public void button_disable()
    {
        bDIV.setEnabled(false);
        bMUL.setEnabled(false);
        bMINUS.setEnabled(false);
        bADD.setEnabled(false);
        bPERC.setEnabled(false);
        bDOT.setEnabled(false);

    }

}
