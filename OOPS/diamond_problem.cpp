#include<iostream>
using namespace std;

class Animal{

    public:
        int age;
        void walk(){
            cout<<"animal walks"<<endl;
        }

};

class Lion:virtual public Animal{

};

class Tiger:virtual public Animal{

};

class Liger:public Lion,public Tiger{

};



int main(){

    Liger liger;
    liger.walk();
    return 0;
}
