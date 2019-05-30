#include<iostream>
using namespace std;


class Complex{

    float real,imag;
    public:
        Complex(){
            real=0;
            imag=0;
        }
        Complex(float a,float b){
            real=a;
            imag=b;
        }
        void show(){
            cout<<this->real<<" "<<this->imag;
        }

        Complex operator+(Complex c){
            Complex temp;
            temp.real=real+c.real;
            temp.imag=imag+c.imag;
            return temp;
        }
};

int main(){

    Complex c1(10,3);
    Complex c2(120,21);
    Complex c3=c1+c2;
    c3.show();
    return 0;
}
