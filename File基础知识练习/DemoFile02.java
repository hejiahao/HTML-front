package cn.hjm.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * д���ļ�
 * @author hjm
 *
 */
public class DemoFile02 {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\hjm\\Desktop\\��Ȥ�ľ���.txt");
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
			System.out.println("�ļ�δ�ҵ���");
		}
		

	}

}
