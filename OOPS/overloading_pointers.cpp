#include<bits/stdc++.h>
#include<iostream>
using namespace std;

class Person{
	int a,b;
	public:
	Person(){
		a=0;
		b=0;
	}
		Person(int a,int b)
		{this->a=a;this->b=b;}
	Person& operator+(Person p){
		Person* temp=new Person();
		temp->a=p.a+a;
		temp->b=p.b+b;
		return *temp;
	}
	void display(){
		cout<<a<<" "<<b;
	}
};


int main(){
	int *a=new int;
	for(int i=0;i<5;i++)
	a=i
	return 0;
}

