package cn.hjm.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 因为BufferedInputStream 没有自己独特的方法，都是来之与父类的方法
 * 简单的 就是在FileInputStream外面套一层BufferedInputStream
 * 一步搞定
 * @author hjm
 *
 */
public class BufferdByteCopyFile {
	
	public static void main(String[] args) throws IOException {
		
		//1.建立联系 源头文件（真实存在并且是文件不能是文件夹）和目的文件
		File file = new File("C:\\Users\\hjm\\Desktop\\a.png");
		//2.目标文件
		File dest = new File("C:\\Users\\hjm\\Desktop\\b.png");
		
		//3.选择流，输入和输出流
		InputStream is = new BufferedInputStream(new FileInputStream(file));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		
		//4.准备车子
		byte[] b = new byte[1024];
		int len=0; //假装车上没人
		
		//开始上车
		try {
			while(-1!=(len=is.read(b))){ //当车子没有满的话继续上车，车子一边开就一边有人下车
				os.write(b, 0, len); //从0开始慢慢把人放下车去，有多少人放多少人
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			os.flush();//还有不想下车的赶紧催下车
			is.close();//本趟车前面要关闭了
			os.close();//本趟车后门要准备关闭了
		}
		
	}

}
