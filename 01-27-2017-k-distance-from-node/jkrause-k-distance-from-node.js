// Run with node providing k, the distance from the tree to print, and the elements of the tree to be inserted from left to right
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
    getTreeRow: function(distanceFromRoot) {
        var row = [];
        if(this.root != null) {
            this.getNextTreeRow(this.root, row, 0, distanceFromRoot);    
        }
        return row;
    },
    getNextTreeRow: function(node, row, currentDepth, desiredDepth) {
        if(currentDepth == desiredDepth) {
            row.push(node.val);
        } else {
            if(node.l != null) {
                this.getNextTreeRow(node.l, row, currentDepth+1, desiredDepth);
            }
            if(node.r != null) {
                this.getNextTreeRow(node.r, row, currentDepth+1, desiredDepth);
            }
        }
    }
}

var args = process.argv.slice(2);
for(var i = 1; i < args.length; i++) {
    bst.insert(parseInt(args[i]));
}
console.log(bst.getTreeRow(parseInt(args[0])));
