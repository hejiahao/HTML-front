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
 * ��ΪBufferedInputStream û���Լ����صķ�����������֮�븸��ķ���
 * �򵥵� ������FileInputStream������һ��BufferedInputStream
 * һ���㶨
 * @author hjm
 *
 */
public class BufferdByteCopyFile {
	
	public static void main(String[] args) throws IOException {
		
		//1.������ϵ Դͷ�ļ�����ʵ���ڲ������ļ��������ļ��У���Ŀ���ļ�
		File file = new File("C:\\Users\\hjm\\Desktop\\a.png");
		//2.Ŀ���ļ�
		File dest = new File("C:\\Users\\hjm\\Desktop\\b.png");
		
		//3.ѡ����������������
		InputStream is = new BufferedInputStream(new FileInputStream(file));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		
		//4.׼������
		byte[] b = new byte[1024];
		int len=0; //��װ����û��
		
		//��ʼ�ϳ�
		try {
			while(-1!=(len=is.read(b))){ //������û�����Ļ������ϳ�������һ�߿���һ�������³�
				os.write(b, 0, len); //��0��ʼ�������˷��³�ȥ���ж����˷Ŷ�����
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			os.flush();//���в����³��ĸϽ����³�
			is.close();//���˳�ǰ��Ҫ�ر���
			os.close();//���˳�����Ҫ׼���ر���
		}
		
	}

}
