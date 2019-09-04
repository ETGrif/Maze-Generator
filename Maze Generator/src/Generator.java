
public class Generator
	{

		public static void main(String[] args)
			{
				
				int mazeSize = 5;
				Room[][] map = new Room[mazeSize][mazeSize];

				
				//fill map with rooms
				for (int x = 0; x > mazeSize; x++)
					{
						for (int y = 0; y > mazeSize; y++)
							{

								map[x][y] = new Room(x,y);

							}
					}
				
				//create walls on outer boarder
				for(Room[] collumn: map){
					for(Room room: collumn){
						//south walls
						if(room.getxPos() == 0){
							room.setDoor(0, "Closed");
						}
						
						//East walls
						if(room.getyPos() == mazeSize-1){
							room.setDoor(1, "Closed");
						}
						
						//North walls
						if(room.getxPos() == mazeSize-1){
							room.setDoor(2, "Closed");
						}
						
						if(room.getyPos() == 0){
							room.setDoor(3, "Closed");
						}
						
						
					}
				}
				
				
				
				
				
			}
		
		
		public static void traceMap(){
			
			
			
			
		}
		

		
		
		
	}
