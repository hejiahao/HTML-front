package cn.hjm.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * ʹ���ַ������в��� �ļ��Ķ�ȡ
 * @author hjm
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		//����file����
		File file = new File("C:\\Users\\hjm\\Desktop\\��Ȥ�ľ���.txt");
		
		Reader reader =null;
		try {
			//������
			reader =new FileReader(file);
			//���������С
			char[] b = new char[1024];
			//�涨�ֽڴ�С
			int len=0;
			try {
				while(-1!=(len=reader.read(b))){ //�����������ݵ�ʱ��Ϊ-1
					String str = new String(b,0,len); //�����ַ���
					System.out.print(str);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�����ʧ��");
			e.printStackTrace();
		}finally{
			while(null!=reader){ //�������ڵ�ʱ�򣬹ر���
				try {
					reader.close();
				} catch (IOException e) {
					
					e.printStackTrace();
					System.out.println("�ر�������");
				}
			}
		}
	}
}
