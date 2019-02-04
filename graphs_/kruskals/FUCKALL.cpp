#include <stdio.h>
#include <iostream>

long int gcd(long int a, long int b) {
    return b == 0 ? a : gcd(b, a % b);
}

int main(int argc, const char* argv[]){
    uint64_t T,N,A,B,K;
    
    std::cin >> T;
    
    while(T){
        std::cin >> N >> A >> B >> K;
        auto lcm = A * (B/gcd(A, B));
        
        auto problems_divisible_by_A = N/A;
        auto problems_divisible_by_B = N/B;
        auto problems_divisible_by_both = N/lcm;
        
        auto problems_solved_combined_under_restrictions = problems_divisible_by_A + problems_divisible_by_B - 2 * problems_divisible_by_both;
//        std::cout << problems_divisible_by_A << " " << problems_divisible_by_B << " " << problems_divisible_by_both << std::endl;
//        std::cout << problems_solved_combined_under_restrictions << std::endl;
//
        if(problems_solved_combined_under_restrictions >= K){
            std::cout << "Win" << std::endl;
        }
        else{
            std::cout << "Lose" << std::endl;
        }
        
        T--;
    }
}
