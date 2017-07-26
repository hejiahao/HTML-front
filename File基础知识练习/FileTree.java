package cn.hjm.test;

import java.io.File;
import java.nio.file.Files;

public class FileTree {
	
	static void printFile(File file, int level){
		for(int i =0 ; i<level; i++){
			System.out.print("-");
		}
		System.out.println(file.getName());
		
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File temp : files){
				printFile(temp,level+1);
			}
		}
	}	
	public  static void main(String[] args) {
		File file = new  File("F:\\java文件上传\\资料\\02.代码\\itcastupload");
		printFile(file,0);
	}

}
