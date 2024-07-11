import java.awt.*;
import java.awt.event.*;

class MyCalc extends Frame implements ActionListener{
	
	Label l1,tf1;
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24;
	
	Boolean flag1,flag2,flag3,flag4;
	double a=0,b=0,c=0;
	
	MyCalc(){
	
		l1 = new Label("Standard");
        l1.setBounds(30, 30, 150, 30);
        l1.setFont(new Font("TimesNewRoman", Font.PLAIN, 30));
        l1.setForeground(new Color(252, 249, 249));
		
	
		
		tf1 = new Label();
        tf1.setBounds(0, 100, 400, 80);
        tf1.setFont(new Font("TimesNewRoman", Font.PLAIN, 30));
        tf1.setBackground(new Color(20, 20, 20));
        tf1.setForeground(new Color(252, 249, 249));
        tf1.setAlignment(Label.RIGHT);

        b1 = createButton("%", 0, 180);
        b2 = createButton("CE", 100, 180);
        b3 = createButton("C", 200, 180);
        b4 = createButton("<-", 300, 180);
        b5 = createButton("1/x", 0, 250);
        b6 = createButton("x^2", 100, 250);
        b7 = createButton("√", 200, 250);
        b8 = createButton("/", 300, 250);
        b9 = createButton("7", 0, 320);
        b10 = createButton("8", 100, 320);
        b11 = createButton("9", 200, 320);
        b12 = createButton("*", 300, 320);
        b13 = createButton("4", 0, 390);
        b14 = createButton("5", 100, 390);
        b15 = createButton("6", 200, 390);
        b16 = createButton("-", 300, 390);
        b17 = createButton("1", 0, 460);
        b18 = createButton("2", 100, 460);
        b19 = createButton("3", 200, 460);
        b20 = createButton("+", 300, 460);
        b21 = createButton("+/-", 0, 530);
        b22 = createButton("0", 100, 530);
        b23 = createButton(".", 200, 530);
        b24 = createButton("=", 300, 530);

        add(l1);
        add(tf1);
        
		addButtons(); 
		setLayout(null);
        setSize(400, 600);
		
		setBackground(new Color(20, 20, 20));
        setVisible(true);
	}
	
	
	private Button createButton(String label, int x, int y) {
        Button button = new Button(label);
        button.setBounds(x, y, 100, 70);
        button.setBackground(new Color(31, 31, 31));
        button.setForeground(new Color(252, 249, 249));
        button.setFont(new Font("TimesNewRoman", Font.PLAIN, 30));
        button.addActionListener(this);
        return button;
    }
	private void addButtons() {
        add(b1); add(b2); add(b3); add(b4); add(b5); add(b6); add(b7); add(b8); 
        add(b9); add(b10); add(b11); add(b12); add(b13); add(b14); add(b15); 
        add(b16); add(b17); add(b18); add(b19); add(b20); add(b21); add(b22); 
        add(b23); add(b24);
    }
	
	public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals("C")) {
            tf1.setText("");
        } 
		else if (command.equals("CE")) {
            tf1.setText("");
            a = b = c = 0;
            flag1 = flag2 = flag3 = flag4 = false;
        }
		else if (command.equals("<-")) {
            String text = tf1.getText();
            if (!text.isEmpty()) {
                tf1.setText(text.substring(0, text.length() - 1));
            }
        } 
		else if (command.equals("+/-")) {
            if (!tf1.getText().isEmpty()) {
                double value = Double.parseDouble(tf1.getText());
                tf1.setText(String.valueOf(value * -1));
            }
        } 
		else if (command.equals("1/x")) {
            a = Double.parseDouble(tf1.getText());
            tf1.setText(String.valueOf(1 / a));
        } 
		else if (command.equals("x^2")) {
            a = Double.parseDouble(tf1.getText());
            tf1.setText(String.valueOf(a * a));
        }
		else if (command.equals("√")) {
            a = Double.parseDouble(tf1.getText());
            tf1.setText(String.valueOf(Math.sqrt(a)));
        } 
		else if (command.equals("%")) {
            if (flag1 || flag2 || flag3 || flag4) {
                b = Double.parseDouble(tf1.getText());
                c = (a * b) / 100;
                tf1.setText(String.valueOf(c));
            }
        }
		else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            a = Double.parseDouble(tf1.getText());
            tf1.setText("");
            flag1 = flag2 = flag3 = flag4 = false;
            if (command.equals("+")) {
                flag2 = true;
            } else if (command.equals("-")) {
                flag3 = true;
            } else if (command.equals("*")) {
                flag1 = true;
            } else if (command.equals("/")) {
                flag4 = true;
            }
        }
		else if (command.equals("=")) {
            b = Double.parseDouble(tf1.getText());
            if (flag1) {
                c = a * b;
            } else if (flag2) {
                c = a + b;
            } else if (flag3) {
                c = a - b;
            } else if (flag4) {
                c = a / b;
            }
            tf1.setText(String.valueOf(c));
            flag1 = flag2 = flag3 = flag4 = false;
        }
		else {
            tf1.setText(tf1.getText() + command);
			
		}
    }

    public static void main(String args[]) {
        new MyCalc();
    }
	
}