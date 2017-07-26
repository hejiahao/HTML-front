package cn.hjm.test;

import java.io.File;
import java.io.IOException;

public class CopyDir {

	public static void main(String[] args) {
			
		String src = new String("C:\\Users\\hjm\\Desktop\\������վ�����ܹ�_����ԭ���밸������_���ǻ�.pdf");
		
		String dest = new String("C:\\Users\\hjm\\Desktop\\b.pdf");
		
		copyDir(src,dest);
		
		

	}
	
	public static void copyDir(String src,String dest){
		File srcPath =new File(src);
		File destPath = new File(dest);
		if(srcPath.isDirectory()){
			destPath = new File(dest,srcPath.getName());//���Դ�ļ��Ǹ��ļ��У���ô����Ŀ���ļ������ٽ�һ��һ�����ļ���
		}
		
		copyDirDetail(srcPath,destPath);
	}
	
	public static void copyDirDetail(File srcPath,File destPath){
		if(srcPath.isFile()){
			try {
				FileUtil.CopyFile(srcPath, destPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(srcPath.isDirectory()){
			destPath.mkdir();//ȷ��Ŀ���ļ��д���
				File[] filelist = srcPath.listFiles();
				for(File file:filelist){
					copyDirDetail(file,new File(destPath,file.getName()));
				}
		}
	}

}
