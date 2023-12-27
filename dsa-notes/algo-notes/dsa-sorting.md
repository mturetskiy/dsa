# Insertion Sort
- The idea: move current element to the its position, to the left direction.
- During implementation it is important to not iterate over all **already sorted** elements (left part)
- It is faster (2x times) than SelectionSort but does a lot more swaps.

# Selection Sort
## raw array impl
- The idea: find **min element** from the rest of the array and swap with current position.
- No extra memory is required.
- It is slow because it does a lot of iterations.
- It does no more than N swaps, which sometimes is good.
## ArrayList impl
- The idea: find min from the array list and add it to the new array. Found min value is removed from original array.
- Extra memory for N elements is required
- It should be not efficient due to remove() from original array list (to be verified), but it is faster due to that for some reason (figure out why).
- Does not perform swaps (it has different logic)

Note: It is possible to implement selection sort on ArrayList the same way as we do for raw array (with swaps, etc) but it will be 2x times slower then.
# Merge Sort
# Heap Sort
# Bubble Sort
# Quick Sort
 - The idea: find (& make) a pivot - some element that is already in the final place of the sorted array - so all elements at left side are lower or equal, 
and all elements at right side are greater or equal. (Perhaps one of 'or equal' needs to be more strict). 
To do that we select last element (one of possible approaches) and perform some permutations. There are different approaches for this:
   - Basic (most widely used): when we have lastHighElement & current pointers, and starting from the left move to the right, and swap elements until
   everything is placed properly **around** our selected pivot element (last one).
   - Lafore: This approach is described in Lafore's algo book and it is based on left & right pointers that we move towards to each other, swapping
   left and right elements when left > right. At the end in the point where they intersect (left & right point to the same index) - we swap it with our 
   pivot (last one), effectively putting it to the right place.
 - The pivot is used to split array into two parts that can be sorted independently. This allows us to use recursion or parallelize the process.
 - The more we lucky with pivot (its computed place is closer to the middle of our array) - the more faster we go. Ideally, the complexity will be O(n Log n)
and recursion depths will be Log N. But in worst case it is possible  (e.g. **already sorted array**) the complexity will be O(nˆ2) - in that case recursion 
won't work for big arrays.

## Multi-threaded version


