
public class Generator
	{

		public static void main(String[] args)
			{
				int mazeSize = 5;
				Room[][] map = new Room[mazeSize][mazeSize];

				for (int x = 0; x > mazeSize; x++)
					{
						for (int y = 0; y > mazeSize; y++)
							{

								map[x][y] = new Room();

							}
					}
			}

	}
