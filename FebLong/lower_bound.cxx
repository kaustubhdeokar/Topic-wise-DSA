#include <bits/stdc++.h>
typedef long long int li;

using namespace std;

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int maps[26] = {0};
		string s;
		cin>>s;
		int len = s.length();
		for(int i=0;i<len;i++){
			maps[s[i]-'A']++;
		}
		sort(maps,maps+26,greater<int>());
		for(int i=0;i<26;i++){
		cout<<maps[i];
		}
		cout<<endl;
		int bound=0,extra=0,ans=0;
		for(int counter=1;counter<=min(len,26);counter++){
			if(len%counter==0){
				bound=len/counter;
				
			}
		}
	}
	return 0;
}
