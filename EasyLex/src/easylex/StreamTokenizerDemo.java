package easylex;

import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class StreamTokenizerDemo {

    public static void main(String[] args) {

        JLabel jl = new JLabel("");
        JLabel jl1 = new JLabel("");
        JLabel jl2 = new JLabel("");
        JLabel jl3 = new JLabel("");
        JLabel jl4 = new JLabel("");
        JPanel jp = new JPanel();
        JDialog jd = new JDialog();
        JFrame jf = new JFrame();
        JOptionPane jo = new JOptionPane();
        

        //System.out.print("Enter the text to be tokenized: ");
        String text = JOptionPane.showInputDialog("Enter string to be tokenized : ");
        Scanner sc = new Scanner(System.in);
        //text = sc.nextLine();

        try {

            // create a new file with an ObjectOutputStream
            FileOutputStream out = new FileOutputStream("test.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);

            // write something in the file
            oout.writeUTF(text);
            oout.flush();

            // create an ObjectInputStream for the file we created before
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));

            // create a new tokenizer
            Reader r = new BufferedReader(new InputStreamReader(ois));
            StreamTokenizer st = new StreamTokenizer(r);

            // print the stream tokens
            boolean eof = false;

            do {
                int token = st.nextToken();

                switch (token) {
                    case StreamTokenizer.TT_EOF:
                        System.out.println("End of File encountered.");
                        //jl.setText("end of file encountered");
                        //jf.add(jl);
                        
                        
                        eof = true;
                        break;

                    case StreamTokenizer.TT_EOL:
                        System.out.println("End of Line encountered.");
                        //jl1.setText("end of line encountered");
                        //jf.add(jl1);

                        break;

                    case StreamTokenizer.TT_WORD:
                        System.out.println("Operand: " + st.toString());
                        //jl2.setText("Operand: " + st.toString());
                        //jf.add(jl2);
                        break;

                    case StreamTokenizer.TT_NUMBER:
                        System.out.println("Number: " + st.nval);
                        //jl3.setText("Number: " + st.nval);
                        //jf.add(jl3);

                        break;

                    default:
                        System.out.println((char) token + " Operator encountered.");
                        //jl4.setText((char) token + " Operator encountered.");
                        //jf.add(jl4);
                        

                        if (token == '!') {
                            eof = true;
                        }
                }
            } while (!eof);

        } catch (Exception ex) {
            //ex.printStackTrace();

        }
        if ("".equals(text)) {
            JOptionPane.showMessageDialog(null, "No String Entered!");
        }
        //jf.setTitle("testing input");
        //jf.add(jl);
        //jf.add(jl1);
        //jf.add(jl2);
        //jf.add(jl3);
        //jf.add(jl4);
        //jf.setVisible(true);
        //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
