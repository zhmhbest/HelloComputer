#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

void printArray(int arr[], int len)
{
    if (len > 0)
    {
        printf("[ %d", arr[0]);
        for (int i = 1; i < len; i++)
        {
            printf(", %d", arr[i]);
        }
        printf(" ]\n");
    }
}

int minKey(int arr[], int len, int i)
{
    int minKey = i;
    int minVal = arr[i];
    for (i++; i < len; i++)
    {
        if (arr[i] < minVal)
        {
            minKey = i;
            minVal = arr[i];
        }
    }
    return minKey;
}

void swapValue(int arr[], int i, int j)
{
    int dump = arr[i];
    arr[i] = arr[j];
    arr[j] = dump;
}


// #include "array.h"
// int main()
// {
//     int arr[] = {8, 5, 9, 4, 2, 1};
//     const int len = 6;
//     printArray(arr, len);
//     Sort(arr, len);
//     printArray(arr, len);
//     return 0;
// }