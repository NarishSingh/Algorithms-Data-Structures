/*
Image the matrix represents an image where 1 = dark background and 0 = the image itself. The image will be rectangular shapes

1. Find the top left and bottom right corner (x,y coordinates)  assuming only 1 rectangle
(HINT: top left will be a 0 with 1's above and left/edges of array
bottom right corner will be 0 with 1's below and right/edges of array
Make a helper function that scans the 0 box for these coordinates)

2. Find the top left/bottom right corners of all rectangles, assuming image has multiple rects

3. Find top left/bottom right corners of irregular rectangles, assuming image has multiple
*/

using System;

namespace CornerFinderYearOne
{
    internal class Program
    {
        /// <summary>
        /// For finding corners if only one rect is present
        /// </summary>
        /// <param name="image">2D array of 0 and 1</param>
        /// <returns>2D arr with x, y coordinates of the top left and bottom right</returns>
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
                        resArr[0, 0] = i;
                        resArr[0, 1] = j;
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
                        resArr[1, 0] = image.GetLength(0) - i; //since we start from back, need to correct
                        resArr[1, 1] = j;
                        break;
                    }
                }
            }

            return resArr;
        }
        
        /// <summary>
        /// Print a formatted matrix
        /// </summary>
        /// <param name="results">2D array</param>
        private static void PrintCorners(int[,] results)
        {
            for (int i = 0; i < results.GetLength(1); i++)
            {
                Console.WriteLine($"[{results[i, 0]},{results[i, 1]}]");
            }

            Console.WriteLine("---");
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
            
            int[,] image1MultiBox =
            {
                {0, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
            };

            //1. only 1 rect
            PrintCorners(FindCorners(image1));
            PrintCorners(FindCorners(image2));
            PrintCorners(FindCorners(image3));
            PrintCorners(FindCorners(image4));
            PrintCorners(FindCorners(image5));
        }
    }
}