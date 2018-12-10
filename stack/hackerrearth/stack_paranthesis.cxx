#include<iostream>
using namespace std;

int count=-1;

int type(char s){
	if(s=='('||s=='['||s=='{')
	return 1;
	else if(s==')'||s==']'||s=='}')
	return 2;
	else
	return 0;
}

void push(char stack[],char s)
{
		count+=1;
		cout<<"Cpush"<<count<<endl;
		stack[count]=s;
}
void pop(char stack[],char s)
{
	
	if((s==')' && stack[count]=='(')||(s==']' && stack[count]=='[')||(s=='}' && stack[count]=='{'))
	{
		if(count==-1)
		cout<<"NO";
		count-=1;
		cout<<"Cpop"<<count<<endl;
			
	}
	else
	count+=1;
}
void top()
{
	cout<<count;
}

int main(){
		string s;
		cin>>s;
		int i,len=s.size();
		for(i=0;i<len;i++)
		{
			char stack[1000]={0};
		    if(type(s[i])==1)
			{
		//		cout<<"Cpush"<<count<<endl;
			    push(stack,s[i]);
			}
		    else if(type(s[i])==2)
		    {
				pop(stack,s[i]);	
			}
			
		}
		if(count!=-1)
		cout<<"NO"<<endl;
		else
		cout<<"YES"<<endl;
		
return 0;
}	
