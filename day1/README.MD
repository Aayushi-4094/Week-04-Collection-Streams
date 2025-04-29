COLLECTIONS
List when we want in ordered collection and want the duplicates
ArrayList and LinkedList both support or extends List interface alongwith vector and stack 

1) ArrayList - worst for adding and removing best for traversing 
uses array as its underlying structure that is behind the scenes uses array to store the values. Now arrays have superfast random access to element in constant amount
Internal working - it creates a new array and copies the elemeny to the new array. It is implemented as an array of objectReferences. When yopu create an arrayList , it has an initial capacity (default is 10). The capacity refers to the size of the internal array that can hold elements before needing to resize. whereas size is the size of the ArrayList. 
So while adding a new element the arraylist checks if there is enough space in the internal array . if it is full, it needs to be resized. if the internal array is full the arraylist will create a new array with a larger capacity and copy the elements from the old array to the new array which is an O(n) operation, where n is the number of elements in the arraylist. The new element is then added to the internal array at the appropriate index, and the size is incremented.
SO while deleting the array - The arrayList first checks if the index is within the valid range. The element is removed and all elements to the right of the removed element are shifted one position to the left to fill the gap and the  size is decremented by 1.
if you define the size in ArrayList<Integer> list = new ArrayList<>(1000)//then initaial capacity or the size of the internal array is 1000 not that of the list. NOTE- we cannot print the capacity of the internal array if we want to then we use reflections for it.
when using List<String> list 1  = Arrays.asList("Monday", "tuesday"); we cannot do list1.add("Wednesday"); because it returns a fixed sized list as it is array so we can only replace the elements therefore list1.set(1, "Wednesday") as asList  returns a fixed sized list another example is list.of(1,2,3,4) so it also unmodifible the size we cannot replce here as we were able to do it in the asList. then list.addAll(list1) is used to add one list to another. using .remove only removes the object so when in the list we have [1,2,3,4] and you want to remove 1 then list.remove(1) will remove 2 not 1 so to remove 1 we use list.remove(Integer.valueOf(1))//basically we need the object therefore need a class

a).add() for adding, //can have index and values like add(3, "aayushi) or just the string ("Aayushi) is slower than linkedlist as it have to create a new whole array at the backned 
b) to get an element at a given index use - get(index)
c) list.size() to get the size of the arryalist or linkedlist
d) list.contains()//list.contains(5) //to check the existence
e) list.remove()//to delete any element like list.remove(5) ///if 2 times available then removes or delete the last refernce
f) list.set(index, value)//here it replaves the previous value at the same index





2)LinkedList - it is a doubly linked list - worst for traversing best for adding and removing
stores elements as nodes in a doubly linked list

Insertions and deletions for it the linkedlist are better as it does not require shifting of the lements as in arraylist

Random Access is slower because of (get(int index)) and has to traverse the list from the start to that element or desired index
Linkedlist requires more memeory than ArrayList because each node in a linkedlist requires extra memeory to store references to the next and previous nodes.
we have addFirst and have addLast(), getFirst() and getLast()
a) .add for adding ,//can have index and values like add(3, "aayushi) or just the string ("Aayushi) as it just adds a node at a index
b) to get an element at a given index use - get(index)  { this operation is slow for linked list as uses head and tails pointers}




3) COMPARATOR - is the interface through which we can do custom ordering or sorting 
+