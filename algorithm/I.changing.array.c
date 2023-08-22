/******************************************************************************

Pedro Biagi Dias 12221BSI200

*******************************************************************************/
int main()
{
    int cont,array[5] = {1,2,3,4,5},*ponteiro_of_array;
    
    while(cont>4 || cont<0){
        printf("Select the position of the number that you want change:\n");
        scanf("%d",&cont);
    }

    ponteiro_of_array=array + cont;

    printf("Write another number:\n");
    scanf("%d",ponteiro_of_array);


    for(int i=0 ; i<5 ; i++){
        printf("\n%d",array[i]);
    }


}
