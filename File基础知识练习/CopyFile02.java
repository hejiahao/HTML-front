package cn.hjm.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyFile02 {

	public static void main(String[] args) throws IOException {

		//1.建立联系 源头文件（真实存在并且是文件不能是文件夹）和目的文件
		File file = new File("C:\\Users\\hjm\\Desktop\\a.txt");
		//2.目标文件
		File dest = new File("C:\\Users\\hjm\\Desktop\\b.txt");
		
		//3.选择流，输入和输出流
		Reader reader = new FileReader(file);
		Writer writer = new FileWriter(dest);
		
		//4.准备车子
		char[] b = new char[1024];
		int len=0; //假装车上没人
		
		//开始上车
		try {
			while(-1!=(len=reader.read(b))){ //当车子没有满的话继续上车，车子一边开就一边有人下车
				writer.write(b, 0, len); //从0开始慢慢把人放下车去，有多少人放多少人
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			writer.flush();//还有不想下车的赶紧催下车
			reader.close();//本趟车前面要关闭了
			writer.close();//本趟车后门要准备关闭了
		}
		
	}

	
	}

