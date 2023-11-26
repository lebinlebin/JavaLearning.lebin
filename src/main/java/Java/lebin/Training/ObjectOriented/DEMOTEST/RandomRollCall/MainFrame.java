package Java.lebin.Training.ObjectOriented.DEMOTEST.RandomRollCall;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;


public class MainFrame extends JFrame {

	private JPanel contentPane;

	private Seat []seats = new Seat[42]; //共42个位置
	private String names[] = {"张厚鑫","张益达","杨睿","肖强","陈司青","宋磊",
			"崔浩","马兰伟","王腾飞","张书民","王光光","高伟伟",
			"陈金玉","薛刚","金飞","谢捷达","李盼盼","杨晓晨",
			"董腾飞","李明远","严春霞","朱华雪","王纬","陈恩强",
			"吴浩鹏","王立旭","石锅瑜","郭键","王学文","邓鹏",
			"齐水青","赵立众","王军","包磊","申红雷","王雨松",
			"","","汪先明","黄平康","林威","陶世和",}; //每个座位对应坐的人

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("随机点名");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
		panel.setBounds(421, 25, 219, 69);
		contentPane.add(panel);

		JLabel label = new JLabel("讲 台");
		label.setFont(new Font("黑体", Font.PLAIN, 32));
		panel.add(label);

		JButton button = new JButton("点 名");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//重新位置
				if(seat!=null) seat.notHighLight();
				//进行选择
				selete();
			}
		});
		button.setBounds(882, 40, 123, 29);
		contentPane.add(button);

		//摆放所有位置
		setSeats(contentPane);
	}

	/**
	 * 随机选择
	 * @return
	 */
	private Seat randomSelect(){
		int ret = random(0, seats.length);
		Seat seat = seats[ret];
		while(!seat.hasPeople()){
			ret = random(0, seats.length);
			seat = seats[ret];
		}
		return seat;
	}

	private void randomShow(){
		//显示20轮
		for(int i=0;i<20;i++){
			Seat s = randomSelect();
			s.highLight();
			try {
				Thread.sleep(random(200,350));
			} catch (InterruptedException e) {}
			s.notHighLight();
			try {
				Thread.sleep(random(80,100));
			} catch (InterruptedException e) {}
		}
	}

	private Seat seat = null;
	/**
	 * 选择
	 */
	private void selete(){
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				//生成随机数
				seat = randomSelect();//这个是最终的结果
				//随机显示
				randomShow();
				//显示选中
				seat.highLight();
			}
		});
		t.start();
	}

	//摆放所有位置
	private void setSeats(JPanel contentPane){
		int xs[] = {52,203,355,576,727,879};
		int ys[] = {133,209,283,359,440,519,596};
		for (int i = 0; i < seats.length; i++) {
			seats[i] = new Seat(names[i]);
			seats[i].setLocation(xs[i%6], ys[i/6]);
			contentPane.add(seats[i]);
		}
	}//setSeats

	/**
	 * 生成随机数[min,max)
	 * @param min
	 * @param max
	 * @return
	 */
	private int random(int min,int max){
		int x = min + (int)(Math.random()*(max-min));
		return x;
	}

}
