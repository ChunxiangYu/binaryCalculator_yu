import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Math;
public class Calculator {
    JFrame f;
    JPanel [] p=new JPanel[4];
    JButton [] c=new JButton[11];
    JLabel [] t=new JLabel[2];
    JTextField [] tf=new JTextField[2];
    String [] bt={"Binary","Decimal","0","1","+","-","*","/","pow","sqrt","="};
    private int firstNumber;
    private String symbol;
    private int result;
    public Calculator(){
        f=new JFrame("Binary Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400,400);
        f.setLayout(new GridLayout(4,1));
        p[0]=new JPanel(new GridLayout(1,2));
        p[1]=new JPanel(new GridLayout(1,2));
        p[2]=new JPanel(new GridLayout(6,2));
        p[3]=new JPanel(new GridLayout(1,1));
        for(int i=0;i<11;i++)
        {
            c[i]=new JButton(bt[i]);
        }
        c[0].addActionListener(new Listener1());
        c[1].addActionListener(new Listener2());
        c[2].addActionListener(new Listener3());
        c[3].addActionListener(new Listener4());
        c[4].addActionListener(new Listener5());
        c[5].addActionListener(new Listener6());
        c[6].addActionListener(new Listener7());
        c[7].addActionListener(new Listener8());
        c[8].addActionListener(new Listener9());
        c[9].addActionListener(new Listener10());
        c[10].addActionListener(new Listener11());


        t[0]=new JLabel("Input Number");
        t[1]=new JLabel("Output");
        tf[0]=new JTextField();
        tf[1]=new JTextField();
        for(int i=0;i<2;i++)
        {
            p[i].add(t[i]);
            p[i].add(tf[i]);

        }
        for(int i=0;i<10;i++)
        {
            p[2].add(c[i]);
        }
        p[3].add(c[10]);
        for(int i=0;i<4;i++)
        {
            f.add(p[i]);
        }
        f.setVisible(true);

    }

    public String binary(int num){
        String binaryNum="";
        int [] arr=new int[32];
        int  v,j=0;
        if(num==0)
            return binaryNum+"0";
        else{
            for(int  i=31;i>=0;i--)
            {
                v=num&1;
                arr[i]=v;
                num=num>>1;
            }
            one:for(int i=0;i<32;i++)
            {
                if(arr[i]==0&&arr[i+1]!=0)
                {
                    j=i+1;
                    break;
                }
            }
            for(int i=j;i<32;i++ )
            {
                binaryNum=binaryNum+arr[i];
            }
            return binaryNum;
        }
    }

    public static Integer BinaryToDecimal(int bi){
        String binStr = bi+"";
        Integer sum = 0;
        int len = binStr.length();
        for (int i=1;i<=len;i++){
            int dt = Integer.parseInt(binStr.substring(i-1,i));
            sum+=(int)Math.pow(2,len-i)*dt;
        }
        return  sum;
    }


    public static void main(String[] args){
        new Calculator();
    }
    class Listener1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            int num1 = Integer.parseInt(tf[0].getText().trim());
            int numResult = Integer.parseInt(tf[1].getText().trim());
            tf[0].setText(binary(num1));
            tf[1].setText(binary(numResult));
        }

    }
    class Listener2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            int num1=Integer.parseInt(tf[0].getText().trim());
            int numResult=Integer.parseInt(tf[1].getText().trim());
            tf[0].setText(String.valueOf(BinaryToDecimal(num1)));
            tf[1].setText(String.valueOf(BinaryToDecimal(numResult)));
        }

    }
    class Listener3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            tf[0].setText(tf[0].getText()+bt[2]);
        }

    }
    class Listener4 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            tf[0].setText(tf[0].getText()+bt[3]);
        }

    }

    class Listener5 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            firstNumber=Integer.parseInt(tf[0].getText().trim());
            symbol = "+";
            tf[0].setText("");
        }

    }
    class Listener6 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            firstNumber=Integer.parseInt(tf[0].getText().trim());
            symbol = "-";
            tf[0].setText("");
        }

    }

    class Listener7 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            firstNumber=Integer.parseInt(tf[0].getText().trim());
            symbol = "*";
            tf[0].setText("");
        }

    }
    class Listener8 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            firstNumber=Integer.parseInt(tf[0].getText().trim());
            symbol = "/";
            tf[0].setText("");
        }

    }
    class Listener9 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            tf[1].setText(String.valueOf(Math.pow(BinaryToDecimal(Integer.parseInt(tf[0].getText())),2)));
        }

    }

    class Listener10 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            tf[1].setText(String.valueOf(Math.sqrt(BinaryToDecimal(Integer.parseInt(tf[0].getText())))));
        }
    }
    class Listener11 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            switch (symbol) {
                case "+":
                    result = BinaryToDecimal(firstNumber) + BinaryToDecimal(Integer.parseInt(tf[0].getText()));
                    break;
                case "-":
                    result = BinaryToDecimal(firstNumber) - BinaryToDecimal(Integer.parseInt(tf[0].getText()));
                    break;
                case "*":
                    result = BinaryToDecimal(firstNumber) * BinaryToDecimal(Integer.parseInt(tf[0].getText()));
                    break;
                case "/":
                    result = BinaryToDecimal(firstNumber) / BinaryToDecimal(Integer.parseInt(tf[0].getText()));
                    break;
            }
            tf[1].setText(String.valueOf(binary(result)));
        }

    }


}