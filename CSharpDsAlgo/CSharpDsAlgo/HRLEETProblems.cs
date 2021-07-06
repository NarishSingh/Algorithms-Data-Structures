using System;
using System.Collections.Generic;
using System.Linq;

namespace CSharpDsAlgo
{
    public class HRLEETProblems
    {
        public static void Main(string[] args)
        {
            //SimpleArraySum
            List<int> l1 = new List<int> {1, 2, 3, 4, 10, 11};
            Console.WriteLine($"Sum of {string.Join(",", l1)} is {SimpleArraySum(l1)}");
            Console.WriteLine("\n");

            //CompareTriplets
            List<int> alice1 = new List<int> {1, 2, 3};
            List<int> bob1 = new List<int> {3, 2, 1};
            List<int> alice2 = new List<int> {5, 6, 7};
            List<int> bob2 = new List<int> {3, 6, 10};
            List<int> alice3 = new List<int> {17, 28, 30};
            List<int> bob3 = new List<int> {99, 16, 8};
            Console.WriteLine($"Alice - {string.Join(",", alice1)} | Bob - {string.Join(",", bob1)} " +
                              $"-> {string.Join(",", CompareTriplets(alice1, bob1))}");
            Console.WriteLine($"Alice - {string.Join(",", alice2)} | Bob - {string.Join(",", bob2)} " +
                              $"-> {string.Join(",", CompareTriplets(alice2, bob2))}");
            Console.WriteLine($"Alice - {string.Join(",", alice3)} | Bob - {string.Join(",", bob3)} " +
                              $"-> {string.Join(",", CompareTriplets(alice3, bob3))}");
            Console.WriteLine("\n");

            //Cat and Mouse
            Console.WriteLine(CatAndMouse(1, 2, 3));
            Console.WriteLine(CatAndMouse(1, 3, 2));
            Console.WriteLine("\n");

            //Subarray Division
            Console.WriteLine(Birthday(new List<int> {1, 2, 1, 3, 2}, 3, 2));
            Console.WriteLine(Birthday(new List<int> {1, 1, 1, 1, 1, 1}, 3, 2));
            Console.WriteLine(Birthday(new List<int> {4}, 4, 1));
            Console.WriteLine("\n");

            //Divisible Sum Pairs
            Console.WriteLine(DivisibleSumPairs(6, 5, new List<int> {1, 2, 3, 4, 5, 6}));
            Console.WriteLine(DivisibleSumPairs(6, 3, new List<int> {1, 3, 2, 6, 1, 2}));
            Console.WriteLine("\n");

            //Sock Merchant
            Console.WriteLine(SockMerchant(9, new List<int> {10, 20, 20, 10, 10, 30, 50, 10, 20}));
            Console.WriteLine("\n");

            //Angry Professor
            Console.WriteLine(AngryProfessor(3, new List<int> {-1, -3, 4, 2}));
            Console.WriteLine(AngryProfessor(2, new List<int> {0, -1, 2, 1}));
            Console.WriteLine("\n");

            //Circular Array Rotation
            Console.WriteLine(string.Join(",",
                CircularArrayRotation(new List<int> {3, 4, 5}, 2, new List<int> {1, 2})));
            Console.WriteLine(string.Join(",",
                CircularArrayRotation(new List<int> {1, 2, 3}, 2, new List<int> {0, 1, 2})));
            Console.WriteLine("\n");

            //Save the prisoner
            Console.WriteLine(SaveThePrisoner(5, 2, 1));
            Console.WriteLine(SaveThePrisoner(5, 2, 2));
            Console.WriteLine(SaveThePrisoner(7, 19, 2));
            Console.WriteLine(SaveThePrisoner(3, 7, 3));
            Console.WriteLine("\n");

            //Repeated String
            Console.WriteLine(RepeatedString("aba", 10));
            Console.WriteLine(RepeatedString("a", 1000000000000));
            Console.WriteLine(RepeatedString("x", 970770));
            Console.WriteLine("\n");

            //Jumping the clouds
            Console.WriteLine(jumpingOnClouds(new List<int> {0, 1, 0, 0, 0, 1, 0}));
            Console.WriteLine(jumpingOnClouds(new List<int> {0, 0, 1, 0, 0, 1, 0}));
            Console.WriteLine(jumpingOnClouds(new List<int> {0, 0, 0, 0, 1, 0}));
            Console.WriteLine(jumpingOnClouds(new List<int> {0, 0, 0, 1, 0, 0}));
            Console.WriteLine("\n");

            //Equalize the array
            Console.WriteLine(EqualizeArray(new List<int> {1, 2, 2, 3}));
            Console.WriteLine(EqualizeArray(new List<int> {3, 3, 2, 1, 3}));
            Console.WriteLine("\n");

            //Counting valleys
            Console.WriteLine(CountingValleys(8, "DDUUUUDD"));
            Console.WriteLine(CountingValleys(8, "UDDDUDUU"));
            Console.WriteLine(CountingValleys(12, "DDUUDDUDUUUD"));
            Console.WriteLine("\n");

            //Arrays: Left Rotation
            Console.WriteLine(string.Join(",", RotLeft(new List<int> {1, 2, 3, 4, 5}, 2)));
            Console.WriteLine(string.Join(",", RotLeft(new List<int> {1, 2, 3, 4, 5}, 4)));
            Console.WriteLine("\n");

            //Mark and Toys
            Console.WriteLine(MaximumToys(new List<int> {1, 2, 3, 4}, 7));
            Console.WriteLine(MaximumToys(new List<int> {1, 12, 5, 111, 200, 1000, 10}, 50));
            Console.WriteLine("\n");

            //Reverse Int
            Console.WriteLine(ReverseInt(123));
            Console.WriteLine(ReverseInt(-123));
            Console.WriteLine(ReverseInt(120));
            Console.WriteLine(ReverseInt(0));
            Console.WriteLine(ReverseInt(-2147483648));
            Console.WriteLine("\n");

            //83. Remove Duplicates from Sorted List
            ListNode removeDupes = new ListNode(1, new ListNode(1, new ListNode(2)));
            removeDupes = DeleteDuplicates(removeDupes);
            while (removeDupes != null)
            {
                Console.WriteLine(removeDupes.val);

                removeDupes = removeDupes.next;
            }

            Console.WriteLine("---");
            ListNode removeDupes2 = new ListNode(1, new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(3)))));
            removeDupes2 = DeleteDuplicates(removeDupes2);
            while (removeDupes2 != null)
            {
                Console.WriteLine(removeDupes2.val);

                removeDupes2 = removeDupes2.next;
            }

            Console.WriteLine("\n");

            //34. Find First and Last Position of Element in Sorted Array
            Console.WriteLine(string.Join(",", SearchRange(new[] {5, 7, 7, 8, 8, 10}, 8)));
            Console.WriteLine(string.Join(",", SearchRange(new[] {5, 7, 7, 8, 8, 10}, 6)));
            Console.WriteLine(string.Join(",", SearchRange(new int[] { }, 0)));
            Console.WriteLine(string.Join(",", SearchRange(new[] {3, 3, 3}, 3)));
            Console.WriteLine("\n");
        }

        /// <summary>
        /// Find the sum of an array/list of integers
        /// </summary>
        /// <param name="ar">List representing an array of integers</param>
        /// <returns>int for the sum</returns>
        private static int SimpleArraySum(List<int> ar)
        {
            return ar.Sum();
        }

        /// <summary>
        /// Compare two lists of 3, awarding points to a or b based on which is greater at a given index
        /// </summary>
        /// <param name="a">List of 3 integers for Alice</param>
        /// <param name="b">List of 3 integers for Bob</param>
        /// <returns>List of 2 int's, Alice then Bob's score</returns>
        private static List<int> CompareTriplets(List<int> a, List<int> b)
        {
            int aScore = 0, bScore = 0;

            for (int i = 0; i < a.Count; i++)
            {
                if (a[i] == b[i])
                {
                    continue;
                }

                if (a[i] > b[i])
                {
                    aScore++;
                }
                else
                {
                    bScore++;
                }
            }

            return new List<int> {aScore, bScore};
        }

        /// <summary>
        /// Find which cat can catch the mouse earlier assuming each moves ++/-- 1, if both reach at the same time mouse escapes
        /// </summary>
        /// <param name="x">Cat A's position on x axis</param>
        /// <param name="y">Cat B's position on x axis</param>
        /// <param name="z">Mouse position on x axis, will not move</param>
        /// <returns>string "Cat A" or "Cat B" if one catches mouse, "Mouse C" if escapes</returns>
        private static string CatAndMouse(int x, int y, int z)
        {
            if (Math.Abs(z - x) == Math.Abs(z - y))
            {
                return "Mouse C";
            }

            if (Math.Abs(z - x) > Math.Abs(z - y))
            {
                return "Cat B";
            }

            return "Cat A";
        }

        /// <summary>
        /// Find the number of ways a chocolate bar can be divided where pieces of length m sum to d
        /// </summary>
        /// <param name="s">ints on each square of chocolate</param>
        /// <param name="d">continuous segments of choc must sum to this</param>
        /// <param name="m">length of continuous segments of choc</param>
        /// <returns>int for # of ways bar can be divided</returns>
        private static int Birthday(List<int> s, int d, int m)
        {
            int divCt = 0;

            for (int i = 0; i < s.Count - (m - 1); i++)
            {
                if (s.GetRange(i, m).Sum() == d)
                {
                    divCt++;
                }
            }

            return divCt;
        }

        /// <summary>
        /// Given a list, find pairs (i,j) where i,j and the pair is divisible by k 
        /// </summary>
        /// <param name="n">length of list</param>
        /// <param name="k">divisor</param>
        /// <param name="ar">list of ints</param>
        /// <returns>int for # of pairs</returns>
        private static int DivisibleSumPairs(int n, int k, List<int> ar)
        {
            int pairs = 0;

            for (int i = 0; i < ar.Count; i++)
            {
                for (int j = i + 1; j < ar.Count; j++)
                {
                    if (i < j && (ar[i] + ar[j]) % k == 0)
                    {
                        pairs++;
                    }
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
        private static int SockMerchant(int n, List<int> ar)
        {
            int pairs = 0;

            while (ar.Count > 0)
            {
                //RemoveAll returns number removed, add removed / 2 to pairs
                int toRemove = ar[0];
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
        private static string AngryProfessor(int k, List<int> a)
        {
            return a.Count(s => s <= 0) >= k ? "NO" : "YES"; //LINQ to filter and sum # of timely students
        }

        /// <summary>
        /// Perform circular rotations on the list, then report the the indices specified
        /// </summary>
        /// <param name="a">list of ints</param>
        /// <param name="k">int for # of circular rotations to perform</param>
        /// <param name="queries">list of indices to report</param>
        /// <returns>list of values at the indices</returns>
        private static List<int> CircularArrayRotation(List<int> a, int k, List<int> queries)
        {
            for (int i = 0; i < k; i++)
            {
                //store last element, pop off end, then push to front
                int temp = a[a.Count - 1];
                a.RemoveAt(a.Count - 1);
                a.Insert(0, temp);
            }

            return queries.Select(i => a[i]).ToList();
        }

        /// <summary>
        /// Prisoners are seated around a circular table, and passed out a number of candies starting from a certain
        /// seat. Determine the last recipient
        /// </summary>
        /// <param name="n">int for # of prisoners</param>
        /// <param name="m">int for # of candies</param>
        /// <param name="s">int for the prisoner to begin from</param>
        /// <returns>int for the prisoner to get the last candy</returns>
        private static int SaveThePrisoner(int n, int m, int s)
        {
            int[] distr = new int[m];

            //fill seating arr
            for (int i = 0; i < m; i++)
            {
                distr[i] = s;

                //restart at 1 due to circular seating, else increment s
                if (s == n)
                {
                    s = 1;
                }
                else
                {
                    s++;
                }
            }

            // Console.WriteLine(string.Join(",", distr));

            return distr[distr.Length - 1];

            //return ((m - 1) + (s - 1)) % n + 1; is the right answer bc they throw you large numbers
            //s+m and %n to return to 0, +/-1 to offset modular math starting at zero
        }

        /// <summary>
        /// Assume an infinite string of s repeated continually, find the number of 'a' that occur in range n
        /// </summary>
        /// <param name="s">substring that is repeated</param>
        /// <param name="n">long for range to search in</param>
        /// <returns>long for the # of a's</returns>
        private static long RepeatedString(string s, long n)
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
        private static int jumpingOnClouds(List<int> c)
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
        private static int EqualizeArray(List<int> arr)
        {
            //create a set of distinct numbers so we know what to get counts of
            HashSet<int> numSet = arr.ToHashSet();

            //use hash set to find counts of each num
            List<int> numCts = new List<int>();
            foreach (int num in numSet)
            {
                numCts.Add(arr.Count(n => n == num));
            }

            return arr.Count - numCts.Max(); //count - the # of max elements = the min to delete for uniform list
        }

        /// <summary>
        /// Find the number of valleys encountered, which begin step down from sea level, and ending with a step up
        /// from sea level
        /// </summary>
        /// <param name="steps">total number of steps in path</param>
        /// <param name="path">string where U = +1 alt, D = -1 alt, assume start at sea level</param>
        /// <returns>number of valleys encountered</returns>
        private static int CountingValleys(int steps, string path)
        {
            List<int> pathAlts = new List<int>(); //start at sea level
            int currentAlt = 0;

            //render path as a list of alt's at a given index of string
            foreach (char step in path)
            {
                if (step == 'U')
                {
                    pathAlts.Add(++currentAlt);
                }
                else
                {
                    pathAlts.Add(--currentAlt);
                }
            }

            bool valleyFlag = false;
            int valleys = 0;
            foreach (int alt in pathAlts)
            {
                //if dips below 0, entered a valley
                if (alt == -1)
                {
                    valleyFlag = true;
                }

                //if entered a valley, and we reach 0, we completed a valley encounter
                if (valleyFlag && alt == 0)
                {
                    valleys++;
                    valleyFlag = false;
                }
            }

            return valleys;
        }

        /// <summary>
        /// Rotate a list to the left many times
        /// </summary>
        /// <param name="a">list of ints</param>
        /// <param name="d">int for # of rotations</param>
        /// <returns>the rotated list</returns>
        private static List<int> RotLeft(List<int> a, int d)
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
        private static int MaximumToys(List<int> prices, int k)
        {
            //sort prices from min to max
            prices.Sort();
            int i = 0; //incremental amount to take
            List<int> elems = new List<int>();

            //Take from list, until you find reach the target
            while (elems.Sum() < k)
            {
                elems = prices.Take(++i).ToList();
            }


            if (elems.Sum() > k) return --i; //check if last take was too much

            return i;
        }

        /// <summary>
        /// Reverse the digits of an int
        /// </summary>
        /// <param name="x">int</param>
        /// <returns>the 'reverse' int with its digits in opposite order, 0 if reversed goes out of bounds of 32 bit int</returns>
        private static int ReverseInt(int x)
        {
            //some params will be long/Int64
            char[] digits = Math.Abs((long) x).ToString().ToCharArray(); //drop the negative, can re-add last

            if (digits.Length == 1) return x; //edge if only 1 digit

            //reverse -> use try parse to determine if the reversed can be saved to Int32 type
            Array.Reverse(digits);
            if (int.TryParse(string.Join("", digits), out int rev))
            {
                return x < 0 ? rev * -1 : rev; //if parsed, re-add the negative if needed
            }

            return rev; //parse failed, we init to 0 so just return that
        }

        /// <summary>
        /// Remove duplicates from a sorted list
        /// </summary>
        /// <param name="head">head node of sll</param>
        /// <returns>the head node after filter</returns>
        private static ListNode DeleteDuplicates(ListNode head)
        {
            if (head == null) return null;
            ListNode walker = head;

            while (walker.next != null)
            {
                //if two neighboring nodes match, link node to the one after
                if (walker.val == walker.next.val) walker.next = walker.next.next;
                else walker = walker.next; //else, step forward
            }

            return head;
        }

        /// <summary>
        /// Find the starting and ending position of the target
        /// </summary>
        /// <param name="nums">int arr</param>
        /// <param name="target">target int to find</param>
        /// <returns>arr with the first and last positon, [-1,-1] if not found</returns>
        private static int[] SearchRange(int[] nums, int target)
        {
            int[] pos = {-1, -1};
            Dictionary<int, int> numMap = new Dictionary<int, int>();
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

            if (numMap.ContainsValue(target))
            {
                IEnumerable<int> idxList = numMap.Where(pair => pair.Value == target)
                    .Select(pair => pair.Key)
                    .ToArray();

                pos = new[] {idxList.First(), idxList.Last()}; //only need the first and last positions
            }

            return pos;
        }
    }
}