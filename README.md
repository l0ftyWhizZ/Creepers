# Creepers
## About this module!
- 'Creepers' module brings in the Creepers (A creature!), inspired by the original Minecraft entity.
- Let them do their job, if you come in their sight, they are going to chase you until you explode into bits!

## How to install?
- Firstly, you can clone the repository by using: `git clone https://github.com/l0ftyWhizZ/Creepers.git`
- Make sure you place the repository inside `modules` folder in Terasology's root.
- After having placed the module correctly, you need to fetch two more modules as dependencies by using: <br>
  `./groovyw module get Behaviors` <br>
  `./groovyw module get Pathfinding` 
  
- After setting the correct branches up, run `./gradlew idea`, to generate the IntelliJ project files, and after building successfully, load it up in IntelliJ CE IDE.

## How to use in-game?
- Build the project, and run the build.
- Create a new game, and in the modules, activate `Creepers` module from the list, and hit play.
- To spawn the Creeper into the world, open up the console and type: `spawnPrefab Creeper`

That's basically it!

<b> (NOTE: The default spawnPrefab console command will spawn the Creeper at the player's location, hence it will instantly trigger the explosion. Rather, change the spawnPrefab function to change the spawnPos offset to be further away from the player.) </b>


