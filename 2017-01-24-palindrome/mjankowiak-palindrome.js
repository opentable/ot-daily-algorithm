function linkedListFromAnArray(array) {
    const list = {};
    let currentElement = list;

    for(var element of array) {
        currentElement.value = element;
        currentElement.next = {};
        currentElement = currentElement.next;
    }

    return list;
}

function reverseLinkedList(linkedList) {
    let reversedLinkedList = {
        value: linkedList.value,
        next: {}
    };

    while((linkedList = linkedList.next)) {
        if(linkedList.value) {
            let currentElement = {
                value: linkedList.value,
                next: reversedLinkedList
            };
            reversedLinkedList = currentElement;
        }
    }

    return reversedLinkedList;
}

function isPalindrome(linkedList) {
    let reversedLinkedList = reverseLinkedList(linkedList);

    while(linkedList){
        if(reversedLinkedList.value !== linkedList.value) {
            return false;
        }
        reversedLinkedList = reversedLinkedList.next;
        linkedList = linkedList.next;
    }

    return true;
}

console.log(`isPalindrome(linkedListFromAnArray([1, 2, 3])) -> '${isPalindrome(linkedListFromAnArray([1, 2, 3]))}'`);     // isPalindrome(linkedListFromAnArray([1, 2, 3])) -> 'false'
console.log(`isPalindrome(linkedListFromAnArray([1, 2, 3, 2, 1])) -> '${isPalindrome(linkedListFromAnArray([1, 2, 3, 2, 1]))}'`);     // isPalindrome(linkedListFromAnArray([1, 2, 3, 2, 1])) -> 'true'