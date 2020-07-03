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
     *Excel的于数据库的操作
     * @date 2020年7月2日
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
	JFileChooser fileCh = new JFileChooser("E:\\学习资料\\java课件\\附件：JAVA程序设计");
	
	/** The log 4 j. */
	Logger log4j=Logger.getLogger(Demo.class);
	
	/**
	 * Import excel.
	 * 导入Excel
	 */

	public void importExcel() {
		int value = fileCh.showOpenDialog(null);
		if (value == JFileChooser.APPROVE_OPTION) {
			file = fileCh.getSelectedFile();
			try {
				workBook = Workbook.getWorkbook(file);
				// 获取sheet页
				sheet = workBook.getSheet(0);
				// 获取数据行
				int rows = sheet.getRows();
				log4j.info(rows);
				Student student = new Student();
				for (int i = 1; i < rows; i++) {
					// 获取单元格
					Cell StudentName = sheet.getCell(0, i);
					Cell StudentId = sheet.getCell(1, i);
					Cell StudentMajor = sheet.getCell(2, i);
					Cell StudentGrade = sheet.getCell(3, i);
					Cell StudentSchool = sheet.getCell(4, i);
					//Cell StudentPassword = sheet.getCell(5, i);
					// 获取单元格中的内容
					String name = StudentName.getContents();
					String id = StudentId.getContents();
					String major = StudentMajor.getContents();
					String grade = StudentGrade.getContents();
					String school = StudentSchool.getContents();
					//String password = StudentPassword.getContents();
					// 将获取的内容放入Student对象中
					student.setName(name);
					student.setId(id);
					student.setMajor(major);
					student.setGrade(grade);
					student.setSchool(school);
					//student.setPassword(password);
					// 将该Student的数据导入到数据库中
					studentInfo.insert(student);
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				workBook.close();
				JLabel txt = new JLabel("已经成功导入");
				txt.setFont(new Font("楷体", Font.BOLD, 20));
				Icon img = new ImageIcon("E:\\学习资料\\java课件\\附件：JAVA程序设计\\附件：JAVA程序设计\\success.jpg");
				JOptionPane.showMessageDialog(null, txt, "提示", 0, img);
			}
		}

	}

	
	    /**
    	 * Export excel.
    	  *将数据导出成Excel
    	 * @param className the class name
    	 */
	    
	public void exportExcel(String className) {
		WritableWorkbook writeBook = null;
		int value = fileCh.showSaveDialog(null);
		if (value == JFileChooser.APPROVE_OPTION) {
			file = fileCh.getSelectedFile();
			try {
				writeBook = Workbook.createWorkbook(file);
				WritableSheet writeSheet = writeBook.createSheet("学生信息", 0);
				//设置表的列长
				for(int i=0;i<5;i++)
				writeSheet.setColumnView(i, 15);
				
				Label nameHeader = new Label(0, 0, "姓名");
				Label idHeader = new Label(1, 0, "学号");
				Label majorHeader = new Label(2, 0, "专业");
				Label gradeHeader = new Label(3, 0, "班级");
				Label schoolHeader = new Label(4, 0, "学校");
				
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