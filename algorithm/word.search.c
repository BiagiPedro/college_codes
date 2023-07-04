/******************************************************************************
Pedro Biagi Dias 12221BSI200
*******************************************************************************/
#include <stdio.h>

int main()
{
    char str[100]={"abcdeaguafghiaguajklmaguanopqaguartsuvwxyz"}
    , str1[100]={"agua"};
    int i,j,cont,num,len = strlen(str),len1 = strlen(str1);
    cont =0;
    num =0;
    for(i=0 ; i<len ; i++){
            for(j=0 ; j<len1 ; j++){
                if(str[i+j] == str1[j]){
                    cont++;
                }
            }
            if(cont == len1){
            num++;
            }
    cont=0;
    }
    printf("%d", num);
}
