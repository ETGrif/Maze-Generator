
public class Room
	{

		private int xPos;
		private int yPos;
		private String[] doors;
		private boolean hasBeenVisited;
		private String roomType;

		public Room(int xPos, int yPos)
			{
				this.xPos = xPos;
				this.yPos = yPos;
				this.doors = new String[4];
				this.hasBeenVisited = false;
				this.roomType = "";

			}

		public int getxPos()
			{
				return xPos;
			}

		public void setxPos(int xPos)
			{
				this.xPos = xPos;
			}

		public int getyPos()
			{
				return yPos;
			}

		public void setyPos(int yPos)
			{
				this.yPos = yPos;
			}

		public String[] getDoors()
			{
				return doors;
			}

		public void setDoors(String[] doors)
			{
				this.doors = doors;
			}

		public void setDoor(int index, String doorState)
			{
				this.doors[index] = doorState;
			}

		public boolean isHasBeenVisited()
			{
				return hasBeenVisited;
			}

		public void setHasBeenVisited(boolean hasBeenVisited)
			{
				this.hasBeenVisited = hasBeenVisited;
			}

		public String getRoomType()
			{
				return roomType;
			}

		public void setRoomType(String roomType)
			{
				this.roomType = roomType;
			}

	}
