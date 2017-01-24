    public class LinkedListPalindromeChecker
    {
        public static bool IsPalindrome(string text)
        {
            if (text == null)
            {
                throw new ArgumentNullException("text");
            }

            var canonicalized = Regex.Replace(
                text.ToLowerInvariant(),
                @"[^0-9A-Za-z]+",
                string.Empty);

            return canonicalized == Reverse(canonicalized);
        }

        private static string Reverse(string text)
        {
            var reversed = new char[text.Length];
            for (var index = 0; index < text.Length; index++)
            {
                reversed[index] = text[text.Length - index - 1];
            }

            return new string(reversed);
        }
    }
    
    
     [TestFixture]
     public class LinkedListPalindromeCheckerTests
     {
            [Test]
            public void IsPalindromeTests()
            {
                Assert.Multiple(() =>
                {
                    Assert.IsTrue(LinkedListPalindromeChecker.IsPalindrome("dad"));
                    Assert.IsTrue(LinkedListPalindromeChecker.IsPalindrome("Dad"));
                    Assert.IsTrue(LinkedListPalindromeChecker.IsPalindrome(""));
                    Assert.IsTrue(LinkedListPalindromeChecker.IsPalindrome("A car, a man, a maraca"));
                    Assert.IsFalse(LinkedListPalindromeChecker.IsPalindrome("opentable"));
                });
            }
    }