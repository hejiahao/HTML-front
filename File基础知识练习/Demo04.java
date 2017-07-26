package cn.hjm.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo04 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\hjm\\Desktop\\有趣的句子.txt");
		Writer writer = null;
		
		try {
			writer = new FileWriter(file,true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str ="是这样的吗？\r\n";
		
		try {
			//直接写入，不需要转字节流
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
			while(null!=writer){ //该流存在的时候，关闭它
				try {
					writer.close();
				} catch (IOException e) {
					
					e.printStackTrace();
					System.out.println("关闭输入流");
				}
			}
		}
		

	}

}
