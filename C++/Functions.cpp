// https://www.hackerrank.com/challenges/c-tutorial-functions

#include <iostream>
#include <cstdio>
using namespace std;

int max_of_two(int a, int b){
    return a < b ? b:a;
}

int max_of_three(int a, int b, int c){
    return a < b ? max_of_two(b, c): max_of_two(a, c);
}

int max_of_four(int a, int b, int c, int d){
    return a < b ? max_of_three(b, c, d):max_of_three(a, c, d);
}


int main() {
    int a, b, c, d;
    scanf("%d %d %d %d", &a, &b, &c, &d);
    int ans = max_of_four(a, b, c, d);
    printf("%d", ans);
    
    return 0;
}

