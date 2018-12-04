/*
	log recorder.
	3 july 2014 ce.
	//
	# save entries to .txt files with time stamps
	# quick update:
	#-now also enter key submits the form (eg. enters the log)
	#-"| " between time stamps and logs instead of " "
	#-meaning "2014.07.03 01:56:51| some text" instead of "2014.07.03 01:56:51 some text"
	# update *5 july 2014:
	#-an alive clock added
	# notice *7 july 2014:
	#-clock stops after around 2 hours 50 minutes.
	# i'll look into it when i have a chance.
	# fix *7 july 2014:
	#-it seems this fixes it for the foreseeable amount of time.
	# i'll be keeping an eye on it.
	# fix *6 jul 2015
	# i can't believe this thing's been sitting there for eternity:
	# for loop of TimeC class lacked a second plus sign for increment.
 */
//there are two classes;
//first file/class: Logger.java

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

public class Logger {
	public boolean error = false;
	public static void main(String args[]){
		Gui g = new Gui();
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setSize(450, 125);
		g.setVisible(true);
	}
	public void logEntry(String dir, String name, String txt){
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(dir + "\\" + name + ".txt", true)))) {
			error = false;
			out.println(createTime() + "| " + txt);
		}catch (IOException e) {
			error = true;
			System.out.println("error");
		}
	}
	public String createTime(){
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return ft.format(date);
	}
}//end of: Logger
//*  *  *  *  *  *  *  *  *  *  *  *  *  *
//*  *  *  *  *  *  *  *  *  *  *  *  *  *
//second file/class: Gui.java

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Gui extends JFrame{
	private Logger topper = new Logger();
	private JLabel item1, item2, item3, msg, time;
	private JButton butt4;
	private JTextField txt1, txt3, txt2;
	private int x = 1;
	private JRadioButton rad1;

	public Gui(){
		super("Log Recorder");
		setLayout(new FlowLayout());

		item1 = new JLabel("Directory:");
		txt1 = new JTextField("C:\\", 33);
		item2 = new JLabel("Filename:");
		txt3 = new JTextField("someFile");
		item3 = new JLabel("Entry:");
		txt2 = new JTextField(18);
		butt4 = new JButton("Enter");
		msg = new JLabel("");
		time = new JLabel("test");
		rad1 = new JRadioButton("", false);

		add(item1);
		add(txt1);
		add(item2);
		add(txt3);
		add(item3);
		add(txt2);
		add(butt4);
		add(time);
		add(msg);
		add(rad1);

		dandy hand = new dandy();
		timeH tim = new timeH();
		butt4.addActionListener(hand);
		txt2.addActionListener(hand);
		rad1.addItemListener(tim);
		rad1.hide();
		rad1.doClick();
	}
	private class dandy implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			topper.logEntry(txt1.getText(), txt3.getText(), txt2.getText());
			if(topper.error == true){
				msg.setText("|| Error: Folder doesn't exist.");
			}else if(x > 1){
				msg.setText("|| Entry logged..");
				x = 1;
				txt2.setText("");
			}else{
				msg.setText("|| Entry logged.");
				x++;
				txt2.setText("");
			}
		}
	}
	public class timeH implements ItemListener{
		public void itemStateChanged(ItemEvent ev){
			time.setText(topper.createTime());
			System.out.println(topper.createTime());
			Thread time1 = new Thread(new TimeC());
			time1.start();
		}
	}
	public class TimeC implements Runnable{
		public void run(){
			try{
				Thread.sleep(333);
				for(int i = 0; i < 3000; i++){
					time.setText(topper.createTime());
					Thread.sleep(333);
				}
				this.run();
			}catch(Exception e){
				System.out.println("timer not working");
			}
		}
	}
}//end of: Gui
