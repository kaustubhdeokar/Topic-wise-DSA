#include <bits/stdc++.h> 
using namespace std; 
int digitSum(int n) { 
	int ans = 0; 
	while (n) { 
		ans=ans+(n % 10); 
		n=n/10; 
	} 
	return ans; 
} 

int findInt(int n, int m) { 
	int minDigit = floor(m/ 9); 
	int start = pow(10, minDigit) - 
				(int)pow(10, minDigit) % n; 
	while (start < INT_MAX) { 
		if (digitSum(start) == m) 
			return start; 
		else
			start += n; 
	} 
	return -1; 
} 

int main() 
{ 
	int t;
	cin>>t;
	while(t){
	int n;
	cin>>n;
	int m = 10; 
	cout << findInt(n, m); 
	t--;
	}
	return 0; 
} 
