package cn.hjm.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * ��ȡ�ļ�
 * @author hjm
 *
 */
public class DemoFile01 {
	public static void main(String[] args) {
		//����file����
		File file = new File("C:\\Users\\hjm\\Desktop\\��Ȥ�ľ���.txt");
		
		InputStream is =null;
		try {
			//������
			is =new FileInputStream(file);
			//���������С
			byte[] b = new byte[3];
			//�涨�ֽڴ�С
			int len=0;
			try {
				while(-1!=(len=is.read(b))){ //�����������ݵ�ʱ��Ϊ-1
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
			while(null!=is){ //�������ڵ�ʱ�򣬹ر���
				try {
					is.close();
				} catch (IOException e) {
					
					e.printStackTrace();
					System.out.println("�ر�������");
				}
			}
		}
	}
}