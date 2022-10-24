using System.Globalization;
using System.Text;
using System.Text.RegularExpressions;
using CsAlgoDsCore;

Console.WriteLine("---SimpleArraySum---");
List<int> l1 = new() { 1, 2, 3, 4, 10, 11 };
Console.WriteLine($"Sum of {string.Join(",", l1)} is {SimpleArraySum(l1)}");
Console.WriteLine();

Console.WriteLine("---CompareTriplets---");
List<int> alice1 = new() { 1, 2, 3 };
List<int> bob1 = new() { 3, 2, 1 };
List<int> alice2 = new() { 5, 6, 7 };
List<int> bob2 = new() { 3, 6, 10 };
List<int> alice3 = new() { 17, 28, 30 };
List<int> bob3 = new() { 99, 16, 8 };
Console.WriteLine($"Alice - {string.Join(",", alice1)} | Bob - {string.Join(",", bob1)} " +
                  $"-> {string.Join(",", CompareTriplets(alice1, bob1))}");
Console.WriteLine($"Alice - {string.Join(",", alice2)} | Bob - {string.Join(",", bob2)} " +
                  $"-> {string.Join(",", CompareTriplets(alice2, bob2))}");
Console.WriteLine($"Alice - {string.Join(",", alice3)} | Bob - {string.Join(",", bob3)} " +
                  $"-> {string.Join(",", CompareTriplets(alice3, bob3))}");
Console.WriteLine();

Console.WriteLine("---CatAndMouse---");
Console.WriteLine(CatAndMouse(1, 2, 3));
Console.WriteLine(CatAndMouse(1, 3, 2));
Console.WriteLine();

Console.WriteLine("---Birthday---");
Console.WriteLine(Birthday(new() { 1, 2, 1, 3, 2 }, 3, 2));
Console.WriteLine(Birthday(new() { 1, 1, 1, 1, 1, 1 }, 3, 2));
Console.WriteLine(Birthday(new() { 4 }, 4, 1));
Console.WriteLine();

Console.WriteLine("---DivisibleSumPairs---");
Console.WriteLine(DivisibleSumPairs(6, 5, new() { 1, 2, 3, 4, 5, 6 }));
Console.WriteLine(DivisibleSumPairs(6, 3, new() { 1, 3, 2, 6, 1, 2 }));
Console.WriteLine();

Console.WriteLine("---SockMerchant---");
// Console.WriteLine(SockMerchant(9, new() { 10, 20, 20, 10, 10, 30, 50, 10, 20 }));
Console.WriteLine();

Console.WriteLine("---AngryProfessor---");
Console.WriteLine(AngryProfessor(3, new() { -1, -3, 4, 2 }));
Console.WriteLine(AngryProfessor(2, new() { 0, -1, 2, 1 }));
Console.WriteLine();

//Circular Array Rotation
Console.WriteLine("---CircularArrayRotation---");
Console.WriteLine(string.Join(",", CircularArrayRotation(new() { 3, 4, 5 }, 2, new() { 1, 2 })));
Console.WriteLine(string.Join(",", CircularArrayRotation(new() { 1, 2, 3 }, 2, new() { 0, 1, 2 })));
Console.WriteLine();

//Save the prisoner
Console.WriteLine("---SaveThePrisoner---");
Console.WriteLine(SaveThePrisoner(5, 2, 1));
Console.WriteLine(SaveThePrisoner(5, 2, 2));
Console.WriteLine(SaveThePrisoner(7, 19, 2));
Console.WriteLine(SaveThePrisoner(3, 7, 3));
Console.WriteLine();

//Repeated String
Console.WriteLine("---RepeatedString---");
Console.WriteLine(RepeatedString("aba", 10));
Console.WriteLine(RepeatedString("a", 1000000000000));
Console.WriteLine(RepeatedString("x", 970770));
Console.WriteLine();

//Jumping the clouds
Console.WriteLine(JumpingOnClouds(new() { 0, 1, 0, 0, 0, 1, 0 }));
Console.WriteLine(JumpingOnClouds(new() { 0, 0, 1, 0, 0, 1, 0 }));
Console.WriteLine(JumpingOnClouds(new() { 0, 0, 0, 0, 1, 0 }));
Console.WriteLine(JumpingOnClouds(new() { 0, 0, 0, 1, 0, 0 }));
Console.WriteLine();

//Equalize the array
Console.WriteLine(EqualizeArray(new() { 1, 2, 2, 3 }));
Console.WriteLine(EqualizeArray(new() { 3, 3, 2, 1, 3 }));
Console.WriteLine();

//Counting valleys
Console.WriteLine(CountingValleys(8, "DDUUUUDD"));
Console.WriteLine(CountingValleys(8, "UDDDUDUU"));
Console.WriteLine(CountingValleys(12, "DDUUDDUDUUUD"));
Console.WriteLine();

//Arrays: Left Rotation
Console.WriteLine(string.Join(",", RotLeft(new() { 1, 2, 3, 4, 5 }, 2)));
Console.WriteLine(string.Join(",", RotLeft(new() { 1, 2, 3, 4, 5 }, 4)));
Console.WriteLine();

//Mark and Toys
Console.WriteLine(MaximumToys(new() { 1, 2, 3, 4 }, 7));
Console.WriteLine(MaximumToys(new() { 1, 12, 5, 111, 200, 1000, 10 }, 50));
Console.WriteLine();

//Reverse Int
Console.WriteLine(ReverseInt(123));
Console.WriteLine(ReverseInt(-123));
Console.WriteLine(ReverseInt(120));
Console.WriteLine(ReverseInt(0));
Console.WriteLine(ReverseInt(-2147483648));
Console.WriteLine();

//83. Remove Duplicates from Sorted List
ListNode? removeDupes = new ListNode(1, new ListNode(1, new ListNode(2)));
removeDupes = DeleteDuplicates(removeDupes);
while (removeDupes != null)
{
    Console.WriteLine(removeDupes.Val);

    removeDupes = removeDupes.Next;
}

Console.WriteLine("---");
ListNode? removeDupes2 = new ListNode(1, new ListNode(1, new ListNode(2,
    new ListNode(3, new ListNode(3)))));
removeDupes2 = DeleteDuplicates(removeDupes2);
while (removeDupes2 != null)
{
    Console.WriteLine(removeDupes2.Val);
    removeDupes2 = removeDupes2.Next;
}

Console.WriteLine();

//34. Find First and Last Position of Element in Sorted Array
Console.WriteLine(string.Join(",", SearchRange(new[] { 5, 7, 7, 8, 8, 10 }, 8)));
Console.WriteLine(string.Join(",", SearchRange(new[] { 5, 7, 7, 8, 8, 10 }, 6)));
Console.WriteLine(string.Join(",", SearchRange(Array.Empty<int>(), 0)));
Console.WriteLine(string.Join(",", SearchRange(new[] { 3, 3, 3 }, 3)));
Console.WriteLine();

//287. Find the Duplicate Number
Console.WriteLine(FindDuplicate(new[] { 1, 3, 4, 2, 2 }));
Console.WriteLine(FindDuplicate(new[] { 3, 1, 3, 4, 2 }));
Console.WriteLine(FindDuplicate(new[] { 1, 1 }));
Console.WriteLine(FindDuplicate(new[] { 1, 1, 2 }));
Console.WriteLine();

//Library Fine
Console.WriteLine(LibraryFine(14, 7, 2018, 5, 7, 2018));
Console.WriteLine(LibraryFine(9, 6, 2015, 6, 6, 2015));
Console.WriteLine(LibraryFine(2, 7, 1014, 1, 1, 1014));
Console.WriteLine(LibraryFine(5, 5, 2014, 23, 2, 2014));
Console.WriteLine();

//Insert a node at the head of a linked list
ListNode? testHead = null;
testHead = InsertNodeAtHead(testHead, 383);
testHead = InsertNodeAtHead(testHead, 484);
testHead = InsertNodeAtHead(testHead, 392);
testHead = InsertNodeAtHead(testHead, 975);
testHead = InsertNodeAtHead(testHead, 321);

while (testHead != null)
{
    Console.WriteLine(testHead.Val);
    testHead = testHead.Next;
}

Console.WriteLine();

//Insert a Node at the Tail of a Linked List
ListNode? testHeadForTail = null;
testHeadForTail = InsertNodeAtTail(testHeadForTail, 141);
testHeadForTail = InsertNodeAtTail(testHeadForTail, 302);
testHeadForTail = InsertNodeAtTail(testHeadForTail, 164);
testHeadForTail = InsertNodeAtTail(testHeadForTail, 530);
testHeadForTail = InsertNodeAtTail(testHeadForTail, 474);

while (testHeadForTail != null)
{
    Console.WriteLine(testHeadForTail.Val);
    testHeadForTail = testHeadForTail.Next;
}

Console.WriteLine();

//Balanced Brackets
Console.WriteLine(IsBalanced(@"{[()]}"));
Console.WriteLine(IsBalanced(@"{[(])}"));
Console.WriteLine(IsBalanced(@"{{[[(())]]}}"));
Console.WriteLine(IsBalanced(@"{(([])[])[]]}"));
Console.WriteLine();

//Electronics Shop
Console.WriteLine(GetMoneySpent(new[] { 40, 50, 60 }, new[] { 5, 8, 12 }, 60));
Console.WriteLine(GetMoneySpent(new[] { 3, 1 }, new[] { 5, 2, 8 }, 10));
Console.WriteLine(GetMoneySpent(new[] { 4 }, new[] { 5 }, 5));
Console.WriteLine();

//Hurdle Race
Console.WriteLine(HurdleRace(4, new() { 1, 6, 3, 5, 2 }));
Console.WriteLine(HurdleRace(7, new() { 2, 5, 4, 5, 2 }));
Console.WriteLine();

//Cut the sticks
Console.WriteLine(string.Join(",", CutTheSticks(new() { 1, 2, 3 })));
Console.WriteLine(string.Join(",", CutTheSticks(new() { 5, 4, 4, 2, 2, 8 })));
Console.WriteLine(string.Join(",", CutTheSticks(new() { 1, 2, 3, 4, 3, 3, 2, 1 })));
Console.WriteLine();

//Mod Kap Nums
KaprekarNumbers(1, 100);
Console.WriteLine();

//Move Zeroes
MoveZeroes(new[] { 0, 1, 0, 3, 12 });
MoveZeroes(new[] { 0 });
Console.WriteLine();

/*CODE WARS*/
Console.WriteLine(SameCase('a', 'g'));
Console.WriteLine(SameCase('C', 'A'));
Console.WriteLine(SameCase('b', 'G'));
Console.WriteLine(SameCase('B', 'g'));
Console.WriteLine(SameCase('0', '?'));

Console.WriteLine("----");
Console.WriteLine($"din - {DuplicateEncode("din")}");
Console.WriteLine($"recede - {DuplicateEncode("recede")}");
Console.WriteLine($"Success - {DuplicateEncode("Success")}");
Console.WriteLine($"(( @ - {DuplicateEncode("(( @")}");

Console.WriteLine("----");
Console.WriteLine($"{TotalPoints(new[] { "1:0", "2:0", "3:0", "4:0", "2:1", "3:1", "4:1", "3:2", "4:2", "4:3" })}");
Console.WriteLine($"{TotalPoints(new[] { "1:1", "2:2", "3:3", "4:4", "2:2", "3:3", "4:4", "3:3", "4:4", "4:4" })}");
Console.WriteLine($"{TotalPoints(new[] { "0:1", "0:2", "0:3", "0:4", "1:2", "1:3", "1:4", "2:3", "2:4", "3:4" })}");
Console.WriteLine($"{TotalPoints(new[] { "1:0", "2:0", "3:0", "4:0", "2:1", "1:3", "1:4", "2:3", "2:4", "3:4" })}");
Console.WriteLine($"{TotalPoints(new[] { "1:0", "2:0", "3:0", "4:4", "2:2", "3:3", "1:4", "2:3", "2:4", "3:4" })}");

Console.WriteLine("----");
Console.WriteLine($"{SpinWords("Welcome")}");
Console.WriteLine($"{SpinWords("Hey fellow warriors")}");
Console.WriteLine($"{SpinWords("This is a test")}");
Console.WriteLine($"{SpinWords("This is another test")}");
Console.WriteLine($"{SpinWords("You are almost to the last test")}");
Console.WriteLine($"{SpinWords("Just kidding there is still one more")}");

Console.WriteLine("----");
Console.WriteLine($"{CountMinutes(DateTime.Now.Date.AddHours(12))}");
Console.WriteLine($"{CountMinutes(DateTime.Now.Date.AddHours(23).AddMinutes(59))}");

Console.WriteLine("----");
Console.WriteLine(PigIt("Pig latin is cool"));
Console.WriteLine(PigIt("Hello world !"));
Console.WriteLine(PigIt("This is my string"));

Console.WriteLine("----");
Console.WriteLine(Encrypt("This is a test!", 0));
Console.WriteLine(Encrypt("This is a test!", 1));
Console.WriteLine(Encrypt("This is a test!", 2));
Console.WriteLine(Encrypt("This is a test!", 3));
Console.WriteLine(Encrypt("This is a test!", 4));
Console.WriteLine(Encrypt("This is a test!", -1));
Console.WriteLine(Encrypt("This kata is very interesting!", 1));

Console.WriteLine("*");
Console.WriteLine(Decrypt("This is a test!", 0));
Console.WriteLine(Decrypt("hsi  etTi sats!", 1));
Console.WriteLine(Decrypt("s eT ashi tist!", 2));
Console.WriteLine(Decrypt(" Tah itse sits!", 3));
Console.WriteLine(Decrypt("This is a test!", 4));
Console.WriteLine(Decrypt("This is a test!", -1));
Console.WriteLine(Decrypt("hskt svr neetn!Ti aai eyitrsig", 1));

Console.WriteLine("----");
Console.WriteLine(ToCamelCase("the_stealth_warrior"));
Console.WriteLine(ToCamelCase("The-Stealth-Warrior"));

Console.WriteLine("----");
Console.WriteLine(string.Join("", UniqueInOrder("").ToList()));
Console.WriteLine(string.Join("", UniqueInOrder("AAAABBBCCDAABBB").ToList()));
Console.WriteLine(string.Join("", UniqueInOrder("ABBCcAD").ToList()));
Console.WriteLine(string.Join("", UniqueInOrder(new[] { 1, 2, 2, 3, 3 }).ToList()));

Console.WriteLine("----");
Console.WriteLine(FindIt(new[] { 7 }));
Console.WriteLine(FindIt(new[] { 0 }));
Console.WriteLine(FindIt(new[] { 1, 1, 2 }));
Console.WriteLine(FindIt(new[] { 1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1 }));
Console.WriteLine(FindIt(new[] { 20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5 }));

//Greed is Good
Console.WriteLine("----");
Console.WriteLine(Score(new[] { 5, 1, 3, 4, 1 }));
Console.WriteLine(Score(new[] { 1, 1, 1, 3, 1 }));
Console.WriteLine(Score(new[] { 2, 4, 4, 5, 4 }));
Console.WriteLine(Score(new[] { 2, 3, 4, 6, 2 }));
Console.WriteLine(Score(new[] { 4, 4, 4, 3, 3 }));
Console.WriteLine(Score(new[] { 2, 4, 4, 5, 4 }));

//CSV Representation of Array
Console.WriteLine("----");
Console.WriteLine(ToCsvText(new[]
{
    new[] { 0, 1, 2, 3, 45 },
    new[] { 10, 11, 12, 13, 14 },
    new[] { 20, 21, 22, 23, 24 },
    new[] { 30, 31, 32, 33, 34 }
}));
Console.WriteLine();
Console.WriteLine(ToCsvText(new[]
{
    new[] { -25, 21, 2, -33, 48 },
    new[] { 30, 31, -32, 33, -34 }
}));
Console.WriteLine();
Console.WriteLine(ToCsvText(new[]
{
    new[] { 5, 55, 5, 5, 55 },
    new[] { 6, 6, 66, 23, 24 },
    new[] { 666, 31, 66, 33, 7 }
}));

//Who Likes It?
Console.WriteLine("----");
Console.WriteLine(Likes(Array.Empty<string>()));
Console.WriteLine(Likes(new[] { "Peter" }));
Console.WriteLine(Likes(new[] { "Jacob", "Alex" }));
Console.WriteLine(Likes(new[] { "Max", "John", "Mark" }));
Console.WriteLine(Likes(new[] { "Alex", "Jacob", "Mark", "Max" }));

Console.WriteLine("----");
Console.WriteLine(ToWeirdCase("String"));
Console.WriteLine(ToWeirdCase("Weird string case"));
Console.WriteLine(ToWeirdCase("This"));
Console.WriteLine(ToWeirdCase("is"));
Console.WriteLine(ToWeirdCase("This is a test"));

/// <summary>
/// Find the sum of an array/list of integers
/// </summary>
/// <param name="ar">List representing an array of integers</param>
/// <returns>int for the sum</returns>
static int SimpleArraySum(List<int> ar) => ar.Sum();

/// <summary>
/// Compare two lists of 3, awarding points to a or b based on which is greater at a given index
/// </summary>
/// <param name="a">List of 3 integers for Alice</param>
/// <param name="b">List of 3 integers for Bob</param>
/// <returns>List of 2 int's, Alice then Bob's score</returns>
static List<int> CompareTriplets(List<int> a, List<int> b)
{
    int aScore = 0, bScore = 0;

    for (int i = 0; i < a.Count; i++)
    {
        if (a[i] == b[i]) continue;

        if (a[i] > b[i]) aScore++;
        else bScore++;
    }

    return new() { aScore, bScore };
}

/// <summary>
/// Find which cat can catch the mouse earlier assuming each moves ++/-- 1, if both reach at the same time mouse escapes
/// </summary>
/// <param name="x">Cat A's position on x axis</param>
/// <param name="y">Cat B's position on x axis</param>
/// <param name="z">Mouse position on x axis, will not move</param>
/// <returns>string "Cat A" or "Cat B" if one catches mouse, "Mouse C" if escapes</returns>
static string CatAndMouse(int x, int y, int z)
{
    if (Math.Abs(z - x) == Math.Abs(z - y)) return "Mouse C";

    return Math.Abs(z - x) > Math.Abs(z - y)
        ? "Cat B"
        : "Cat A";
}

/// <summary>
/// Find the number of ways a chocolate bar can be divided where pieces of length m sum to d
/// </summary>
/// <param name="s">ints on each square of chocolate</param>
/// <param name="d">continuous segments of choc must sum to this</param>
/// <param name="m">length of continuous segments of choc</param>
/// <returns>int for # of ways bar can be divided</returns>
static int Birthday(List<int> s, int d, int m)
{
    int divCt = 0;
    for (int i = 0; i < s.Count - (m - 1); i++)
    {
        if (s.GetRange(i, m).Sum() == d) divCt++;
    }

    return divCt;
}

/// <summary>
/// Given a list, find pairs of indices where the pair is divisible by k 
/// </summary>
/// <param name="n">length of list</param>
/// <param name="k">divisor</param>
/// <param name="ar">list of ints</param>
/// <returns>int for # of pairs</returns>
static int DivisibleSumPairs(int n, int k, List<int> ar)
{
    int pairs = 0;

    for (int i = 0; i < ar.Count; i++)
    {
        for (int j = i + 1; j < ar.Count; j++)
        {
            if (i < j && (ar[i] + ar[j]) % k == 0) pairs++;
        }
    }

    return pairs;
}

/// <summary>
/// Find pairs of socks where the int in list represents sock color
/// </summary>
/// <param name="n">count of list</param>
/// <param name="ar">sock color list</param>
/// <returns>int for # of pairs</returns>
static int SockMerchant(int n, List<int> ar)
{
    int pairs = 0;

    //RemoveAll returns number removed, add removed / 2 to pairs
    int toRemove = ar[0];
    while (ar.Count > 0)
    {
        pairs += ar.RemoveAll(num => num == toRemove) / 2; //int division forces truncation
    }

    return pairs;
}

/// <summary>
/// Determine if the prof will cancel class, in the case that less than k students arrive on time
/// </summary>
/// <param name="k">int for threshold</param>
/// <param name="a">student arrival times, any positive int indicates lateness</param>
/// <returns>"YES" if class cancelled, "NO" if proceeds</returns>
static string AngryProfessor(int k, List<int> a) => a.Count(s => s <= 0) >= k ? "NO" : "YES";

/// <summary>
/// Perform circular rotations on the list, then report the the indices specified
/// </summary>
/// <param name="a">list of ints</param>
/// <param name="k">int for # of circular rotations to perform</param>
/// <param name="queries">list of indices to report</param>
/// <returns>list of values at the indices</returns>
static List<int> CircularArrayRotation(List<int> a, int k, List<int> queries)
{
    for (int i = 0; i < k; i++)
    {
        //store last element, pop off end, then push to front
        int temp = a[^1];
        a.RemoveAt(a.Count - 1);
        a.Insert(0, temp);
    }

    return queries
        .Select(i => a[i])
        .ToList();
}

/// <summary>
/// Prisoners are seated around a circular table, and passed out a number of candies starting from a certain
/// seat. Determine the last recipient
/// </summary>
/// <param name="n">int for # of prisoners</param>
/// <param name="m">int for # of candies</param>
/// <param name="s">int for the prisoner to begin from</param>
/// <returns>int for the prisoner to get the last candy</returns>
static int SaveThePrisoner(int n, int m, int s)
{
    int[] distr = new int[m];

    //fill seating arr
    for (int i = 0; i < m; i++)
    {
        distr[i] = s;

        //restart at 1 due to circular seating, else increment s
        if (s == n) s = 1;
        else s++;
    }

    // Console.WriteLine(string.Join(",", distr));

    return distr[^1];

    //return ((m - 1) + (s - 1)) % n + 1; is the right answer bc they throw you large numbers
    //s+m and %n to return to 0, +/-1 to offset modular math starting at zero
}

/// <summary>
/// Assume an infinite string of s repeated continually, find the number of 'a' that occur in range n
/// </summary>
/// <param name="s">substring that is repeated</param>
/// <param name="n">long for range to search in</param>
/// <returns>long for the # of a's</returns>
static long RepeatedString(string s, long n)
{
    long rep = n / s.Length; //long div to find dividend
    long iToTrunc = n % s.Length; //modulo to find how much is left after full repetitions
    string sTrunc = s.Remove(Convert.ToInt32(iToTrunc));

    //count a's in original string, * the # of repetitions + the a's of the truncated string
    return s.Count(c => c == 'a') * rep + sTrunc.Count(c => c == 'a');
}

/// <summary>
/// Determine the number of jumps to avoid the thunder clouds and complete the course
/// </summary>
/// <param name="c">list of ints, where 0 are safe, 1 are to be avoided - 1st and last will always be 0</param>
/// <returns>int for number of jumps to complete course</returns>
static int JumpingOnClouds(List<int> c)
{
    int i = 0, jumps = 0;
    while (i < c.Count - 1)
    {
        //look ahead 2 indices, if both safe, jump 2 i's, else jump 1
        if (i + 2 < c.Count && c[i + 2] == 0) //have to check so it doesn't hit the out of bounds exception
        {
            i += 2;
            jumps++;
        }
        else if (c[i + 1] == 0)
        {
            i++;
            jumps++;
        }
    }

    return jumps;
}

/// <summary>
/// Find the min number of elements to delete to leave the list with only 1 element type
/// </summary>
/// <param name="arr">list of ints</param>
/// <returns>min # of indices to delete</returns>
static int EqualizeArray(List<int> arr)
{
    //create a set of distinct numbers so we know what to get counts of
    HashSet<int> numSet = arr.ToHashSet();
    List<int> numCts = numSet
        .Select(num => arr.Count(n => n == num))
        .ToList();

    return arr.Count - numCts.Max(); //count - the # of max elements = the min to delete for uniform list
}

/// <summary>
/// Find the number of valleys encountered, which begin step down from sea level, and ending with a step up
/// from sea level
/// </summary>
/// <param name="steps">total number of steps in path</param>
/// <param name="path">string where U = +1 alt, D = -1 alt, assume start at sea level</param>
/// <returns>number of valleys encountered</returns>
static int CountingValleys(int steps, string path)
{
    List<int> pathAlts = new(); //start at sea level
    int currentAlt = 0;

    //render path as a list of alt's at a given index of string
    foreach (char step in path)
    {
        if (step == 'U') pathAlts.Add(++currentAlt);
        else pathAlts.Add(--currentAlt);
    }

    bool valleyFlag = false;
    int valleys = 0;
    foreach (int alt in pathAlts)
    {
        //if dips below 0, entered a valley
        if (alt == -1) valleyFlag = true;

        //if entered a valley, and we reach 0, we completed a valley encounter
        if (!valleyFlag || alt != 0) continue;

        valleys++;
        valleyFlag = false;
    }

    return valleys;
}

/// <summary>
/// Rotate a list to the left many times
/// </summary>
/// <param name="a">list of ints</param>
/// <param name="d">int for # of rotations</param>
/// <returns>the rotated list</returns>
static List<int> RotLeft(List<int> a, int d)
{
    //fails for big lists with many shifts on HR
    for (int i = 0; i < d; i++)
    {
        int temp = a[0];
        a.RemoveAt(0);
        a = a.Append(temp).ToList();
    }

    return a;
}

/// <summary>
/// Find the max num of elements to achieve the target sum
/// </summary>
/// <param name="prices">list of ints</param>
/// <param name="k">target sum</param>
/// <returns>int for the maximum # of elements</returns>
static int MaximumToys(List<int> prices, int k)
{
    //sort prices from min to max
    prices.Sort();
    int i = 0; //incremental amount to take
    List<int> elems = new();

    //Take from list, until you find reach the target
    while (elems.Sum() < k)
    {
        elems = prices
            .Take(++i)
            .ToList();
    }

    return elems.Sum() > k ? --i : i; //check if last take was too much
}

/// <summary>
/// Reverse the digits of an int
/// </summary>
/// <param name="x">int</param>
/// <returns>the 'reverse' int with its digits in opposite order, 0 if reversed goes out of bounds of 32 bit int</returns>
static int ReverseInt(int x)
{
    //some params will be long/Int64
    char[] digits = Math.Abs((long)x) //drop the negative, can re-add last
        .ToString()
        .ToCharArray();

    if (digits.Length == 1) return x;

    //reverse -> use try parse to determine if the reversed can be saved to Int32 type
    Array.Reverse(digits);
    if (int.TryParse(string.Join("", digits), out int rev))
    {
        return x < 0
            ? rev * -1 //readd negative sign if needed 
            : rev;
    }

    return rev; //parse failed, we init to 0 so just return that
}

/// <summary>
/// Remove duplicates from a sorted list
/// </summary>
/// <param name="head">head node of sll</param>
/// <returns>the head node after filter</returns>
static ListNode? DeleteDuplicates(ListNode? head)
{
    if (head == null) return null;
    ListNode? walker = head;

    while (walker.Next != null)
    {
        //if two neighboring nodes match, link node to the one after
        if (walker.Val == walker.Next.Val) walker.Next = walker.Next.Next;
        else walker = walker.Next; //else, step forward
    }

    return head;
}

/// <summary>
/// Find the starting and ending position of the target
/// </summary>
/// <param name="nums">int arr</param>
/// <param name="target">target int to find</param>
/// <returns>arr with the first and last position, [-1,-1] if not found</returns>
static int[] SearchRange(int[] nums, int target)
{
    Dictionary<int, int> numMap = new();
    for (int i = 0; i < nums.Length; i++)
    {
        numMap.Add(i, nums[i]);
    }

    /*
    //this is a bit slower, but this is the linq way
    Dictionary<int, int> numMap = Enumerable.Range(0, nums.Length)
        .ToDictionary(
            i => i,
            i => nums[i]
        );
    */

    if (!numMap.ContainsValue(target)) return new[] { -1, -1 };

    int[] idxList = numMap.Where(pair => pair.Value == target)
        .Select(pair => pair.Key)
        .ToArray();

    return new[] { idxList.First(), idxList.Last() }; //only need the first and last positions
}

/// <summary>
/// Find the duplicate in the arr w/o modifying and constant extra space
/// </summary>
/// <param name="nums">int arr</param>
/// <returns>int with a duplicate in arr</returns>
static int FindDuplicate(int[] nums)
{
    //todo fails on large nums
    int idx = 0;
    int current = nums[idx];

    while (idx < nums.Length - 1)
    {
        if (nums.Where((n, i) => current - n == 0 && i != idx).Any())
            return current;

        current = nums[++idx];
    }

    return int.MinValue; //won't ever hit this
}

/// <summary>
/// Calculate the fine on the date returned
/// </summary>d
/// <param name="d1">day of actual return</param>
/// <param name="m1">month of actual return</param>
/// <param name="y1">year of actual return</param>
/// <param name="d2">day of due date</param>
/// <param name="m2">month of due date</param>
/// <param name="y2">year of due date</param>
/// <returns>the fine</returns>
static int LibraryFine(int d1, int m1, int y1, int d2, int m2, int y2)
{
    DateTime returnDate = DateTime.ParseExact(string.Join("/", d1, m1, y1), "d/M/yyyy", null);
    DateTime dueDate = DateTime.ParseExact(string.Join("/", d2, m2, y2), "d/M/yyyy", null);

    TimeSpan timeSpan = returnDate - dueDate;

    if (timeSpan <= TimeSpan.Zero) return 0; //book return before or on time

    //late, but within a month = 15 * days late
    if (returnDate.Month == dueDate.Month && returnDate.Year == dueDate.Year)
        return (int)(15 * timeSpan.TotalDays);

    //late but within same year = 500 * months late
    if (returnDate.Year == dueDate.Year) return 500 * Math.Abs(returnDate.Month - dueDate.Month);

    return 10000; //past the year of due date
}

/// <summary>
/// Insert a node at head of SLL
/// </summary>
/// <param name="llist">Head ListNode of a SLL</param>
/// <param name="data">int to insert at head</param>
/// <returns>Head ListNode of new SLL post insertion</returns>
static ListNode? InsertNodeAtHead(ListNode? llist, int data) =>
    llist == null
        ? new ListNode(data)
        : new ListNode
        {
            Val = data,
            Next = llist
        };

static ListNode? InsertNodeAtTail(ListNode? head, int data)
{
    if (head == null) return new ListNode(data);

    ListNode clone = head;
    while (head.Next != null)
    {
        head = head.Next;
    }

    head.Next = new ListNode(data);

    return clone;
}

/// <summary>
/// Check if the brackets of a string are balanced = if {[( are closed by a matching }])
/// </summary>
/// <param name="s">string with brackets</param>
/// <returns>YES if balanced, NO otherwise</returns>
static string IsBalanced(string s)
{
    Stack<char> bracStak = new();
    Regex op = new Regex("[{\\[(]");
    Regex cl = new Regex("[}\\])]");

    foreach (char c in s)
    {
        Match opening = op.Match(c.ToString());
        Match closing = cl.Match(c.ToString());

        if (opening.Success) bracStak.Push(c); //if opening push onto stack
        if (!closing.Success) continue; //if not closing, skip to next iteration

        //if closing, check if there is its matching opening, if so then pop
        char openerForC = c switch
        {
            '}' => '{',
            ']' => '[',
            ')' => '(',
            _ => '\0'
        };

        if (bracStak.Peek() != openerForC) return "NO"; //if not a match, unbalanced
        bracStak.Pop();
    }

    return bracStak.Count == 0 ? "YES" : "NO";
}

/// <summary>
/// Find the highest possible combination of 1 element from each of the 2 arr's that are under the target
/// </summary>
/// <param name="keyboards">int arr of keyboard prices</param>
/// <param name="drives">int arr of drive prices</param>
/// <param name="b">int target for budget</param>
/// <returns>int for the highest possible combo of elements/price under target/budget</returns>
static int GetMoneySpent(int[] keyboards, int[] drives, int b)
{
    //fails on massive arr's
    /*
    if (keyboards.Min() + drives.Min() > b) return -1; //edge

    //create price combinations
    List<int> priceCombos = keyboards.SelectMany(
        kb => drives,
        (kb, dr) => kb + dr
    ).ToList();

    //filter and return the max combo price below b
    return priceCombos.Where(p => p < b).Max();
    */

    int[] kb = keyboards
        .OrderByDescending(i => i)
        .ToArray(); //start from most expensive
    Array.Sort(drives); //start from cheapest

    int max = -1;
    for (int i = 0; i < keyboards.Length; i++)
    {
        max = drives
            .TakeWhile(dr => kb[i] + dr <= b)
            .Select(dr => kb[i] + dr)
            .Prepend(max)
            .Max();
    }

    return max;
}

/// <summary>
/// Get the number of +1 height potions the player has to take to jump all hurdles in the race
/// </summary>
/// <param name="k">The base jump height of player</param>
/// <param name="height">List of hurdle heights</param>
/// <returns>Number of +1 potions to take</returns>
static int HurdleRace(int k, List<int> height) => k >= height.Max() ? 0 : height.Max() - k;

/// <summary>
/// Find the shortest stick each iteration, chop that length from the longer sticks, and discard the shortest.
/// Continue until all sticks are the same length
/// Return the number of sticks from each iteration
/// </summary>
/// <param name="arr">Int List with the length of sticks</param>
/// <returns>A list of the sticks from each iteration</returns>
static List<int> CutTheSticks(List<int> arr)
{
    List<int> stickCt = new();
    while (arr.Any(n => n != arr[0]))
    {
        stickCt.Add(arr.Count); //grab the count before operations

        //find the shortest and remove
        int min = arr.Min();
        _ = arr.RemoveAll(n => n == min);

        arr = arr
            .Select(n => n - min)
            .ToList(); //subtract shortest the remaining sticks
    }

    stickCt.Add(arr.Count); //need the end count also
    return stickCt;
}

/// <summary>
/// Print the modified Kaprekar nums within range p - q
/// When squared, its digits will add up to the original num
/// </summary>
/// <param name="p">lower bound</param>
/// <param name="q">upper bound</param>
static void KaprekarNumbers(int p, int q)
{
    List<double> kNums = new();
    for (int i = p; i <= q; i++)
    {
        double sq = Math.Pow(i, 2);
        char[] sqChunks = sq.ToString(CultureInfo.InvariantCulture).ToCharArray();

        if (sqChunks.Length > 1)
        {
            int half = sqChunks.Length / 2;
            int firstHalf = int.Parse(new string(sqChunks[..half]));
            int lastHalf = int.Parse(new string(sqChunks[half..]));

            if (firstHalf + lastHalf == i) kNums.Add(i);
        }
        else if (int.Parse(sqChunks[0].ToString()) == i)
        {
            kNums.Add(i);
        }
    }

    Console.WriteLine(
        kNums.Any()
            ? string.Join(" ", kNums)
            : "INVALID RANGE"
    );
}

/// <summary>
/// Given an array, move all zeros to the end
/// </summary>
/// <param name="nums">int array</param>
static void MoveZeroes(int[] nums)
{
    if (nums.Length == 1) Console.WriteLine(nums[0]);

    List<int> numList = new(nums);
    int removed = numList.RemoveAll(n => n == 0);

    numList.AddRange(Enumerable.Repeat(0, removed));

    Console.WriteLine(string.Join(",", numList));
}

/// <summary>
/// Verify if two chars are in the same case
/// </summary>
/// <param name="a">1st char</param>
/// <param name="b">2nd char</param>
/// <returns>1 if both chars are the same case, 0 if not, and -1 if either char is not a letter</returns>
static int SameCase(char a, char b)
{
    if (!char.IsLetter(a) || !char.IsLetter(b))
        return -1;

    return char.IsLower(a) == char.IsLower(b) ? 1 : 0;
}

/// <summary>
/// Encode a string such that a char is replaced with '(' if it appears only one, and ')' otherwise
/// </summary>
/// <param name="word">string to encode</param>
/// <returns>The encoded string</returns>
static string DuplicateEncode(string word)
{
    string lower = word.ToLower();
    List<char> dupes = lower
        .ToHashSet()
        .ToDictionary(
            ch => ch,
            ch => word.Count(c => c == ch)
        )
        .Where(kv => kv.Value > 1)
        .Select(kv => kv.Key)
        .ToList();

    StringBuilder sb = new();
    foreach (char c in lower)
    {
        sb.Append(dupes.Contains(c) ? ')' : '(');
    }

    return sb.ToString();
}

/// <summary>
/// Get the total points for a team this season
/// </summary>
/// <param name="games">array of 10 strings of format "x:y" with x being our team</param>
/// <returns>Total points based on the season performance</returns>
static int TotalPoints(string[] games)
{
    int pts = 0;

    foreach (string game in games)
    {
        if (game[0] == game[2])
            pts++;
        else if (game[0] > game[2])
            pts += 3;
    }

    return pts;
}

/// <summary>
/// Take a sentence, and reverse in place all of the words with length >= 5
/// </summary>
/// <param name="sentence">A complete sentence of one or more words</param>
/// <returns>The sentence with the spin conditions applied</returns>
static string SpinWords(string sentence)
{
    if (string.IsNullOrWhiteSpace(sentence)) return sentence;

    string[] words = sentence.Split(" ");
    if (words.Length == 0) return sentence;

    switch (words.Length)
    {
        case <= 1 when words.First().Length >= 5:
            return new string(sentence.ToCharArray().Reverse().ToArray());
        case <= 1:
            return sentence;
    }

    for (int i = 0; i < words.Length; i++)
    {
        string word = words[i];
        if (word.Length >= 5) words[i] = new string(word.Reverse().ToArray());
    }

    return string.Join(" ", words);

    // return string.Join(" ", sentence.Split(' ').Select(s => s.Length >= 5 ? new string(s.Reverse().ToArray()) : s)); //one line version
}

/// <summary>
/// Given a DateTime, count the minutes until midnight of the same day
/// </summary>
/// <param name="d">DateTime object with today's date, and a random timestamp</param>
/// <returns>Minutes to midnight as a string</returns>
static string CountMinutes(DateTime d)
{
    TimeSpan midnight = DateTime.Today.AddHours(24).TimeOfDay;
    Console.WriteLine(midnight);
    Console.WriteLine(d.TimeOfDay);
    double timeTo = (midnight - d.TimeOfDay).TotalMinutes;
    return $"{timeTo} {(timeTo == 1 ? "minute" : "minutes")}";
}

/// <summary>
/// Convert each string to pig latin, leaving punctuation and spacing in place
/// </summary>
/// <param name="str">string to be converted</param>
/// <returns>The string converted to pig latin</returns>
static string PigIt(string str)
{
    StringBuilder sb = new();
    string[] words = str.Split(' ');

    foreach (string w in words)
    {
        if (char.IsPunctuation(w[0])) sb.Append(w).Append(' '); //leave punctuation alone
        else sb.Append(w[1..]).Append(w[0]).Append("ay").Append(' ');
    }

    sb.Length--; //strip last ' '

    return sb.ToString();

    // return string.Join(" ", str.Split(" ").Select(w => char.IsPunctuation(w[0]) ? w : $"{w[1..]}{w[0]}ay")); //one liner 
}

/// <summary>
/// Encrypt string by concatenating the odd-index chars with the even index chars, n number of times
/// </summary>
/// <param name="text">string to encrypt</param>
/// <param name="n">int number of iterations to pass the string through</param>
/// <returns>The encrypted string</returns>
static string Encrypt(string text, int n)
{
    if (string.IsNullOrWhiteSpace(text) || n < 1) return text;

    string enc = text;
    for (int i = 0; i < n; i++)
    {
        string odd = new(enc.Where((_, i) => i % 2 != 0).ToArray());
        string even = new(enc.Where((_, i) => i % 2 == 0).ToArray());
        enc = $"{odd}{even}";
    }

    return enc;
}

/// <summary>
/// Decrypt the string, using the reverse algorithm from Encrypt(string text, int n)
/// </summary>
/// <param name="encryptedText">string to decrypt</param>
/// <param name="n">int number of iterations to pass the string through</param>
/// <returns>The decrypted string</returns>
static string Decrypt(string encryptedText, int n)
{
    if (string.IsNullOrWhiteSpace(encryptedText) || n < 1) return encryptedText;

    StringBuilder sb = new();
    string deEnc = encryptedText;
    string fst = deEnc[..(deEnc.Length / 2)];
    string scd = deEnc[(deEnc.Length / 2 + 1)..];

    for (int i = 0; i < fst.Length; i++)
    {
        sb.Append(fst[i]);
        sb.Append(scd.ElementAtOrDefault(i)); //try to get it, but likely will be shorter
    }

    return deEnc;
}

/// <summary>
/// Take a '-' or '_' delimited string and convert it to camel case
/// </summary>
/// <param name="str">string to convert</param>
/// <returns>Camel cased string</returns>
static string ToCamelCase(string str)
{
    TextInfo textInfo = new CultureInfo("en-US", false).TextInfo;
    string[] words = str.Split(new char[] { '-', '_' });

    //leave first word alone
    for (int i = 1; i < words.Length; i++)
    {
        words[i] = textInfo.ToTitleCase(words[i]);
    }

    return string.Join("", words);
}

/// <summary>
/// Process out strictly sequential duplicates, and preverse the order of the elements
/// </summary>
/// <param name="iterable">Generic IEnumerable</param>
/// <typeparam name="T">no type restriction</typeparam>
/// <returns>IEnumerable where unique elements in order are preserved</returns>
static IEnumerable<T> UniqueInOrder<T>(IEnumerable<T> iterable)
{
    //dump to list approach
    List<T> list = iterable.ToList();
    T? current = default;
    List<T> uniques = new();

    foreach (T item in list.Where(item => !Equals(item, current)))
    {
        current = item;
        uniques.Add(current);
    }

    return uniques;

    //working on the iterable
    /*
    T? prev = default;
    foreach (T curr in iterable)
    {
        if (!curr.Equals(prev))
        {
            prev = curr;
            yield return curr;
        }
    }
    */
}

/// <summary>
/// Find the integer that appears an odd number of times
/// Will always be only 1 number that appears an odd number of times
/// </summary>
/// <param name="seq">int array</param>
/// <returns>The int that appears an odd number of times</returns>
static int FindIt(int[] seq) =>
    seq.GroupBy(n => n)
        .Single(group => group.Count() % 2 == 1)
        .Key;
/*
//first attempt
seq.GroupBy(n => n)
    .Where(group => group.Count() % 2 != 0)
    .First()
    .First();
*/

/// <summary>
/// Given an array of 5 * 6-sided dice, return the score if:
/// 3 x 1's = 1000 pts
/// 3 x 6's = 600 pts
/// 3 x 5's = 500 pts
/// 3 x 4's = 400 pts
/// 3 x 3's = 300 pts
/// 3 x 2's = 200 pts
/// 1 x 1 = 100 pts
/// 1 * 5 = 50 pts
/// </summary>
/// <param name="dice">int array of length 5, each being within a range of 1-6 inclusive</param>
/// <returns>Game score based on rolls</returns>
static int Score(int[] dice)
{
    Dictionary<int, int> dict = dice.GroupBy(n => n)
        .ToDictionary(
            group => group.Key,
            group => group.Count()
        );

    return dict.Sum(
        kv => kv.Key switch
        {
            1 when kv.Value == 3 => 1000,
            1 => 100,
            2 when kv.Value == 3 => 200,
            3 when kv.Value == 3 => 300,
            4 when kv.Value == 3 => 400,
            5 when kv.Value == 3 => 500,
            5 => 50,
            6 when kv.Value == 3 => 600,
            _ => 0 //shouldn't hit this
        }
    );
}

static string ToCsvText(int[][] array) => string.Join("\n", array.Select(row => string.Join(",", row)));
/*
{
    StringBuilder sb = new();
    foreach (int[] row in array)
    {
        sb.Append(string.Join(",", row));
        sb.Append('\n');
    }

    sb.Length--;

    return sb.ToString();
}
*/

static string Likes(string[] name) => name.Length switch
{
    > 3 => $"{name[0]}, {name[1]} and {name.Length - 2} others like this",
    3 => $"{name[0]}, {name[1]} and {name[2]} like this",
    2 => $"{name[0]} and {name[1]} like this",
    1 => $"{name[0]} likes this",
    _ => "no one likes this"
};

static string ToWeirdCase(string s)
{
    IEnumerable<string> weird = s
        .Split(' ')
        .Select(word => new string(word.Select((c, i) => i % 2 == 0 ? char.ToUpper(c) : char.ToLower(c)).ToArray()));

    return string.Join(" ", weird);
}
