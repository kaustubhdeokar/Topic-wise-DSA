//
//  artbalan.cpp
//  problems
//
//  February challenge 2019 Div 2
//  Created by Prakhar Malhotra on 2/3/19.
//  Copyright © 2019 Prakhar Malhotra. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

const int DEBUG_ARTBALAN = 0;

int get_max_ops(std::vector<int> &distribution,int average, int variable_count){
    auto lower_bound_average = std::lower_bound(distribution.begin(),distribution.end(),average);
    auto max_ops = 0;
    
    if (variable_count < distribution.size()){
        for(std::size_t i=0; i<(distribution.size() - variable_count); i++){
            max_ops += distribution[i];
        }
    }
    
    while(lower_bound_average < distribution.end()){
        max_ops += *lower_bound_average - average;
        lower_bound_average++;
    }
    
    return max_ops;
}

int main(int argc, const char* argv[]){
    int T;
    std::cin >> T;
    std::cin.ignore();
    
    std::string test_string;
    while(T){
        std::map<char,int> string_character_distribution;
        std::getline(std::cin,test_string);
        auto string_character_count = test_string.size();
        
        for(auto &i:test_string){
            string_character_distribution[i]++;
        }
        
        //distribution in sorted order.
        std::vector<int> given_distribution;
        for(auto it=string_character_distribution.begin(); it!= string_character_distribution.end(); it++){
            given_distribution.push_back(it->second);
        }
        
        std::sort(given_distribution.begin(),given_distribution.end());
        auto max_ops = string_character_count - given_distribution.back();
        
        if(DEBUG_ARTBALAN){
            //print distribution
            for(auto &i: given_distribution){
                std::cout << i << " ";
            }
            std::cout << std::endl;
        }
        
        //increase variable count
        for(auto variable_count = 2;variable_count<=26;variable_count++){
            if(string_character_count%variable_count == 0){
                auto average = string_character_count/variable_count;
                auto max_ops_for_vc = get_max_ops(given_distribution, average, variable_count);
                
                if(DEBUG_ARTBALAN){
                    std::cout << "VC = " << variable_count << " " << max_ops_for_vc << " " << max_ops << std::endl;
                }
                
                if(max_ops_for_vc <= max_ops){
                    max_ops = max_ops_for_vc;
                }
                else{
                    break;
                }
            }
        }
        
        std::cout << max_ops << std::endl;
        T--;
    }
    return 0;
}