public static class SubArraySumsToZeroFinder
{
        public static bool DoesSubArraySumToZero(int[] numbers)
        {
            if (numbers == null)
            {
                throw new ArgumentNullException("numbers");
            }

            var sumSoFarLookup = new HashSet<int>();
            var sumSoFar = 0;
            foreach (var number in numbers)
            {
                sumSoFar = sumSoFar + number;

                if (number == 0 || sumSoFar == 0)
                {
                    return true;
                }

                if (sumSoFarLookup.Contains(sumSoFar))
                {
                    return true;
                }

                sumSoFarLookup.Add(sumSoFar);
            }

            return false;
}

[TestFixture]
public class SubArraySumsToZeroFinderTests
{
        [Test]
        public void DoesSubArraySumToZeroTests()
        {
            Assert.IsTrue(SubArraySumsToZeroFinder.DoesSubArraySumToZero(new[] { 4, 2, -3, 1, 6 }));
            Assert.IsTrue(SubArraySumsToZeroFinder.DoesSubArraySumToZero(new[] { 4, 2, 0, 1, 6 }));
            Assert.IsFalse(SubArraySumsToZeroFinder.DoesSubArraySumToZero(new[] { -3, 2, 3, 1, 6 }));
        }
}