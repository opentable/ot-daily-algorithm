using System.Collections.Generic;
using NUnit.Framework;

namespace test
{
	class SubarraySolution
	{
		public static int[] FindSubarray(int[] input)
		{
			List<int> sums = new List<int>();
			for (int i = 0; i < input.Length; i++)
			{
				for (int j = 0; j < sums.Count; j++)
				{
					sums[j] += input[i];

					if (sums[j] == 0)
						return new[] { j, i };
				}
				sums.Add(input[i]);
			}
			return new int[] { };
		}

		[TestFixture]
		public class SubarrayTests
		{
			[Test]
			public void SubarrayTest()
			{
				Assert.IsEmpty(FindSubarray(new[] { 1, 2, 3 }));
				Assert.IsEmpty(FindSubarray(new[] { 1, -2, 3, 7 }));
				Assert.AreEqual(FindSubarray(new[] { 1, 2, 3, -9, 4 }), new[] { 1, 4 });
				Assert.AreEqual(FindSubarray(new[] { 1, 2, 3, 4, -3, -4 }), new[] { 0, 5 });
				Assert.AreEqual(FindSubarray(new[] { 1, 2, 3, -3, -4 }), new[] { 2, 3 });
				Assert.AreEqual(FindSubarray(new[] { 1, 2, 3, -4, 2, -3, 9 }), new[] { 1, 5 });
			}
		}
	}

}

