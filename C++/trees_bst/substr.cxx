#include<iostream>
#include<string>
using namespace std;

int main(){
	string s;
	cin>>s;
	int l=s.size();
	string c=s.substr(1,l);
	while(1)
	{
		if(s[0]=='\0')
		break;
		else
		{
			cout<<s[0]<<" ";
			s=s.substr(1,l);
		}
	}
	return 0;
}
