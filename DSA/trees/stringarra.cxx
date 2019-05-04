#include<iostream>
#include<string>
using namespace std;

int main(){
	string s[5],key;
	int i,j;
	for(i=0;i<5;i++)
	{
		cin>>s[i];
		if(i>0){
			key=s[i];
			j=i-1;
			while(j>=0 && (s[j].size()>key.size()))
			{
				s[j+1]=s[j];
				j--;
			}
			s[j+1]=key;
		}
	}		
	for(i=0;i<5;i++)
	cout<<s[i]<<" ";
	return 0;
}
