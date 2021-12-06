#include<iostream>
using namespace std;

class Person{

public:

    string name;
    class Address{
        public:
            string country;
            string state;
            int houseno;
        void getaddr(string icountry,string istate,int ihouseno){
            country=icountry;
            state=istate;
            houseno=ihouseno;
        }
    };
    Address addr;
    Person(Address addr,string name){
            this->addr=addr;
            this->name=name;
    }
    void print(){
        cout<<addr.country<<name<<endl;
    } 
};



int main(){

    Person::Address ad;
    ad.getaddr("India","Maharashtra",10);
    Person p(ad,"kaustubh");
    p.print();
    return 0;
}
