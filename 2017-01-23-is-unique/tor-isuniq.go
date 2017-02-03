package main

import (
	"fmt"
)

//This checks the string for uniqueness without using data structions
// wooo ~n^2
func isUniq(str string) bool {
	iter := 0
	strLen := len(str)
	// popping off items here because we don't need to keep using characters we already checked.
	for i := strLen - 1; i > 0; i-- {
		// use i instead of strLen because it's more efficient
		for j := 0; j < i; j++ {
			if i != j {
				if str[i] == str[j] {
					fmt.Println("iter is:", iter)
					return false
				}
			}
			iter++
		}
		strLen--
	}
	fmt.Println("iter is:", iter)
	return true
}

func main() {
	fmt.Println("Hello, playground")
	fmt.Println("what is unique:", isUniq("abc"))
	fmt.Println("what is unique2:", isUniq("abac"))
	fmt.Println("What is unique3:", isUniq("abcdefghijklmnopqrstuvwxyz"))
	fmt.Println("What is unique4:", isUniq("abcdefghijklmznopqrstuvwxyz"))
}

/*
Hello, playground
iter is: 3
what is unique: true
iter is: 3
what is unique2: false
iter is: 325
What is unique3: true
iter is: 13
What is unique4: false
*/
