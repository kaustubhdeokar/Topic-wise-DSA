#include<iostream>
using namespace std;


void function(){
    class Person{
        public:
        int age;
        void getage(int age){
            this->age=age;
        }
        void showage(){
            cout<<age;
        }
    };

    Person p;
    p.getage(10);
    p.showage();
}

int main(){

    function();
    return 0;
}
