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
        
        isEquivalenceRelation(relationOne);
        isEquivalenceRelation(relationTwo);
        isEquivalenceRelation(relationThree);
        isEquivalenceRelation(relationFour);
        isEquivalenceRelation(relationFive);
        isEquivalenceRelation(relationSix);
        
		
	}
	
	public static Scanner relations = new Scanner(System.in);
	public static  ArrayList<Integer>[] pairs = new ArrayList[8];
	
	public static void printMatrix(int[][] matrix){
		for (int i = 0; i < 8; i++) { 
	        pairs[i] = new ArrayList<Integer>(); 
	    } 
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < 8; j++) {
				if(matrix[i][j] == 1) {
					int n = 0;
					while(n < 8) {
						if(pairs[n].size() == 0 && i == j) {
							pairs[n].add(i);
							n = 9;
						}
						else if(pairs[n].size() == 0 && i != j) {
							pairs[n].add(i);
							pairs[n].add(j);
							n = 9;
						}
						else if(pairs[n].contains(i) && !pairs[n].contains(j)) {
							pairs[n].add(j);
							n = 9;
						}
						else if(pairs[n].contains(j) && !pairs[n].contains(i)) {
							pairs[n].add(i);
							n = 9;
						}
						else if(pairs[n].contains(i) || pairs[n].contains(j)) {
							n = 8;
						}
						else {
							n++;
						}
					}
				}
				System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	
	public static boolean checkSymmetric(int [][] matrix) {
		int c = 1;
		for(int r = 0; r < matrix.length; r++) {
			for(c++; c < matrix.length; c++) {
				if(matrix[r][c] != matrix[c][r]) {
					System.out.println("is not symmetric because ("+ r +", "+ c +") and ("+ c +", "+ r +") are not related");
					return false;
				}
			}
		}
		System.out.println("is symmetric");
		return true;
	}
	
	public static boolean checkAntiSymmetric(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if(i != j) {
					if(matrix[i][j] == 1) {
						if(matrix[j][i] == 1) {
							System.out.println("is not antisymmetric because both ("+i+", "+j
									+ ") and ("+j+", "+i+") are in the set.");
							return false;
						}
					}
				}
			}
		}
		System.out.println("is antisymmetric");
		return true;
	}
	
	public static boolean checkReflexive(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][i] != 1) {
				System.out.println("is not reflexive because ("+i+", "+i+") is not in the set.");
				return false;
			}
		}
		System.out.println("is reflexive.");
		return true;
	}
	
	public static int[][] fogMatrix(int[][] matrix) {
		int[][] returnVal = new int[matrix.length][matrix.length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				for(int k = 0; k < matrix.length; k++) {
					if(matrix[i][k] == 1 && matrix[k][j] == 1) {
						returnVal[i][j] = 1;
					}
				}
			}
		}
		
		return returnVal;
	}
    
	public static boolean checkTransitive(int[][] matrix) {
		int[][] compareMatrix = fogMatrix(matrix);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if((compareMatrix[i][j] == 1) && (matrix[i][j] == 0)) {
					System.out.println("is not transitive");
					return false;
				}
			}
		}
		System.out.println("is transitive");
		return true;
	}
        	
    public static void isEquivalenceRelation(int[][] matrix) {
    	System.out.println("The matrix: ");
    	System.out.println();
    	printMatrix(matrix);

    	boolean symmetric, antisymmetric, reflexive, transitive;
    	symmetric = checkSymmetric(matrix);
    	antisymmetric = checkAntiSymmetric(matrix);
    	reflexive = checkReflexive(matrix);
    	transitive = checkTransitive(matrix);
    	
    	if(symmetric && reflexive && transitive) {
    		System.out.println("is an equivalence relation");
    		System.out.println();
    		System.out.println("The equivalence classes are: ");
    		System.out.print("[ ");
    		for(int i = 0; i < pairs.length; i++) {
    			if(pairs[i].size() != 0) {
        			System.out.print(pairs[i].toString() + " ");
        		}
    		}
    		System.out.println("] ");
    		
    	} 
    	else {
    		System.out.println("is not an equivalence relation");
    		System.out.println();
    	}
    }
}
