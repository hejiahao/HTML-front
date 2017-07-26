package cn.hjm.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyFile02 {

	public static void main(String[] args) throws IOException {

		//1.������ϵ Դͷ�ļ�����ʵ���ڲ������ļ��������ļ��У���Ŀ���ļ�
		File file = new File("C:\\Users\\hjm\\Desktop\\a.txt");
		//2.Ŀ���ļ�
		File dest = new File("C:\\Users\\hjm\\Desktop\\b.txt");
		
		//3.ѡ����������������
		Reader reader = new FileReader(file);
		Writer writer = new FileWriter(dest);
		
		//4.׼������
		char[] b = new char[1024];
		int len=0; //��װ����û��
		
		//��ʼ�ϳ�
		try {
			while(-1!=(len=reader.read(b))){ //������û�����Ļ������ϳ�������һ�߿���һ�������³�
				writer.write(b, 0, len); //��0��ʼ�������˷��³�ȥ���ж����˷Ŷ�����
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			writer.flush();//���в����³��ĸϽ����³�
			reader.close();//���˳�ǰ��Ҫ�ر���
			writer.close();//���˳�����Ҫ׼���ر���
		}
		
	}

	
	}

