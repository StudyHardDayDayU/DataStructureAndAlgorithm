# 选择排序

十大经典排序算法之一

## 思路

从数组第一个数开始，找出后面最小的数，放到开头位置。

例如，当前从第一个数开始，那么从第二个数到最后一个数中间找到最小的那个数，让这个数和第一个数进行交换；再从第二个数开始，找到第三和最后一个数中的最小的数，让这个数和第二个进行交换，以此类推。

当然，首先要假设当前这个数比后面所有的数都小，把这个数作为初始数。

优化方案为，如果后面的数没有比当前开头数小的，则不进行交换。性能优化很大。

此排序算法处理大量随机数据时，性能大大优于冒泡排序。