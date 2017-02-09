partitionList xs x = [a | a <- xs, a < x] ++ [x] ++ [b | b <- xs, b >= x]
