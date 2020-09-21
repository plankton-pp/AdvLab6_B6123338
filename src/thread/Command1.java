package thread;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Command1 {

    private JFrame frame;
    private JTextField t_input;
    private JTextArea t_baht;
    private JTextArea t_usd;
    private JTextArea t_euro;
    public double get_input;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Command1 window = new Command1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Command1() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 596, 465);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
//Compute
        JButton btn_compute = new JButton("compute");
        btn_compute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    get_input = Double.parseDouble(t_input.getText());

                    convertBaht cbath = new convertBaht();
                    convertEuro ceuro = new convertEuro();
                    convertUSD  cusd =  new convertUSD();

                    cbath.run();
                    ceuro.run();
                    cusd.run();

                }catch (Exception err){
                    System.out.println("Invalid Input Type");
                    err.printStackTrace();
                }
            }
        });
        btn_compute.setBounds(249, 28, 89, 32);
        frame.getContentPane().add(btn_compute);

//Exit
        JButton btn_exit = new JButton("exit");
        btn_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        btn_exit.setBounds(344, 28, 89, 32);
        frame.getContentPane().add(btn_exit);

        t_input = new JTextField();
        t_input.setBounds(30, 31, 177, 26);
        frame.getContentPane().add(t_input);
        t_input.setColumns(10);

        JLabel lblBath = new JLabel("Bath");
        lblBath.setBounds(30, 118, 46, 14);
        frame.getContentPane().add(lblBath);

        JLabel lblUsdollar = new JLabel("U.S.Dollar");
        lblUsdollar.setBounds(210, 116, 68, 14);
        frame.getContentPane().add(lblUsdollar);

        JLabel lblEuro = new JLabel("Euro");
        lblEuro.setBounds(389, 118, 46, 14);
        frame.getContentPane().add(lblEuro);

        t_baht = new JTextArea();
        t_baht.setEditable(true);
        t_baht.setBounds(29, 143, 123, 250);
        frame.getContentPane().add(t_baht);

        t_usd = new JTextArea();
        t_usd.setEditable(true);
        t_usd.setBounds(210, 141, 123, 250);
        frame.getContentPane().add(t_usd);

        t_euro = new JTextArea();
        t_euro.setEditable(true);
        t_euro.setBounds(385, 143, 123, 250);
        frame.getContentPane().add(t_euro);
    }

    public class convertBaht extends Thread{
        public void run(){
            t_baht.setText("");
            double Arr_bath[] = {0.03,0.02,0.03,0.26,0.04,0.21,0.03,0.17,0.04,0.03,1.32,33.33,0.04,0.17,0.80};
            String type[] ={"USD","EUR","JPY","HKD","SGD","CNY","AUD","DKK","NZD","CAD","PHP","KRW","BND","ZAR","RUB"};
            String result ="";
            for(int i=0;i<Arr_bath.length;i++){
                Arr_bath[i] *= get_input;
                result += "= "+String.format("%.2f",Arr_bath[i])+"     "+type[i]+"\n";
            }

            t_baht.append(result);
        }
    }
    public class convertUSD extends Thread{
        public void run(){
            t_usd.setText(null);
            double Arr_usd[] = {29.99,0.70,0.77,7.67,1.20,6.23,0.90,5.23,1.13,0.96,39.46,999.67,1.20,5.17,23.99};
            String type[] ={"BATH","EUR","JPY","HKD","SGD","CNY","AUD","DKK","NZD","CAD","PHP","KRW","BND","ZAR","RUB"};
            String result ="";
            for(int i=0;i<Arr_usd.length;i++){
                Arr_usd[i] *= get_input;
                result += "= "+String.format("%.2f",Arr_usd[i])+"     "+type[i]+"\n";
            }
            t_usd.append(result);
        }
    }
    public class convertEuro extends Thread{
        public void run(){
            t_euro.setText(null);
            double Arr_euro[] = {42.75,1.43,1.10,10.93,1.73,8.89,1.29,7.46,1.61,1.36,56.25,1425.00,1.71,7.37,34.20};
            String type[] ={"BATH","USD","JPY","HKD","SGD","CNY","AUD","DKK","NZD","CAD","PHP","KRW","BND","ZAR","RUB"};
            String result ="";
            for(int i=0;i< Arr_euro.length;i++){
                Arr_euro[i] *= get_input;
                result += "= "+String.format("%.2f",Arr_euro[i])+"     "+type[i]+"\n";
            }
            t_euro.append(result);
        }
    }
}

