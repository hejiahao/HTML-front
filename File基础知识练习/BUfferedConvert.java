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
 * ͨ��ָ���ı����ʽ���ļ����п���
 * @author hjm
 *
 */
public class BUfferedConvert {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(new File("C:\\Users\\hjm\\Desktop\\��Ȥ�ľ���.txt"))
						,"gbk")//�� InputStreamReader���ָ���ַ���
				
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
