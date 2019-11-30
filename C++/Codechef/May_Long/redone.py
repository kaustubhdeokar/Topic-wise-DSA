modulus=1000000007

def factorial(number):
    fact_arr=[0,1]
    for i in range(2,number+2):
        fact_arr.append(((fact_arr[i-1]*i)%modulus))
    return fact_arr

test_cases=int(input())
questions=[]
maximum=0
for i in range(test_cases):
    number=int(input())
    if(maximum<number):
        maximum=number
    questions.append(number)
ans=factorial(maximum)
for i in range(test_cases):
    print(ans[questions[i]+1]-1)
