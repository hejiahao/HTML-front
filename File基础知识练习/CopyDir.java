package cn.hjm.test;

import java.io.File;
import java.io.IOException;

public class CopyDir {

	public static void main(String[] args) {
			
		String src = new String("C:\\Users\\hjm\\Desktop\\大型网站技术架构_核心原理与案例分析_李智慧.pdf");
		
		String dest = new String("C:\\Users\\hjm\\Desktop\\b.pdf");
		
		copyDir(src,dest);
		
		

	}
	
	public static void copyDir(String src,String dest){
		File srcPath =new File(src);
		File destPath = new File(dest);
		if(srcPath.isDirectory()){
			destPath = new File(dest,srcPath.getName());//如果源文件是个文件夹，那么现在目标文件夹下再建一个一样的文件夹
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
			destPath.mkdir();//确保目标文件夹存在
				File[] filelist = srcPath.listFiles();
				for(File file:filelist){
					copyDirDetail(file,new File(destPath,file.getName()));
				}
		}
	}

}
