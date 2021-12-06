# include<stdio.h> 
#include<iostream>
using namespace std;
# define MAX_SIZE 100 

void _printParenthesis(int pos, int n, int open, int close); 

void printParenthesis(int n) 
{ 
	if(n > 0) 
		_printParenthesis(0, n, 0, 0); 
	return; 
}	 

void _printParenthesis(int pos, int n, int open, int close) 
{ 
	static char str[MAX_SIZE];	 
	
	if(close == n) 
	{ 
		cout<<str<<endl;
		return; 
	} 
	else
	{ 
		if(open > close) 
		{ 
			str[pos] = '}'; 
			_printParenthesis(pos+1, n, open, close+1); 
		} 
		
		if(open < n) 
		{ 
		str[pos] = '{'; 
		_printParenthesis(pos+1, n, open+1, close); 
		
		} 
	} 
} 

// Driver program to test above functions 
int main() 
{ 
	int n;
	cin>>n; 
	printParenthesis(n);
	return 0; 
} 
