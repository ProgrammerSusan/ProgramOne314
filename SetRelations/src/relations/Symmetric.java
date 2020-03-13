package relations;

import java.util.*;
import java.io.*;
import java.io.IOException;

public class Symmetric {
	public static void main(String[] args) throws IOException {
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
                			relationOne[counter][i/2] = Character.getNumericValue(line.charAt(i));
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
            		}
            		else {
            			for(int i = 0; i < line.length(); i+=2) {
                			relationTwo[counter][i/2] = Character.getNumericValue(line.charAt(i));
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
                			relationThree[counter][i/2] = Character.getNumericValue(line.charAt(i));
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
                			relationFour[counter][i/2] = Character.getNumericValue(line.charAt(i));
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
                			relationFive[counter][i/2] = Character.getNumericValue(line.charAt(i));
                		}
                		counter++;
                		line = relations.nextLine();
            		}
            	}
            	else {
            		for(int i = 0; i < line.length(); i+=2) {
            			relationSix[counter][i/2] = Character.getNumericValue(line.charAt(i));
            		}
            		line = relations.nextLine();
            		if(!relations.hasNextLine()) {
            			counter++;
            			for(int i = 0; i < line.length(); i+=2) {
                			relationSix[counter][i/2] = Character.getNumericValue(line.charAt(i));
                		}
            		}
            		else {
                    	counter++;
            		}
            	}
            }
            relations.close();
         }
         catch(Exception e){
            System.out.println("Problem Reading File" + e);
         }
        
        System.out.print(isSymmetric(relationThree));
		
	}
	
	public static Scanner relations = new Scanner(System.in);
	
	public static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static boolean isSymmetric(int [][] matrix) {
		int c = 1;
		for(int r = 0; r < matrix.length; r++) {
			for(c++; c < matrix.length; c++) {
				if(matrix[r][c] != matrix[c][r]) {
					return false;
				}
			}
		}
		return true;
	}
}
