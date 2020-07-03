package com.main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.*;
import javax.swing.undo.UndoManager;

import org.apache.log4j.Logger;

import com.dao.Student;
import com.dao.StudentDao;

// TODO: Auto-generated Javadoc
/**
 * The Class Demo.
 *
 * @date 2020年7月2日
 * @author linyuju
 * @version v1.0
 */

public class Demo extends JFrame implements ActionListener {

	/** The Constant serialVersionUID. */

	private static final long serialVersionUID = 1L;
	
	/** The bar. */
	private JMenuBar bar = new JMenuBar();
	
	/** The menu file. */
	private JMenu menuFile = new JMenu("文件");
	
	/** The menu item new. */
	private JMenuItem menuItemNew = new JMenuItem("新建");
	
	/** The menu item open. */
	private JMenuItem menuItemOpen = new JMenuItem("打开");
	
	/** The menu item save. */
	private JMenuItem menuItemSave = new JMenuItem("保存");
	
	/** The menu item save as. */
	private JMenuItem menuItemSaveAs = new JMenuItem("另存为");
	
	/** The menu item close. */
	private JMenuItem menuItemClose = new JMenuItem("关闭");

	/** The menu edit. */
	private JMenu menuEdit = new JMenu("编辑");
	
	/** The menu item cancel. */
	private JMenuItem menuItemCancel = new JMenuItem("撤销");
	
	/** The menu item shear. */
	private JMenuItem menuItemShear = new JMenuItem("剪切");
	
	/** The menu item copy. */
	private JMenuItem menuItemCopy = new JMenuItem("复制");
	
	/** The menu item paste. */
	private JMenuItem menuItemPaste = new JMenuItem("粘贴");
	
	/** The menu item empty. */
	private JMenuItem menuItemEmpty = new JMenuItem("清空");
	
	/** The menu item search. */
	private JMenuItem menuItemSearch = new JMenuItem("查找");

	/** The menu function. */
	private JMenu menuFunction = new JMenu("功能设置");
	
	/** The menu item auto wrap. */
	private JCheckBoxMenuItem menuItemAutoWrap = new JCheckBoxMenuItem("自动换行");
	
	/** The menu item font color. */
	private JMenuItem menuItemFontColor = new JMenuItem("字体颜色");
	
	/** The menu item back color. */
	private JMenuItem menuItemBackColor = new JMenuItem("背景颜色");
	
	/** The menu item font choose. */
	private JMenuItem menuItemFontChoose = new JMenuItem("字体选择");

	/** The menu help. */
	private JMenu menuHelp = new JMenu("帮助");
	
	/** The menu item time. */
	private JMenuItem menuItemTime = new JMenuItem("时间");
	
	/** The menu item about. */
	private JMenuItem menuItemAbout = new JMenuItem("关于");

	/** The menu manage. */
	private JMenu menuManage = new JMenu("管理");
	
	/** The menu item import. */
	private JMenuItem menuItemImport = new JMenuItem("导入信息");
	
	/** The menu item person. */
	private JMenuItem menuItemPerson = new JMenuItem("个人信息");
	
	/** The menu item class. */
	private JMenuItem menuItemClass = new JMenuItem("班级名单");
	
	/** The menu item revise. */
	private JMenuItem menuItemRevise = new JMenuItem("密码修改");

	/** The txt area. */
	private JTextArea txtArea = new JTextArea();
	
	/** The Undo. */
	private UndoManager Undo = new UndoManager();
	
	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The popup menu. */
	private JPopupMenu popupMenu = new JPopupMenu();
	
	/** The menu item cancel 2. */
	private JMenuItem menuItemCancel2;
	
	/** The menu item shear 2. */
	private JMenuItem menuItemShear2;
	
	/** The menu item copy 2. */
	private JMenuItem menuItemCopy2;
	
	/** The menu item paste 2. */
	private JMenuItem menuItemPaste2;
	
	/** The menu item empty 2. */
	private JMenuItem menuItemEmpty2;
	
	/** The menu item search 2. */
	private JMenuItem menuItemSearch2;

	/** The content pane. */
	private JPanel contentPane = new JPanel();
	
	/** The color dialog. */
	private JDialog colorDialog;
	
	/** The color ch. */
	private JColorChooser colorCh = new JColorChooser();
	
	/** The file ch. */
	private JFileChooser fileCh = new JFileChooser("E:\\学习资料\\java课件\\附件：JAVA程序设计");
	
	/** The excel manage. */
	private ExcelManage excelManage = new ExcelManage();
	
	/** The br. */
	BufferedReader br;
	
	/** The bw. */
	BufferedWriter bw;
	
	/** The txt info. */
	String txtInfo = null;
	
	/** The open file name. */
	String openFileName = null;
	
	/** The name. */
	String name = null;

	/** The log 4 j. */
	Logger log4j = Logger.getLogger(Demo.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new Demo().init();
	}

	/**
	 * Inits the.
	 * 页面初始化
	 */
	public void init() {
		this.setTitle("文本编辑器");
		ImageIcon icon = new ImageIcon("E:\\\\学习资料\\\\java课件\\\\附件：JAVA程序设计\\\\附件：JAVA程序设计\\\\1.jpg");
		this.setIconImage(icon.getImage());
		this.setBounds(500, 300, 700, 600);
		this.setJMenuBar(bar);
		txtArea.getDocument().addUndoableEditListener(Undo);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);
		bar.add(menuFile);
		menuFile.add(menuItemNew);
		menuFile.add(menuItemOpen);
		menuFile.add(menuItemSave);
		menuFile.add(menuItemSaveAs);
		menuFile.addSeparator();
		menuFile.add(menuItemClose);
		bar.add(menuEdit);
		menuEdit.add(menuItemCancel);
		menuEdit.add(menuItemShear);
		menuEdit.add(menuItemCopy);
		menuEdit.add(menuItemPaste);
		menuEdit.add(menuItemSearch);
		menuEdit.addSeparator();
		menuEdit.add(menuItemEmpty);

		bar.add(menuFunction);
		menuFunction.add(menuItemAutoWrap);
		menuFunction.add(menuItemFontChoose);
		menuFunction.add(menuItemFontColor);
		menuFunction.add(menuItemBackColor);

		bar.add(menuHelp);
		menuHelp.add(menuItemTime);
		menuHelp.add(menuItemAbout);

		bar.add(menuManage);
		menuManage.add(menuItemImport);
		menuManage.add(menuItemClass);
		menuManage.add(menuItemPerson);
		menuManage.add(menuItemRevise);
		

		scrollPane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		txtArea.setFont(new Font("宋体", Font.BOLD, 20));
		contentPane.add(scrollPane);

		menuItemCancel2 = new JMenuItem("撤销");
		popupMenu.add(menuItemCancel2);
		menuItemShear2 = new JMenuItem("剪切");
		popupMenu.add(menuItemShear2);
		menuItemCopy2 = new JMenuItem("复制");
		popupMenu.add(menuItemCopy2);
		menuItemPaste2 = new JMenuItem("粘贴");
		popupMenu.add(menuItemPaste2);
		menuItemEmpty2 = new JMenuItem("清空");
		popupMenu.add(menuItemEmpty2);
		menuItemSearch2=new JMenuItem("查找");
		popupMenu.add(menuItemSearch2);

		popupMenu.setBorderPainted(true);
		popupMenu.setPopupSize(80, 100);
		txtArea.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});

		menuItemAutoWrap.addActionListener(this);
		menuItemAbout.addActionListener(this);
		menuItemTime.addActionListener(this);
		menuItemFontColor.addActionListener(this);
		menuItemBackColor.addActionListener(this);
		menuItemClose.addActionListener(this);
		menuItemEmpty.addActionListener(this);
		menuItemFontChoose.addActionListener(this);
		menuItemCancel.addActionListener(this);
		menuItemCancel2.addActionListener(this);
		menuItemOpen.addActionListener(this);
		menuItemSaveAs.addActionListener(this);
		menuItemImport.addActionListener(this);
		menuItemEmpty2.addActionListener(this);
		menuItemShear.addActionListener(this);
		menuItemShear2.addActionListener(this);
		menuItemPaste.addActionListener(this);
		menuItemPaste2.addActionListener(this);
		menuItemCopy.addActionListener(this);
		menuItemCopy2.addActionListener(this);
		menuItemClass.addActionListener(this);
		menuItemSave.addActionListener(this);
		menuItemNew.addActionListener(this);
		menuItemPerson.addActionListener(this);
		menuItemSearch.addActionListener(this);
		menuItemRevise.addActionListener(this);
		menuItemSearch2.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Icon img = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\问号.jpg");
				JLabel txt = new JLabel("退出文本？");
				txt.setFont(new Font("楷体", Font.BOLD, 20));
				int i = JOptionPane.showConfirmDialog(null, txt, "提示", JOptionPane.YES_NO_OPTION, 0, img);
				if (i == JOptionPane.YES_OPTION)
					System.exit(0);

			}
		});
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setVisible(true);

	}

	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param e
	    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	    */
	    
	public void actionPerformed(ActionEvent e) {
		// 自动换行
		if (e.getSource() == menuItemAutoWrap) {
			if (menuItemAutoWrap.isSelected())
				txtArea.setLineWrap(true);
			else
				txtArea.setLineWrap(false);
		}
		// 关于
		if (e.getSource() == menuItemAbout) {
			JFrame frame1 = new JFrame("关于");
			frame1.setSize(300, 200);
			frame1.setLocation(400, 400);
			String s1 = "  开发者： LINLIN";
			String s2 = "  开发日期： 2020/07/03";
			String s3 = "  开发版本： 01";
			JLabel label = new JLabel("<html>" + s1 + "<br>" + s2 + "<br>" + s3 + "</html>");
			label.setFont(new Font("宋体", Font.BOLD, 20));
			frame1.add(label);
			frame1.setVisible(true);
		}
		// 时间显示
		if (e.getSource() == menuItemTime) {
			TimeShow time = new TimeShow();
			new Thread(time).start();

		}
		// 文本框背景颜色
		if (e.getSource() == menuItemBackColor) {
			colorDialog = JColorChooser.createDialog(this, "背景颜色", true, colorCh, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					txtArea.setBackground(colorCh.getColor());
				}

			}, null);
			colorDialog.setVisible(true);
		}
		// 文字颜色选择
		if (e.getSource() == menuItemFontColor) {
			colorDialog = JColorChooser.createDialog(this, "字体颜色", true, colorCh, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					txtArea.setForeground(colorCh.getColor());
				}

			}, null);
			colorDialog.setVisible(true);
		}
		// 清空
		if (e.getSource() == menuItemEmpty || e.getSource() == menuItemEmpty2) {
			txtArea.setText("");
		}
		// 文本关闭
		if (e.getSource() == menuItemClose) {
			Icon img = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\问号.jpg");
			JLabel txt = new JLabel("退出文本？");
			txt.setFont(new Font("楷体", Font.BOLD, 20));
			int i = JOptionPane.showConfirmDialog(null, txt, "提示", JOptionPane.YES_NO_OPTION, 0, img);
			if (i == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		// 文本字体选择
		if (e.getSource() == menuItemFontChoose) {
			@SuppressWarnings("unused")
			FontChoose font = new FontChoose(txtArea);
		}
		// 撤销
		if (e.getSource() == menuItemCancel || e.getSource() == menuItemCancel2) {
			if (Undo.canUndo()) {
				Undo.undo();
			}
		}
		// 新建一个文件
		if (e.getSource() == menuItemNew) {
			this.createFile();
		}
		// 开一个文件
		if (e.getSource() == menuItemOpen) {
			this.Open();
		}
		// 保存文件
		if (e.getSource() == menuItemSave) {
			this.Save();
		}
		// 另存为文件
		if (e.getSource() == menuItemSaveAs) {
			this.saveAs();
		}
		// 导入Excel数据
		if (e.getSource() == menuItemImport) {
			excelManage.importExcel();
		}
		// 导出班级名单
		if (e.getSource() == menuItemClass) {
			Student student = new Student();
			name = getName();
			student = new StudentDao().queryAsCondition(name);
			String grade=student.getGrade();
			excelManage.exportExcel(grade);
		}
		// 个人信息
		if (e.getSource() == menuItemPerson) {
			Student student = new Student();
			name = getName();
			student = new StudentDao().queryAsCondition(name);
			personInfo(student);

		}
		// 密码修改
		if (e.getSource() == menuItemRevise) {
			new reviseFrame().init();;
		}
		// 文本复制
		if (e.getSource() == menuItemCopy || e.getSource() == menuItemCopy2) {
			txtInfo = txtArea.getSelectedText();
		}
		// 文本剪切
		if (e.getSource() == menuItemShear || e.getSource() == menuItemShear2) {
			txtInfo = txtArea.getSelectedText();
			int start = txtArea.getSelectionStart();
			int end = txtArea.getSelectionEnd();
			txtArea.replaceRange("", start, end);
		}
		// 文本粘贴
		if (e.getSource() == menuItemPaste || e.getSource() == menuItemPaste2) {
			if (txtArea.getSelectedText() != null) {
				int start = txtArea.getSelectionStart();
				int end = txtArea.getSelectionEnd();
				txtArea.replaceRange(txtInfo, start, end);
			} else {
				int location = txtArea.getCaretPosition();
				txtArea.insert(txtInfo, location);
			}

		}
		if (e.getSource() == menuItemSearch||e.getSource()==menuItemSearch2) {
			new Search(txtArea).init();
		}
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @return
	    * @see java.awt.Component#getName()
	    */
	    
	public String getName() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\name.txt"), "utf-8"));
			name = br.readLine();
			br.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			log4j.info(name);
		}
		return name;
	}

	
	/**
	 * Person info.
	 *
	 * @param student the student
	 * 个人信息的面板
	 */
	@SuppressWarnings("static-access")
	public void personInfo(Student student) {
		JFrame person = new JFrame("个人信息");
		person.setLayout(new GridLayout(5, 1));
		JLabel name = new JLabel("学生姓名：" + student.getName());
		JLabel id = new JLabel("学号：" + student.getId());
		JLabel major = new JLabel("专业：" + student.getMajor());
		JLabel grade = new JLabel("班级：" + student.getGrade());
		JLabel school = new JLabel("学校：" + student.getSchool());
		name.setHorizontalAlignment(name.CENTER);
		id.setHorizontalAlignment(id.CENTER);
		major.setHorizontalAlignment(major.CENTER);
		grade.setHorizontalAlignment(grade.CENTER);
		school.setHorizontalAlignment(school.CENTER);
		name.setFont(new Font("黑体", Font.PLAIN, 15));
		id.setFont(new Font("黑体", Font.PLAIN, 15));
		major.setFont(new Font("黑体", Font.PLAIN, 15));
		grade.setFont(new Font("黑体", Font.PLAIN, 15));
		school.setFont(new Font("黑体", Font.PLAIN, 15));
		person.setSize(400, 200);
		person.setLocation(800, 400);
		person.getContentPane().add(name);
		person.getContentPane().add(id);
		person.getContentPane().add(major);
		person.getContentPane().add(grade);
		person.getContentPane().add(school);
		person.setVisible(true);
		// person.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Creates the file.
	 * 创建新的文本
	 */
	public void createFile() {
		File file = null;
		int value = fileCh.showSaveDialog(this);
		if (value == JFileChooser.APPROVE_OPTION) {
			file = fileCh.getSelectedFile();
			// String name=fileCh.getName(file);
			if (file.exists()) {
				log4j.info("文件已经存在");
				Icon img = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\new.jpg");
				JLabel txt = new JLabel("文件已经存在，确认覆盖吗？？");
				txt.setFont(new Font("宋体", Font.BOLD, 20));
				int choice = JOptionPane.showConfirmDialog(null, txt, "确认", JOptionPane.YES_NO_OPTION, 0, img);
				if (choice == JOptionPane.YES_OPTION) {
					try {
						openFileName = file.getAbsolutePath();
						bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
						txtArea.setText("");
						bw.write(txtArea.getText());
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							bw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					log4j.info("文件已经覆盖");
				}
				if (choice == JOptionPane.NO_OPTION) {
					Icon img2 = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\fail.jpg");
					JLabel txt2 = new JLabel("取消覆盖，新建文本失败");
					txt2.setFont(new Font("宋体", Font.BOLD, 15));
					JOptionPane.showMessageDialog(null, txt2, "提示", 0, img2);
					log4j.info("取消覆盖");
				}
			} else {
				log4j.info("文件不存在");
				try {
					openFileName = file.getAbsolutePath();
					bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
					txtArea.setText("");
					bw.write(txtArea.getText());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				log4j.info("文件已经保存");
			}
		}
	}

	/**
	 * Open.
	 * 打开一个文本
	 */
	public void Open() {
		int value = fileCh.showOpenDialog(this);
		if (value == JFileChooser.APPROVE_OPTION) {
			try {
				File fileName = fileCh.getSelectedFile();
				openFileName = fileName.getAbsolutePath();
				log4j.info(openFileName);
				br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
				String line = null;
				txtArea.setText("");
				while ((line = br.readLine()) != null) {
					txtArea.append(line + "\r\n");
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	/**
	 * Save.
	 * 保存目前的文本
	 */
	public void Save() {
		if (openFileName != null) {
			log4j.info(openFileName);
			try {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(openFileName), "UTF-8"));
				bw.write(txtArea.getText());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			saveAs();
		}

	}

	/**
	 * Save as.
	 * 另存为文本
	 */
	public void saveAs() {
		File file=null;
		int value = fileCh.showSaveDialog(this);
		if (value == JFileChooser.APPROVE_OPTION) {
			file = fileCh.getSelectedFile();
			if (file.exists()) {
				log4j.info("文件已经存在");
				Icon img = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\new.jpg");
				JLabel txt = new JLabel("文件已经存在，确认覆盖吗？？");
				txt.setFont(new Font("宋体", Font.BOLD, 20));
				int choice = JOptionPane.showConfirmDialog(null, txt, "确认", JOptionPane.YES_NO_OPTION, 0, img);
				if (choice == JOptionPane.YES_OPTION) {
					try {
						openFileName = file.getAbsolutePath();
						bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
						bw.write(txtArea.getText());
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							bw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					log4j.info("文件已经覆盖");
				}
				if (choice == JOptionPane.NO_OPTION) {
					Icon img2 = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\fail.jpg");
					JLabel txt2 = new JLabel("取消覆盖，新建文本失败");
					txt2.setFont(new Font("宋体", Font.BOLD, 15));
					JOptionPane.showMessageDialog(null, txt2, "提示", 0, img2);
					log4j.info("取消覆盖");
				}
			}else {
				try {
					openFileName = file.getAbsolutePath();
					bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
					bw.write(txtArea.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			
		}
	}

}
