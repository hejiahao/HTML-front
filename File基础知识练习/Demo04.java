package cn.hjm.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo04 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\hjm\\Desktop\\��Ȥ�ľ���.txt");
		Writer writer = null;
		
		try {
			writer = new FileWriter(file,true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str ="����������\r\n";
		
		try {
			//ֱ��д�룬����Ҫת�ֽ���
			writer.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			while(null!=writer){ //�������ڵ�ʱ�򣬹ر���
				try {
					writer.close();
				} catch (IOException e) {
					
					e.printStackTrace();
					System.out.println("�ر�������");
				}
			}
		}
		

	}

}
