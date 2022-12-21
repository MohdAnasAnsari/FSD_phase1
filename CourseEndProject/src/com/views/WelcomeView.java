package com.views;
import java.util.ArrayList;
import java.util.Scanner;

import com.support.DirectorySupport;
import com.support.ViewSupport;

import java.util.InputMismatchException;

public class WelcomeView implements Views{

private String welcomeText = "Virtual__Key__Repository";
private String developerText = "Developer : Mohd Anas Ansari";

private ArrayList<String> options = new ArrayList<String>();


public WelcomeView() {
options.add("1 for Display all Files");
options.add("2 for Show Different File Operations");
options.add("3 for Quit");

}

public void introduction() {
System.out.println("*******************************************************");
System.out.println("**---------------********************----------------**\n\n");
System.out.println("\t\t"+welcomeText+"\n");
System.out.println("\t\t"+developerText+"\t\t\n\n");
System.out.println("------------------***********************--------------");
System.out.println("-------------------------------------------------------");
Show();
}

@Override
public void Show() {
System.out.println("\nMain Menu:: \n"+"\nEnter Number from Below Options"+"\n---------------------------------");
for (String s : options) {
System.out.println(s);
}

}

public void GetInputFromUser() {
int selectedOption = 0;
while ((selectedOption = this.getOption()) != 3) {
this.NavigateOption(selectedOption);
}
}

@Override
public void NavigateOption(int option) {
switch(option) {

//Files in Directory
case 1:
this.ShowFiles();
this.Show();
break;

//File Options menu
case 2: 
ViewSupport.setCurrentView(ViewSupport.FileOperationView);
ViewSupport.getCurrentView().Show();
ViewSupport.getCurrentView().GetInputFromUser();

this.Show();
break;

default:
System.out.println("Invalid Option");
break;
}

}

public void ShowFiles() {

//Get the files from the Directory

System.out.println("\nList of Files: \n"+"--------------------------------");
DirectorySupport.PrintFiles();

}

private int getOption() {
Scanner in = new Scanner(System.in);

int returnOption = 0;
try {
returnOption = in.nextInt();
}
catch (InputMismatchException e) {

}
return returnOption;

}



}
