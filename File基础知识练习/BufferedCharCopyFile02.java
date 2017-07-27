package cn.hjm.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * �ı����ͻ�������������Ϊ���Լ��ķ���  ʹ��������������ʹ�ö�̬��Ҳ���Ǹ��಻��ʹ�û��࣬����Ҫ���Լ�����
 * �Ͳ�Ҫ�쳵��
 * ���صķ���
 *    readLine();
 *    writer(String strLine);
 * @author hjm
 *
 */
public class BufferedCharCopyFile02 {
	
	public static void main(String[] args) throws IOException{
	
	//1.������ϵ Դͷ�ļ�����ʵ���ڲ������ļ��������ļ��У���Ŀ���ļ�
	File file = new File("C:\\Users\\hjm\\Desktop\\a.txt");
	//2.Ŀ���ļ�
	File dest = new File("C:\\Users\\hjm\\Desktop\\b.txt");
	
	//3.ѡ������������������Ҫ�����໻������
	BufferedReader reader =   new BufferedReader(new FileReader(file));
	BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
	
			//4.׼������
			//	char[] b = new char[1024];
			//	int len=0; //��װ����û��
	
			//��ʼ�ϳ�
	try {
			//		while(-1!=(len=reader.read(b))){ //������û�����Ļ������ϳ�������һ�߿���һ�������³�
			//			writer.write(b, 0, len); //��0��ʼ�������˷��³�ȥ���ж����˷Ŷ�����
			//		}
		String line =null;
		while(null!=(line=reader.readLine()))//�������ʹ�û��࣬��ô����͵��ò����Լ����صķ���
		{
		 writer.write(line);
		 writer.write("\r\n");
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

