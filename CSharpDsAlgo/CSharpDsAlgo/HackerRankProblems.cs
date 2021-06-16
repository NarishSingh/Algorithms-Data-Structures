using System;
using System.Collections.Generic;
using System.Linq;

namespace CSharpDsAlgo
{
    public class HackerRankProblems
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
    }
}