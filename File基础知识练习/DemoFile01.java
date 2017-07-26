package cn.hjm.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * 读取文件
 * @author hjm
 *
 */
public class DemoFile01 {
	public static void main(String[] args) {
		//创建file对象
		File file = new File("C:\\Users\\hjm\\Desktop\\有趣的句子.txt");
		
		InputStream is =null;
		try {
			//创建流
			is =new FileInputStream(file);
			//创建数组大小
			byte[] b = new byte[3];
			//规定字节大小
			int len=0;
			try {
				while(-1!=(len=is.read(b))){ //当读不到数据的时候为-1
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
			while(null!=is){ //该流存在的时候，关闭它
				try {
					is.close();
				} catch (IOException e) {
					
					e.printStackTrace();
					System.out.println("关闭输入流");
				}
			}
		}
	}
}