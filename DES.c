#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main()
{
    int i,ch,lp=1;
    char cipher[50],plain[50];
    char key[50];

    while(1)
    {
        printf("\n-----------MENU-------\n");
        printf("\n 1.Data Encryption \n 2.Data Decryption\n 3.EXIT \n");
        scanf("%d",&ch);
        
        switch(ch)
        {
            case 1:  
                    printf("\n Data Encryption");
                    printf("\n Enter the plain text:");
                    //fflush(stdin);
                    //fgets(plain,50,stdin);
                    scanf("%s", plain);
                    printf("\n Enter the Encryption key:");
                    //fgets(key,50,stdin);
                    scanf("%s", key);
                    lp=strlen(key);
                    for(i=0;plain[i]!='\0';i++)
                        cipher[i]=plain[i]^lp;
                    printf("The Encrypted text :");
                    puts(cipher);
                    break;
            case 2:
                    printf("\n Data Decryption");
                    for(i=0;i<cipher[i]!='\0';i++)
                        plain[i]=cipher[i]^lp;
                    printf("\n Decrypted text is:");
                    puts(plain);
                    break;
            case 3:
                    exit(0); 
            default:
                    printf("Enter a correct choice");
        }

    }
    return 0;
}
