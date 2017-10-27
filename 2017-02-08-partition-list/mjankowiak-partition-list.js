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

function linkedListToString(linkedList) {
    let list = `${linkedList.value}`;
    while((linkedList = linkedList.next)) {
        if(linkedList.value)
            list += '->' + linkedList.value;
    }

    return list;
}

function partitionList(linkedList, x) {
    let originalBeginning = linkedList;
    let greaterThanOrEqualX = {};
    let currentElement = greaterThanOrEqualX;

    while(linkedList.value) {
        if(linkedList.value >= x) {
            currentElement.value = linkedList.value;
            currentElement.next = {};
            currentElement = currentElement.next;

            if(linkedList.next){
                linkedList.value = linkedList.next.value;
                linkedList.next = linkedList.next.next;
            }
        } else {
            linkedList = linkedList.next
        }
    }
    linkedList.value = greaterThanOrEqualX.value;
    linkedList.next = greaterThanOrEqualX.next;

    return linkedListToString(originalBeginning);
}

console.log(`partitionList(linkedListFromAnArray([1,4,3,2,5,2]), 3) -> '${partitionList(linkedListFromAnArray([1,4,3,2,5,2]), 3)}'`);     // partitionList(linkedListFromAnArray([1,2,2,4,3,5]), 3) -> '1->2->2->4->3->5'
console.log(`partitionList(linkedListFromAnArray([1,4,3,2,5,2]), 4) -> '${partitionList(linkedListFromAnArray([1,4,3,2,5,2]), 4)}'`);     // partitionList(linkedListFromAnArray([1,2,2,4,3,5]), 4) -> '1->3->2->2->4->5'