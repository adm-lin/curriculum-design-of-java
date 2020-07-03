package com.main;

import java.awt.Font;
import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.dao.Student;
import com.dao.StudentDao;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


    // TODO: Auto-generated Javadoc
/**
     * The Class ExcelManage.
     *Excel�������ݿ�Ĳ���
     * @date 2020��7��2��
     * @author linyuju
     * @version v1.0
     */
    
public class ExcelManage {
	
	/** The file. */
	File file = null;
	
	/** The work book. */
	Workbook workBook = null;
	
	/** The student info. */
	StudentDao studentInfo = new StudentDao();
	
	/** The sheet. */
	Sheet sheet = null;
	
	/** The file ch. */
	JFileChooser fileCh = new JFileChooser("E:\\ѧϰ����\\java�μ�\\������JAVA�������");
	
	/** The log 4 j. */
	Logger log4j=Logger.getLogger(Demo.class);
	
	/**
	 * Import excel.
	 * ����Excel
	 */

	public void importExcel() {
		int value = fileCh.showOpenDialog(null);
		if (value == JFileChooser.APPROVE_OPTION) {
			file = fileCh.getSelectedFile();
			try {
				workBook = Workbook.getWorkbook(file);
				// ��ȡsheetҳ
				sheet = workBook.getSheet(0);
				// ��ȡ������
				int rows = sheet.getRows();
				log4j.info(rows);
				Student student = new Student();
				for (int i = 1; i < rows; i++) {
					// ��ȡ��Ԫ��
					Cell StudentName = sheet.getCell(0, i);
					Cell StudentId = sheet.getCell(1, i);
					Cell StudentMajor = sheet.getCell(2, i);
					Cell StudentGrade = sheet.getCell(3, i);
					Cell StudentSchool = sheet.getCell(4, i);
					//Cell StudentPassword = sheet.getCell(5, i);
					// ��ȡ��Ԫ���е�����
					String name = StudentName.getContents();
					String id = StudentId.getContents();
					String major = StudentMajor.getContents();
					String grade = StudentGrade.getContents();
					String school = StudentSchool.getContents();
					//String password = StudentPassword.getContents();
					// ����ȡ�����ݷ���Student������
					student.setName(name);
					student.setId(id);
					student.setMajor(major);
					student.setGrade(grade);
					student.setSchool(school);
					//student.setPassword(password);
					// ����Student�����ݵ��뵽���ݿ���
					studentInfo.insert(student);
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				workBook.close();
				JLabel txt = new JLabel("�Ѿ��ɹ�����");
				txt.setFont(new Font("����", Font.BOLD, 20));
				Icon img = new ImageIcon("E:\\ѧϰ����\\java�μ�\\������JAVA�������\\������JAVA�������\\success.jpg");
				JOptionPane.showMessageDialog(null, txt, "��ʾ", 0, img);
			}
		}

	}

	
	    /**
    	 * Export excel.
    	  *�����ݵ�����Excel
    	 * @param className the class name
    	 */
	    
	public void exportExcel(String className) {
		WritableWorkbook writeBook = null;
		int value = fileCh.showSaveDialog(null);
		if (value == JFileChooser.APPROVE_OPTION) {
			file = fileCh.getSelectedFile();
			try {
				writeBook = Workbook.createWorkbook(file);
				WritableSheet writeSheet = writeBook.createSheet("ѧ����Ϣ", 0);
				//���ñ���г�
				for(int i=0;i<5;i++)
				writeSheet.setColumnView(i, 15);
				
				Label nameHeader = new Label(0, 0, "����");
				Label idHeader = new Label(1, 0, "ѧ��");
				Label majorHeader = new Label(2, 0, "רҵ");
				Label gradeHeader = new Label(3, 0, "�༶");
				Label schoolHeader = new Label(4, 0, "ѧУ");
				
				writeSheet.addCell(nameHeader);
				writeSheet.addCell(idHeader);
				writeSheet.addCell(majorHeader);
				writeSheet.addCell(gradeHeader);
				writeSheet.addCell(schoolHeader);

				List<Student> list = studentInfo.queryClass(className);
				Iterator<Student> it=list.iterator();
				while(it.hasNext()) {
					log4j.info(it.next());
					}
				int row = 1;
				for (Student student : list) {
					Label studentName = new Label(0, row, student.getName());
					Label studentId = new Label(1, row, student.getId());
					Label major = new Label(2, row, student.getMajor());
					Label grade = new Label(3, row, student.getGrade());
					Label school = new Label(4, row, student.getSchool());

					writeSheet.addCell(studentName);
					writeSheet.addCell(studentId);
					writeSheet.addCell(major);
					writeSheet.addCell(grade);
					writeSheet.addCell(school);
					row++;
				}
				writeBook.write();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					writeBook.write();
					writeBook.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

}