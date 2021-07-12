using System;

namespace CornerFinderYearOne
{
    internal class Program
    {
        private static int[,] FindCorners(int[,] image)
        {
            int[,] resArr = new int[2, 2];

            //find top left of 0 box -> 1st 0 encountered in matrix
            //TODO its finding them, but the coordinates are off by one
            for (int i = 0; i < image.GetLength(0); i++)
            {
                for (int j = 0; j < image.GetLength(1); j++)
                {
                    if (image[i, j] == 0)
                    {
                        resArr.SetValue(i, 0, 0);
                        resArr.SetValue(j, 0, 1);
                        break;
                    }
                }
            }

            //find bottom right of 0 box -> last 0 encountered in matrix
            for (int i = image.GetLength(0) - 1; i > 0; i--)
            {
                //well formed, so all will be same length
                for (int j = image.GetLength(1) - 1; j > 0; j--)
                {
                    if (image[i, j] == 0)
                    {
                        resArr.SetValue(i, 1, 0);
                        resArr.SetValue(j, 1, 1);
                        break;
                    }
                }
            }

            return resArr;
        }

        public static void Main(string[] args)
        {
            int[,] image1 =
            {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
            };

            int[,] image1MultiBox =
            {
                {0, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
            };

            int[,] image2 =
            {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0}
            };

            int[,] image3 =
            {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 0, 0}
            };

            int[,] image4 =
            {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
            };

            int[,] image5 =
            {
                {0}
            };

            //1. only 1 rect
            PrintCorners(FindCorners(image1));
            PrintCorners(FindCorners(image2));
            PrintCorners(FindCorners(image3));
            PrintCorners(FindCorners(image4));
            PrintCorners(FindCorners(image5));
        }

        /// <summary>
        /// Print a formatted matrix
        /// </summary>
        /// <param name="corners1">2D array</param>
        private static void PrintCorners(int[,] corners1)
        {
            for (int i = 0; i < corners1.GetLength(1); i++)
            {
                Console.WriteLine($"[{corners1[i, 0]},{corners1[i, 1]}]");
            }

            Console.WriteLine();
        }
    }
}