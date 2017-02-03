bunnyEars = f 0
  where f a b | b < 1     = a
              | otherwise = f (2 + b `mod` 2 + a) (b - 1)
