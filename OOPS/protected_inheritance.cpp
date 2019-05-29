#include<iostream>
using namespace std;

class Person{
    protected:
        int id;
    public:
        int age;
        string name;
        Person(string iname,int iage,int iid){
            this->name=iname;
            this->id=iid;
            this->age=iage;
        }
};

class Boy:private Person{
    public:
        string gender;
        Boy(string igender,string iname,int iage,int iid):Person(iname,iage,iid)
        {
            this->gender=igender;
        }
        void display(){
            cout<<name;
            cout<<age;
            cout<<gender;
            cout<<id;
        }
};

int main(){

    Person p1("kaustubh",21,100);
    Boy b1("male","kaustubh",21,100);
    b1.display();
    //we cannot access the id by Boy's object b1. as it behaves protected and can only be 
    //accessed inside the class Boy if want to assign value.
    return 0;
}
