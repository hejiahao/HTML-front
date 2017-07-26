package cn.hjm.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * 使用字符流进行操作 文件的读取
 * @author hjm
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		//创建file对象
		File file = new File("C:\\Users\\hjm\\Desktop\\有趣的句子.txt");
		
		Reader reader =null;
		try {
			//创建流
			reader =new FileReader(file);
			//创建数组大小
			char[] b = new char[1024];
			//规定字节大小
			int len=0;
			try {
				while(-1!=(len=reader.read(b))){ //当读不到数据的时候为-1
					String str = new String(b,0,len); //构建字符串
					System.out.print(str);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件查找失败");
			e.printStackTrace();
		}finally{
			while(null!=reader){ //该流存在的时候，关闭它
				try {
					reader.close();
				} catch (IOException e) {
					
					e.printStackTrace();
					System.out.println("关闭输入流");
				}
			}
		}
	}
}
