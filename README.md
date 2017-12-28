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
  
- After getting these modules, go into `Behaviors` module first, and change the current working branch to `behaviorv2` by using: <br>
  `git checkout behaviorv2` <br>
  Same for Pathfinding: <br>
  `git checkout behaviorv2`
  
  You, also need to change the branch for Terasology, from `develop` to `behaviorv2` similarily.
  
  <b>(NOTE: These branch changes are to be done, since Behaviors v2 hasn't been merged into `master` yet. Once done, no need to change the branches.)</b>
  
- After setting the correct branches up, run `./gradlew idea`, to generate the IntelliJ project files, and after building successfully, load it up in IntelliJ CE IDE.

## How to use in-game?
- Build the project, and run the build.
- Create a new game, and in the modules, activate `Creepers` module from the list, and hit play.
- To spawn the Creeper into the world, open up the console and type: `spawnPrefab Creeper`

That's basically it!

## TODO
- Currently, the model used is the same as that of a deer, since I wasn't able to find a proper 'working' model for the creeper that could be easily converted to .MD5Mesh.


