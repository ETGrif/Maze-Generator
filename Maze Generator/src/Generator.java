import java.time.temporal.ChronoField;
import java.util.ArrayList;

public class Generator
	{
		static int mazeSize = 16;

		static Room[][] map = new Room[mazeSize][mazeSize];

		public static void main(String[] args)
			{

				// fill map with rooms
				fillMapWithRooms();

				// create walls on outer boarder
				// createBoarderWalls();

				traceMap(map[0][0]);

				printMap();

			}

		public static void fillMapWithRooms()
			{
				for (int x = 0; x < mazeSize; x++)
					{
						for (int y = 0; y < mazeSize; y++)
							{

								map[x][y] = new Room(x, y);

							}
					}
			}

		public static void traceMap(Room room)
			{
				// entered a room
				// set some variables
				int x = room.getxPos();
				int y = room.getyPos();

				// setRoom to visited
				room.setHasBeenVisited(true);
				boolean branching = true;
//this whole section needs to be run everytime the room branches
				while (branching)
					{
						// create arrayList of available rooms (Exists and not visited)
						ArrayList<Room> availableRooms = getAvailableRooms(room);

						if (availableRooms.size() != 0)
							{
								// while there are rooms:
								// choose a random room + remove it from the available rooms
								int randomIndex = (int) (Math.random() * availableRooms.size());

								Room chosenRoom = availableRooms.get(randomIndex);
								availableRooms.remove(chosenRoom);

								testPirint(
										"New Room: (" + chosenRoom.getxPos() + ", " + chosenRoom.getyPos() + ")");

								// set the door between them to open
								int[] doorIndexes = getConnectingDoors(room, chosenRoom);
								room.setDoor(doorIndexes[0], "Open");
								chosenRoom.setDoor(doorIndexes[1], "Open");

								// move to that room

								traceMap(chosenRoom);
							} else
							{
								// if there is no available room, break to previous room
								testPirint("Break (" + x + ", " + y + ")");
								branching = false;
							}
					}
			}
			
		public static void printMap()
			{

				// for every Y level
				// for every X level
				for (int y = mazeSize - 1; y >= 0; y--)
					{

						// TOP LINE
						// for each room, if there is a north(2) door
						// that is closed, print a "-", otherwise a " ".
						// Separated by a "+".
						for (int x = 0; x < mazeSize; x++)
							{
								System.out.print("+");
								if (map[x][y].getDoor(1) == "Closed")
									{
										System.out.print("--");
									} else
									{
										System.out.print("  ");
									}
							}
						System.out.println("+");

						// BOTTOM LINE
						// for each room, if there is a west(3) door
						// that is closed print a "|", otherwise a " ".
						// separated by a " ".
						for (int x = 0; x < mazeSize; x++)
							{

								if (map[x][y].getDoor(0) == "Closed")
									{
										System.out.print("|");
									} else
									{
										System.out.print(" ");
									}

								// CENTER OF BOX
								System.out.print("  ");

							}
						if (map[mazeSize - 1][y].getDoor(2) == "Closed")
							{
								System.out.println("|");
							} else
							{
								System.out.println();
							}

						// Bottom of map line
						if (y == 0)
							{
								for (int x = 0; x < mazeSize; x++)
									{
										System.out.print("+");
										if (map[x][y].getDoor(3) == "Closed")
											{
												System.out.print("--");
											} else
											{
												System.out.print("  ");
											}

									}
								System.out.println("+");

							}

					}
			}

		public static ArrayList<Room> getAvailableRooms(Room room)
			{
				// set some variables
				int x = room.getxPos();
				int y = room.getyPos();

				ArrayList<Room> unvisitedAdjacentRooms = new ArrayList<Room>();
				// west room
				try
					{
						if (map[x - 1][y].isVisited() == false)
							{
//							System.out.println("west room exists");
								unvisitedAdjacentRooms.add(map[x - 1][y]);

							}
					} catch (Exception e)
					{
//					System.out.println("W");
					}
				// north room
				try
					{
						if (map[x][y + 1].isVisited() == false)
							{
//							System.out.println("north room exists");
								unvisitedAdjacentRooms.add(map[x][y + 1]);
							}
					} catch (Exception e)
					{
//					System.out.println("N");

					}

				// east room

				try
					{
						if (map[x + 1][y].isVisited() == false)
							{
//							System.out.println("east room exists");
								unvisitedAdjacentRooms.add(map[x + 1][y]);
							}
					} catch (Exception e)
					{
//					System.out.println("E");

					}
				// south room
				try
					{
						if (map[x][y - 1].isVisited() == false)
							{
//							System.out.println("south room exists");
								unvisitedAdjacentRooms.add(map[x][y - 1]);
							}
					} catch (Exception e)
					{
//					System.out.println("S");

					}

				// return the filled arrayList
				return unvisitedAdjacentRooms;

			}

		public static int[] getConnectingDoors(Room a, Room b)
			{

				int dX = b.getxPos() - a.getxPos();
				int dY = b.getyPos() - a.getyPos();

				// west of a
				if (dX == -1)
					{
						int[] doorIndexes = { 0, 2 };
//						System.out.println("a");
						return doorIndexes;
					} else if (dY == 1)
					{
						int[] doorIndexes = { 1, 3 };
//						System.out.println("b");
						return doorIndexes;
					} else if (dX == 1)
					{
						int[] doorIndexes = { 2, 0 };
//						System.out.println("c");
						return doorIndexes;
					} else
					{
						int[] doorIndexes = { 3, 1 };
//						System.out.println("d");
						return doorIndexes;
					}

			}

		public static void testPirint(String testPrint) {
			boolean testPrinting = false;
			if(testPrinting) {
				System.out.println(testPrint);
			}
		}
	}
