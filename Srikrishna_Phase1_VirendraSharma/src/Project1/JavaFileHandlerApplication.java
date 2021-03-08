
package Project1;

import java.io.File;
import java.io.IOException;
import java.util.*;
//File function started
public class JavaFileHandlerApplication {  //main function
	
private void WelcomePage() {
	//JavaFileHandlerApplication obj=new JavaFileHandlerApplication();
	System.out.println("Welcome You...!");
	System.out.println("Project Name: Java File Handing");
	System.out.println("Project done by: Srikrishna Ganpatrao Kharatmul");
	System.out.println("Online Trainer: Virendra Sharma");

}
//FUctions started  below listing all files as ascending order
private void ListFile() {
//	File file=new File("C:\\Simplilearn\\SrikrishnaGanpatrao_Phase1_VirendraSharma\\src\\MyJavaProject\\textfile.txt");
	File file=new File("C:\\Simplilearn\\Project1\\src\\Project1\\");

	System.out.println("Files in "+file.getAbsolutePath()+" Path is");
	String arr[]=file.list();
	Set<String> treeset=new TreeSet<String>();
	int m=0;
	for(String j:arr)
	{
		m++;
		treeset.add(j);
		System.out.println("    "+m+"."+j);
	}
	System.out.println("\nListed succesfully... Again start your File operations");
}
private void Operations() {
	System.out.println("\nPlease select operations want to perform following below");
	System.out.println(" 1)Add File\n 2)Delete File\n 3)Search File\n 4)Return Main Menu\n");
	Scanner scan=new Scanner(System.in);
	JavaFileHandlerApplication obj=new JavaFileHandlerApplication();
	int input=scan.nextInt();
	switch(input) {
	case 1:{
		try {
			obj.AddFile();
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	case 2:{
		try {
			obj.DeleteFile();
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	case 3:{
		try {
			obj.SearchFile();
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	case 4:{
		try {
			obj.MainFile();
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}

public void MenuPage() {
	try{
		System.out.println("\nFile Handling Concept begins here...!");
		System.out.println("\nPlease select operations want to perform by entering perticular numbers(1,2 & 3) only");
		System.out.println("     1)List the Files name as in ascending order\n     2)Perform Operations of ADD, DELETE, SEARCH \n     3)Exit file operation");
	JavaFileHandlerApplication obj=new JavaFileHandlerApplication();
	Scanner scan=new Scanner(System.in);
	int ch=scan.nextInt();
	switch(ch) {
	case 1:{
		//list of files
		obj.ListFile();
		obj.MenuPage();
		break;
	}
	case 2:{
		//operation of add, delete, search, return to menu
		obj.Operations();
		obj.MenuPage();
		break;
	}
	case 3:{
		//exit file operations
		System.out.print("Now you are out of operation. Thank you..!");
		Runtime.getRuntime().exit(0); 
		break;
	}
}
	}catch(Exception e)
	{
		System.out.println("Exception catched in Menu page:"+e);
	}
}
//User Interaction Functions(Add,delete,search,GO to main menu
public void AddFile() throws IOException {
	System.out.println("For adding Enter Filename want to add with extension(ex:.txt,.doc, .pdf)");
	//System.out.println("Note: After operation, if you want to add more please enter 'c' to continue otherwise enter 'e' to exit operation)");
	Scanner scan=new Scanner(System.in);
	String filename=scan.nextLine();
	if(filename.equals("e")||filename.equals("c")||filename.equals(""))
	{
		System.out.println("Please enter valid Filename");
		System.out.println();
		AddFile();
	}
	else {
		File file=new File("C:\\Simplilearn\\Project1\\src\\Project1\\"+filename);
		if(file.exists())
		{
			System.out.println("Oh no..! This file already exist..!");
			System.out.println();
			char input=scan.next().charAt(0);
			if(input=='e') {
				Operations();
			}
			else if(input=='c') {
				AddFile();
			}
			else {
				System.out.println("it's an invalid input..!\n");
				MenuPage();
			}
		}else {
			file.createNewFile();
			System.out.println("Yes, File Created Successfully!\n");
			Operations();
			char input=scan.next().charAt(0);
			if(input=='e') {
				Operations();
			}
			else if(input=='c'){
				AddFile();
			}
			else {
				System.out.println("it's an invalid input..!");
				MenuPage();
			}
		}	
	}
	
}
public void DeleteFile() {
	System.out.println("For deleting Enter Filename want to delete with extension(ex:.txt,.doc, .pdf)");
	//System.out.println("Note: After operation, if you want to add more please enter 'c' to continue otherwise enter 'e' to exit operation)");
	//System.out.println("Now enter file name to delete");
	Scanner scan=new Scanner(System.in);
	String filename=scan.nextLine();
	if(filename.equals("e")||filename.equals("c")||filename.equals(""))
	{
		System.out.println("Please enter valid filename");
		System.out.println();
		DeleteFile();
	}
	else {
	File file=new File("C:\\Simplilearn\\Project1\\src\\Project1\\"+filename);
	File path=new File("C:\\Simplilearn\\Project1\\src\\Project1\\");
	String filecheck=file.getName();
	String arr[]=path.list();
	int count=0;
	for(int i=1;i<arr.length;i++)
	{
		if(arr[i].equals(filecheck))
		{
			file.delete();
			System.out.println("File Deleted successfully..!");
			
			count=1;
			
			Operations();
			System.out.println();
			char input=scan.next().charAt(0);
			if(input=='e') {
				Operations();
			}
			else if(input=='c'){
				DeleteFile();
			}
			else {
				System.out.println("It's an invalid input..!");
				MenuPage();
			}
		}else {
			continue;
		}
	}
	if(count==0) {
		System.out.println("File not exists!(Note:Case sensitive)\n");
		char input=scan.next().charAt(0);
		if(input=='e') {
			Operations();
		}
		else if(input=='c'){
			DeleteFile();
		}
		else {
			System.out.println("It's an invalid input..!");
			MenuPage();
		}
	}
}
}
public void MainFile() {
	JavaFileHandlerApplication obj=new JavaFileHandlerApplication();
	obj.MenuPage();
}
public void SearchFile() {
	Scanner scan=new Scanner(System.in);
	System.out.println("Please enter File name you want to search");
	String input=scan.nextLine();
	File file=new File("C:\\Simplilearn\\Project1\\src\\Project1\\"+input);
	if(file.exists())
	{
		System.out.println("Yes, File Available..!\n");
		Operations();
		char check=scan.next().charAt(0);
		if(check=='e') {
			Operations();
		}
		else if(check=='c'){
			SearchFile();
		}
		else {
			System.out.println("Entered wrong input..!");
			MenuPage();
		}
	}
	else
	{
		System.out.println("No, File is not in the list..!");
		System.out.println();
		char check=scan.next().charAt(0);
		if(check=='e') {
			Operations();
		}
		else if(check=='c'){
			SearchFile();
		}
		else {
			System.out.println("invalid input!");
			MenuPage();
		}
	}
}
//main class
public static void main(String[] args) 
{
	try{
	JavaFileHandlerApplication obj=new JavaFileHandlerApplication();
	obj.WelcomePage();
	
Scanner scan=new Scanner(System.in);
obj.MenuPage();

	}
	catch(Exception e)
	{
		System.out.println("Exception in Main:"+e);
	}
}
}