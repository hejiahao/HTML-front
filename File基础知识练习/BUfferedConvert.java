package cn.hjm.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
/**
 * 通过指定的编码格式将文件进行拷贝
 * @author hjm
 *
 */
public class BUfferedConvert {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(new File("C:\\Users\\hjm\\Desktop\\有趣的句子.txt"))
						,"gbk")//在 InputStreamReader这边指定字符集
				
				);
		
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(new File("C:\\Users\\hjm\\Desktop\\a.txt"))
						,"gbk")
				);
		String line=null;
		while(null!=(line=br.readLine())){
			bw.write(line);
		}
		bw.flush();
		br.close();
		bw.close();

	}

}
