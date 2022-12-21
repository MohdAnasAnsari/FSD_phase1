package com.views;
import java.util.ArrayList;
import java.io.File;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Scanner;
import java.util.InputMismatchException;

import com.file_directory.Directory;

public class FileOperationView implements Views{

private Directory dir = new Directory();

private ArrayList<String> options = new ArrayList<String>();

public FileOperationView() {

options.add("1. To Create a New File");
options.add("2. To Delete an Existing File");
options.add("3. To Search a File");
options.add("4. Return to Main Menu");
}

@Override
public void Show() {
System.out.println("\nAvailable File Operations are"+"\n--------------------------");
for (String s : options) {
System.out.println(s);
}
}

public void GetInputFromUser() {
int selectedOption;
while ((selectedOption = this.getOption()) != 4) {
this.NavigateOption(selectedOption);
}
}

@Override
public void NavigateOption(int option) {

switch(option) {

//Create a new File
case 1: 
this.AddFile();

this.Show();
break;

//Delete File
case 2: 
this.DeleteFile();

this.Show();
break;

//Search File
case 3:
this.SearchFile();
this.Show();
break;

/*
case 4 to Return to Menu
break;
*/

default:
System.out.println("Invalid Number, Please Enter Number Between 1 to 4.");
break;
}
}

private String getInputString() {

Scanner in = new Scanner(System.in);
return(in.nextLine());

}

private int getOption() {
Scanner in = new Scanner(System.in);

int returnOption = 0;
try {
returnOption = in.nextInt();
}
catch (InputMismatchException ex) {
System.out.println("Invalid input");
}
return returnOption;
}

public void AddFile() {
System.out.println("\nPlease Enter Correct Filename : ");

String fileName = this.getInputString();

System.out.println("\nfile name : " + fileName+ " has been added successfully");

try {
Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
File file = new File(dir.getName() + fileName);

if (file.createNewFile()) {
System.out.println("Successfully File created : " + file.getName());
dir.getFiles().add(file);
} 
else {
System.out.println("This File Already Exits !!!");
}
}catch (IOException e){
System.out.println(e);
}
}

public void DeleteFile() {

System.out.println("\nPlease Enter the Filename :");

String fileName = this.getInputString();

System.out.println("\nYou are deleting a file named : " + fileName);

//TODO: Delete file

Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
File file = path.toFile();
if (file.delete()) {
System.out.println("Successfully File Deleted : " + file.getName());
dir.getFiles().remove(file);
} else {
System.out.println("Failed to delete file : " + fileName + " ,File not found.");
}
}

public void SearchFile() {

Boolean found = false;

System.out.println("\nEnter the Filename : ");

String fileName = this.getInputString();

System.out.println("\nYou are searching for a file named : " + fileName);

//Fix it so ArrayList obtains files

ArrayList<File> files = dir.getFiles();

for(int i = 0; i < files.size(); i++) {
if(files.get(i).getName().equals(fileName)) {
System.out.println("Found " + fileName);
found = true;
}
}
if (found == false) {
System.out.println("File not found");
}
}
}