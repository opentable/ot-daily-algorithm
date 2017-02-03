bunnyEars = f 0
  where f a b | b < 1     = a
              | odd b     = f (3 + a) (b - 1)
              | otherwise = f (2 + a) (b - 1)
