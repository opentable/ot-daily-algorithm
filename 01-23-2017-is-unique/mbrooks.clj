(defn unique [str] (= (count str) (count (set str))))

(unique "abc") ; true
(unique "aba") ; false
