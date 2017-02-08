data BST = Empty | Node Int BST BST

validateBST = f (minBound :: Int, maxBound :: Int)
  where f _      Empty        = True
        f (a, b) (Node n l r) | a < n && n < b = f (a, n) l && f (n, b) r
                              | otherwise      = False
