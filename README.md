To use KnightsTour on a 3x3 chessboard run :

java -jar knightstour.jar #x <x> #y <y> [where x and y are positive positions on the board.]



Example : To begin from the location 3,2 on a 3x3 board the command would be : java -jar knightstour.jar #x 3 #y 2

To use KnightsTour on a nxn chessboard run :
java -jar knightstour.jar #size <n> (where n is the board size)  #x <x> #y <y> [where x and y are positive positions on the board.]

Example : To begin from the location 3,2 on a 5x5 board the command would be : java -jar knightstour.jar #x 3 #y2 #size 5

Note:

If you are on a UNIX/MAC OS, then you would need to escape sequence the "#" character, i.e., your command would look as below:

java -jar knightstour.jar \#x 3 \#y 2


The standalone application can be downloaded from here : http://krmahadevan.github.io/knight-tour/target/knightstour.jar  

The javadocs are available here : http://krmahadevan.github.io/knight-tour/target/apidocs/index.html

