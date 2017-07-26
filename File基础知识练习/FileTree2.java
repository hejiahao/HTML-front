package cn.hjm.test;

import java.io.File;

public class FileTree2 {
	
	static void printFile(File  file,int level){
		for(int i=0;i<level;i++){
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File temp:files){
				printFile(temp,level+1);
			}
		}
	}
	public static void main(String[] args) {
		File file = new  File("F:\\java文件上传");
		printFile(file,0);

	}

}
