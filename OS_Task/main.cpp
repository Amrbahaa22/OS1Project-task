#include <bits/stdc++.h>
using namespace std;


int main(int argc,string argv[])
{

    char command[50],name_user[50],GroupName[50];
    int choice;
    int check;

    while(1)
    {
        printf("-------------------------------");
        printf("\n| 1-for add user              |\n| 2-for delete user|\n| 3-for add group|\n| 4-for delete group|\n| 5-for changing user's info|\n| 6-to change password of user|\n| 7- to Assign User to a Group|\n| 0-to exit |\n");
        cin>>choice;
        switch(choice)
        {
        case 1:
            printf("\name of user you want to add:\n ");
            cin>>name_user;
            strcpy(command,"sudo adduser ");
            strcat(command,name_user);
            check=system(command);
            if (check==-1)
            {
                printf("\n please Check User name \n");
            }
            else
            {
                printf("\n done \n");
            }
            break;

        case 2:
            printf("\name of user you want to delete:\n ");
            cin>>name_user;
            strcpy(command,"sudo deluser ");
            strcat(command,name_user);
            check=system(command);
            if (check==-1)
            {
                printf("\n please Check User name \n");
            }
            else
            {
                printf("\n deleted successfully\n");
            }
            break;

        case 3:
            printf("name of group you want to add\n");
            cin>>GroupName;
            strcpy(command,"sudo groupadd ");
            strcat(command,GroupName);
            check=system(command);
            if(check==-1)
                printf("\n please Check group name \n");
            else
                printf("\n done \n");
            break;
        case 4:
            printf("Enter the name of group you want to delete\n");
            cin>>GroupName;
            strcpy(command,"sudo groupdel ");
            strcat(command,GroupName);
            check=system(command);
            if (check==-1)
            {
                printf("\n please Check group name\n");
            }
            else
            {
                printf("\n deleted successfully \n");
            }
            break;
            case 5:
            printf("\n name of user you want to update his info \n");
            cin>>name_user;
            strcpy(command,"chfn ");
            strcat(command,name_user);
            system(command);
            break;

            case 6:
            printf("\nname of the user you want to update his password\n");
            cin>>name_user;
            strcpy(command,"sudo passwd ");
            strcat(command,name_user);
            system(command);
            break;
            case 7:
            printf("\n name of group\n");
            cin>>GroupName;
            printf("\n name of user:\n ");
            cin>>name_user;
            strcpy(command,"sudo usermod -a -G ");
            strcat(command,GroupName);
            strcat(command," ");
            strcat(command,name_user);
            system(command);
            break;

          default:printf("\n Choose from the above options !\n");
                  break;
            case 0:
            return 0;
        }
    }


    return 0;
}
