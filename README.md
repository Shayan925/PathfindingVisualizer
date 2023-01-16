# Pathfinding Visualizer

#### By: Pareesh, Kabir, Shayan
JAR application to visualize A*, Depth first search, and Breadth first search
12/15/2022

### Table of Contents of Tutorials/Guide 
<ul>
<li> Start Up/Installation Guide </li>
<li> Main Menu </li>
<li> Start </li>
<li> Purpose of Project </li>
<li> User interaction/Reference Manuals </li>
<li> Search </li>
<li> Save/Load Game </li>
<li> Information </li>
<li> Credits </li>
<li> Reset </li>
<li> Clear Path </li>
</ul> 

### I). Start Up/Installation Guide:
 To begin download our JAR from our github. Upon starting the program by clicking on the JAR file, the main menu will be displayed.

### II). Main Menu: 
The main menu will contain two main components; a menu bar and grid. Navigate through the main menu with the mouse and click on the left mouse button to interact with the buttons. 

Start: 
The user will be prompted via messages to click their start and end tile. 

<p align="center">
<img src="https://github.com/Shayan925/PathfindingVisualizer/blob/main/app.png" height="600" width = "650"/>
</p>

### III). Purpose of Project: 
The purpose of this project is to create an application that visualises the process of pathfinding. Pathfinding is a series of steps created to take a starting point, and an ending point. It will then try to find the shortest path between the two, while avoiding obstacles in the way. Through our JAR, users will be able to understand how it operates from first hand experience as they will create a start/end point, obstacles, and find paths with different algorithms.

### IV). User Interaction: 
After the user has selected the start & end points, they will choose their desired pathfinding algorithm from the dropbox above the grid. The dropbox’s options will contain: A*, Depth-First, and Breadth-first search. Then the user can click on tiles with the left mouse button which will change their colour, and mark them as an obstacle. In addition the user can remove obstacles with the right mouse button, changing them back to white. Reference Manuals
A*: Uses a heuristic which estimates the distance from the start to end. Ours uses the manhattan distance because we are searching on a grid, and cannot move diagonally. Each node stores the distance between the starting and the current and the distance from ending to current, and calculates the next closest point. Once the ending node is reached, we know the optimal path was taken.
Breath First: Searches all neighbouring nodes, and explores all nodes at the present depth prior to moving on to the nodes on the next depth level. 
Depth First: The algorithm starts at the root node and always travels one direction until it reaches the end (wall, or border) and can’t continue, then it changes direction and continues until it can not travel anymore. This process is repeated until it reaches the end. The user should note the displayed path for depth first is not the shortest.

<p align="center">
<img src="https://github.com/Shayan925/PathfindingVisualizer/blob/main/edit.png" height="100" width = "350"/>
<img src="https://github.com/Shayan925/PathfindingVisualizer/blob/main/algorithm.png" height="100" width = "350"/>
</p>


### V). Search: 
When the user clicks the Search button, the corresponding pathfinding algorithm will begin from the start, changing the colour of the tiles while searching, until it reaches the end point. After, the program will display the amount of time it took as well as the number nodes searched. Finally the program will show the shortest path from the start to the end, so the user can compare.

<p align="center">
<img src="https://github.com/Shayan925/PathfindingVisualizer/blob/main/search.png" height="400" width = "450"/>
<img src="https://github.com/Shayan925/PathfindingVisualizer/blob/main/path.png" height="400" width = "450"/>
</p>

### VI). Save/Load Game: 
The user can save the game as a csv file at any time by pressing the save button, then load with the load button.

### VII). Information: 
Links about pathfinding can be found at the top-left of the program, by pressing these links, articles/websites about pathfinding will appear on the users web-browsers so they can learn more.

### VIII) Credits: 
This option will bring the user to a new screen and allows one to view the members of the staff.
Press the “back” button to return to the main menu

### X). Reset: 
One can reset the program and tiles if they press the reset button. This will cause the grid to return to its original white colour.

### IX). Clear Path: 
One can clear the yellow tiles that indicate the shortest path by pressing the clear path button.
