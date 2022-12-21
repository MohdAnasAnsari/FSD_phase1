package com.support;

import java.io.File;

import com.file_directory.Directory;

public class DirectorySupport {

private static Directory Dir = new Directory();

public static void PrintFiles() {

Dir.fillFiles();

for (File file : DirectorySupport.getDir().getFiles())
{
System.out.println(file.getName());
}
}
public static Directory getDir() {
return Dir;
}

public static void setDir(Directory Dir) {
DirectorySupport.Dir = Dir;
}

}
