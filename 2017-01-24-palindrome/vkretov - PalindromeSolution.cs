using System.Collections.Generic;
using NUnit.Framework;

namespace test
{
	class PalindromeSolution
	{
		private static bool IsPalindrome<T>(LinkedList<T> input)
		{
			if (input == null || input.Count == 0)
				return false;

			while (input.First.Value.Equals(input.Last.Value))
			{
				if (input.Count <= 3)
					return true;

				input.RemoveFirst();
				input.RemoveLast();
			}

			return false;
		}

		[TestFixture]
		public class PalindromeTests
		{
			[Test]
			public void IsPalindromeTests()
			{
				Assert.IsTrue(IsPalindrome(new LinkedList<string>(new [] {"a", "b", "a"})));
				Assert.IsTrue(IsPalindrome(new LinkedList<string>(new [] {"aaa", "bbb", "aa", "aa", "bbb", "aaa"})));
				Assert.IsTrue(IsPalindrome(new LinkedList<int>(new []{1,2,3,3,2,1})));
				Assert.IsFalse(IsPalindrome(new LinkedList<int>(new []{1,2,3,3,2,1,4})));
				Assert.IsFalse(IsPalindrome(new LinkedList<string>(new[] { "aaa", "bbb", "aa", "Aa", "bbb", "aaa" })));

			}
		}
	}

}

