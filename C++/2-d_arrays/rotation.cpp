#include <bits/stdc++.h> 
#define n 4 
using namespace std; 
void displayMatrix(int mat[n][n]); 
void rotateMatrix(int mat[][n]) 
{ 
	for (int x = 0; x < n / 2; x++) { 
		for (int y = x; y < n-x-1; y++) { 
			int temp = mat[x][y]; 
			mat[x][y]=mat[n-1-y][x];
			mat[n-1-y][x]=mat[n-1-x][n-1-y];
			mat[n-1-x][n-1-y]=mat[y][n-1-x];
			mat[y][n-1-x]=temp;
			
			
		} 
	} 
} 

void displayMatrix(int mat[n][n]) { 
	for (int i = 0; i < n; i++) { 
		for (int j = 0; j < n; j++) 
			printf("%2d ", mat[i][j]); 
		printf("\n"); 
	} 
	printf("\n"); 
} 

int main() 
{ 
	int mat[n][n] = 
	{ 
		{1, 2, 3, 4}, 
		{5, 6, 7, 8}, 
		{9, 10, 11, 12}, 
		{13, 14, 15, 16} 
	}; 
	rotateMatrix(mat); 
	displayMatrix(mat); 

	return 0; 
} 

