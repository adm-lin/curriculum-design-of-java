package com.main;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;


    // TODO: Auto-generated Javadoc
/**
     * The Class TimeShow.
          *时间显示类
     * @date 2020年7月2日
     * @author linyuju
     * @version v1.0
     */
    
public class TimeShow extends JFrame implements Runnable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The info. */
	private JLabel info;
	
	/** The time. */
	private JLabel time;

	/**
	 * Instantiates a new time show.
	 */
	public TimeShow() {
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 200);
		this.setResizable(false);
		this.setLocation(800, 400);
		this.setTitle("当地时间");

		info = new JLabel("当前时间:");
		info.setSize(100, 30);
		info.setLocation(140, 20);
		info.setHorizontalAlignment(JLabel.LEFT);
		info.setFont(new Font("宋体", Font.BOLD, 20));
		this.getContentPane().add(info);

		time = new JLabel("");
		time.setSize(200, 30);
		time.setLocation(140, 20);
		time.setHorizontalAlignment(JLabel.CENTER);
		time.setFont(new Font("宋体", Font.BOLD, 20));
		time.setForeground(Color.BLUE);
		this.getContentPane().add(time);
		this.setVisible(true);
	}

	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see java.lang.Runnable#run()
	    */
	    
	public void run() {
		while (true) { // 一直展示，设置true
			Date d = new Date();
			DateFormat dateMat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time.setText(dateMat.format(d));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
