#include <iostream>
using namespace std;

//! Naive sort
void naiveSort(int arr[], int dim, int *iterations = nullptr)
{
    for (int i = 0; i < dim - 1; i++)
    {
        for (int j = i + 1; j < dim; j++)
        {
            if (arr[i] > arr[j])
            {
                if (iterations != nullptr)
                    (*iterations)++;
                swap(arr[j], arr[i]);
            }
        }
    }
}

//! Selection sort
void selectionSort(int arr[], int dim, int *iterations = nullptr)
{
    for (int i = 0; i < dim - 1; i++)
    {
        int min = INT_MAX;
        int index = i;
        for (int j = i; j < dim; j++)
        {
            if (arr[j] < min)
            {
                min = arr[j];
                index = j;
            }
        }
        if (iterations != nullptr)
            (*iterations)++;
        swap(arr[index], arr[i]);
    }
}

//! Bubble sort
void bubbleSort(int arr[], int dim, int *iterations = nullptr)
{
    bool sentinel = true;
    int j = 0;
    do
    {
        sentinel = false;
        for (int i = 0; i < dim - 1 - j; i++)
        {
            if (arr[i] > arr[i + 1])
            {
                if (iterations != nullptr)
                    (*iterations)++;
                swap(arr[i], arr[i + 1]);
                sentinel = true;
            }
        }
        j++;

    } while (j < (dim - 1) && sentinel);
}