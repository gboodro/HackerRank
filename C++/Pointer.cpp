// https://www.hackerrank.com/challenges/c-tutorial-pointer

#include <stdio.h>

void update(int *a,int *b) {
    int t = *a+*b;
    if(*b < *a) *b = *a-*b;
    else *b = *b-*a;
    *a = t;
}

int main() {
    int a, b;
    int *pa = &a, *pb = &b;
    
    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}
