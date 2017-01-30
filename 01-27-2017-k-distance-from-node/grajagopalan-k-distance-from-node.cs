    public class BTreeNode
    {
            public int Data { get; set; }
    
            public int Level { get; set; }
    
            public BTreeNode Left { get; set; }
    
            public BTreeNode Right { get; set; }
    }
    
    public class NodesAtKDistanceFromRootFinder
    {
        public static List<BTreeNode> Find(BTreeNode root, int k)
        {
            var nodesAtDistanceK = new List<BTreeNode>();

            if (root == null || k < 0)
            {
                return nodesAtDistanceK;
            }

            var queue = new Queue<BTreeNode>();
            root.Level = 0;
            queue.Enqueue(root);

            while (queue.Count > 0)
            {
                var current = queue.Dequeue();

                if (current.Level == k)
                {
                    nodesAtDistanceK.Add(current);
                }
                else if (current.Level > k)
                {
                    break;
                }

                if (current.Left != null)
                {
                    current.Left.Level = current.Level + 1;
                    queue.Enqueue(current.Left);
                }

                if (current.Right != null)
                {
                    current.Right.Level = current.Level + 1;
                    queue.Enqueue(current.Right);
                }
            }

            return nodesAtDistanceK;
        }
    }
    
    public class NodesAtKDistanceFromRootFinderTests
       {
           [TestFixture]
           public class FindTests
           {
               private BTreeNode _tree;
   
               [SetUp]
               public void TestSetup()
               {
                   _tree = new BTreeNode
                   {
                       Data = 1,
                       Left = new BTreeNode
                       {
                           Data = 2,
                           Left = new BTreeNode() { Data = 4 },
                           Right = new BTreeNode() { Data = 5 }
                       },
                       Right = new BTreeNode
                       {
                           Data = 3,
                           Left = new BTreeNode() { Data = 8 }
                       }
                   };
               }
   
               [Test]
               public void PositiveCases()
               {
                   var distance0 = NodesAtKDistanceFromRootFinder.Find(_tree, 0);
                   Assert.AreEqual(1, distance0.Count);
                   Assert.AreEqual(1, distance0[0].Data);
   
                   var distance1 = NodesAtKDistanceFromRootFinder.Find(_tree, 1);
                   Assert.AreEqual(2, distance1.Count);
                   Assert.AreEqual(2, distance1[0].Data);
                   Assert.AreEqual(3, distance1[1].Data);
   
                   var distance2 = NodesAtKDistanceFromRootFinder.Find(_tree, 2);
                   Assert.AreEqual(3, distance2.Count);
                   Assert.AreEqual(4, distance2[0].Data);
                   Assert.AreEqual(5, distance2[1].Data);
                   Assert.AreEqual(8, distance2[2].Data);
               }
   
               [Test]
               public void ErrorCases()
               {
                   var distanceNegative = NodesAtKDistanceFromRootFinder.Find(_tree, -1);
                   Assert.AreEqual(0, distanceNegative.Count);
   
                   BTreeNode nullTree = null;
                   var distanceNull = NodesAtKDistanceFromRootFinder.Find(nullTree, 2);
                   Assert.AreEqual(0, distanceNull.Count);
               }
   
           }
    }