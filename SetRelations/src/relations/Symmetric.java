package relations;

import java.util.*;
import java.io.*;
import java.io.IOException;

public class Symmetric {
	public static void main(String[] args) throws IOException {
		String file = "";
		boolean relation1 = true;
		boolean relation2 = false;
		boolean relation3 = false;
		boolean relation4 = false;
		boolean relation5 = false;
		int counter = 0; 
		int [][] relationOne = new int[8][8];
        int [][] relationTwo = new int[8][8];
        int [][] relationThree = new int[8][8];
        int [][] relationFour = new int[8][8];
        int [][] relationFive= new int[8][8];
        int [][] relationSix = new int[8][8];
        String line;
        
        try{
            relations = new Scanner(new FileInputStream("C:\\Users\\Mahdi\\Desktop\\ProgramOne314\\Reldata.txt"));
            line = relations.nextLine();
            line = line.trim();
            while(relations.hasNextLine()) {
            	if(line.isEmpty()) {
                	line = relations.nextLine();
            	}
            	else if(line.charAt(0) == 'R') {
            		line = relations.nextLine();
            	}
            	else if(relation1) {
            		if(counter == 8) {
            			relation1 = false;
            			relation2 = true;
            			counter = 0;
            		}
            		else {
            			for(int i = 0; i < line.length(); i+=2) {
                			relationOne[counter][i/2] = 							Character.getNumericValue(line.charAt(i));
                		}
                		counter++;
                		line = relations.nextLine();
            		}
            	}
            	else if(relation2) {
            		if(counter == 8) {
            			relation2 = false;
            			relation3 = true;
            			counter = 0;
            			line = relations.nextLine();
            		}
            		else {
            			for(int i = 0; i < line.length(); i+=2) {
                			relationTwo[counter][i/2] = 							Character.getNumericValue(line.charAt(i));
                		}
                		counter++;
                		line = relations.nextLine();
            		}
            	}
            	else if(relation3) {
            		if(counter == 8) {
            			relation3 = false;
            			relation4 = true;
            			counter = 0;
            		}
            		else {
            			for(int i = 0; i < line.length(); i+=2) {
                			relationThree[counter][i/2] = 							Character.getNumericValue(line.charAt(i));
                		}
                		counter++;
                		line = relations.nextLine();
            		}
            	}
            	else if(relation4) {
            		if(counter == 8) {
            			relation4 = false;
            			relation5 = true;
            			counter = 0;
            		}
            		else {
            			for(int i = 0; i < line.length(); i+=2) {
                			relationFour[counter][i/2] = 							Character.getNumericValue(line.charAt(i));
                		}
                		counter++;
                		line = relations.nextLine();
            		}
            	}
            	else if(relation5) {
            		if(counter == 8) {
            			relation5 = false;
            			counter = 0;
            		}
            		else {
            			for(int i = 0; i < line.length(); i+=2) {
                			relationFive[counter][i/2] = 							Character.getNumericValue(line.charAt(i));
                		}
                		counter++;
                		line = relations.nextLine();
            		}
            	}
            	else {
            		if(counter == 8) {
            			line = relations.nextLine();
            		}
            		else {
            			for(int i = 0; i < line.length(); i+=2) {
                			relationSix[counter][i/2] = 							Character.getNumericValue(line.charAt(i));
                		}
                		counter++;
                		line = relations.nextLine();
            		}
            	}
            }
            relations.close();
         }
         catch(Exception e){
            System.out.println("Problem Reading File" + e);
         }
        
        for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(relationTwo[i][j] + " ");
			}
			System.out.println();
		}
       
		
	}
	
	public static Scanner relations = new Scanner(System.in);
	
//	private static int[][] getMatrix(String[] s, int[] indexes, int index){
//		int [][] relationMatrix = new int[8][8];
//		for(int i = 0; i < 8; i++) {
//			for(int j = 0; j < 8; j++) {
//				relationMatrix[i][j] = s[index + 1].charAt(j) + " ";
//			}
//		}
//		return relationMatrix;
//	}
}
