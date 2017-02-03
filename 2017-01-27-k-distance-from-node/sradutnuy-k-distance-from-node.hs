data Tree = E | Branch Int Tree Tree

printAtK :: Int -> Tree -> String
printAtK _ E = ""
printAtK 0 (Branch a _ _) = show a
printAtK n (Branch _ l r) = printAtK (n - 1) l ++ " " ++ printAtK (n - 1) r
