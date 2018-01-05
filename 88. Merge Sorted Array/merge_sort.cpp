#include <limits>
// p <= q < r
// 子数组A[p..q] 和 A[q..r]已排好序
// 利用归并技术将数组排序
// 有哨兵
// 算法导论版本
void merge(int *A, int p, int q, int r)
{
    //申请辅助数组,存放两子数组
    //数组的空间比原来的空间 多1 ，用于存放哨兵元素
    int n1 = q - p + 2;
    int n2 = r - q + 1;
    int left[n1],right[n2];
    int i,j;
    for (i = 0; i < q - p + 1; i++)
    {
        left[i] = A[p + i];
    }
    for (j = 0; j < r - q; j++)
    {
        right[j] = A[q + j + 1];
    }
    //哨兵元素
    left[i] = std::numeric_limits<int>::max();
    right[j] = std::numeric_limits<int>::max();
    for (int k = p,i = 0,j = 0; k <= r; k++ )
    {
        if (left[i] <= right[j])
        {
            A[k] = left[i++]; 
        }else{
            A[k] = right[j++];
        }
    }
}
void merge_sort(int *A,int p, int r)
{
    if (p < r)
    {
        int q = (p + r) / 2;
        merge_sort(A, p, q);
        merge_sort(A,q+1,r);
        merge(A, p, q, r);
    }
}
