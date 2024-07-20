import java.util.*;
public class CourseWork
 {
	public static String[] id=new String[0];
	public static String[] name=new String[0];
	public static int[] pfm=new int[0];
	public static int[] dbms=new int[0];
	public static int[] sum=new int[0];
	public static double[] avg=new double[0];
	//+++++++++++++++++++++++++++++++++++++++
	public static void Home(){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Option Number > ");
		int op=input.nextInt();
		switch(op){
			case 1: 
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println("|\t\t\t\tADD NEW STUDENT\t\t\t\t\t\t|");
				System.out.println("-----------------------------------------------------------------------------------------");
				AddNewStudent();break;
			case 2:
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println("|\t\t\t\tADD NEW STUDENT WITH MARKS\t\t\t\t|");
				System.out.println("-----------------------------------------------------------------------------------------");
				AddNewStudentWithMarks();break;
			case 3: 
				System.out.println("---------------------------------------------------------------------------------");
				System.out.println("|\t\t\t\tADD MARKS\t\t\t\t\t|");
				System.out.println("---------------------------------------------------------------------------------");
				AddMarks();break;
			case 4:
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("|\t\t\t\tUPDATE STUDENT\t\t\t\t|");
				System.out.println("-------------------------------------------------------------------------");
				updateStudentDetail();break;
			case 5:
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("|\t\t\t\tUPDATE MARKS\t\t\t\t|");
			System.out.println("-------------------------------------------------------------------------");
			 UpdateMarks();break;
			case 6: 
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("|\t\t\t\tDELETE STUDENT\t\t\t\t|");
				System.out.println("-------------------------------------------------------------------------");
				DeleteStudent();break;
			case 7:
				System.out.println("---------------------------------------------------------------------------------");
				System.out.println("|\t\t\t\tPRINT STUDENT DETAILS\t\t\t\t|");
				System.out.println("---------------------------------------------------------------------------------");
				PrintStudentDetails();break;
			case 8:
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("|\t\t\t\tPRINT STUDENT RANK\t\t\t\t|");
			System.out.println("---------------------------------------------------------------------------------");
			 PrintStudentRank();break;
			case 9: 
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("|\t\t\tBEST IN DATABASE MANAGEMENT SYSTEM\t\t\t\t|");
			System.out.println("-----------------------------------------------------------------------------------------");
			BestInProgrammingFundamentals();break;
			case 10: 
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("|\t\t\t\tBEST IN PROGRAMMING FUNDAMENTALS\t\t\t|");
			System.out.println("-----------------------------------------------------------------------------------------");
			BestInDeatabaseManagementSystem();break;
		}
		
	}
	//+++++++++++++++++++++++++++++++++++++++++++++=
	public static int Search(String stId){
		for(int i=0;i<id.length;i++){
			if(stId.equalsIgnoreCase(id[i])){
				return i;
			}
		}
		return -1;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++
	public static void AddElementArr(){
		int size=id.length;
		String[] tempId=new String[size+1];
		String[] tempName=new String[size+1];
		int[] tempPfm=new int[size+1];
		int[] tempDbms=new int[size+1];
		int[] tempSum=new int[size+1];
		double[] tempAvg=new double[size+1];
		
		for (int i = 0; i < size; i++){
			tempId[i]=id[i];
			tempName[i]=name[i];
			tempPfm[i]=pfm[i];
			tempDbms[i]=dbms[i];
			tempSum[i]=sum[i];
			tempAvg[i]=avg[i];
		}
		id=tempId;
		name=tempName;
		pfm=tempPfm;
		dbms=tempDbms;
		sum=tempSum;
		avg=tempAvg;
	}
	//+++++++++++++++++++++++++++++++++++++++++
	public static void AddNewStudent(){
		
		Scanner input=new Scanner(System.in);
		boolean state=false;
		do{
				System.out.print("Enter Student ID: ");
				String stId=input.next();
				if(Search(stId)!=-1){
					System.out.println("The Student ID alredy exists!");
					continue;
				}
				System.out.print("Enter Student Name: ");
				String stName=input.next();
				AddElementArr();
				id[id.length-1]=stId;
				name[name.length-1]=stName;
				pfm[pfm.length-1]=-1;
				dbms[dbms.length-1]=-1;
				sum[sum.length-1]=-1;
				avg[avg.length-1]=-1;
				System.out.print("Student has been added successfully. Do you want to add a new student (Y/n): ");
				String yesNo=input.next();
				if(yesNo.equalsIgnoreCase("Y")){
					state=true;
				}
				else if(yesNo.equalsIgnoreCase("n")){
					Home();
				}
				
		}while(state);
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void AddNewStudentWithMarks(){
		
		Scanner input=new Scanner(System.in);
		boolean state=false;
		boolean stateP=false;
		boolean stateD=false;
		int stPfm;
		int stDbms;
		int stSum=0;
		double stAvg=0.0;
		do{
				System.out.print("Enter Student ID: ");
				String stId=input.next();
				if(Search(stId)!=-1){
					System.out.println("The Student ID alredy exists!");
					continue;
				}
				System.out.print("Enter Student Name: ");
				String stName=input.next();
				do{
					System.out.print("Programming Fundamentals Marks: ");
					stPfm=input.nextInt();
					if(stPfm>100 || stPfm<0){
						System.out.println("Invalid marks, please enter correct marks.");
						stateP=true;
					}else{
						stateP=false;
					}
				}while(stateP);
				do{
					System.out.print("Database Management System Marks: ");
					stDbms=input.nextInt();
					if(stDbms>100 || stDbms<0){
						System.out.println("Invalid marks, please enter correct marks.");
						stateD=true;
					}else{
						stateD=false;
					}
				}while(stateD);
				stSum=stPfm+stDbms;
				stAvg=(double)stSum/2;
				AddElementArr();
				sum[sum.length-1]=stSum;
				avg[avg.length-1]=stAvg;
				id[id.length-1]=stId;
				name[name.length-1]=stName;
				pfm[pfm.length-1]=stPfm;
				dbms[dbms.length-1]=stDbms;
				System.out.print("Student has been added successfully. Do you want to add a new student (Y/n): ");
				String yesNo=input.next();
				if(yesNo.equalsIgnoreCase("Y")){
					state=true;
				}
				else if(yesNo.equalsIgnoreCase("n")){
					Home();
				}	
		}while(state);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void AddMarks(){
		
		Scanner input=new Scanner(System.in);
		boolean state=false;
		boolean stateP=false;
		boolean stateD=false;
		int stPfm;
		int stDbms;
		int stSum=0;
		double stAvg=0.0;
		do{
			System.out.print("Enter Student ID: ");
			String stId=input.next();
				if(Search(stId)==-1){
					System.out.print("Invalid Student ID. Do you want to search again? (Y/n): ");
					String yn=input.next();
					if(yn.equalsIgnoreCase("Y")){
						AddMarks();
					}else if(yn.equalsIgnoreCase("n")){
						Home();
					}
				}else if(Search(stId)>-1){
					System.out.println("Student Name: "+name[Search(stId)]);	
				}
				
				if(pfm[Search(stId)]!=-1){
					System.out.println("This student's marks have been already added.\nIf you want to update the marks, please use [4] update Marks option");
					System.out.print("Do you want to add marks for another student?(Y/n): ");
					String yesNo=input.next();
					if(yesNo.equalsIgnoreCase("Y")){
						AddMarks();
					}
					else if(yesNo.equalsIgnoreCase("n")){
						Home();
						break;
					}	
				}
			do{
				System.out.print("Programming Fundamentals Marks: ");
				stPfm=input.nextInt();
				if(stPfm>100 || stPfm<0){
					System.out.println("Invalid marks, please enter correct marks.");
					stateP=true;
				}else{
					stateP=false;
				}
			}while(stateP);
			do{
				System.out.print("Database Management System Marks: ");
				stDbms=input.nextInt();
				if(stDbms>100 || stDbms<0){
					System.out.println("Invalid marks, please enter correct marks.");
					stateD=true;
				}else{
					stateD=false;
				}
			}while(stateD);
			stSum=stPfm+stDbms;
			stAvg=(double)stSum/2;
			AddElementArr();
			pfm[pfm.length-1]=stPfm;
			dbms[dbms.length-1]=stDbms;
			sum[sum.length-1]=stSum;
			avg[avg.length-1]=stAvg;
			System.out.print("Marks have been added. Do you want to add marks for another student?(Y/n): ");
			String yesNo=input.next();
			if(yesNo.equalsIgnoreCase("Y")){
				state=true;
			}
			else if(yesNo.equalsIgnoreCase("n")){
				Home();
			}	
		}while(state);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void DeleteStudent(){
		
		Scanner input=new Scanner(System.in);
		boolean state=false;
		do{
			System.out.print("Enter Student ID: ");
			String stId=input.next();
			int index=Search(stId);
			if(index==-1){
				System.out.print("Invalid ID. Do you want to search again? (Y/n): ");
				String yesNo=input.next();
				if(yesNo.equalsIgnoreCase("Y")){
					DeleteStudent();
				}else{
					Home();
					break;
				}
			}else{
				System.out.println(name[index]+"\t"+id[index]+"\t"+pfm[index]+"\t"+dbms[index]);
			}
			int size=id.length;
			for (int i = index; i <size-1; i++){
				id[i]=id[i+1];
				name[i]=name[i+1];
				pfm[i]=pfm[i+1];
				dbms[i]=dbms[i+1];
				sum[i]=sum[i+1];
				avg[i]=avg[i+1];
			}
			String[] tempId=new String[size-1];
			String[] tempName=new String[size-1];
			int[] tempPfm=new int[size-1];
			int[] tempDbms=new int[size-1];
			int[] tempSum=new int[size-1];
			double[] tempAvg=new double[size-1];
			for (int i = 0; i < size-1; i++)
			{
				tempId[i]=id[i];
				tempName[i]=name[i];
				tempPfm[i]=pfm[i];
				tempDbms[i]=dbms[i];
				tempSum[i]=sum[i];
				tempAvg[i]=avg[i];
			}
			id=tempId;
			name=tempName;
			pfm=tempPfm;
			dbms=tempDbms;
			sum=tempSum;
			avg=tempAvg;
			System.out.println("Student has been deleted successfully!");
			System.out.print("Do you want to delete another student?(Y/n): ");
			String yesNo=input.next();
			if(yesNo.equalsIgnoreCase("Y")){
				state=true;
			}
			else if(yesNo.equalsIgnoreCase("n")){
				Home();
			}	
		}while(state);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void updateStudentDetail(){
		
		Scanner input=new Scanner(System.in);
		boolean state=false;
		do{
				System.out.print("Enter Student ID: ");
				String stId=input.next();
				int size=Search(stId);
				if(size==-1){
					System.out.println("Please Enter Exists ID");
					continue;
				}else{
					System.out.println("Student Name: "+name[size]);
					System.out.print("Enter the new student name: ");
					name[size]=input.next();
				}
				System.out.println("Student detail has been updated successfully!");
				System.out.print("Do you want to update another student detail?(Y/n): ");
				String yesNo=input.next();
				if(yesNo.equalsIgnoreCase("Y")){
					state=true;
				}
				else if(yesNo.equalsIgnoreCase("n")){
					Home();
				}	
				
		}while(state);
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++=
	public static void UpdateMarks(){
		
		Scanner input=new Scanner(System.in);
		boolean state=false;
		boolean stateP=false;
		boolean stateD=false;
		do{
				System.out.print("Enter Student ID: ");
				String stId=input.next();
				int size=Search(stId);
				if(size==-1){
					System.out.println("Please Enter Exists ID");
					continue;
				}else{
					System.out.println("Student Name: "+name[size]);
					if(Search(stId)!=-1 && pfm[Search(stId)]==-1){
						System.out.println("This student's marks yet to be added");
						System.out.print("Do you want to update marks for another student detail?(Y/n): ");
						String yesNo=input.next();
						if(yesNo.equalsIgnoreCase("Y")){
							UpdateMarks();
						}
						else if(yesNo.equalsIgnoreCase("n")){
							Home();
				}	
					}
					System.out.println("Programming Fundamentals Marks: "+pfm[size]);
					System.out.println("Database Management System Marks "+dbms[size]);
					do{
						System.out.print("Enter the new Programming Fundamentals Marks: ");
						pfm[size]=input.nextInt();
						if(pfm[size]>100 || pfm[size]<0){
							System.out.println("Invalid marks, please enter correct marks.");
							stateP=true;
						}else{
							stateP=false;
						}
					}while(stateP);
					do{
						System.out.print("Enter the new Database Management System Marks: ");
						dbms[size]=input.nextInt();
						if(dbms[size]>100 || dbms[size]<0){
							System.out.println("Invalid marks, please enter correct marks.");
							stateD=true;
						}else{
							stateD=false;
						}
					}while(stateD);	
				}
				int stSum=pfm[size]+dbms[size];
				double stAvg=(double)stSum/2;
				sum[size]=stSum;
				avg[size]=stAvg;
				System.out.println("Marks have been updated successfully!");
				System.out.print("Do you want to update marks for another student detail?(Y/n): ");
				String yesNo=input.next();
				if(yesNo.equalsIgnoreCase("Y")){
					state=true;
				}
				else if(yesNo.equalsIgnoreCase("n")){
					Home();
				}	
		}while(state);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void PrintStudentDetails(){
		
		Scanner input=new Scanner(System.in);
		boolean state=false;
		String stId;
		do{
				System.out.print("Enter Student ID: ");
				stId=input.next();
				int size=Search(stId);
				if(size==-1){
					System.out.println("Please Enter Exists ID");
					continue;
				}else{
					System.out.println("Student Name: "+name[size]);
					if(pfm[size]==-1 || dbms[size]==-1){
						System.out.println("Marks yet to be added");
						System.out.print("Do you want to search another student details? (Y/n): ");
						String ys=input.next();
						if(ys.equalsIgnoreCase("Y")){
							PrintStudentDetails();	
						}else{
							Home();
							break;
						}
					}
					int[] tempStSum=new int[size];
					for (int i = 0; i < size; i++){
						tempStSum[i]=sum[i];
					}
					String index="";
					for (int i = 0; i<size-1; i++){
						for (int j= 0; j<size-i-1; j++){
							if(tempStSum[j]<tempStSum[j+1]){
								int tempSum=tempStSum[j];
								tempStSum[j]=tempStSum[j+1];
								tempStSum[j+1]=tempSum;
							}
						}	
					}
					for (int i = 0; i <size; i++)
					{
						if(i==0){
							index="1(First)";
						}
						else if(i==1){
							index="2(Second)";
						}
						else if(i==2){
							index="3(Third)";
						}
						else if(i==size-1){
							index="Last";
						}
					}
					
					System.out.println("Programming Fundamentals Marks:\t"+pfm[size]+"\nDatabase Management System Marks:\t"+dbms[size]+"\nTotal Marks:\t"+sum[size]+"\nAvg. Marks:\t"+avg[size]+"\nRank:\t"+index);	
				}
				System.out.print("Do you want to search  another student detail?(Y/n): ");
				String yesNo=input.next();
				if(yesNo.equalsIgnoreCase("Y")){
					state=true;
				}
				else if(yesNo.equalsIgnoreCase("n")){
					Home();
				}	
			}while(state);
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void PrintStudentRank(){
		
		Scanner input=new Scanner(System.in);
		boolean state=false;
		do{
			int size=sum.length;
			int[] tempStSum=new int[size];
			double[] tempStAvg=new double[size];
			String[] tempStId=new String[size];
			String[] tempStName=new String[size];
			for (int i = 0; i < size; i++){
				tempStId[i]=id[i];
				tempStName[i]=name[i];
				tempStAvg[i]=avg[i];
				tempStSum[i]=sum[i];
			}
			for (int i = 0; i<size-1; i++){
				for (int j= 0; j<size-i-1; j++){
					if(tempStSum[j]<tempStSum[j+1]){
						int tempSum=tempStSum[j];
						tempStSum[j]=tempStSum[j+1];
						tempStSum[j+1]=tempSum;
					
						double tempAvg=tempStAvg[j];
						tempStAvg[j]=tempStAvg[j+1];
						tempStAvg[j+1]=tempAvg;
					
						String tempId=tempStId[j];
						tempStId[j]=tempStId[j+1];
						tempStId[j+1]=tempId;
					
						String tempName=tempStName[j];
						tempStName[j]=tempStName[j+1];
						tempStName[j+1]=tempName;
					}
				}	
			}
			System.out.println("Rank\tId\tName\tTotal Marks\tAvg.Marks");
			for (int i = 0; i<size; i++){
				System.out.println((i+1)+"\t"+tempStId[i]+"\t"+tempStName[i]+"\t"+tempStSum[i]+"\t\t"+tempStAvg[i]);
			}
				System.out.print("Do you want to go back to main menu?(Y/n): ");
				String yesNo=input.next();
				if(yesNo.equalsIgnoreCase("Y")){
					state=true;
				}
				else if(yesNo.equalsIgnoreCase("n")){
					Home();
				}	
		}while(state);
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static void BestInProgrammingFundamentals(){
		
		Scanner input=new Scanner(System.in);
		boolean state=false;
		do{
			int size=pfm.length;
			String[] tempStId=new String[size];
			String[] tempStName=new String[size];
			int[] tempStPfm=new int[size];
			int[] tempStDbms=new int[size];
			for (int i = 0; i < size; i++){
				tempStId[i]=id[i];
				tempStName[i]=name[i];
				tempStPfm[i]=pfm[i];
				tempStDbms[i]=dbms[i];
			}
			for (int i = 0; i<size-1; i++){
				for (int j= 0; j<size-i-1; j++){
					if(tempStPfm[j]<tempStPfm[j+1]){
						int tempPfm=tempStPfm[j];
						tempStPfm[j]=tempStPfm[j+1];
						tempStPfm[j+1]=tempPfm;
					
						int tempDbms=tempStDbms[j];
						tempStDbms[j]=tempStDbms[j+1];
						tempStDbms[j+1]=tempDbms;
					
						String tempId=tempStId[j];
						tempStId[j]=tempStId[j+1];
						tempStId[j+1]=tempId;
					
						String tempName=tempStName[j];
						tempStName[j]=tempStName[j+1];
						tempStName[j+1]=tempName;
					}
				}	
			}
			System.out.println("Rank\tId\tName\tPF Marks\tDbms Marks");
			for (int i = 0; i<size; i++){
				System.out.println((i+1)+"\t"+tempStId[i]+"\t"+tempStName[i]+"\t\t"+tempStPfm[i]+"\t"+tempStDbms[i]);
			}
				System.out.print("Do you want to go back to main menu?(Y/n): ");
				String yesNo=input.next();
				if(yesNo.equalsIgnoreCase("Y")){
					state=true;
				}
				else if(yesNo.equalsIgnoreCase("n")){
					Home();
				}	
		}while(state);
	}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void BestInDeatabaseManagementSystem(){
		
		Scanner input=new Scanner(System.in);
		boolean state=false;
		do{
			int size=dbms.length;
			String[] tempStId=new String[size];
			String[] tempStName=new String[size];
			int[] tempStPfm=new int[size];
			int[] tempStDbms=new int[size];
			for (int i = 0; i < size; i++){
				tempStId[i]=id[i];
				tempStName[i]=name[i];
				tempStPfm[i]=pfm[i];
				tempStDbms[i]=dbms[i];
			}
			for (int i =0; i<size-i-1; i++){
				for (int j= 0; j<size-i-1; j++){
					if(tempStDbms[j]<tempStDbms[j+1]){
						int tempPfm=tempStPfm[j];
						tempStPfm[j]=tempStPfm[j+1];
						tempStPfm[j+1]=tempPfm;
					
						int tempDbms=tempStDbms[j];
						tempStDbms[j]=tempStDbms[j+1];
						tempStDbms[j+1]=tempDbms;
					
						String tempId=tempStId[j];
						tempStId[j]=tempStId[j+1];
						tempStId[j+1]=tempId;
					
						String tempName=tempStName[j];
						tempStName[j]=tempStName[j+1];
						tempStName[j+1]=tempName;
					}
				}	
			}
			System.out.println("Rank\tId\tName\tDbms Marks\tPF Marks");
			for (int i = 0; i<size; i++){
				System.out.println((i+1)+"\t"+tempStId[i]+"\t"+tempStName[i]+"\t\t"+tempStDbms[i]+"\t"+tempStPfm[i]);
			}
				System.out.print("Do you want to go back to main menu?(Y/n): ");
				String yesNo=input.next();
				if(yesNo.equalsIgnoreCase("Y")){
					state=true;
				}
				else if(yesNo.equalsIgnoreCase("n")){
					Home();
				}	
		}while(state);
	}
	
//+++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void main (String[] args){
		
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t\t|");
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("[1] Add New Student\t\t\t[2] Add New Student With Marks\n[3] Add Marks\t\t\t\t[4] Update Student Details\n[5] Update Marks\t\t\t[6] Delete Student\n[7] Print Student Detail\t\t[8] Print Student Ranks\n[9] Best in Programming Fundamentals\t[10] Best in Database Management System");
		System.out.println("");
		
		 Home();
		
	}
}

