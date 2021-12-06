//this is a program for minimum deletions to make two string anagrams.
#include<bits/stdc++.h>
using namespace std;
#define max(a,b) ((a>b)?a:b)
#define alphabets 26

int difference(int dict1[],int dict2[]){
	int diff=0;
	for(int i=0;i<alphabets;i++)
	diff+=abs(dict1[i]-dict2[i]);
	return diff;
}

int anagrams(string s1,string s2){
	
	int dict1[alphabets]={0};
	int dict2[alphabets]={0};
	for(int i=0;i<s1.length();i++)
		dict1[s1[i]-'a']+=1;
	for(int i=0;i<s2.length();i++)
		dict2[s2[i]-'a']+=1;
	
	return difference(dict1,dict2);

}

int main(){
	int t;
	cin>>t;
	while(t--){
		string s1,s2;
		cin>>s1>>s2;
		cout<<anagrams(s1,s2);
	}
	return 0;
}


