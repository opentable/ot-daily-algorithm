public class BunnyEars
{
        public static int FindEars(int line)
        {
            if (line == 0)
            {
                return 0;
            }

            var numberOfEars = line % 2 == 0 ? 3 : 2;

            return numberOfEars + FindEars(line - 1);
}

[TestFixture]
public class BunnyEarsTests
{
       [Test]
       public void FindEarsTest()
       {
           Assert.AreEqual(0, BunnyEars.FindEars(0));
           Assert.AreEqual(2, BunnyEars.FindEars(1));
           Assert.AreEqual(5, BunnyEars.FindEars(2));
       }
}
