package cn.hjm.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * ���ݴ�����������͵��ò�ͬ�Ŀ���������ʵ������
 * @author hjm
 * ����ʵ���ļ��п��ļ��У��ļ����ļ����ļ����ļ��� �⼸�ֲ���
 *
 */
public class FileUtil {
	
	/**
	 * 
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	
	public static void CopyFile(File src, File dest) throws IOException{
		InputStream is=null;
		OutputStream os = null;
		File destSecond=null;
		if(dest.isDirectory()){ //���Ŀ����һ���ļ��У���ô���ڸ�dest�ļ����½���һ���µ��ļ�����
			destSecond = new File(dest,src.getName()); //��һ������ƶ��ļ��ĸ�ʽ����Ϊ�������ļ�����Ҫָ��˫�����ļ�����
			//ʵ���ļ����ļ�����ȥ
		
			os = new FileOutputStream(destSecond); //ʵ�ֿ��ļ�����
		}else{
			//����Ǹ��ļ��Ļ���ֱ�ӿ���
			os =new FileOutputStream(dest);
		}
		try {
			is = new FileInputStream(src);
		
			
			byte[] by = new byte[1024];//׼������
			int len=0; //���賵��û����
			
			try {
				while(-1!=(len=is.read(by))){ //��ʼ�����³����ϳ�
					os.write(by, 0, len); //�³�
				}
			} catch (IOException e) {
				e.printStackTrace();
				
			}finally{
				os.flush();
				is.close();
				os.close();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�δ�ҵ�");
		}
	}
/**
 * 
 * @param srcPath
 * @param destPath
 * @throws IOException
 */
	public static void CopyFile(String srcPath,String destPath) throws IOException{
		CopyFile(new File(srcPath), new File(destPath));
	}
	
	/**
	 * �ļ��еĿ���
	 * @param src
	 * @param dest
	 */
	public static void copyDir(String src,String dest){
		File srcPath =new File(src);
		File destPath = null;
		if(srcPath.isDirectory()){
			destPath = new File(dest,srcPath.getName());//���Դ�ļ��Ǹ��ļ��У���ô����Ŀ���ļ������ٽ�һ��һ�����ļ���
		}
		
		copyDirDetail(srcPath,destPath);
	}
	
	public static void copyDirDetail(File srcPath,File destPath){
		if(srcPath.isFile()){ //Ϊ�¼���׼�����⼶�����ò���
			try {
				FileUtil.CopyFile(srcPath, destPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(srcPath.isDirectory()){
			destPath.mkdir();//����������ȷ��Ŀ���ļ��д���
				File[] filelist = srcPath.listFiles();
				for(File file:filelist){
					copyDirDetail(file,new File(destPath,file.getName()));
				}
		}
	}

}
