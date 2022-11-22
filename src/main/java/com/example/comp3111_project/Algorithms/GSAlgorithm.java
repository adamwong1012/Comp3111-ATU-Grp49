package com.example.comp3111_project.Algorithms;

import java.util.*;


/* Java program for Gale Shapley Algorithm, Optimal Matching  */
public class GSAlgorithm { 
		  
		// Number of Teams & Students 
		private static int M = 33;
		private static int N = 100-33; 
		private static int S = N;
		
		
		// Note: m represents team_no ; n represents remaining_student_no ; s = len(longest_preference_list)
		public static void setNumbers(int m, int n, int s) { M = m; N = n; S = s; }
		  
		// This function returns true if student 's' prefers team 't_cur' over team 't' 
		private static boolean PrefersCurrrentOverNew(SortingEntity prefer[][], int s, int t, int t_cur) 
		{ 
		    // loop list of student s
		    for (int i = 0; i < M; i++) 
		    { 
		        // t_cur comes before t --> s prefers current more --> don't do anything 
		        if (prefer[S+s][i].getIndex() == t_cur) 
		            return true; 
		  
		        // t comes before t_cur --> s prefers new more --> free t_cur & engage t 
		        if (prefer[S+s][i].getIndex() == t) 
		        return false; 
		    }
		    return false;
		} 
		  
		// Function for optimal matching: teams, prefer[0..M][] ; students, prefer[N..2N-1][]
		public static void GS_Matching(SortingEntity prefer[][], Team teams[], SortingEntity student_entity[]) 
		{ 
			/*System.out.println("================================" + S);
			for (int i = 0; i < 2*S; i++) {
				for (int j = 0; j < S; j++) {
					if (prefer[i][j] != null) {
						System.out.print(prefer[i][j].getIndex() + " ");
					}
				}
				System.out.println();
			}
			System.out.println("================================");//*/
			
		    // students' team choice. if currently not exists, then null is stored
		    SortingEntity sChoice[] = new SortingEntity[N]; 
		  
		    // true = occupied ; false = available
		    boolean tFree[] = new boolean[M]; 
		  
		    // Initialisation
		    Arrays.fill(sChoice, null); 
		    int freeCount = M; 
		  
		    // While there are available teams 
		    while (freeCount > 0) 
		    { 
		    	boolean breakOutLoop = true;
		        for (int k = 0; k < N; k++) { 
		        	if (sChoice[k] == null) {
		        		breakOutLoop = false; 
		        		break;
		        	}
		        }
		        if (breakOutLoop) break;
		        // Choose teams in its given order
		        int t; // Note: t = index of Team = TeamID - 1
		        for (t = 0; t < M; t++) 
		            if (tFree[t] == false) 
		                break; 
		        if (t == M) break;
		  
		        // Go through s one by one according to t's preference
		        for (int i = 0; i < N && tFree[t] == false; i++) 
		        { 
		        	int s = prefer[t][i].getIndex();
		  
		            if (sChoice[s] == null) // If s is available, just choose he/she 
		            { 
		            	sChoice[s] = prefer[t][i]; 
		            	tFree[t] = true; 
		                freeCount--; 
		            } else // If s is not available 
		            { 
		                // Find current choice of s 
		                int t_cur = sChoice[s].getTeam().getID()-1; 
		  
		                // Check preference of s for cur_t against t
		                if (PrefersCurrrentOverNew(prefer, s, t, t_cur) == false) 
		                { 
		                	sChoice[s] = prefer[t][i]; 
		                	tFree[t] = true; 
		                	tFree[t_cur] = false; 
		                } 
		            }  
		        } // End of the for loop that goes through s's list
		    } // End of main while loop 
		  
			for (int i = 0; i < sChoice.length; i++) {
				// Note: index in sChoice == index in student_entity
				if (sChoice[i] != null) {
					sChoice[i].getTeam().addStudent(sChoice[i].getPerson());
					student_entity[i].setIndex(-1);
				}
			}
		}
		
} 
