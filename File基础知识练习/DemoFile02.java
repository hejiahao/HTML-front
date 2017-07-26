package cn.hjm.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 写入文件
 * @author hjm
 *
 */
public class DemoFile02 {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\hjm\\Desktop\\有趣的句子.txt");
		OutputStream os = null;
		
		try {
			os = new FileOutputStream(file,true);
			String str ="hello world\r\n";
			byte[] b = str.getBytes();
		    try {
				os.write(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				os.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件未找到！");
		}
		

	}

}
