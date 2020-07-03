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
 * @date 2020��7��2��
 * @author linyuju
 * @version v1.0
 */

public class Demo extends JFrame implements ActionListener {

	/** The Constant serialVersionUID. */

	private static final long serialVersionUID = 1L;
	
	/** The bar. */
	private JMenuBar bar = new JMenuBar();
	
	/** The menu file. */
	private JMenu menuFile = new JMenu("�ļ�");
	
	/** The menu item new. */
	private JMenuItem menuItemNew = new JMenuItem("�½�");
	
	/** The menu item open. */
	private JMenuItem menuItemOpen = new JMenuItem("��");
	
	/** The menu item save. */
	private JMenuItem menuItemSave = new JMenuItem("����");
	
	/** The menu item save as. */
	private JMenuItem menuItemSaveAs = new JMenuItem("���Ϊ");
	
	/** The menu item close. */
	private JMenuItem menuItemClose = new JMenuItem("�ر�");

	/** The menu edit. */
	private JMenu menuEdit = new JMenu("�༭");
	
	/** The menu item cancel. */
	private JMenuItem menuItemCancel = new JMenuItem("����");
	
	/** The menu item shear. */
	private JMenuItem menuItemShear = new JMenuItem("����");
	
	/** The menu item copy. */
	private JMenuItem menuItemCopy = new JMenuItem("����");
	
	/** The menu item paste. */
	private JMenuItem menuItemPaste = new JMenuItem("ճ��");
	
	/** The menu item empty. */
	private JMenuItem menuItemEmpty = new JMenuItem("���");
	
	/** The menu item search. */
	private JMenuItem menuItemSearch = new JMenuItem("����");

	/** The menu function. */
	private JMenu menuFunction = new JMenu("��������");
	
	/** The menu item auto wrap. */
	private JCheckBoxMenuItem menuItemAutoWrap = new JCheckBoxMenuItem("�Զ�����");
	
	/** The menu item font color. */
	private JMenuItem menuItemFontColor = new JMenuItem("������ɫ");
	
	/** The menu item back color. */
	private JMenuItem menuItemBackColor = new JMenuItem("������ɫ");
	
	/** The menu item font choose. */
	private JMenuItem menuItemFontChoose = new JMenuItem("����ѡ��");

	/** The menu help. */
	private JMenu menuHelp = new JMenu("����");
	
	/** The menu item time. */
	private JMenuItem menuItemTime = new JMenuItem("ʱ��");
	
	/** The menu item about. */
	private JMenuItem menuItemAbout = new JMenuItem("����");

	/** The menu manage. */
	private JMenu menuManage = new JMenu("����");
	
	/** The menu item import. */
	private JMenuItem menuItemImport = new JMenuItem("������Ϣ");
	
	/** The menu item person. */
	private JMenuItem menuItemPerson = new JMenuItem("������Ϣ");
	
	/** The menu item class. */
	private JMenuItem menuItemClass = new JMenuItem("�༶����");
	
	/** The menu item revise. */
	private JMenuItem menuItemRevise = new JMenuItem("�����޸�");

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
	private JFileChooser fileCh = new JFileChooser("E:\\ѧϰ����\\java�μ�\\������JAVA�������");
	
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
	 * ҳ���ʼ��
	 */
	public void init() {
		this.setTitle("�ı��༭��");
		ImageIcon icon = new ImageIcon("E:\\\\ѧϰ����\\\\java�μ�\\\\������JAVA�������\\\\������JAVA�������\\\\1.jpg");
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
		txtArea.setFont(new Font("����", Font.BOLD, 20));
		contentPane.add(scrollPane);

		menuItemCancel2 = new JMenuItem("����");
		popupMenu.add(menuItemCancel2);
		menuItemShear2 = new JMenuItem("����");
		popupMenu.add(menuItemShear2);
		menuItemCopy2 = new JMenuItem("����");
		popupMenu.add(menuItemCopy2);
		menuItemPaste2 = new JMenuItem("ճ��");
		popupMenu.add(menuItemPaste2);
		menuItemEmpty2 = new JMenuItem("���");
		popupMenu.add(menuItemEmpty2);
		menuItemSearch2=new JMenuItem("����");
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
				Icon img = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\�ʺ�.jpg");
				JLabel txt = new JLabel("�˳��ı���");
				txt.setFont(new Font("����", Font.BOLD, 20));
				int i = JOptionPane.showConfirmDialog(null, txt, "��ʾ", JOptionPane.YES_NO_OPTION, 0, img);
				if (i == JOptionPane.YES_OPTION)
					System.exit(0);

			}
		});
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setVisible(true);

	}

	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @param e
	    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	    */
	    
	public void actionPerformed(ActionEvent e) {
		// �Զ�����
		if (e.getSource() == menuItemAutoWrap) {
			if (menuItemAutoWrap.isSelected())
				txtArea.setLineWrap(true);
			else
				txtArea.setLineWrap(false);
		}
		// ����
		if (e.getSource() == menuItemAbout) {
			JFrame frame1 = new JFrame("����");
			frame1.setSize(300, 200);
			frame1.setLocation(400, 400);
			String s1 = "  �����ߣ� LINLIN";
			String s2 = "  �������ڣ� 2020/07/03";
			String s3 = "  �����汾�� 01";
			JLabel label = new JLabel("<html>" + s1 + "<br>" + s2 + "<br>" + s3 + "</html>");
			label.setFont(new Font("����", Font.BOLD, 20));
			frame1.add(label);
			frame1.setVisible(true);
		}
		// ʱ����ʾ
		if (e.getSource() == menuItemTime) {
			TimeShow time = new TimeShow();
			new Thread(time).start();

		}
		// �ı��򱳾���ɫ
		if (e.getSource() == menuItemBackColor) {
			colorDialog = JColorChooser.createDialog(this, "������ɫ", true, colorCh, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					txtArea.setBackground(colorCh.getColor());
				}

			}, null);
			colorDialog.setVisible(true);
		}
		// ������ɫѡ��
		if (e.getSource() == menuItemFontColor) {
			colorDialog = JColorChooser.createDialog(this, "������ɫ", true, colorCh, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					txtArea.setForeground(colorCh.getColor());
				}

			}, null);
			colorDialog.setVisible(true);
		}
		// ���
		if (e.getSource() == menuItemEmpty || e.getSource() == menuItemEmpty2) {
			txtArea.setText("");
		}
		// �ı��ر�
		if (e.getSource() == menuItemClose) {
			Icon img = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\�ʺ�.jpg");
			JLabel txt = new JLabel("�˳��ı���");
			txt.setFont(new Font("����", Font.BOLD, 20));
			int i = JOptionPane.showConfirmDialog(null, txt, "��ʾ", JOptionPane.YES_NO_OPTION, 0, img);
			if (i == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		// �ı�����ѡ��
		if (e.getSource() == menuItemFontChoose) {
			@SuppressWarnings("unused")
			FontChoose font = new FontChoose(txtArea);
		}
		// ����
		if (e.getSource() == menuItemCancel || e.getSource() == menuItemCancel2) {
			if (Undo.canUndo()) {
				Undo.undo();
			}
		}
		// �½�һ���ļ�
		if (e.getSource() == menuItemNew) {
			this.createFile();
		}
		// ��һ���ļ�
		if (e.getSource() == menuItemOpen) {
			this.Open();
		}
		// �����ļ�
		if (e.getSource() == menuItemSave) {
			this.Save();
		}
		// ���Ϊ�ļ�
		if (e.getSource() == menuItemSaveAs) {
			this.saveAs();
		}
		// ����Excel����
		if (e.getSource() == menuItemImport) {
			excelManage.importExcel();
		}
		// �����༶����
		if (e.getSource() == menuItemClass) {
			Student student = new Student();
			name = getName();
			student = new StudentDao().queryAsCondition(name);
			String grade=student.getGrade();
			excelManage.exportExcel(grade);
		}
		// ������Ϣ
		if (e.getSource() == menuItemPerson) {
			Student student = new Student();
			name = getName();
			student = new StudentDao().queryAsCondition(name);
			personInfo(student);

		}
		// �����޸�
		if (e.getSource() == menuItemRevise) {
			new reviseFrame().init();;
		}
		// �ı�����
		if (e.getSource() == menuItemCopy || e.getSource() == menuItemCopy2) {
			txtInfo = txtArea.getSelectedText();
		}
		// �ı�����
		if (e.getSource() == menuItemShear || e.getSource() == menuItemShear2) {
			txtInfo = txtArea.getSelectedText();
			int start = txtArea.getSelectionStart();
			int end = txtArea.getSelectionEnd();
			txtArea.replaceRange("", start, end);
		}
		// �ı�ճ��
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
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @return
	    * @see java.awt.Component#getName()
	    */
	    
	public String getName() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\name.txt"), "utf-8"));
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
	 * ������Ϣ�����
	 */
	@SuppressWarnings("static-access")
	public void personInfo(Student student) {
		JFrame person = new JFrame("������Ϣ");
		person.setLayout(new GridLayout(5, 1));
		JLabel name = new JLabel("ѧ��������" + student.getName());
		JLabel id = new JLabel("ѧ�ţ�" + student.getId());
		JLabel major = new JLabel("רҵ��" + student.getMajor());
		JLabel grade = new JLabel("�༶��" + student.getGrade());
		JLabel school = new JLabel("ѧУ��" + student.getSchool());
		name.setHorizontalAlignment(name.CENTER);
		id.setHorizontalAlignment(id.CENTER);
		major.setHorizontalAlignment(major.CENTER);
		grade.setHorizontalAlignment(grade.CENTER);
		school.setHorizontalAlignment(school.CENTER);
		name.setFont(new Font("����", Font.PLAIN, 15));
		id.setFont(new Font("����", Font.PLAIN, 15));
		major.setFont(new Font("����", Font.PLAIN, 15));
		grade.setFont(new Font("����", Font.PLAIN, 15));
		school.setFont(new Font("����", Font.PLAIN, 15));
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
	 * �����µ��ı�
	 */
	public void createFile() {
		File file = null;
		int value = fileCh.showSaveDialog(this);
		if (value == JFileChooser.APPROVE_OPTION) {
			file = fileCh.getSelectedFile();
			// String name=fileCh.getName(file);
			if (file.exists()) {
				log4j.info("�ļ��Ѿ�����");
				Icon img = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\new.jpg");
				JLabel txt = new JLabel("�ļ��Ѿ����ڣ�ȷ�ϸ����𣿣�");
				txt.setFont(new Font("����", Font.BOLD, 20));
				int choice = JOptionPane.showConfirmDialog(null, txt, "ȷ��", JOptionPane.YES_NO_OPTION, 0, img);
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
					log4j.info("�ļ��Ѿ�����");
				}
				if (choice == JOptionPane.NO_OPTION) {
					Icon img2 = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\fail.jpg");
					JLabel txt2 = new JLabel("ȡ�����ǣ��½��ı�ʧ��");
					txt2.setFont(new Font("����", Font.BOLD, 15));
					JOptionPane.showMessageDialog(null, txt2, "��ʾ", 0, img2);
					log4j.info("ȡ������");
				}
			} else {
				log4j.info("�ļ�������");
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
				log4j.info("�ļ��Ѿ�����");
			}
		}
	}

	/**
	 * Open.
	 * ��һ���ı�
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
	 * ����Ŀǰ���ı�
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
	 * ���Ϊ�ı�
	 */
	public void saveAs() {
		File file=null;
		int value = fileCh.showSaveDialog(this);
		if (value == JFileChooser.APPROVE_OPTION) {
			file = fileCh.getSelectedFile();
			if (file.exists()) {
				log4j.info("�ļ��Ѿ�����");
				Icon img = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\new.jpg");
				JLabel txt = new JLabel("�ļ��Ѿ����ڣ�ȷ�ϸ����𣿣�");
				txt.setFont(new Font("����", Font.BOLD, 20));
				int choice = JOptionPane.showConfirmDialog(null, txt, "ȷ��", JOptionPane.YES_NO_OPTION, 0, img);
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
					log4j.info("�ļ��Ѿ�����");
				}
				if (choice == JOptionPane.NO_OPTION) {
					Icon img2 = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\fail.jpg");
					JLabel txt2 = new JLabel("ȡ�����ǣ��½��ı�ʧ��");
					txt2.setFont(new Font("����", Font.BOLD, 15));
					JOptionPane.showMessageDialog(null, txt2, "��ʾ", 0, img2);
					log4j.info("ȡ������");
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
