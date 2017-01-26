// Run with node and provide the values to be inserted into the binary search tree
// A binary search tree with distinct values
var bst = {
    root: null,
    insert: function(item) {
        var node = { val: item, l: null, r: null };
        if(this.root == null) {
            this.root = node;
        } else {
            this.binaryInsert(this.root, node);
        }
    },
    binaryInsert: function(root, node) {
        if(node.val < root.val) {
            if(root.l == null) {
                root.l = node;
            } else {
                this.binaryInsert(root.l, node);
            }
        } else if(node.val > root.val) {
            if(root.r == null) {
                root.r = node;
            } else {
                this.binaryInsert(root.r, node);
            }
        }
    },
    getTreeRows: function() {
        var rows = [];
        if(this.root != null) {
            this.getNextTreeRow(this.root, rows, 0);    
        }
        return rows;
    },
    getNextTreeRow: function(node, rows, currentDepth) {
        if(rows.length <= currentDepth) {
            rows.push([]);
        }
        rows[currentDepth].push(node.val);
        if(node.l != null) {
            this.getNextTreeRow(node.l, rows, currentDepth+1);
        }
        if(node.r != null) {
            this.getNextTreeRow(node.r, rows, currentDepth+1);
        }
    }
}

var args = process.argv.slice(2);

for(var i = 0; i < args.length; i++) {
    bst.insert(parseInt(args[i]));
}

var p = [];

var visit = function(nextRight, nextLeft, currentList, permutations) {
    if(nextRight.length == 0 && nextLeft.length == 0) {
        permutations.push(currentList);
    } else {
        for(var i = 0; i < nextRight.length; i++) {
            var newNextRight = nextRight.slice(0);
            var chosenNextRight = newNextRight[i];
            newNextRight.splice(i, 1);
            var newCurrentList = currentList.slice(0);
            newCurrentList.push(chosenNextRight.val);
            if(chosenNextRight.r != null) {
                newNextRight.push(chosenNextRight.r);
            }
            if(chosenNextRight.l != null) {
                newNextRight.push(chosenNextRight.l);
            }
            visit(newNextRight, nextLeft, newCurrentList, permutations);
        }
        for(var i = 0; i < nextLeft.length; i++) {
            var newNextLeft = nextLeft.slice(0);
            var chosenNextLeft = newNextLeft[i];
            newNextLeft.splice(i, 1);
            var newCurrentList = currentList.slice(0);
            newCurrentList.push(chosenNextLeft.val);
            if(chosenNextLeft.r != null) {
                newNextLeft.push(chosenNextLeft.r);
            }
            if(chosenNextLeft.l != null) {
                newNextLeft.push(chosenNextLeft.l);
            }
            visit(nextRight, newNextLeft, newCurrentList, permutations);
        }
    }
}
visit((bst.root.r == null ? [] : [bst.root.r]), (bst.root.l == null ? [] : [bst.root.l]), [bst.root.val], p);
console.log(p);

// validation that this actually is correct
var initialRows = bst.getTreeRows();
for(var i = 0; i < p.length; i++) {
    var items = p[i];
    bst.root = null;
    for(var j = 0; j < items.length; j++) {
        bst.insert(items[j]);
    }
    var rows = bst.getTreeRows();
    for(var j = 0; j < rows.length; j++) {
        var row = rows[j];
        var validateRow = initialRows[j];
        for(var k = 0; k < row.length; k++) {
            if(row[k] != validateRow[k]) {
                throw "error";
            }
        }
    }
}
